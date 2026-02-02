import React, { useState } from "react";
import "./AdminDashboard.css";

const AdminDashboard: React.FC = () => {
  const [activeSection, setActiveSection] = useState("dashboard");

  const renderContent = () => {
    switch (activeSection) {
      case "dashboard":
        return <h2>Bienvenido al Dashboard</h2>;
      case "usuarios":
        return <h2>Gestión de Usuarios</h2>;
      case "reportes":
        return <h2>Reportes y Estadísticas</h2>;
      case "configuracion":
        return <h2>Configuración del Sistema</h2>;
      default:
        return <h2>Bienvenido al Dashboard</h2>;
    }
  };

  return (
    <div className="admin-dashboard">
      <aside className="sidebar">
        <h1 className="logo">AdminPanel</h1>
        <nav>
          <ul>
            <li
              className={activeSection === "dashboard" ? "active" : ""}
              onClick={() => setActiveSection("dashboard")}
            >
              Dashboard
            </li>
            <li
              className={activeSection === "usuarios" ? "active" : ""}
              onClick={() => setActiveSection("usuarios")}
            >
              Usuarios
            </li>
            <li
              className={activeSection === "reportes" ? "active" : ""}
              onClick={() => setActiveSection("reportes")}
            >
              Reportes
            </li>
            <li
              className={activeSection === "configuracion" ? "active" : ""}
              onClick={() => setActiveSection("configuracion")}
            >
              Configuración
            </li>
          </ul>
        </nav>
      </aside>

      <main className="content">{renderContent()}</main>
    </div>
  );
};

export default AdminDashboard;
