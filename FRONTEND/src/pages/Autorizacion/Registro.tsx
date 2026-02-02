import { useState, FormEvent } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./Registro.css";

const Registro: React.FC = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [nombre, setNombre] = useState("");
  const [apellidos, setApellidos] = useState("");
  const [direccion, setDireccion] = useState("");
  const [fechaNacimiento, setFechaNacimiento] = useState("");
  const [error, setError] = useState("");

  const navigate = useNavigate();

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    setError("");

    try {
      const res = await fetch("http://localhost:8089/api/usuarios/registro", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          username,
          password,
          nombre,
          apellidos,
          direccion,
          fechaNacimiento, // ⚡ coincide con tu backend: "fechaNacimiento"
        }),
      });

      const data = await res.json();

      if (!res.ok) {
        // 🔹 Muestra el mensaje de error que envía el backend
        throw new Error(data || "Error al registrar el usuario");
      }

      console.log("Usuario registrado:", data);
      navigate("/login");

    } catch (err: any) {
      setError(err.message);
    }
  };

  return (
    <div className="auth-page">
      <form className="auth-card" onSubmit={handleSubmit}>
        <h2>Registro</h2>

        <label>Usuario</label>
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />

        <label>Contraseña</label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />

        <label>Nombre</label>
        <input
          type="text"
          value={nombre}
          onChange={(e) => setNombre(e.target.value)}
        />

        <label>Apellidos</label>
        <input
          type="text"
          value={apellidos}
          onChange={(e) => setApellidos(e.target.value)}
        />

        <label>Dirección</label>
        <input
          type="text"
          value={direccion}
          onChange={(e) => setDireccion(e.target.value)}
        />

        <label>Fecha de nacimiento</label>
        <input
          type="date"
          value={fechaNacimiento}
          onChange={(e) => setFechaNacimiento(e.target.value)}
        />

        <button type="submit" className="btn register-btn">
          Registrar
        </button>

        {error && <p className="error">{error}</p>}

        <Link to="/" className="btn back-btn">
          Volver
        </Link>
      </form>
    </div>
  );
};

export default Registro;
