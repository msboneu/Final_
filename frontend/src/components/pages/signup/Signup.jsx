import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./Signup.css";
import RegisterForm from "../../forms/register/RegisterForm";

const Signup = () => {
  const [registerType, setRegisterType] = useState("user");
  return (
    <div className="register">
      <div className="row">
        {/* <div className="col-md-4">
          <h3>Hola, ¿Ya tienes cuenta?</h3>
          <Link to="/login">Login</Link>
          <br />
        </div> */}
        <div className="col-md-12">
          <RegisterForm />
        </div>
      </div>
    </div>
  );
};

export default Signup;
