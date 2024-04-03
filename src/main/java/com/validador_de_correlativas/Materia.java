package com.validador_de_correlativas;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    boolean aprobada;
    private List<Materia> listaCorrelativas;
    public Materia() {
        this.listaCorrelativas = new ArrayList<>();
    }
    public void setCorrelativas(List<Materia> listaCorrelativas){
        this.listaCorrelativas = listaCorrelativas;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }

    public boolean cumpleCorrelativas(Alumno alumno){
        return alumno.aproboMaterias(listaCorrelativas);
    }
}
