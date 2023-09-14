import React, { useContext, useState, useEffect } from "react";
import { Form, Button, Container, Row, Col, Modal } from "react-bootstrap";
import { useParams } from "react-router-dom";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { AuthContext } from "../../../context/AuthContext";
import axios from "axios";
import moment from "moment";

const CreateBooking = () => {
  const { productId } = useParams();
  const { token } = useContext(AuthContext);
  const { datosUsuario } = useContext(AuthContext);
  const [productToBook, setProductToBook] = useState({});
  const [dateRange, setDateRange] = useState(null);
  const startDate = dateRange;  
  const [cantidadCupos, setCantidadCupos] = useState(1);
  const [tipoPaquete, setTipoPaquete] = useState("");
  const [showModal, setShowModal] = useState(false);

  const calculateEndDate = (startDate, duration) => {
    if (startDate && duration) {
      const endDate = moment(startDate).add(duration, 'days').toDate();
      return endDate;
    }
    return null;
  };

  const endDate = calculateEndDate(startDate, productToBook.duracionDias);

  const fetchProduct = async () => {
    try {
      const response = await axios.get(
        `http://18.224.212.146:8080/experiencia/detalle/${productId}`,
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
            Accept: "*/*",
          },
        }
      );
      const data = response.data;
      console.log({ data });
      setProductToBook(data);
    } catch (error) {
      console.error("Error fetching product data: ", error);
    }
  };

  useEffect(() => {
    fetchProduct();
  }, [productId]);

  const handleBooking = async () => {
    try {
      const payload = {
        email: datosUsuario.email,
        fechaInicio: moment(startDate).format("YYYY-MM-DD"),
        cantidadCupos,
        tipoPaquete,
      };
      console.log(payload, "payloadddd")
      const response = await axios.post(
        `http://18.224.212.146:8080/reserva/crear/${productId}`,
        payload,
        {
          headers: {
            "Content-Type": "application/json",
            Accept: "*/*",
            Authorization: `Bearer ${token}`,
          },
        }
      );
      setShowModal(true);
      console.log(response.data);
    } catch (error) {
      console.error("Error creating booking: ", error);
    }
  };

  const getPriceByPackage = () => {
    if (tipoPaquete === "Basic") {
      return productToBook.precioBasico;
    } else if (tipoPaquete === "Premium") {
      return productToBook.precioPremium;
    } else {
      return ""
    }
    return null;
  };

  const packagePrice = getPriceByPackage();

  console.log(productToBook)
  console.log(startDate, "startdate", endDate, "endDate")
  console.log(dateRange);
  return (
    <>
      <Container>
        <Row>
          <Col md={6}>
            <Row>
              <Col>
                <h4>Verifica tus datos</h4>
                <div className="user_data">
                  <p>
                    <span>Nombre: </span>
                    {datosUsuario.nombre}
                  </p>
                  <p>
                    <span>Apellido: </span>
                    {datosUsuario.apellido}
                  </p>
                  <p>
                    <span>Email: </span>
                    {datosUsuario.email}
                  </p>
                </div>
              </Col>
            </Row>
            <Row>
              <Col>
                <h4>Seleccione fecha de reserva</h4>
                <DatePicker
                  minDate={new Date()}
                  showDisabledMonthNavigation
                  selected={startDate}
                  onChange={(date) => setDateRange(date)}
                  dateFormat="MM/dd/yyyy"
                  inline
                  monthsShown={2}
                />
              </Col>
            </Row>
            <Row>
              <Col>
                <h4>Cantidad de cupos</h4>
                <Form.Control
                  type="number"
                  min={1}
                  value={cantidadCupos}
                  onChange={(e) => setCantidadCupos(Number(e.target.value))}
                />
              </Col>
            </Row>
            <Row>
              <Col>
                <h4>Tipo de paquete</h4>
                <Form.Control
                  as="select"
                  value={tipoPaquete}
                  onChange={(e) => setTipoPaquete(e.target.value)}
                >
                  <option value="Basic">Basic</option>
                  <option value="Premium">Premium</option>
                </Form.Control>
              </Col>
            </Row>
            <Row>
              <Col>
                <h4>Precio del paquete: {packagePrice}</h4>
              </Col>
            </Row>
          </Col>
          <Col md={6}>
            <h4>Detalle de la reserva</h4>
            <div className="booking_data">
              <p>{productToBook.nombreExperiencia}</p>
              <p>{productToBook.descripcion}</p>
              <p>
                Inicio: {startDate ? moment(startDate).format("l") : "-"}
              </p>
              <p>
                Finalización: {endDate ? moment(endDate).format("l") : "-"}
              </p>
            </div>
            {startDate && endDate ? <Button onClick={handleBooking}>Reservar</Button> : null}
          </Col>
        </Row>
      </Container>

      <Modal show={showModal} onHide={() => setShowModal(false)} centered>
        <Modal.Header closeButton>
          <Modal.Title>Reserva Exitosa</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <p>Tu reserva ha sido realizada exitosamente.</p>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowModal(false)}>
            Cerrar
          </Button>
        </Modal.Footer>
      </Modal>

    </>
  );
};

export default CreateBooking;
