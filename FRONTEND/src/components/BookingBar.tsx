import { useEffect, useState } from "react";

function BookingBar() {
  const [mode, setMode] = useState<"hero" | "sticky">("hero");

  useEffect(() => {
    const onScroll = () => {
      const trigger = window.innerHeight * 0.75;
      setMode(window.scrollY > trigger ? "sticky" : "hero");
    };

    window.addEventListener("scroll", onScroll);
    return () => window.removeEventListener("scroll", onScroll);
  }, []);

  return (
    <div className={`booking-bar booking-${mode}`}>
      <div className="booking-inner">
        <input type="date" className="booking-input" />
        <input type="date" className="booking-input" />

        <select className="booking-select">
          <option>1 persona</option>
          <option>2 personas</option>
          <option>3 personas</option>
        </select>

        <button className="booking-btn">Reservar</button>
      </div>
    </div>
  );
}


export default BookingBar;
