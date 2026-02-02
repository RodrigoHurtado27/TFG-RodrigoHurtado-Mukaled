import { Link } from "react-router-dom";
import { useTranslation } from "react-i18next";

function Header() {
  const { i18n, t } = useTranslation();

  return (
    <header className="site-header">
      {/* LOGO */}
      <img src="/logo3.png" alt="X Madrid Hotel" className="logo" />

      {/* NAVEGACIÓN */}
      <nav className="header-nav">
        <Link to="/">{t("nav.hotel")}</Link>
        <Link to="/madrid">{t("nav.madrid")}</Link>
        <Link to="/servicios">{t("nav.servicios")}</Link>
        <Link to="/tienda">{t("nav.tienda")}</Link>
      </nav>

      {/* AREA DE ACCIONES: IDIOMA + LOGIN/REGISTRO */}
      <div className="header-actions">
        {/* Banderas de idioma */}
        <div className="lang-switch">
          <button onClick={() => i18n.changeLanguage("es")}>
            <img src="/es.png" alt="Español" />
          </button>
          <button onClick={() => i18n.changeLanguage("en")}>
            <img src="/en.png" alt="English" />
          </button>
        </div>

        {/* Botones Login/Registro */}
        <div className="auth-buttons">
          <Link to="/login" className="login-btn">
            {t("auth.login", "Login")}
          </Link>
          <Link to="/registro" className="register-btn">
            {t("auth.register", "Registro")}
          </Link>
        </div>
      </div>
    </header>
  );
}

export default Header;
