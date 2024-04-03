package com.validador_de_correlativas;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private final List<Materia> listaMaterias;

    public Inscripcion(Alumno alumno, List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
        this.alumno = alumno;
    }

    boolean aprobada(){
        return listaMaterias.stream().allMatch(materia -> materia.cumpleCorrelativas(alumno));
    }
}