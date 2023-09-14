import React from "react";
import styles from "./Footer.module.css"
import { Outlet } from "react-router-dom";

const Footer = () => {
  return (
    <footer>
      <div className={styles.nomad_travel_info}>
        <img src="./assets/footer_logo.png" alt="Logo de nomad travel" />
        <span>
          &copy; 2023 Nomad Travel. Todos los derechos reservados.
        </span>
      </div>
    </footer>
  );
};

export default Footer;
