import React, { useState } from "react";
import styles from "./RegisterForm.module.css";
import { Link } from "react-router-dom";
import FormField from "../../inputs/FormField";
import PopupWindow from "../../modals/PopupWindow";

const RegisterForm = () => {
  const [formData, setFormData] = useState({
    name: "",
    lastname: "",
    email: "",
    password: "",
    confirmPassword: "",
    address: "",
  });

  const [errors, setErrors] = useState({});
  const [showModal, setShowModal] = useState(false);


  const handleSubmit = (event) => {
    event.preventDefault();
    const validationErrors = validateForm(formData);
    setErrors(validationErrors);
    if (Object.keys(validationErrors).length === 0) {
      registerUser(formData)
        .then(() => {
          console.log("Form submitted:", formData);
          resetForm();
          setShowModal(true);
        })
        .catch((error) => {
          if (error.message === "Email already registered") {
            setErrors((prevErrors) => ({
              ...prevErrors,
              email: "El correo electrónico ya está registrado.",
            }));
          } else {
            console.error("Registration error:", error);
          }
        });
      }
   };

  const registerUser = (data) => {
    return new Promise((resolve, reject) => {
      fetch("http://18.224.212.146:8080/autenticacion/registro", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      })
        .then((response) => {
          if (response.ok) {
            console.log("Registration successful");
            resetForm();
            resolve(); 
          } else if (response.status === 406) {
            reject(new Error("Email already registered")); 
          } else {
            reject(new Error("Registration error")); 
          }
        })
        .catch((error) => {
          reject(error); 
        });
    });
  };

  const resetForm = () => {
    setFormData({
      name: "",
      lastname: "",
      email: "",
      password: "",
      confirmPassword: "",
      address: "",
    });
    setErrors({});
  };

  const validateForm = (data) => {
    const errors = {};

    if (!data.name.trim()) {
      errors.name = "El nombre es obligatorio.";
    }

    if (!data.lastname.trim()) {
      errors.lastname = "El apellido es obligatorio.";
    }

    if (!data.email.trim()) {
      errors.email = "El correo electrónico es obligatorio.";
    } else if (!isValidEmail(data.email)) {
      errors.email = "Ingrese un correo electrónico válido.";
    }

    if (!data.password.trim()) {
      errors.password = "La contraseña es obligatoria.";
    } else if (!isValidPassword(data.password)) {
      errors.password =
        "La contraseña debe tener al menos 8 caracteres, 1 minúscula, 1 mayúscula, 1 número y 1 caracter especiales.";
    }

    if (!data.confirmPassword.trim()) {
      errors.confirmPassword = "La contraseña es obligatoria.";
    } else if (data.password !== data.confirmPassword) {
      errors.confirmPassword = "Las contraseñas no coinciden.";
    }

    if (!data.address.trim()) {
      errors.address = "La dirección es obligatoria";
    }

    return errors;
  };

  const isValidEmail = (email) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  };

  const isValidPassword = (password) => {
    const passwordRegex =
      /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()])[0-9a-zA-Z!@#$%^&*()]{8,}$/;
    return passwordRegex.test(password);
  };

  return (
    <>
    <div className={styles.register_form}>
      <h3 className={`${styles.register_heading} text-center`}>
        Registro de nuevo usuario
      </h3>
      <form action="" className="row" onSubmit={handleSubmit}>
        <div className="col-md">
          <FormField
            id="name-user-register"
            name="name"
            label="Nombre"
            placeholder="Ingrese su nombre completo"
            value={formData.name}
            error={errors.name}
            type="text"
            onChange={(e) =>
              setFormData({ ...formData, name: e.target.value })
            }
          />
          <FormField
            id="email-user-register"
            name="email"
            label="Email"
            placeholder="Ingrese su email"
            value={formData.email}
            error={errors.email}
            type="email"
            onChange={(e) =>
              setFormData({ ...formData, email: e.target.value })
            }
          />
          <FormField
            id="pass-user-register"
            name="password"
            label="Contraseña"
            placeholder="Ingrese su contraseña"
            value={formData.password}
            error={errors.password}
            type="password"
            onChange={(e) =>
              setFormData({ ...formData, password: e.target.value })
            }
          />
        </div>
        <div className="col-md">
        <FormField
            id="lastname-user-register"
            name="lastname"
            label="Apellido"
            placeholder="Ingrese su apellido"
            value={formData.lastname}
            error={errors.lastname}
            type="text"
            onChange={(e) =>
              setFormData({ ...formData, lastname: e.target.value })
            }
          />
          <FormField
            id="address-user-register"
            name="address"
            label="Dirección"
            placeholder="Ingrese su dirección"
            value={formData.address}
            error={errors.address}
            type="text"
            onChange={(e) =>
              setFormData({ ...formData, address: e.target.value })
            }
          />
          <FormField
            id="pass-confirm-user-register"
            name="confirmPassword"
            label="Confirmar contraseña"
            placeholder="Ingrese de nuevo su contraseña"
            value={formData.confirmPassword}
            error={errors.confirmPassword}
            type="password"
            onChange={(e) =>
              setFormData({ ...formData, confirmPassword: e.target.value })
            }
          />
        </div>
        <div className={styles.actions}>
          <input
            type="submit"
            className={styles.register_btn}
            value="Registrar usuario"
          />
          <p className="text-muted">¿Ya estás registrado?</p>
          <Link to="/login">Login</Link>
        </div>
      </form>
    </div>
    <PopupWindow 
      showModal={showModal}
      onClose={() => setShowModal(false)}
    />
  </>
  );
};

export default RegisterForm;
