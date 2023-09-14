import React from "react";
import styles from "./ProductCard.module.css"
import { Link } from "react-router-dom";
import ResultRatings from "../rating/ResultRatings";

const ProductCard = ({
  nombre,
  descripcion,
  precioBasic,
  precioPremium,
  url,
  id,
  reserva = {},
  mostrarCalificacion = true,
  mostrarPrecios = true,
  mostrarDetalle = true,
  mostrarReserva = false,
}) => {
  return (
    <div className={styles.card_product}>
      {" "}
      <div className={`${styles.card} mb-3`}>
        <div className="row g-0">
          <div className="col-md-4">
            <img src={url} className={`${styles.card_img} img-fluid rounded-start`} alt="..." />
          </div>
          <div className="col-md-8">
            <div className={styles.card_body}>
              <h5 className={styles.card_title}>{nombre}</h5>
              {mostrarCalificacion && <ResultRatings />}
              <p className={styles.card_text}>{descripcion}</p>
              {mostrarPrecios && <p className={styles.card_price}>
                basic: {precioBasic}$ | premium: {precioPremium}$
              </p>}
              {mostrarDetalle && <div className={styles.card_actions}>
                <Link to={`/product/${id}`}>
                  Ver más
                </Link>
              </div>}
              {mostrarReserva && 
                <>
                  <span className={styles.separator}></span>
                  <div className={styles.card_booking}>
                    <h5 className={styles.card_title}>Detalles de tu reserva</h5>
                    <div className={styles.card_booking_property}>
                      <h4 className={styles.card_subtitle_booking}>Fecha reservada: </h4>
                      <p>{reserva.fechaInicio}</p>
                    </div>
                    <div className={styles.card_booking_property}>
                      <h4 className={styles.card_subtitle_booking}>Fecha fin: </h4>
                      <p>{reserva.fechaFin}</p>
                    </div>
                    <div className={styles.card_booking_property}>
                      <h4 className={styles.card_subtitle_booking}>Personas: </h4>
                      <p>{reserva.cantidadCupos}</p>
                    </div>
                    <div className={styles.card_booking_property}>
                     <h4 className={styles.card_subtitle_booking}>Beneficios del paquete: </h4>
                     <p>{reserva.paqueteReservado}</p>
                    </div>
                  </div>
                </>}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;
