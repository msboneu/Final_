import React, { useEffect, useState } from "react";
import { useParams, useNavigate, Link } from "react-router-dom";
import styles from "./Detail.module.css";
import axios from "axios";
import { Button } from "react-bootstrap";

const Detail = () => {
  const paquetePremiun = [
    {
      icon: "restaurant",
      servicio: "alimentacion",
    },
    {
      icon: "airplane_ticket",
      servicio: "transporte",
    },
    {
      icon: "redeem",
      servicio: "souvenir",
    },
    {
      icon: "home_health",
      servicio: "seguro medico",
    },
  ];
  const paqueteBasico = [
    {
      icon: "airplane_ticket",
      servicio: "transporte",
    },
    {
      icon: "redeem",
      servicio: "souvenir",
    },
  ];
  const navigate = useNavigate();
  const { productId } = useParams();
  const [product, setProduct] = useState(null);

  const handleGoBack = () => {
    navigate(-1);
  };

  useEffect(() => {
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
        setProduct(data);
      } catch (error) {
        console.error("Error fetching product data: ", error);
      }
    };

    fetchProduct();
  }, [productId]);

  if (!product) {
    return <div>Loading...</div>;
  }

  return (
    <>
      <div className={styles.detail_page}>
        <div className={styles.detail_actions}>
          <button onClick={handleGoBack}>
            <span class="material-symbols-outlined">arrow_back</span>
          </button>
          <Link to={`/createBooking/${productId}`}>
            <Button>Reservar</Button>
          </Link>
        </div>
        <h1 className={styles.detail_title} id="imgtext">
          {product.nombreExperiencia}
        </h1>
        <p className={styles.detail_description}>
          <span className="material-symbols-outlined">pin_drop</span>
          {product.destino}
        </p>
        <section className={styles.detail_section}>
          <div className={styles.image_grid}>
            <img
              id="expandedImg"
              src={product.imagenes[0]}
              alt={product.nombreExperiencia}
              className={`${styles.image_grid_col_2} ${styles.image_grid_row_2}`}
            />
            <img src={product.imagenes[1]} alt={product.nombreExperiencia} />
            <img
              src={product.imagenes[2]}
              alt={product.nombreExperiencia}
              className="detail-thumbnail"
            />

            <img src={product.imagenes[3]} alt={product.nombreExperiencia} />

            <img src={product.imagenes[4]} alt={product.nombreExperiencia} />
          </div>
          <div className={styles.detail_info}>
            <h2>Detalles</h2>
            <p className={styles.detail_text}>{product.descripcion}</p>
            <h2>Servicios</h2>
            <div className="detail-services">
              <div>
                <h4>premium</h4>
                <ul className={styles.detail_services_list}>
                  {paquetePremiun.map((item, index) => (
                    <div
                      className={styles.detail_services_list_item}
                      key={index}
                    >
                      <span className="material-symbols-outlined">
                        {item.icon}
                      </span>
                      <li>{item.servicio}</li>
                    </div>
                  ))}
                </ul>
              </div>
              <div>
                <h4>basic</h4>
                <ul className={styles.detail_services_list}>
                  {paqueteBasico.map((item, index) => (
                    <div
                      className={styles.detail_services_list_item}
                      key={index}
                    >
                      <span className="material-symbols-outlined">
                        {item.icon}
                      </span>
                      <li>{item.servicio}</li>
                    </div>
                  ))}
                </ul>
              </div>
            </div>
          </div>
        </section>
      </div>
    </>
  );
};

export default Detail;
