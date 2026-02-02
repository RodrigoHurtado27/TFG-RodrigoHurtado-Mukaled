import React from "react";

const EmpleadoDashboard: React.FC = () => {
  const storedUser = sessionStorage.getItem("usuario");
  const user = storedUser ? JSON.parse(storedUser) : null;

  return (
    <div style={{ padding: "40px", fontFamily: "sans-serif" }}>
      <h1>Dashboard de Trabajador</h1>
      {user ? (
        <p>Bienvenido, {user.username}!</p>
      ) : (
        <p>No se encontró información del usuario.</p>
      )}
    </div>
  );
};

export default EmpleadoDashboard;
