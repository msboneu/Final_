import React from "react";
import Spinner from "react-bootstrap/Spinner";
import styles from "./FullPageLoader.module.css";

const FullPageLoader = () => {
  return (
    <div className={styles.spinner_container}>
      <Spinner animation="border" role="status">
        <span className="visually-hidden">Loading...</span>
      </Spinner>
    </div>
  );
};

export default FullPageLoader;
