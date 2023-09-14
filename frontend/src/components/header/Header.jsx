import React from "react";
import styles from "./Header.module.css";
import Navbar from "../navbar/Navbar";

const Header = () => {
  return (
    <>
      <header className={styles.sticky_header}>
        <Navbar />
      </header>
    </>
  );
};

export default Header;
