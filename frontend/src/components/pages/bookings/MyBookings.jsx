import React, { useState, useEffect } from "react";
import { AuthContext } from "../../../context/AuthContext";
import { useContext } from "react";
import axios from "axios";
import { Container, Row, Col, Card } from "react-bootstrap";
import ProductCard from "../../cards/productCard";
import styles from "./MyBookings.module.css"

const MyBookings = () => {

    const [bookings, setBookings] = useState([]);
    const { datosUsuario } = useContext(AuthContext);

    useEffect(() => {
        const fetchBookings = async () => {
          try {
            const response = await axios.get(
              `http://18.224.212.146:8080/usuario/reservas/${datosUsuario.id}`,
              {
                method: "GET",
                headers: {
                  "Content-Type": "application/json",
                  Accept: "*/*",
                },
              }
            );
            const data = response.data;
            setBookings(data);
          } catch (error) {
            console.error("Error fetching bookings:", error);
          }
        };
        
        fetchBookings();
      }, []);

      const fetchExperiences = async () => {
        try {
          const response = await axios.get(
            "http://18.224.212.146:8080/experiencia/listarExperiencias"
          );
          const experiences = response.data;
          setBookings((prevBookings) => {
            return prevBookings.map((booking) => {
              const matchingExperience = experiences.find(
                (experience) => experience.nombreExperiencia === booking.experiencia
              );
              return {
                ...booking,
                urlImagen: matchingExperience?.urlImagen || "",
              };
            });
          });
        } catch (error) {
          console.error("Error fetching experiences:", error);
        }
      };
    
      useEffect(() => {
        fetchExperiences();
      }, []);

      console.log(bookings, "bookingz")
  
    return (
      <Container>
        <Row className="my-4">
          <Col>
            <h1>Mis Reservas</h1>
            <p>En este espacio encontrarás todas las reservas que has realizado con Nomad Travel. Contáctanos a nuestro correo nomad@travel.com si necesitas asistencia al respecto.</p>
          </Col>
        </Row>

        {bookings.length === 0 ? (
          <p className={`alert alert-primary ${styles.no_bookings}`}>
            No tienes ninguna reserva. ¡Te invitamos a explorar la gran variedad de viajes y experiencias alucinantes que tenemos para tí!
            <br/>
            <br/>
            Puedes visitar nuestra página de <a className="link-info" href="/categories">categorías</a> para buscar experiencias.
          </p>
        ) : (
        <div className={styles.booking_cards}>
            {bookings.map((booking) => (
            <Col key={booking.id} md={12} lg={12} className="mb-6">
                <ProductCard
                    nombre={booking.experiencia}
                    descripcion={booking.descripcion}
                    mostrarPrecios={false}
                    mostrarDetalle={false}
                    url={booking.urlImagen}
                    reserva={booking}
                    mostrarReserva={true}
                />
            </Col>
            ))}
        </div>
          )}
      </Container>
    );
  };
  
  export default MyBookings;