package Ejercicio9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Juan Pérez","Informática",1200);
        Empleado empleado2 = new Empleado("Antonio Castillo","Contabilidad",1500);
        Empleado empleado3 = new Empleado("María López","Informática",1500);
        Empleado empleado4 = new Empleado("Luis Martínez","Informática",2000);
        Empleado empleado5 = new Empleado("Rigoberta Pérez","Contabilidad",4000);

        //a
        List<Empleado> listaEmpleadosA = new ArrayList<>(List.of(empleado1,empleado2,empleado3,empleado4,empleado5));
        listaEmpleadosA.removeIf(empleado -> empleado.getSueldo()>2500);
        System.out.println(listaEmpleadosA);
        //b
        List<Empleado> listaEmpleadosB = new ArrayList<>(List.of(empleado1,empleado2,empleado3,empleado4,empleado5));
        listaEmpleadosB.forEach(empleado -> System.out.println(empleado.getSueldo()));
        listaEmpleadosB.forEach(empleado -> empleado.setSueldo(empleado.getSueldo()*1.1));
        listaEmpleadosB.forEach(empleado -> System.out.println(empleado.getSueldo()));
        //c
        List<Empleado> listaEmpleadosC= new ArrayList<>(List.of(empleado1,empleado2,empleado3,empleado4,empleado5));
        File file = new File("empresa.txt");
            listaEmpleadosC.forEach(empleado -> {
                try {
                    FileWriter fileWriter = new FileWriter(file,true);
                    fileWriter.write("Nombre: "+empleado.getNombre()+" Sueldo: "+empleado.getSueldo()+ "\n");
                    fileWriter.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            });


    }
}
