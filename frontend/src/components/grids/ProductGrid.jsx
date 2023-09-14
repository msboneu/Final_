import React from "react";
import ProductCard from "../cards/productCard.jsx";
import styles from "./ProductGrid.module.css"

const ProductGrid = ({ products }) => {

  return (
    <div className={styles.grid_container}>
      {products.map((item, index) => (
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
  );
};

export default ProductGrid;