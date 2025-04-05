

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio8 {
    public static void main(String[] args) {
        //a
        List<String> listaDias = new ArrayList<>(List.of("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"));
        List<String> diasIngles = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        listaDias.replaceAll(dias -> diasIngles.get(listaDias.indexOf(dias)));
        System.out.println(listaDias);

        //b
        List<Integer> listaNumeros = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        listaNumeros.replaceAll(numero -> (int)Math.pow(numero,2));
        System.out.println(listaNumeros);

        //c
        List<LocalDate> listaFechas = new ArrayList<>(List.of(LocalDate.now(),LocalDate.of(2005,10,1),LocalDate.of(2015,3,23),LocalDate.of(1999,6,29),LocalDate.of(2005,9,29)));
        int añoActual = LocalDate.now().getYear();
        listaFechas.replaceAll(fecha -> fecha.withYear(añoActual));
        System.out.println(listaFechas);
        //d
        Rectangle rectangle1 = new Rectangle(100,50);
        Rectangle rectangle2 = new Rectangle(100,50);
        Rectangle rectangle3 = new Rectangle(100,50);
        Rectangle rectangle4 = new Rectangle(100,50);
        Rectangle rectangle5 = new Rectangle(110,50);
        List<Rectangle> listaRectangulos = new ArrayList<>(List.of(rectangle1,rectangle2,rectangle3,rectangle4,rectangle5));
        listaRectangulos.replaceAll(rectangulo -> new Rectangle(rectangulo.width*rectangulo.height,rectangulo.width*rectangulo.height));
        listaRectangulos.forEach(rectangle -> System.out.println("Altura "+rectangle.height+ " Ancho " +rectangle.width));
        //e
        List<String> palabras = new ArrayList<>(List.of("Hola", "Adios", "Java", "Python"));
        palabras.replaceAll(palabra -> new StringBuilder(palabra).reverse().toString());
        System.out.println(palabras);

        //f

    }


}
