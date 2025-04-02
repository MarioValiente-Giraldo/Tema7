import Ejercicio1.TipoElemento;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        Runnable a = () -> System.out.println("Hola mundo");;

        Function<Integer, Double> b = x -> Math.sqrt(x);

        Supplier<LocalTime> c = () -> LocalTime.now();

        Predicate<List<Integer>> d = x -> x.isEmpty();

        Consumer<String> e = x -> {
            if (!Files.exists(Paths.get(x))) {
                File file = new File(x);
                try {
                    file.createNewFile();

                }catch (IOException y){
                    System.out.println(y.getMessage());
                }

            }
        };
        Function<String, Integer> f =  x -> {
            char[] y = x.toCharArray();
            int contador = 0;
            for (char i : y) {
                if (i == ' ') {
                    contador++;
                }
            }
            return contador;
        };

        Function<int[], Integer> g =  x -> {
            int numeroMaximo = Integer.MIN_VALUE;
            for (int y : x) {
                if (y > numeroMaximo) {
                    numeroMaximo = y;
                }
            }
            return numeroMaximo;
        };

        Function<Integer, Character> h = x -> {
            char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
            return letras[x % 23];
        };

        Predicate<Integer> i =  x ->  x >= 18;


        Function<String, Long> j = x -> {
            long tamaño = 0;
            try {
                tamaño = Files.size(Paths.get(x));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            return tamaño;
        };

        Function<LocalDate, String> k =  x -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return x.format(dateTimeFormatter);
        };

        Predicate<Integer> l =  x -> {
            boolean resultado = false;
            if (x % 1 == 0 && x % x == 0) {
                resultado = true;
            }
            return resultado;
        };
        Runnable m = () -> System.out.println(LocalTime.now());


        Consumer<String> n = x -> {
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
        Consumer<Integer> o = x -> {
            System.out.println("La pausa empieza");
            try {
                Thread.sleep(x * 1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("La pausa ha terminado");
        };
        Function<Character, Integer> p =  x-> (int) x;
        BiPredicate<List<String>, String> q = (List<String> listaPalabras, String palabra) -> listaPalabras.contains(palabra);
        Function<String, TipoElemento> r =  x -> {
            if (!Files.exists(Paths.get(x))) {
                throw new IllegalArgumentException("No se ha econtrado el archivo");
            }
            return Files.isDirectory(Paths.get(x)) ? TipoElemento.CARPETA : TipoElemento.ARCHIVO;
        };
        BiFunction<Integer, Integer, Integer> s = (Integer x, Integer y) -> x + y;

        BiConsumer<List<String>, List<String>> t = (List<String> origen, List<String> destino) -> {
            for (String x : origen) {
                destino.add(x);
            }
        };
    }
}
