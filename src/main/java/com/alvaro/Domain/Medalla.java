package com.alvaro.Domain;

import javax.persistence.*;

@Entity
public class Medalla {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String especialidad;
    private tipoMedalla tipoMedalla;
    private String competicion;
    @ManyToOne
    private Atleta atleta;

    public Medalla() {
    }

    public Medalla(String especialidad, com.alvaro.Domain.tipoMedalla tipoMedalla, String competicion, Atleta atleta) {
        this.especialidad = especialidad;
        this.tipoMedalla = tipoMedalla;
        this.competicion = competicion;
        this.atleta = atleta;
    }

    @Override
    public String toString() {
        return "Medalla{" +
                "id=" + id +
                ", especialidad='" + especialidad + '\'' +
                ", tipoMedalla=" + tipoMedalla +
                ", competicion='" + competicion + '\'' +
                ", atleta=" + atleta +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public com.alvaro.Domain.tipoMedalla getTipoMedalla() {
        return tipoMedalla;
    }

    public void setTipoMedalla(com.alvaro.Domain.tipoMedalla tipoMedalla) {
        this.tipoMedalla = tipoMedalla;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
}
