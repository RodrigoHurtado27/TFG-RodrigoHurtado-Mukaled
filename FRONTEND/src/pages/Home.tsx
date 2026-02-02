import { useTranslation } from "react-i18next";
import Header from "../components/Header";
import BookingBar from "../components/BookingBar";
import Footer from "../components/Footer";
import { useRevealOnScroll } from "../hooks/useRevealOnScroll";
import "./Home.css";

function Home() {
  const { t } = useTranslation();

  useRevealOnScroll();

  const rooms = [
    {
      img: "/room1.png",
      alt: t("rooms.deluxe.alt"),
      title: "rooms.deluxe.title",
      text: "rooms.deluxe.text",
      delay: "reveal-delay-1",
    },
    {
      img: "/Suite2.png",
      alt: t("rooms.suite.alt"),
      title: "rooms.suite.title",
      text: "rooms.suite.text",
      delay: "reveal-delay-2",
    },
    {
      img: "/Premium1.png",
      alt: t("rooms.premium.alt"),
      title: "rooms.premium.title",
      text: "rooms.premium.text",
      delay: "reveal-delay-3",
    },
  ];

  return (
    <>
      <Header />

      {/* HERO */}
      <section className="hero">
        <div className="hero-overlay reveal">
          <h1 className="lux-title">{t("hero.title")}</h1>
          <p>{t("hero.subtitle")}</p>

          <a href="#rooms" className="reserve-btn">
            {t("hero.cta")}
          </a>
        </div>

        <BookingBar />
      </section>

      {/* ABOUT */}
      <section className="about">
        <div className="about-container">
          <div className="about-text reveal reveal-delay-1">
            <span className="about-kicker">{t("about.kicker")}</span>
            <h2>{t("about.title")}</h2>
            <p>{t("about.text1")}</p>
            <p>{t("about.text2")}</p>
          </div>

          <div className="about-image reveal reveal-delay-2">
            <img src="/enter.png" alt={t("about.imageAlt")} />
          </div>
        </div>
      </section>

      {/* ROOMS */}
      <section className="rooms" id="rooms">
        <div className="rooms-container">
          <div className="rooms-header reveal">
            <span className="section-kicker">{t("rooms.kicker")}</span>
            <h2>{t("rooms.title")}</h2>
            <p>{t("rooms.subtitle")}</p>
          </div>

          <div className="rooms-grid">
            {rooms.map((room, i) => (
              <div key={i} className={`room-card reveal ${room.delay}`}>
                <img src={room.img} alt={room.alt} />
                <h3>{t(room.title)}</h3>
                <p>{t(room.text)}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      <Footer />
    </>
  );
}

export default Home;
