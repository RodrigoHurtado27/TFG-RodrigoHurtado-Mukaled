import "./Madrid.css";
import "./Home.css";

function Madrid() {
  return (
    <section className="madrid">
      <div className="madrid-hero">
        <h1>Madrid</h1>
        <p>
          Cultura, gastronomía y historia en el corazón de España.
        </p>
      </div>

      <div className="madrid-content">
        {/* MAPA */}
        <div className="madrid-map">
          <iframe
            title="Mapa Madrid"
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3036.149368093266!2d-3.703790684602368!3d40.41677597936421!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd42299780000001%3A0x4023c8c0d5000000!2sMadrid!5e0!3m2!1ses!2ses!4v1700000000000"
            loading="lazy"
          />
        </div>

        {/* SITIOS */}
        <div className="madrid-places">
          <h2>Sitios imprescindibles</h2>

          <ul>
            <li><strong>Gran Vía</strong> – Compras y vida nocturna</li>
            <li><strong>Puerta del Sol</strong> – Centro histórico</li>
            <li><strong>Plaza Mayor</strong> – Arquitectura clásica</li>
            <li><strong>Parque del Retiro</strong> – Naturaleza y relax</li>
            <li><strong>Museo del Prado</strong> – Arte de clase mundial</li>
          </ul>
        </div>
      </div>
    </section>
  );
}

export default Madrid;
