package Ejercicio12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Lenguaje c = new Lenguaje("C++",Proposito.MULTIPROPOSITO);
        Lenguaje php = new Lenguaje("PHP",Proposito.WEB);
        Lenguaje java = new Lenguaje("Java",Proposito.MULTIPROPOSITO);
        Lenguaje python = new Lenguaje("Python",Proposito.MULTIPROPOSITO);
        Lenguaje visual = new Lenguaje("Visual Basic",Proposito.ESCRITORIO);
        Lenguaje swift = new Lenguaje("Swift",Proposito.MOVIL);
        Lenguaje asp = new Lenguaje("ASP",Proposito.WEB);
        Lenguaje dart = new Lenguaje("Dart",Proposito.MOVIL);

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
        ArrayList<Lenguaje> lenguajes = new ArrayList<>(List.of(c,php,java,python,visual,asp,swift,dart));


        //a
        programadores.stream()
                .filter(a -> a.experiencia()>3)
                .forEach(x -> System.out.println(x.nombre()));

        System.out.println("--------------------------------------------------------------------------------");

        //b
        programadores.stream()
                .forEach(x ->{
                    int salario = (x.experiencia() * 900) + (100 * x.lenguajes().size());
                    System.out.println(x.nombre()+" : "+salario);
                });
        System.out.println("--------------------------------------------------------------------------------");

        //c
        proyectos.stream()
                .filter(b -> b.nombre() == "MercaRafa")
                .flatMap(a ->a.equipo().stream())
                .min(Comparator.comparingInt( v -> v.experiencia()))
                .ifPresent(d-> System.out.println(d.nombre()));
        System.out.println("--------------------------------------------------------------------------------");

        //d
        programadores.stream()
                .min(Comparator.comparingInt(a-> a.experiencia()))
                .ifPresent(x -> x.lenguajes().stream().forEach(y-> System.out.println(y.nombre())));
        System.out.println("--------------------------------------------------------------------------------");
        //e
        proyectos.stream()
                .filter( x -> x.equipo().contains(luis))
                .forEach(y -> System.out.println(y.nombre()));
        System.out.println("--------------------------------------------------------------------------------");

        //f
        programadores.stream()
                .sorted(Comparator.comparingInt(x -> x.experiencia()))
                .forEach(y -> System.out.println(y.nombre()+" : "+y.experiencia()));
        System.out.println("--------------------------------------------------------------------------------");
        //g
        int total = programadores.stream()
                .mapToInt(x -> x.lenguajes().size())
                .sum();
        int media = total/ programadores.size();
        System.out.println(media);
        System.out.println("--------------------------------------------------------------------------------");
        //h
        proyectos.stream()
                .forEach(x -> System.out.println(x.nombre()+ " : "+x.equipo().getFirst().nombre()));
        System.out.println("--------------------------------------------------------------------------------");
        //i
        proyectos.stream()
                .min(Comparator.comparingInt(x -> x.equipo().size()))
                .stream().limit(1)
                .forEach(y-> System.out.println(y.nombre()));
        System.out.println("--------------------------------------------------------------------------------");
        //j
        lenguajes.stream()
                .filter(x-> x.proposito().equals(Proposito.MULTIPROPOSITO))
                .forEach(y-> System.out.println(y.nombre()));
        System.out.println("--------------------------------------------------------------------------------");
        //k
        int total2 =proyectos.stream()
                .filter(x -> x.nombre() == "Banco Granada")
                .flatMap(y -> y.equipo().stream())
                .mapToInt( z->z.experiencia())
                .sum();
        int media2 = total2/banco.equipo().size();
        System.out.println(media2);
        System.out.println("--------------------------------------------------------------------------------");
        //l
        proyectos.stream()
                .filter(x -> x.nombre().equals("Banco Granada"))
                .flatMap(y -> y.equipo().stream())
                        .sorted(Comparator.comparing(z->z.experiencia()))
                        .forEach(d -> System.out.println(d.nombre()));
        System.out.println("--------------------------------------------------------------------------------");
        //m
        proyectos.stream()
                .filter(x->x.nombre() == "MercaRafa")
                .flatMap(y ->y.equipo().stream()
                        .flatMap(z -> z.lenguajes().stream()))
                .map(d->d.nombre())
                .distinct()
                .forEach(v-> System.out.println(v));
        System.out.println("--------------------------------------------------------------------------------");
        //n
        lenguajes.stream()
                .filter(lenguaje -> lenguaje.proposito() == Proposito.MULTIPROPOSITO)
                .forEach(lenguaje -> System.out.println(lenguaje.nombre()));
        System.out.println("--------------------------------------------------------------------------------");
        //o
        programadores.stream()
                .filter(x -> x.lenguajes().contains(java))
                .forEach(y -> System.out.println(y.nombre() +" : "+y.experiencia()));
        System.out.println("--------------------------------------------------------------------------------");
        //p
        proyectos.stream()
                .filter( x -> x.equipo().stream()
                        .mapToInt(y -> y.experiencia() * 900 + 100 * y.lenguajes().size())
                        .sum() > 5000)
                .forEach(z -> System.out.println(z.nombre()));
        System.out.println("--------------------------------------------------------------------------------");
        //q
        proyectos.stream()
                .filter(x -> x.equipo().stream()
                        .filter(y -> y.lenguajes().contains(java))
                        .count() > 0)
                .forEach(z -> System.out.println(z.nombre()));

        //r










    }
}
