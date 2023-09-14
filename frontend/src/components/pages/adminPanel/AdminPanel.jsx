import React, { useState } from "react";
import { Container, Row, Col, Nav } from "react-bootstrap";
import CreateProduct from "../createProduct/CreateProduct";
import ManageProducts from "./manageProducts/ManageProducts";
import CreateCategory from "../../forms/createCategory/CreateCategory";
import ManageCategories from "./manageCategories/ManageCategories";
import styles from "./AdminPanel.module.css";

const AdminPanel = () => {
  const [activeOption, setActiveOption] = useState("RegistrarProducto");

  const renderComponent = () => {
    switch (activeOption) {
      case "CreateProduct":
        return <CreateProduct />;
      case "ManageProducts":
        return <ManageProducts />;
      case "CreateCategory":
        return <CreateCategory />;
      case "ManageCategories":
          return <ManageCategories />;
      default:
        return null;
    }
  };

  const handleOptionClick = (option) => {
    setActiveOption(option);
  };

  return (
    <Container fluid>
      <Row>
        <Col className={styles.fixed_column} sm={2} style={{ backgroundColor: "#f8f9fa", minHeight: "100%" }}>
          <h3 className={styles.panel_message}>Admin Panel</h3>
          <p className={styles.panel_message}>
            En este panel podrás gestionar los productos y categorias de Nomad Travel.
          </p>
          <Nav>
            <Nav.Link
              onClick={() => handleOptionClick("CreateProduct")}
              className={`${styles.menuOption} ${
                activeOption === "CreateProduct" ? styles.activeOption : ""
              }`}
            >
              Registrar producto
            </Nav.Link>
            <Nav.Link
              onClick={() => handleOptionClick("ManageProducts")}
              className={`${styles.menuOption} ${
                activeOption === "ManageProducts" ? styles.activeOption : ""
              }`}
            >
              Gestión de productos
            </Nav.Link>
            <Nav.Link
              onClick={() => handleOptionClick("CreateCategory")}
              className={`${styles.menuOption} ${
                activeOption === "CreateCategory" ? styles.activeOption : ""
              }`}
            >
              Registrar categoría
            </Nav.Link>
            <Nav.Link
              onClick={() => handleOptionClick("ManageCategories")}
              className={`${styles.menuOption} ${
                activeOption === "ManageCategories" ? styles.activeOption : ""
              }`}
            >
              Gestión de categorías
            </Nav.Link>
          </Nav>
        </Col>
        <Col sm={10}>{renderComponent()}</Col>
      </Row>
    </Container>
  );
};

export default AdminPanel;
