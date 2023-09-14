import React, { useRef, useEffect } from "react";
import { useState } from "react";
import CreateProductForm from "../../forms/createProduct/CreateProductForm";
import CustomModal from "../../modals/CustomModal";
import { useContext } from "react";
import { AuthContext } from "../../../context/AuthContext";
import axios from "axios";

const CreateProduct = () => {
  const formRef = useRef();
  const { token } = useContext(AuthContext);
  const [mockPost, setMockPost] = useState([]);
  const [formData, setFormData] = useState({
    nombreExperiencia: "",
    categoria: "",
    destino: "",
    precioBasico: 0,
    precioPremium: 0,
    descripcion: "",
    urlImagenes: [],
    cupoMaximo: 0,
    duracionDias: 0,
  });

  const [errors, setErrors] = useState({});
  const [categorias, setCategorias] = useState([]);
  const [showSuccessRegister, setShowSuccessRegister] = useState(false);

  const handleCloseSuccessRegister = () => setShowSuccessRegister(false);

  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const response = await axios.get(
          "http://18.224.212.146:8080/categoria/listar",
          {
            method: "GET",
            headers: {
              "Content-Type": "application/json",
              Accept: "*/*",
            },
          }
        );
        const data = response.data;
        const categoriasData = data.map((item) => {
          return {
            name: item.tipoExperiencia,
            value: item.tipoExperiencia,
          };
        });
        setCategorias(categoriasData);
      } catch (error) {
        console.error(
          "Error fetching categories:",
          error.response.data.messages
        );
      }
    };

    fetchCategories()

  }, []);

  const validateForm = () => {
    let formIsValid = true;
    let errors = {};

    if (
      formData.nombreExperiencia.trim() === "" ||
      formData.destino.trim() === ""
    ) {
      formIsValid = false;
      errors.nombreExperiencia = true;
      errors.destino = true;
    }

    if (
      !Number.isInteger(+formData.precioBasico) ||
      !Number.isInteger(+formData.precioPremium) ||
      !Number.isInteger(+formData.cupoMaximo) ||
      !Number.isInteger(+formData.duracionDias)
    ) {
      formIsValid = false;
      errors.precioBasico = true;
      errors.precioPremium = true;
      errors.cupoMaximo = true;
      errors.duracionDias = true;
    }

    if (!formData.categoria) {
      formIsValid = false;
      errors.categoria = "Selecciona una categoría";
    }

    if (!formData.descripcion) {
      formIsValid = false;
      errors.descripcion = "Campo obligatorio";
    }

    setErrors(errors);
    return formIsValid;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name === "urlImagenes") {
      const urls = value.split(",");
      setFormData((prevState) => ({
        ...prevState,
        [name]: urls,
      }));
    } else if (
      name === "precioBasico" ||
      name === "precioPremium" ||
      name === "cupoMaximo" ||
      name === "duracionDias"
    ) {
      setFormData((prevState) => ({
        ...prevState,
        [name]: +value,
      }));
    } else {
      setFormData((prevState) => ({
        ...prevState,
        [name]: value,
      }));
    }
  };

  const postNuevaExperiencia = async () => {
    try {
      const response = await axios.post(
        "http://18.224.212.146:8080/experiencia/guardar/v2",
        formData,
        {
          headers: {
            "Content-Type": "application/json",
            Accept: "*/*",
            Authorization: `Bearer ${token}`,
          },
        }
      );

      if (response.status === 201) {
        console.log("La experiencia se ha guardado correctamente");
        console.log(response);
      } else {
        console.log("Hubo un error al guardar la experiencia");
      }
    } catch (error) {
      console.log(
        "Ocurrió un error en la solicitud",
        error.response.data.messages
      );
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (validateForm()) {
      await postNuevaExperiencia();
      setFormData({
        nombreExperiencia: "",
        categoria: "",
        destino: "",
        precioBasico: 0,
        precioPremium: 0,
        descripcion: "",
        urlImagenes: [],
        cupoMaximo: 0,
        duracionDias: 0,
      });
      setShowSuccessRegister(true);
    }
  };

  return (
    <>
      <CreateProductForm
        formRef={formRef}
        handleSubmit={handleSubmit}
        handleChange={handleChange}
        formData={formData}
        errors={errors}
        categorias={categorias}
      />
      <CustomModal
        buttonActionLabel="registro exitoso"
        title="Producto Registrado correctamente"
        content="Su producto se encuentra disponible tanto para usuarios como para gestiones internas"
        actionCancel={false}
        actionSuccess={false}
        show={showSuccessRegister}
        handleClose={handleCloseSuccessRegister}
      />
    </>
  );
};

export default CreateProduct;
