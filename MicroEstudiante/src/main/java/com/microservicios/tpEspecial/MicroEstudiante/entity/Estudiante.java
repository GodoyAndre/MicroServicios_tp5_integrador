package main.java.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estudiante {

    @Id
    @Column(name = "numero_libreta_universitaria")
    private String numeroLibretaUniversitaria;

    private String nombres;
    private String apellido;
    private Integer edad;
    private String genero;
    private String documento;

    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<Matricula> matriculas;

    //Constructor
    public Estudiante() {
    }

    public Estudiante(String nombres, String apellido, Integer edad, String genero, String documento, String ciudadResidencia, List<Matricula> matriculas, String numeroLibretaUniversitaria) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.documento = documento;
        this.ciudadResidencia = ciudadResidencia;
        this.matriculas = matriculas;
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
    }

    // Getters y setters

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getNumeroLibretaUniversitaria() {
        return numeroLibretaUniversitaria;
    }

    public void setNumeroLibretaUniversitaria(String numeroLibretaUniversitaria) {
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "numeroLibretaUniversitaria=" + numeroLibretaUniversitaria +
                ", nombres='" + nombres + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", documento='" + documento + '\'' +
                ", ciudadResidencia='" + ciudadResidencia + '\'' +
                '}';
    }
}

