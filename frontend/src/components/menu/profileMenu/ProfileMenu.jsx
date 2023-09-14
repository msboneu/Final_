import React, { useContext, useState } from "react";
import styles from "./ProfileMenu.module.css";
import { AuthContext } from "../../../context/AuthContext";
import { Link, useNavigate } from "react-router-dom";

const ProfileMenu = ({ children }) => {
  const navigate = useNavigate();
  const [open, setOpen] = useState(false);
  const { datosUsuario , dispatch } = useContext(AuthContext);
  const toggleMenu = () => {
    setOpen(!open);
  };

  const handleLogout = () => {
    dispatch({
      type: "LOGOUT",
    });
    navigate("/");
  };

  return (
    <>
      <div className={styles.profile_dropdown}>
        <div className={styles.menu_trigger} onClick={toggleMenu}>
          <span className="material-symbols-outlined">account_circle</span>
        </div>
        {open && (
          <div className={styles.menu_container}>
            <ul className={styles.dropdown_menu}>
              <li className={styles.disabled}>Mi Perfil</li>
              {datosUsuario.rol === "USER" && (
                <Link to="/mybookings">
                  <li>Mis Reservas</li>
                </Link>
              )}
              {datosUsuario.rol === "ADMIN" && (
                <Link to="/adminPanel">
                  <li>Admin Panel</li>
                </Link>
              )}
              <Link onClick={handleLogout} to="/">
                <li>Cerrar Sesión</li>
              </Link>
            </ul>
          </div>
        )}
      </div>
    </>
  );
};

export default ProfileMenu;
