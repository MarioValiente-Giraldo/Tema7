package Ejercicio11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

public record CargadorInstituto() {
    public static void cargarInstituto(String ruta, Consumer<Instituto> exito, Consumer<IOException> error){
        File file = new File(ruta);
        try {
            FileWriter fileWriter = new FileWriter(file);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
