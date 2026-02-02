import { useState, FormEvent } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./Login.css";

interface User {
  id: number;
  username: string;
  role: string; // 'admin', 'user', 'empleado'
}

const Login: React.FC = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    setError("");

    try {
      const authHeader = "Basic " + btoa(username + ":" + password);

      const res = await fetch("http://localhost:8089/api/usuarios/login", {
        method: "POST",
        headers: {
          "Authorization": authHeader,
          "Content-Type": "application/json",
        },
        credentials: "include", // cookies de sesión si las usas
      });

      if (!res.ok) {
        const text = await res.text();
        throw new Error(text || "Usuario o contraseña incorrectos");
      }

      const user: User = await res.json();
      console.log("Usuario logueado:", user);

      if (!user.role) {
        throw new Error("No se encontró rol del usuario");
      }

      // Guardar usuario en sessionStorage
      sessionStorage.setItem("usuario", JSON.stringify(user));

      // Redirigir según el rol
      console.log("Redirigiendo según rol:", user.role);
      switch (user.role.toLowerCase()) {
        case "admin":
          navigate("/admin/dashboard");
          break;
        case "empleado":
          navigate("/empleado/dashboard");
          break;
        case "cliente":
          navigate("/cliente/dashboard");
          break;
        default:
          console.warn("Rol desconocido, redirigiendo a /");
          navigate("/");
      }
    } catch (err: any) {
      console.error("Error al iniciar sesión:", err);
      setError(err.message);
    }
  };

  return (
    <div className="auth-page">
      <form className="auth-card" onSubmit={handleSubmit}>
        <h2>Iniciar Sesión</h2>

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

        <button type="submit" className="btn login-btn">
          Entrar
        </button>

        {error && <p className="error">{error}</p>}

        <p>
          ¿No tienes cuenta? <Link to="/registro">Regístrate</Link>
        </p>

        <Link to="/" className="btn back-btn">
          Volver
        </Link>
      </form>
    </div>
  );
};

export default Login;
