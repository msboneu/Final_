import React from "react";
import styles from "./CategoryCard.module.css"
import { Link } from "react-router-dom";

const CategoryCard = ({ image, name }) => {
  
  const encodedCategoryName = encodeURIComponent(name);

  return (
    <article className={styles.category_card}>
      <img className={styles.category_card_img} src={image} alt={name} />
      <Link
        style={{ textDecoration: 'none', color: 'black' }}
        to={{
          pathname: '/categories',
          search: `?selectedCategory=${encodedCategoryName}`,
          state: { selectedCategory: name }
        }}
        >
          <h3 className={styles.category_card_h3}>{name}</h3>
      </Link>
    </article>
  );
};

export default CategoryCard;