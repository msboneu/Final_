import { createContext, useReducer } from "react";

export const AuthContext = createContext();

const initialState = {
  datosUsuario: JSON.parse(localStorage.getItem("datosUsuario")) || null,
  token: localStorage.getItem("token") || "",
};

const authReducer = (state, action) => {
  switch (action.type) {
    case "LOGIN":
      localStorage.setItem("token", action.payload.token);
      localStorage.setItem("datosUsuario", JSON.stringify(action.payload.datosUsuario));
      return {
        ...state,
        datosUsuario: action.payload.datosUsuario,
        token: action.payload.token,
      };
    case "LOGOUT":
      localStorage.removeItem("token");
      localStorage.removeItem("datosUsuario");
      return {
        ...state,
        datosUsuario: null,
        token: "",
      };

    default:
      return state;
  }
};

const AuthContextProvider = ({ children }) => {
  const [state, dispatch] = useReducer(authReducer, initialState);

  const data = {
    dispatch,
    datosUsuario: state.datosUsuario,
    token: state.token,
  };

  return <AuthContext.Provider value={data}>{children}</AuthContext.Provider>;
};

export default AuthContextProvider;
