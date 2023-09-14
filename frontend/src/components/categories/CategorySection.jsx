  import React, { useState, useEffect } from "react";
  import CategoryCard from "../cards/CategoryCard";
  import styles from "./CategorySection.module.css"
  import { Link } from "react-router-dom";
  import axios from "axios";

  const CategorySection = () => {

    const [categories, setCategories] = useState([]);
    const [products, setProducts] = useState([]);
  
    useEffect(() => {
      fetchCategoriesAndProducts();
    }, []);
  
    const fetchCategoriesAndProducts = () => {
      Promise.all([
        axios.get("http://18.224.212.146:8080/categoria/listar", {
          headers: {
            "Content-Type": "application/json",
            Accept: "*/*",
          },
        }),
        axios.get("http://18.224.212.146:8080/experiencia/listarExperiencias", {
          headers: {
            "Content-Type": "application/json",
            Accept: "*/*",
          },
        }),
      ])
        .then(([categoriesResponse, productsResponse]) => {
          const categoriesData = categoriesResponse.data;
          const productsData = productsResponse.data;
          setCategories(categoriesData);
          setProducts(productsData);
  
          const filteredCategories = categoriesData.filter((category) =>
            productsData.some((product) => category.tipoExperiencia === product.categoria)
          );
          setCategories(filteredCategories);
        })
        .catch((error) => console.error("Error fetching data:", error));
    };

    const leftScroll = () => {
      const categorySection = document.querySelector(`.${styles.category_section}`);
      const scrollAmount = categorySection.offsetWidth;
      categorySection.scrollLeft -= scrollAmount;
    };
  
    const rightScroll = () => {
      const categorySection = document.querySelector(`.${styles.category_section}`);
      const scrollAmount = categorySection.offsetWidth;
      categorySection.scrollLeft += scrollAmount;
    };

    return (
      <section className={styles.categories}>
        <button className={`${styles.left} btn`} onClick={leftScroll}>
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
          <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0zm3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
        </svg>
        </button>
        <h2 className={styles.categories_h2}>Categorías</h2>
        <div className={styles.category_section}>
          {categories.map((category, index) => (
            <CategoryCard
              key={index}
              image={category.urlImagen}
              name={category.tipoExperiencia}
            >
              <Link to={`/categories?selectedCategory=${encodeURIComponent(category.tipoExperiencia)}`} />
            </CategoryCard>
          ))}
        </div>
        <button className={`${styles.right} btn`} onClick={rightScroll}>
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
          <path d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"/>
        </svg>
        </button>
        <button className={`${styles.btn_all_categories} btn-link`}>
          <Link to={`/categories`}>
            Ver Todo
          </Link>  
        </button>
      </section>
    );
  };

  export default CategorySection;
