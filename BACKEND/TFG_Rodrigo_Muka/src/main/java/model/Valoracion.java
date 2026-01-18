package model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "VALORACIONES")
public class Valoracion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VALORACION")
	private int idValoracion;
	@ManyToOne
	@JoinColumn(name = "username")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "id_habitacion")
	private Habitacion habitacion;
	private int puntuacion;
	private String comentario;
	private LocalDate fecha;
}
