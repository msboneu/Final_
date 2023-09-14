import React, { useContext, useState } from "react";
import "./Navbar.css"; // Importa tu archivo de estilos CSS
import { Link, useLocation } from "react-router-dom";
import Button from "../buttons/Button";
import logo from "../../../public/assets/header_logo.png";
import { AuthContext } from "../../context/AuthContext";
import ProfileMenu from "../menu/profileMenu/ProfileMenu";

const Navbar = () => {
  const location = useLocation();
  const { datosUsuario } = useContext(AuthContext);
  const [isOpen, setIsOpen] = useState(false);

  const toggleDropdown = () => {
    setIsOpen(!isOpen);
  };

  console.log(datosUsuario);
  
  return (
    <>
      <nav class="navbar navbar-expand-lg">
        <Link to="/">
          <img src={logo} alt="nomad_travel_logo" />
          <p>Nomad Travel</p>
        </Link>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div
          class="collapse navbar-collapse d-flex justify-content-end"
          id="navbarSupportedContent"
        >
          {!datosUsuario ? (
            <ul class="link-buttons">
              <li class="nav-item active">
                <Link to="signup">crear cuenta</Link>
              </li>
              <li class="nav-item dropdown">
                <Link to="/login">iniciar sesión</Link>
              </li>
            </ul>
          ) : (
            <ProfileMenu />
          )}
        </div>
      </nav>
    </>
  );
};

export default Navbar;

// {
//           /*
//                <nav>
//           <ul className="nav-links">
//             <li>
//               <Link>crear cuenta</Link>
//             </li>

//             <li>
//               <Link to="/login">iniciar sesión</Link>
//             </li>
//         elemento del perfin una vez el usuario este logueado
//         <li className="dropdown">
//           <button className="user-btn" onClick={toggleDropdown}>
//             <img src="ruta-del-icono-usuario.png" alt="Usuario" />
//           </button>
//           {isOpen && (
//             <ul className="dropdown-menu">
//               <li>
//                 <a href="/perfil">Mi cuenta</a>
//               </li>
//               <li>
//                 <button onClick={handleLogout}>Cerrar sesión</button>
//               </li>
//             </ul>
//           )}
//         </li>
//            </ul>
//         </nav> */
