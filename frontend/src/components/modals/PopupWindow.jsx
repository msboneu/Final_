import React from "react";
import { Modal, Button } from "react-bootstrap";
import styles from "./PopupWindow.module.css"
import { Link } from "react-router-dom";

const PopupWindow = ({ showModal, onClose }) => {
  return (
    <Modal className={styles.popup} show={showModal} onHide={onClose} centered>
      <Modal.Header closeButton>
        <Modal.Title>Registro Exitoso</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <p>Tu registro ha sido exitoso. ¡Te damos la bienvenida!</p>
      </Modal.Body>
      <Modal.Footer>
      <Link to="/login">
        <Button variant="primary">
          Iniciar sesión
        </Button>
      </Link>
      </Modal.Footer>
    </Modal>
  );
};

export default PopupWindow;