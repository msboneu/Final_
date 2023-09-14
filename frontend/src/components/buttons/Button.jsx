import React from "react";
import styles from "./Button.module.css"

const Button = ({ label, id, type, name, onClick }) => {
  return (
    <button
      id={id}
      type={type}
      name={name}
      onClick={onClick}
      className={styles.regular_button}
    >
      {label}
    </button>
  );
};

export default Button;
