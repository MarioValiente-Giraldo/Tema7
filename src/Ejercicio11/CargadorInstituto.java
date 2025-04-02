package Ejercicio11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public record CargadorInstituto() {
    public static void cargarInstituto(String ruta, Consumer<Instituto> exito, Consumer<IOException> error){
        File file = new File(ruta);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<Alumno> alumnos = new ArrayList<>();
            String x ;
            while ((x = bufferedReader.readLine()) != null) {
                String [] datosAlumno = x.split(",");
                String nombre = datosAlumno[0];
                int años = Integer.parseInt(datosAlumno[1]);
                String ciudad = datosAlumno[2];
                alumnos.add(new Alumno(nombre,años,ciudad));
            }
            Instituto instituto = new Instituto("hlanz",alumnos);
            exito.accept(instituto);

        } catch (IOException e) {
            error.accept(e);
        }
    }
}
