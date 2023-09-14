import React from "react";
import axios from "axios";
import styles from "./BookingCard.module.css"
import { Row, Col, Image } from 'react-bootstrap';

function BookingCard({ booking }) {
    const {
      experiencia,
      paqueteReservado,
      precioTotal,
      fechaInicio,
      fechaFin,
      cantidadCupos,
      imageUrl,
    } = booking;
  
    return (
      <Col md={6} lg={4}>
        <Row className="mb-4">
          <Col md={4}>
            <Image src={imageUrl} alt="Product Image" fluid rounded />
          </Col>
          <Col md={8}>
            <h5>{experiencia}</h5>
            <p>Package: {paqueteReservado}</p>
            <p>Total Price: ${precioTotal}</p>
          </Col>
        </Row>
        <Row>
          <Col md={12}>
            <p>Start Date: {fechaInicio}</p>
            <p>End Date: {fechaFin}</p>
            <p>No. of People: {cantidadCupos}</p>
          </Col>
        </Row>
      </Col>
    );
  }
  
  export default BookingCard;