package Ejercicio1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Ejercicio1yEjercicio2 {
    public static void main(String[] args) {


        Runnable a = () -> {
            System.out.println("Hola mundo");
        };

        Function<Integer, Double> b = (Integer x) -> {
            return Math.sqrt(x);
        };
        Supplier<LocalTime> c = () -> {
            System.out.println(LocalTime.now());
            return LocalTime.now();
        };
        Predicate<List<Integer>> d = (x) -> {
            return x.isEmpty();
        };
        Consumer<String> e = (String x) -> {
            if (!Files.exists(Paths.get(x))) {
                File file = new File(x);

            }
        };
        Function<String, Integer> f = (String x) -> {
            char[] y = x.toCharArray();
            int contador = 0;
            for (char i : y) {
                if (i == ' ') {
                    contador++;
                }
            }
            return contador;
        };

        Function<int[], Integer> g = (int[] x) -> {
            int numeroMaximo = Integer.MIN_VALUE;
            for (int y : x) {
                if (y > numeroMaximo) {
                    numeroMaximo = y;
                }
            }
            return numeroMaximo;
        };

        Function<Integer, Character> h = (Integer x) -> {
            char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
            return letras[x % 23];
        };

        Predicate<Integer> i = (Integer x) -> {
            return x >= 18;
        };

        Function<String, Long> j = (String x) -> {
            long tamaño = 0;
            try {
                tamaño = Files.size(Paths.get(x));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            return tamaño;
        };

        Function<LocalDate, String> k = (LocalDate x) -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return x.format(dateTimeFormatter);
        };

        Predicate<Integer> l = (Integer x) -> {
            boolean resultado = false;
            if (x % 1 == 0 && x % x == 0) {
                resultado = true;
            }
            return resultado;
        };
        Runnable m = () -> {
            System.out.println(LocalTime.now());
        };

        Consumer<String> n = (String x) -> {
            try {
                FileReader fileReader = new FileReader(x);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (bufferedReader.readLine() != null) {
                    System.out.println(bufferedReader.readLine());
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException z) {
                System.out.println(z.getMessage());
            }
        };
        Consumer<Integer> o = (Integer x) -> {
            System.out.println("La pausa empieza");
            try {
                Thread.sleep(x * 1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("La pausa ha terminado");
        };
        Function<Character, Integer> p = (Character x) -> {
            return (int) x;
        };
        BiPredicate<List<String>, String> q = (List<String> listaPalabras, String palabra) -> {
            return listaPalabras.contains(palabra);
        };
        Function<String, TipoElemento> r = (String x) -> {
            if (!Files.exists(Paths.get(x))) {
                throw new IllegalArgumentException("No se ha econtrado el archivo");
            }
            return Files.isDirectory(Paths.get(x)) ? TipoElemento.CARPETA : TipoElemento.ARCHIVO;
        };
        BiFunction<Integer, Integer, Integer> s = (Integer x, Integer y) -> {
            return x + y;
        };
        BiConsumer<List<String>, List<String>> t = (List<String> origen, List<String> destino) -> {
            for (String x : origen) {
                destino.add(x);
            }
        };

        //a
        System.out.println("Apartado a");
        a.run();
        System.out.println();
        //b
        double raiz = b.apply(25);
        System.out.println(raiz);
        System.out.println();

        //c
        System.out.println(c.get());
        System.out.println();

        //d
        System.out.println(d.test(new ArrayList<>()));
        System.out.println();

        //e
        e.accept("pruebaApartadoe.txt");
        System.out.println();

        //f
        System.out.println(f.apply("Hola buenas"));
        System.out.println();

        //g
        int [] numeros = {1 ,25, 6, 100};
        System.out.println(g.apply(numeros));
        System.out.println();

        //h
        System.out.println(h.apply(12345678));
        System.out.println();

        //i
        System.out.println(i.test(50));
        System.out.println();

        //j
        System.out.println(j.apply("C:/Users/Usuario/IdeaProjects/Practicar-Java/prueba.txt"));
        System.out.println();

        //k
        System.out.println(k.apply(LocalDate.now()));
        System.out.println();

        //l
        System.out.println(l.test(7));
        System.out.println();

        //m
        m.run();
        System.out.println();

        //n
        n.accept("C:/Users/Usuario/IdeaProjects/Practicar-Java/prueba.txt");
        System.out.println();

        //o
        o.accept(5);
        System.out.println();

        //p
        p.apply('a');
        System.out.println();

        //q
        List<String> palabras = List.of("Hola", "Adios");
        System.out.println(q.test(palabras,"Hola"));
        System.out.println();

        //r
        System.out.println( r.apply("C:/Users/Usuario/IdeaProjects/Practicar-Java/prueba.txt"));
        System.out.println();

        //s
        System.out.println(s.apply(5,20));


        //t
        List<String> origen = new ArrayList<>(List.of("a", "b", "c"));
        List<String> destino = new ArrayList<>(List.of("x", "y"));
        t.accept(origen,destino);
        System.out.println(destino);
    }
}



