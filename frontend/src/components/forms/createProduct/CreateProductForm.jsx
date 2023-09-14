import React from "react";
import { Form, Button, Container, Row, Col } from "react-bootstrap";
import styles from "./CreateProductForm.module.css";

const CreateProductForm = ({
  formRef,
  handleSubmit,
  handleChange,
  formData,
  errors,
  categorias,
}) => {
  return (
    <Container className={styles.create_product_container}>
      <Row>
        <Col className={styles.form_tagline} md={4}>
          <h1>Registrar Producto</h1>
        </Col>
        <Col className={styles.form_content} md={8}>
          <Form ref={formRef} onSubmit={handleSubmit}>
            <Row>
              <Col md={12}>
                <Form.Group
                  controlId="nombreExperiencia"
                  className={styles.form_group}
                  required
                >
                  <Form.Label className={styles.form_label}>
                    Nombre de la experiencia
                  </Form.Label>
                  <Form.Control
                    type="text"
                    name="nombreExperiencia"
                    placeholder="Ingresa el nombre de la experiencia"
                    value={formData.nombreExperiencia}
                    onChange={handleChange}
                    className={errors.descripcion && `${styles.is_invalid}`}
                  />
                  {errors.nombreExperiencia && (
                    <span className={styles.invalid_feedback}>
                      El nombre de la experiencia es obligatorio.
                    </span>
                  )}
                </Form.Group>
              </Col>
              <Col md={12}>
                <Form.Group className={styles.form_group} controlId="categoria">
                  <Form.Label className={styles.form_label}>
                    Categoría
                  </Form.Label>
                  <Form.Control
                    as="select"
                    name="categoria"
                    value={formData.categoria}
                    onChange={handleChange}
                    className={errors.descripcion && `${styles.is_invalid}`}
                  >
                    <option value="">Selecciona una categoría</option>
                    {categorias.map((categoria, index) => (
                      <option key={index} value={categoria.value}>
                        {categoria.name}
                      </option>
                    ))}
                  </Form.Control>
                  {errors.categoria && (
                    <span className={styles.invalid_feedback}>
                      {errors.categoria}
                    </span>
                  )}
                </Form.Group>
              </Col>
              <Col md={12}>
                <Form.Group className={styles.form_group} controlId="destino">
                  <Form.Label className={styles.form_label}>Destino</Form.Label>
                  <Form.Control
                    type="text"
                    name="destino"
                    placeholder="Ingresa el destino de la experiencia"
                    value={formData.destino}
                    onChange={handleChange}
                    className={errors.descripcion && `${styles.is_invalid}`}
                  />
                  {errors.destino && (
                    <span className={styles.invalid_feedback}>
                      El destino es obligatorio.
                    </span>
                  )}
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group
                  className={styles.form_group}
                  controlId="precioBasico"
                >
                  <Form.Label className={styles.form_label}>
                    Precio Básico
                  </Form.Label>
                  <Form.Control
                    type="number"
                    name="precioBasico"
                    placeholder="Ingresa el precio básico"
                    value={formData.precioBasico}
                    onChange={handleChange}
                    className={errors.descripcion && `${styles.is_invalid}`}
                  />
                  {errors.precioBasico && (
                    <span className={styles.invalid_feedback}>
                      Campo obligatorio
                    </span>
                  )}
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group
                  className={styles.form_group}
                  controlId="precioPremium"
                >
                  <Form.Label className={styles.form_label}>
                    Precio Premium
                  </Form.Label>
                  <Form.Control
                    type="number"
                    name="precioPremium"
                    placeholder="Ingresa el precio premium"
                    value={formData.precioPremium}
                    onChange={handleChange}
                    className={errors.descripcion && `${styles.is_invalid}`}
                  />
                  {errors.precioPremium && (
                    <span className={styles.invalid_feedback}>
                      Campo Obligatorio
                    </span>
                  )}
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group
                  className={styles.form_group}
                  controlId="cupoMaximo"
                >
                  <Form.Label className={styles.form_label}>
                    Cupo Máximo
                  </Form.Label>
                  <Form.Control
                    type="number"
                    name="cupoMaximo"
                    placeholder="Ingresa el cupo máximo de personas por día"
                    value={formData.cupoMaximo}
                    onChange={handleChange}
                    className={errors.cupoMaximo && `${styles.is_invalid}`}
                  />
                  {errors.cupoMaximo && (
                    <span className={styles.invalid_feedback}>
                      Campo Obligatorio
                    </span>
                  )}
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group
                  className={styles.form_group}
                  controlId="duracionDias"
                >
                  <Form.Label className={styles.form_label}>
                    Duración en días
                  </Form.Label>
                  <Form.Control
                    type="number"
                    name="duracionDias"
                    placeholder="Ingresa el cupo máximo por día"
                    value={formData.duracionDias}
                    onChange={handleChange}
                    className={errors.duracionDias && `${styles.is_invalid}`}
                  />
                  {errors.duracionDias && (
                    <span className={styles.invalid_feedback}>
                      Campo Obligatorio
                    </span>
                  )}
                </Form.Group>
              </Col>
              <Col md={12}>
                <Form.Group className={styles.form_group} controlId="url">
                  <Form.Label className={styles.form_label}>
                    URLs de imágenes (separadas por comas)
                  </Form.Label>
                  <Form.Control
                    type="text"
                    name="urlImagenes"
                    placeholder="Ingresa las URLs de las imágenes separadas por comas"
                    value={formData.urlImagenes}
                    onChange={handleChange}
                    className={errors.descripcion && `${styles.is_invalid}`}
                  />
                </Form.Group>
              </Col>
              <Col md={12}>
                <Form.Group
                  className={styles.form_group}
                  controlId="descripcion"
                >
                  <Form.Label className={styles.form_label}>
                    Descripción
                  </Form.Label>
                  <Form.Control
                    as="textarea"
                    name="descripcion"
                    placeholder="Ingresa la descripción de la experiencia"
                    value={formData.descripcion}
                    onChange={handleChange}
                    rows="5"
                    className={errors.descripcion && `${styles.is_invalid}`}
                  />
                  {errors.descripcion && (
                    <span className={styles.invalid_feedback}>
                      La descripción es obligatoria.
                    </span>
                  )}
                </Form.Group>
              </Col>

              <Col md={12} className={styles.form_submit_button}>
                <Form.Group>
                  <Button
                    variant="primary"
                    type="submit"
                    className={styles.btn_create}
                    aria-pressed="true"
                  >
                    Crear Producto
                  </Button>
                </Form.Group>
              </Col>
            </Row>
          </Form>
        </Col>
      </Row>
    </Container>
  );
};

export default CreateProductForm;