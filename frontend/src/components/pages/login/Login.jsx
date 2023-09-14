import React, { useContext, useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import { AuthContext } from "../../../context/AuthContext";
import logo from "../../../../public/assets/logo_letras_blanco.png";
import "./Login.css";
import FullPageLoader from "../../loaders/FullPageLoader";

const Login = () => {
  const [resUser, setResUser] = useState({
    email: "",
    password: "",
  });
  const [loading, setLoading] = useState(false);
  const { dispatch } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      setLoading(true);
      const response = await axios.post(
        "http://18.224.212.146:8080/autenticacion/autenticar",
        resUser
      );
      const token = response.data.token;
      const datosUsuario = response.data.datosUsuario;
      dispatch({
        type: "LOGIN",
        payload: { datosUsuario, token },
      });
      setLoading(false);
      navigate("/");
    } catch (error) {
      setLoading(false);
      console.error("Error during login:", error);
    }
  };
  console.log({ resUser });
  return (
    <>
      {!loading ? (
        <div className="login">
          <div className="container">
            <div className="d-flex flex-lg-row flex-column-reverse">
              <div className="card card1">
                <div className="row justify-content-center my-auto">
                  <div className="col-md-8 col-10">
                    <div className="row justify-content-center ">
                      {/* <img id="logo" src={logo} alt="Logo" /> */}
                      <h1 className="text-center p-3">¡Bienvenidos!</h1>
                    </div>

                    <h6 className="msg-info">
                      Porfavor, usa tu cuenta para iniciar sesión
                    </h6>

                    <form action="" onSubmit={handleSubmit}>
                      <div className="form-group">
                        <label className="form-control-label">Usuario</label>
                        <input
                          type="text"
                          id="email"
                          name="email"
                          placeholder="Ingrese su email"
                          className="form-control"
                          value={resUser.name}
                          onChange={(e) =>
                            setResUser({ ...resUser, email: e.target.value })
                          }
                        />
                      </div>

                      <div className="form-group">
                        <label className="form-control-label">Contraseña</label>
                        <input
                          type="password"
                          id="psw"
                          name="psw"
                          placeholder="Ingrese su contraseña"
                          className="form-control"
                          value={resUser.password}
                          onChange={(e) =>
                            setResUser({ ...resUser, password: e.target.value })
                          }
                        />
                      </div>
                      <div className="row justify-content-center ">
                        <button
                          type="submit"
                          className="btn btn-block btn-color"
                        >
                          Iniciar Sesión
                        </button>
                      </div>
                    </form>
                  </div>
                </div>
                <div className="bottom text-center sinup-options">
                  <p className="sm-text text-muted">¿No tienes cuenta?</p>
                  <Link to="/signup">Crear Cuenta</Link>
                </div>
              </div>
              <div className="card card2">
                <div className="">
                  <img id="logo" src={logo} alt="Logo" />
                </div>
              </div>
            </div>
          </div>
        </div>
      ) : (
        <FullPageLoader />
      )}
    </>
  );
};

export default Login;
