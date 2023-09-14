import { useContext } from "react";
import { Outlet, Navigate } from "react-router-dom";
import { AuthContext } from "./context/AuthContext";

const ProtectedRoutes = () => {
  const { datosUsuario } = useContext(AuthContext);

  if (datosUsuario.rol === "USER") {
    return <Navigate to="/" />;
  }

  return <Outlet />;
};

export default ProtectedRoutes;
