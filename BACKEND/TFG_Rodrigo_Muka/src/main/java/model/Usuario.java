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
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;  // 🔹 PK numérica

    @Column(nullable = false, unique = true)
    private String username; // 🔹 sigue siendo único para login

    private String password;
    private String nombre;
    private String apellidos;
    private boolean enabled;

    @Column(name = "FECHA_REGISTRO")
    private LocalDate fechaRegistro;

    @Column(name = "FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

    private String direccion;

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL")
    private Perfil perfil;  // 🔹 FK a perfiles
}
