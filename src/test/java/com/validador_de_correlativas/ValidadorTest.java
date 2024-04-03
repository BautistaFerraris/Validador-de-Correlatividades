package com.validador_de_correlativas;

import com.validador_de_correlativas.Alumno;
import com.validador_de_correlativas.Materia;
import com.validador_de_correlativas.Inscripcion;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ValidadorTest {


    @Test
    public void listaMateriasAprobadas() {                       //me devuelve la lista de materias aprobadas
        Alumno alumno = new Alumno();

        Materia disenioSistemas = new Materia();
        Materia paradigmas = new Materia();
        Materia analisisSistemas = new Materia();
        Materia analisisI = new Materia();

        disenioSistemas.setAprobada(true);
        paradigmas.setAprobada(true);
        analisisSistemas.setAprobada(true);
        analisisI.setAprobada(false);

        alumno.agregarMateria(disenioSistemas);
        alumno.agregarMateria(paradigmas);
        alumno.agregarMateria(analisisSistemas);
        alumno.agregarMateria(analisisI);

        assertEquals(3, alumno.listaMateriasAprobadas().size());

    }

    @Test
    public void aprobadasLasMaterias(){
        Alumno alumno = new Alumno();

        Materia disenioSistemas = new Materia();
        Materia paradigmas = new Materia();
        Materia analisisSistemas = new Materia();

        disenioSistemas.setAprobada(true);
        paradigmas.setAprobada(true);
        analisisSistemas.setAprobada(true);

        alumno.agregarMateria(disenioSistemas);
        alumno.agregarMateria(paradigmas);
        alumno.agregarMateria(analisisSistemas);

        assertTrue(alumno.aproboMaterias(alumno.getListaMaterias()));
    }

    @Test
    public void noAprobadasLasMaterias(){
        Alumno alumno = new Alumno();

        Materia disenioSistemas = new Materia();
        Materia paradigmas = new Materia();
        Materia analisisSistemas = new Materia();
        Materia analisisI = new Materia();

        disenioSistemas.setAprobada(true);
        paradigmas.setAprobada(true);
        analisisSistemas.setAprobada(true);
        analisisI.setAprobada(false);

        alumno.agregarMateria(disenioSistemas);
        alumno.agregarMateria(paradigmas);
        alumno.agregarMateria(analisisSistemas);
        alumno.agregarMateria(analisisI);

        assertFalse(alumno.aproboMaterias(alumno.getListaMaterias()));
    }

    @Test
    public void cumpleCondicionesDeCorrelativas(){
        Alumno alumno = new Alumno();

        Materia disenioSistemas = new Materia();
        Materia paradigmas = new Materia();
        Materia analisisSistemas = new Materia();

        disenioSistemas.setAprobada(true);
        paradigmas.setAprobada(true);
        analisisSistemas.setAprobada(true);

        alumno.agregarMateria(disenioSistemas);
        alumno.agregarMateria(paradigmas);
        alumno.agregarMateria(analisisSistemas);

        disenioSistemas.setCorrelativas(Arrays.asList(paradigmas, analisisSistemas));

        assertTrue(disenioSistemas.cumpleCorrelativas(alumno));
    }

    @Test
    public void noCumpleCondicionesDeCorrelativas(){
        Alumno alumno = new Alumno();

        Materia disenioSistemas = new Materia();
        Materia paradigmas = new Materia();
        Materia analisisSistemas = new Materia();

        disenioSistemas.setAprobada(true);
        paradigmas.setAprobada(false);
        analisisSistemas.setAprobada(true);

        alumno.agregarMateria(disenioSistemas);
        alumno.agregarMateria(paradigmas);
        alumno.agregarMateria(analisisSistemas);

        disenioSistemas.setCorrelativas(Arrays.asList(paradigmas, analisisSistemas));

        assertFalse(disenioSistemas.cumpleCorrelativas(alumno));
    }

    @Test
    public void estaAprobadaLaInscripcion(){

        Materia disenioSistemas = new Materia();
        Materia quimica = new Materia();
        Materia fisicaI = new Materia();

        Alumno alumno = new Alumno();

        disenioSistemas.setAprobada(true);
        quimica.setAprobada(false);
        fisicaI.setAprobada(true);

        alumno.agregarMateria(disenioSistemas);
        alumno.agregarMateria(quimica);
        alumno.agregarMateria(fisicaI);

        Inscripcion inscripcion = new Inscripcion(alumno, alumno.getListaMaterias());

        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void noEstaAprobadaLaInscripcion(){

        Materia disenioSistemas = new Materia();
        Materia analisisSistemas = new Materia();

        Alumno alumno = new Alumno();

        disenioSistemas.setAprobada(true);
        analisisSistemas.setAprobada(false);

        alumno.agregarMateria(disenioSistemas);
        alumno.agregarMateria(analisisSistemas);

        disenioSistemas.setCorrelativas(Arrays.asList(analisisSistemas));

        Inscripcion inscripcion = new Inscripcion(alumno, alumno.getListaMaterias());

        assertFalse(inscripcion.aprobada());
    }
}