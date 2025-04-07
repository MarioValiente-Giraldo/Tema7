package Ejercicio12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Programador luis = new Programador("Luis Gonzalez",5,new ArrayList<>(List.of(
                new Lenguaje("C++",Proposito.MULTIPROPOSITO),
                new Lenguaje("PHP",Proposito.WEB)
        )));
        Programador antonio = new Programador("Antonio Perez",2,new ArrayList<>(List.of(
                new Lenguaje("Java",Proposito.MULTIPROPOSITO),
                new Lenguaje("Python",Proposito.MULTIPROPOSITO)
        )));
        Programador juana = new Programador("Juana López",4,new ArrayList<>(List.of(
                new Lenguaje("Visual Basic", Proposito.ESCRITORIO),
                new Lenguaje("Swift",Proposito.MOVIL)
        )));
        Programador josefa = new Programador("Josefa Smith",3,new ArrayList<>(List.of(
                new Lenguaje("ASP",Proposito.WEB),
                new Lenguaje("Dart",Proposito.MOVIL)
        )));
        Proyecto banco = new Proyecto("Banco Granada",new ArrayList<>(List.of(luis,juana,josefa)));
        Proyecto merca = new Proyecto("MercaRafa",new ArrayList<>(List.of(antonio,luis,josefa)));
        Proyecto jorgePhone = new Proyecto("JorgePhone",new ArrayList<>(List.of(antonio,juana)));

        List<Programador> programadores = new ArrayList<>(List.of(luis,antonio,juana,josefa));
        List<Proyecto> proyectos = new ArrayList<>(List.of(banco,merca,jorgePhone));
        //a
        programadores.stream()
                .filter(a -> a.experiencia()>3)
                .forEach(x -> System.out.println(x.nombre()));


        //b
        programadores.stream()
                .forEach(x ->{
                    int salario = (x.experiencia() * 900) + (100 * x.lenguajes().size());
                    System.out.println(x.nombre()+" : "+salario);
                });
        //c
        proyectos.stream()
                .filter(b -> b.nombre() == "MercaRafa")
                .flatMap(a ->a.equipo().stream())
                .min(Comparator.comparingInt( c -> c.experiencia()))
                .ifPresent(d-> System.out.println(d.nombre()));
        //d
        programadores.stream()
                .min(Comparator.comparingInt(a-> a.experiencia()))
                .ifPresent(x -> x.lenguajes().stream().forEach(y-> System.out.println(y.nombre())));
        //e

    }
}
