import React from "react";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import styles from "./CustomModal.module.css";

const CustomModal = ({
  title,
  content,
  actionCancel,
  actionSuccess,
  show,
  handleClose,
}) => {
  return (
    <>
      <Modal show={show} onHide={handleClose} centered>
        <Modal.Header closeButton>
          <Modal.Title className={styles.modal_title}>{title}</Modal.Title>
        </Modal.Header>
        <Modal.Body className={styles.modal_body}>{content}</Modal.Body>
        <Modal.Footer>
        {actionCancel && (
            <Button variant="secondary" onClick={handleClose}>
              {actionCancel}
            </Button>
          )}
          {actionSuccess && (
            <Button variant="primary" onClick={handleClose}>
              {actionSuccess}
            </Button>
          )}
        </Modal.Footer>
      </Modal>
    </>
  );
};

export default CustomModal;
