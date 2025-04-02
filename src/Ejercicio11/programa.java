package Ejercicio11;

import java.io.IOException;
import java.util.function.Consumer;

public class programa {
    public static void main(String[] args) {
        Consumer<Instituto> exito = instituto -> {
            System.out.println(instituto.nombre());
            instituto.alumnos().forEach(alumno -> System.out.println("Nombre: " +alumno.nombre()+ " Edad "+ alumno.edad()+ " Ciudad "+ alumno.ciudad()));

        };
        Consumer<IOException> error = e -> System.out.println("Error: "+e.getMessage());

        CargadorInstituto.cargarInstituto("C:\\Users\\Usuario\\IdeaProjects\\Tema7\\src\\hlanz.csv",exito,error);
    }
}
