import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import App from "./App";
import Detail from "./components/pages/detail/Detail";
import Layout from "./components/layout/Layout";
import Login from "./components/pages/login/Login";
import "./index.css";
import Signup from "./components/pages/signup/Signup";
import Categories from "./components/pages/categories/Categories";
import AuthContextProvider, { AuthContext } from "./context/AuthContext";
import ProtectedRoutes from "./ProtectedRoutes";
import AdminPanel from "./components/pages/adminPanel/AdminPanel";
import BookingsPanel from "./components/pages/adminPanel/manageBookings/BookingsPanel";
import MyBookings from "./components/pages/bookings/MyBookings";
import CreateBooking from "./components/pages/bookings/CreateBooking";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <BrowserRouter>
      <AuthContextProvider>
        <Routes>
          <Route element={<Layout />}>
            <Route path="/" element={<App />}></Route>
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/categories" element={<Categories />} />
            <Route path="/product/:productId" element={<Detail />} />
            <Route path="/bookings" element={<BookingsPanel />} />
            <Route path="/mybookings" element={<MyBookings />} />
            <Route
              path="/createBooking/:productId"
              element={<CreateBooking />}
            />
            <Route element={<ProtectedRoutes />}>
              <Route path="/adminPanel" element={<AdminPanel />} />
            </Route>
          </Route>
        </Routes>
      </AuthContextProvider>
    </BrowserRouter>
  </React.StrictMode>
);
