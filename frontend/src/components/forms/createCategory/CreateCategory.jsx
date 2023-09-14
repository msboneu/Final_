import React, { useState } from "react";
import { Form } from "react-bootstrap";
import styles from "./CreateCategory.module.css";
import { Toast } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useContext } from "react";
import { AuthContext } from "../../../context/AuthContext";
import axios from "axios";
import Button from "../../buttons/Button"

const CreateCategory = () => {

  const { token } = useContext(AuthContext);
  const [newCategory, setNewCategory] = useState({
    tipoExperiencia: "",
    urlImagen: "",
    descripcion: ""
  });
  const [showToast, setShowToast] = useState(false);
  const [error, setError] = useState(null);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setNewCategory((prevState) => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    setError(null);

    try {
      if (!newCategory.tipoExperiencia || !newCategory.urlImagen || !newCategory.descripcion) {
        setError("Es necesario rellenar todos los campos");
        return;
      }

      console.log(newCategory)

      const response = await axios.post("http://18.224.212.146:8080/categoria/guardar",        
        newCategory,
        {
          headers: {
            "Content-Type": "application/json",
            Accept: "*/*",
            Authorization: `Bearer ${token}`,
          },
        }
      );

      if (response.status == 201) {
        setShowToast(true);
      }

      if (response.status !== 201) {
        throw new Error(response.data.message || "La creación de categoría ha fallado");
      }

      setNewCategory({
        tipoExperiencia: "",
        urlImagen: "",
        descripcion: ""
      });
      setError(null);

    } catch (error) {
      setError(error.message || "La creación de categoría ha fallado");
    }
  };
  
  const SuccessToast = () => (
    <Toast className={styles.delete_toast} show={showToast} onClose={() => setShowToast(false)} delay={3000} autohide>
      <Toast.Header>
        <strong className="me-auto">Petición exitosa</strong>
      </Toast.Header>
      <Toast.Body>Categoría creada exitosamente</Toast.Body>
    </Toast>
  );

  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group className={styles.form_group} required>
        <Form.Label className={styles.form_label}>Nombre de categoria</Form.Label>
        <Form.Control
          type="text"
          className={`form-control`}
          id="nueva-categoria"
          placeholder="Escriba el nombre de la nueva categoria"
          name="tipoExperiencia"
          value={newCategory.tipoExperiencia}
          onChange={handleInputChange}
        />
      </Form.Group>
      <Form.Group className={styles.form_group} required>
        <Form.Label className={styles.form_label}>URL, imagen descriptiva</Form.Label>
        <Form.Control
          type="text"
          className={`form-control`}
          id="img-category"
          placeholder="Agregue una imagen acorde a la categoría"
          name="urlImagen"
          value={newCategory.urlImagen}
          onChange={handleInputChange}
        />
      </Form.Group>
      <Form.Group className={styles.form_group} required>
        <Form.Label className={styles.form_label}>Descripción</Form.Label>
        <Form.Control
          as="textarea"
          className={`form-control`}
          rows="2"
          id="descripcion-categoria"
          placeholder="Escriba una descripción lo más detallada posible de la experiencia"
          name="descripcion"
          value={newCategory.descripcion}
          onChange={handleInputChange}
        />
      </Form.Group>
      {error && <div className="text-danger">{error}</div>}
      <Button 
        type="submit"
        name="Crear"
        label="Crear categoría"
      />
      {showToast && <SuccessToast />}
    </Form>
  );
};

export default CreateCategory;