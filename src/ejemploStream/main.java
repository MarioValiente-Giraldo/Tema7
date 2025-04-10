package ejemploStream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<Alumno> alumnos = List.of(
                new Alumno("Juan","Granada",16,List.of("Programacion","Base de datos")),
                new Alumno("Gregorio","Armilla",18,List.of("Programacion","Entornos","Base de datos")),
                new Alumno("Francisco Javier","Cortes y Graena",19,List.of("Porgramacion","Sistemas")),
                new Alumno("Roberto","Valderrubio",18,List.of("Programacion","Entornosw")),
                new Alumno("Adam","Granada",17,List.of("Programacion","Base de datos")),
                new Alumno("Esther","Granada",18,List.of("Programacion","Entornos","Base de datos"))

        );
        //Muestra el nombre de los alumnos mayores de edad
        alumnos.stream()
                .filter(a -> a.edad()>=18)
                .forEach(a -> System.out.println(a.nombre()));
        //de otra forma
        alumnos.stream()
                .filter(a->a.edad()>=18)
                .map(a->a.nombre())
                .forEach(nombre -> System.out.println(nombre));
        //Cuenta los alumnos de granada
        long alumnoGranada = alumnos.stream()
                .filter(alumno -> alumno.ciudad().equals("Granada"))
                .count();
        System.out.println(alumnoGranada);
        //Muestra los alumnos de granada menores de edad
        alumnos.stream()
                .filter(alumno ->alumno.ciudad().equals("Granada"))
                .filter(a->a.edad()<18)
                .map(alumno -> alumno.nombre())
                .forEach(nombre -> System.out.println(nombre));
        //Ordenalo alfabeticamente
        alumnos.stream()
                .filter(alumno ->alumno.ciudad().equals("Granada"))
                .filter(a->a.edad()<18)
                .map(alumno -> alumno.nombre())
                .sorted()
                .forEach(nombre -> System.out.println(nombre));

        //Mostrar los alumnos menores de edad, ordenados por la longitud del nombre de su ciudad
        alumnos.stream()
                .filter(a ->a.edad()<18)
                .sorted(Comparator.comparing((Alumno a) -> a.ciudad().length()).reversed())
                .map(a -> a.nombre())
                .forEach(a -> System.out.println(a));
        //Mostrar las 3 edades mas pequeñas de los alumnos
        alumnos.stream()
                .mapToInt(a -> a.edad())
                .sorted()
                .limit(3)
                .forEach(edad -> System.out.println(edad));


        System.out.println("---------------------------------------------------------------");
        //Mostrar la cuarta edad
        alumnos.stream()
                .mapToInt(a-> a.edad())
                .sorted()
                .skip(3)
                .limit(1)
                .forEach(edad-> System.out.println(edad));

        System.out.println("----------------------------------------------------------------");
        //Crea una cadena de caracteres con las ciudades de los alumnos separados por coma
        String cadena = alumnos.stream()
                .map(a -> a.ciudad())
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println(cadena);
        System.out.println("-----------------------------------------------------------------");
        List<Alumno> alumnosranada =alumnos.stream()
                .filter(alumno -> alumno.ciudad().equals("Granada"))
                .toList();
        System.out.println(alumnosranada);
        System.out.println("-----------------------------------------------------------------");
        //OPTIONAL
        //Muestra la menor edad del alumno
        alumnos.stream()
                .mapToInt(a -> a.edad())
                .min()
                .ifPresent( minimo -> System.out.println(minimo));
        System.out.println("-----------------------------------------------------------------");
        alumnos.stream()
                .filter(alumno -> alumno.ciudad().equals("Granada"))
                        .mapToInt(a -> a.edad())
                                .min()
                                        .ifPresent(minim -> System.out.println(minim));
        //Otra forma
        alumnos.stream()
                .filter(alumno -> alumno.ciudad().equals("Pontevedra"))
                .mapToInt(a -> a.edad())
                .min()
                .ifPresentOrElse(minimo -> System.out.println(minimo),
                        () -> System.out.println("No hay alumno en Pontevedra"));
        System.out.println("-----------------------------------------------------------------");
        //Muetsra el cuadrado de la edad minima
        alumnos.stream()
                .mapToInt(a -> a.edad())
                .min()
                .ifPresent(edad -> System.out.println(edad*edad));

        //Otra forma
        alumnos.stream()
                .mapToInt(a -> a.edad())
                .map(edad -> edad*edad)
                .min()
                .ifPresent(edad -> System.out.println(edad));
        System.out.println("-----------------------------------------------------------------");
        //FlatMap
        //Crea una cadena de caracteres sin repetirse
        String asignaturasNoReoetidas = alumnos.stream()
                        .flatMap(a -> a.asignaturas().stream())
                                .distinct()
                                .collect(Collectors.joining(","));

        System.out.println(asignaturasNoReoetidas);
        System.out.println("-----------------------------------------------------------------");
        //Muestra las asignaturas de menor longitud
        alumnos.stream()
                .flatMap(a -> a.asignaturas().stream())
                .sorted(Comparator.comparing(a -> a.length()))
                .findFirst()
                .ifPresent(a -> System.out.println(a));

        System.out.println("-----------------------------------------------------------------");
        //Otra forma
        alumnos.stream()
                .flatMap(a -> a.asignaturas().stream())
                .min(Comparator.comparing(a -> a.length()))
                .ifPresent(a -> System.out.println(a));







    }
}
