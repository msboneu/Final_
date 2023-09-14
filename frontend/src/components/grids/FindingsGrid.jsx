import React, { useState, useEffect } from "react";
import axios from "axios";
import ProductCard from "../cards/productCard.jsx";
import styles from "./ProductGrid.module.css"

const FindingsGrid = () => {
  const [products, setProducts] = useState([]);
  const [shuffledProducts, setShuffledProducts] = useState([]);

  const shuffleArray = (array) => {
    const newArray = [...array];
    for (let i = newArray.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [newArray[i], newArray[j]] = [newArray[j], newArray[i]];
    }
    return newArray;
  };

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

  useEffect(() => {
    const shuffledArray = shuffleArray(products);
    setShuffledProducts(shuffledArray);
  }, [products]);

  return (
    <section className={styles.findings_section}>
      <h2>Recomendaciones</h2>
      <div className={styles.grid_container}>
        {shuffledProducts.slice(0, 9).map((item, index) => (
          <div key={index}>
            <ProductCard
              nombre={item.nombreExperiencia}
              descripcion={item.descripcion}
              precioBasic={item.precioBasico}
              precioPremium={item.precioPremium}
              categoria={item.categoria}
              url={item.urlImagen}
              id={item.id}
            />
          </div>
        ))}
      </div>
    </section>
  );
};

export default FindingsGrid;
