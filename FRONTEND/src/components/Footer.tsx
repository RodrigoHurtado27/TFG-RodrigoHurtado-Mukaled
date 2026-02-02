function Footer() {
    return (
      <footer className="experience-footer">
        {/* TEXTO PRINCIPAL */}
        <div className="footer-top">
          <h2>Vive Madrid desde dentro</h2>
          <p>
            No es solo dormir. Es sentir la ciudad, su ritmo y su elegancia.
          </p>
        </div>
  
        {/* EXPERIENCIAS */}
        <div className="footer-experiences">
          <div>🍸 Rooftop & Lounge</div>
          <div>🍽️ Gastronomía local</div>
          <div>🧖 Spa & Relax</div>
          <div>🏙️ Experiencias urbanas</div>
        </div>
  
        {/* PARTE INFERIOR */}
        <div className="footer-bottom">
          <div className="footer-contact">
            <strong>X Madrid Hotel</strong>
            <p>Madrid · España</p>
            <p>info@xmadridhotel.com</p>
          </div>
  
          <form className="footer-newsletter">
            <input
              type="email"
              placeholder="Tu email"
              aria-label="Email"
            />
            <button type="submit">Unirme</button>
          </form>
        </div>
      </footer>
    );
  }
  
  export default Footer;
  