import { BrowserRouter, Routes, Route } from "react-router-dom";

// Componentes globales
import Header from "./components/Header";
import BookingBar from "./components/BookingBar";

// Páginas
import Home from "./pages/Home";
import Madrid from "./pages/Madrid";
import Login from "./pages/Autorizacion/Login";
import Registro from "./pages/Autorizacion/Registro";

// Dashboards
import AdminDashboard from "./pages/Dashboards/AdminDashboard";
import UserDashboard from "./pages/Dashboards/ClienteDashboard";
import EmpleadoDashboard from "./pages/Dashboards/EmpleadoDashboard";

function App() {
  return (
    <BrowserRouter>
      {/* Header global */}
      <Header />
      {/* BookingBar global */}
      <BookingBar />

      <Routes>
        {/* Páginas generales */}
        <Route path="/" element={<Home />} />
        <Route path="/madrid" element={<Madrid />} />
        <Route path="/login" element={<Login />} />
        <Route path="/registro" element={<Registro />} />

        {/* Dashboards */}
        <Route path="/admin/dashboard" element={<AdminDashboard />} />
        <Route path="/user/dashboard" element={<UserDashboard />} />
        <Route path="/empleado/dashboard" element={<EmpleadoDashboard />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
