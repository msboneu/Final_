import React, { useState, useEffect } from "react";
import { Table, Button, Modal } from "react-bootstrap";
import axios from "axios";
import styles from "./ManageCategories.module.css";
import { Toast } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useContext } from "react";
import { AuthContext } from "../../../../context/AuthContext";

const ManageCategories = () => {
  const [categories, setCategories] = useState([]);
  const [products, setProducts] = useState([]);
  const { token } = useContext(AuthContext);
  const [showModal, setShowModal] = useState(false);
  const [selectedItem, setSelectedItem] = useState(null);
  const [showToast, setShowToast] = useState(false);

  const handleDelete = (item) => {
    setSelectedItem(item);
    setShowModal(true);
  };

  const confirmDelete = async () => {
    if (selectedItem) {
      try {
        await axios.delete(`http://18.224.212.146:8080/categoria/eliminar/${selectedItem.id}`, {
          headers: {
            "Content-Type": "application/json",
            Accept: "*/*",
            Authorization: `Bearer ${token}`,
          },
        });
        setShowToast(true);
        setCategories((prevCategories) =>
          prevCategories.filter((category) => category.id !== selectedItem.id)
        );
      } catch (error) {
        console.error("Error deleting item:", error);
      }
      setSelectedItem(null);
    }
    setShowModal(false);
  };

  const closeConfirmationModal = () => {
    setShowModal(false);
  };

  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const response = await axios.get(
          "http://18.224.212.146:8080/categoria/listar",
          {
            headers: {
              "Content-Type": "application/json",
              Accept: "*/*",
            },
          }
        );
        const data = response.data;
        setCategories(data);
      } catch (error) {
        console.error("Error fetching categories:", error);
      }
    };

    fetchCategories();
  }, []);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await axios.get(
          "http://18.224.212.146:8080/experiencia/listarExperiencias",
          {
            headers: {
              "Content-Type": "application/json",
              Accept: "*/*",
            },
          }
        );
        const data = response.data;
        setProducts(data);
      } catch (error) {
        console.error("Error fetching products:", error);
      }
    };

    fetchProducts();
  }, []);

  const categoryHasProducts = (category) => {
    const hasProducts = products.some(
      (product) => product.categoria === category.tipoExperiencia
    );
    return hasProducts;
  };
  
  const SuccessToast = () => (
    <Toast className={styles.delete_toast} show={showToast} onClose={() => setShowToast(false)} delay={3000} autohide>
      <Toast.Header>
        <strong className="me-auto">Petición exitosa</strong>
      </Toast.Header>
      <Toast.Body>Categoría eliminada.</Toast.Body>
    </Toast>
  );

  return (
    <>
      <h2>Gestión de categorías</h2>
      <p>
        Consulta la lista completa de categorías disponibles. Puedes eliminar categorías <strong>que no tengan ningún producto asociado.</strong>
      </p>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Tipo de Experiencia</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {categories.map((category) => (
            <tr key={category.id}>
              <td>{category.id}</td>
              <td>{category.tipoExperiencia}</td>
              <td>
              <Button 
                  variant="danger" 
                  onClick={() => handleDelete(category)}
                  disabled={categoryHasProducts(category)}
                >
                  Eliminar
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      <Modal
        className={styles.delete_modal}
        show={showModal}
        onHide={closeConfirmationModal}
      >
        <Modal.Header closeButton>
          <Modal.Title>Eliminar elemento</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <p>
            Estás a punto de eliminar el elemento. Ten en cuenta que esta acción
            es <strong>irreversible</strong>. ¿Deseas eliminar este elemento?
          </p>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={closeConfirmationModal}>
            Cancelar
          </Button>
          <Button 
            variant="danger" 
            onClick={confirmDelete}>
            Eliminar
          </Button>
        </Modal.Footer>
      </Modal>
      {showToast && <SuccessToast />}
    </>
  );
};

export default ManageCategories;