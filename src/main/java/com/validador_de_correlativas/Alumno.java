package com.validador_de_correlativas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Alumno {
    String nombre;
    private List<Materia> listaMaterias = new ArrayList<>();

    public void agregarMateria(Materia materia){
        this.listaMaterias.add(materia);
    }

    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public List<Materia> listaMateriasAprobadas(){
        return listaMaterias.stream().filter(materia -> materia.aprobada).collect(Collectors.toList());
    }
    public boolean aproboMaterias(List<Materia> listaMaterias){
        List<Materia> aprobadas = listaMateriasAprobadas();

        return aprobadas.containsAll(listaMaterias);
    }

}
