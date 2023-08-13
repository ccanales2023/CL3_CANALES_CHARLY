package pe.edu.cibertec.CL3_CHARLY_CANALES.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;

     String nombre;
     String apellido;
     BigDecimal salario;
     String puesto;

    @Temporal(TemporalType.TIMESTAMP)
     Date fechaRegistro;

    public Empleado() {}

    public Empleado(String nombre, String apellido, BigDecimal salario, String puesto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.puesto = puesto;
        this.fechaRegistro = new Date();
    }

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}

