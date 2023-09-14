  import React, { useState, useEffect } from "react";
  import styles from "./Categories.module.css"
  import ProductGrid from "../../grids/ProductGrid";
  import HomeSearch from "../../home_search/HomeSearch";
  import { useLocation } from "react-router-dom";
  import axios from "axios";

  const Categories = () => {

    const [categories, setCategories] = useState([]);
    const [productos, setProductos] = useState([]);
    const [loading, setLoading] = useState(true);

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
          setProductos(data);
          setLoading(false);
        } catch (error) {
          console.error("Error fetching products:", error.response.data.messages);
          setLoading(false);
        }
      };

      fetchProducts();
    }, []);

    useEffect(() => {
      const fetchCategories = async () => {
        setLoading(true);
        try {
          const response = await axios.get("http://18.224.212.146:8080/categoria/listar");
          const data = response.data;
          const filteredCategories = data.filter((category) =>
            categoryHasProducts(category)
          );
          setCategories(filteredCategories);
          setLoading(false);
        } catch (error) {
          console.error("Error fetching categories:", error);
          setLoading(false);
        }
      };

      fetchCategories();
    }, [productos]);

    const categoryHasProducts = (category) => {
      return productos.some(
        (product) => product.categoria === category.tipoExperiencia
      );
    };

    const [selectedCategory, setSelectedCategory] = useState(null);
    const [searchParams, setSearchParams] = useState({});
    const location = useLocation();

    useEffect(() => {
      const queryParams = new URLSearchParams(location.search);
      const selectedCategoryParam = queryParams.get("selectedCategory");
    
      if (selectedCategoryParam) {
        const decodedCategoryName = decodeURIComponent(selectedCategoryParam);
        const category = categories.find((cat) => cat.tipoExperiencia === decodedCategoryName);
        setSelectedCategory(category);
      } else {
        setSelectedCategory(null);
      }
    
      const keywords = queryParams.get("keywords") || "";
      const locationParam = queryParams.get("location") || "";
      setSearchParams({ keywords, location: locationParam });
    }, [location.search, categories]);

    const handleSearchParams = (params) => {
      setSearchParams(params);
      setSelectedCategory(null);
    };

    const handleCategoryClick = (category) => {
      setSelectedCategory(category);
      setSearchParams({});
      const queryParams = new URLSearchParams(location.search);
      queryParams.set("selectedCategory", encodeURIComponent(category.tipoExperiencia));
      const newUrl = `${location.pathname}?${queryParams.toString()}`;
      window.history.pushState(null, "", newUrl);
    };

    const filteredProducts = productos.filter((product) => {
      const matchesCategory = !selectedCategory || product.categoria === selectedCategory.tipoExperiencia;
      const matchesKeywords =
        !searchParams.keywords ||
        product.nombreExperiencia.toLowerCase().includes(searchParams.keywords.toLowerCase()) ||
        product.descripcion.toLowerCase().includes(searchParams.keywords.toLowerCase());
      const matchesLocation =
        !searchParams.location || product.destino.toLowerCase().includes(searchParams.location.toLowerCase());
      return matchesCategory && matchesKeywords && matchesLocation;
    });

      return (
          <>
            <main className={styles.category_hero}>
                <HomeSearch 
                  setSearchParams={handleSearchParams}
                  searchTitle="Explora el mundo, a tu medida"
                  searchDescription="Nomad Travel te ofrece paquetes exclusivos para que tengas la mejor experiencia en tus viajes"
                  searchParams={searchParams}
                />
                <div className={styles.category_hero_filters}>
                  {categories.map((category) => (
                    <button
                      key={category.id}
                      type="button"
                      className={`btn btn-outline-primary m-2 ${
                        selectedCategory === category ? "active" : ""
                      }`}
                      onClick={() => handleCategoryClick(category)}
                    >
                    {category.tipoExperiencia}
                    </button>
                  ))}
                </div>
            </main>
            <section className={`container ${styles.category_filters}`}>
              <div className={`row ${styles.category_filters_container}`}>
                <div className={`col-md-2 ${styles.category_filters_container_side}`}>
                  <h4>Categorías</h4>
                  <ul className="list-group">
                    {categories.map((category) => (
                      <li
                        key={category.id}
                        className={`list-group-item d-flex justify-content-between align-items-center ${
                          selectedCategory === category ? "active" : ""
                        }`}
                        onClick={() => handleCategoryClick(category)}
                      >
                        <span className={styles.category_name_list_group} data-bs-toggle="tooltip">
                        {category.tipoExperiencia}
                        </span>
                        <span className={`badge badge-primary badge-pill ${styles.category_filters_container_side_pills}`}>
                          {category.stockCount}
                        </span>
                      </li>
                    ))}
                  </ul>
                </div>
                <div className={`col-md-10 ${styles.category_filter_grid}`}>
                <p className={`alert alert-primary ${styles.category_filter_grid_header} ${
                    filteredProducts.length === 0 ? styles.no_results : ""
                  }`}>
                    {loading ? (
                      "Cargando, solo unos segundos más..."
                    ) : (
                      filteredProducts.length > 0 ? (
                        selectedCategory ? (
                          `¡Estos son los paquetes de tipo ${selectedCategory.tipoExperiencia} que esperan por ti!`
                        ) : (
                          `¡Estos son los paquetes de experiencias increíbles que puedes adquirir hoy!`
                        )
                      ) : (
                        `Actualmente no contamos con experiencias relacionadas a tu búsqueda. ¡Estamos trabajando para traer cada vez más paquetes! Te invitamos a compartir tus sugerencias a nuestro correo experiencias@nomadtravel.com`
                      )
                    )}
                  </p>
                  <ProductGrid 
                    class="col-md-8"
                    products={filteredProducts}
                    selectedCategory={selectedCategory ? selectedCategory.tipoExperiencia : null}
                    searchParams={searchParams}
                  />             
                </div>
              </div>
            </section>
          </>
      )

  }

  export default Categories;