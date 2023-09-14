import React, { useState, useEffect } from "react";
import { Table, Button, Modal } from "react-bootstrap";
import axios from "axios";
import styles from "./ManageProducts.module.css";
import { Toast } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useContext } from "react";
import { AuthContext } from "../../../../context/AuthContext";

const ManageProducts = () => {

  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await axios.get(
          "http://18.224.212.146:8080/experiencia/listarExperiencias",
          {
            method: "GET",
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
        await axios.delete(
          `http://18.224.212.146:8080/experiencia/eliminar/${selectedItem.id}`,
          {
            headers: {
              "Content-Type": "application/json",
              Accept: "*/*",
              Authorization: `Bearer ${token}`,
            },
          }
        );
        setShowToast(true);
        setProducts((prevProducts) =>
          prevProducts.filter((product) => product.id !== selectedItem.id)
        );
      } catch (error) {
        console.error("Error deleting item:", error);
      }
      setSelectedItem(null);
    }
    setShowModal(false);
  };

  const SuccessToast = () => (
    <Toast className={styles.delete_toast} show={showToast} onClose={() => setShowToast(false)} delay={3000} autohide>
      <Toast.Header>
        <strong className="me-auto">Petición exitosa</strong>
      </Toast.Header>
      <Toast.Body>Producto eliminado.</Toast.Body>
    </Toast>
  );

  const closeConfirmationModal = () => {
    setShowModal(false);
  };

  const headers = [
    "id",
    "nombreExperiencia",
    "urlImagen",
    "descripcion",
    "categoria",
    "precioBasico",
    "precioPremium",
  ];

  const fields = [
    "id",
    "nombreExperiencia",
    "urlImagen",
    "descripcion",
    "categoria",
    "precioBasico",
    "precioPremium",
  ];

  return (
    <>
      <div className={styles.info}>
        <h2>Gestión de productos</h2>
        <p>
          Consulta la lista completa de productos disponibles. Puedes eliminar productos, pero ten en cuenta que esta acción es
          irreversible.
        </p>
      </div>
      <div className={styles.table_list}>
        <Table responsive>
          <thead>
            <tr>
              {headers.map((header) => (
                <th key={header}>{header}</th>
              ))}
              <th>Eliminar</th>
            </tr>
          </thead>
          <tbody>
            {products.map((item) => (
              <tr key={item.id} className={styles.table_row}>
                {fields.map((field) => (
                  <td className={styles.cell_content} key={field}>
                    {item[field]}
                  </td>
                ))}
                <td>
                  <Button 
                    variant="danger" 
                    onClick={() => handleDelete(item)}
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
      </div>
    </>
  );
};

export default ManageProducts;
