package Ejercicio10;

import java.util.function.BiFunction;

public class programaEjercicio10 {
    public static void main(String[] args) {
        CoreccionExamen coreccionExamen = new CoreccionExamen("Pepe",12,8);
        BiFunction<Integer,Integer,Double> a  = (Integer correctas,Integer totalPreguntas) -> (((double)correctas/totalPreguntas)*10);
        System.out.println(a.apply(coreccionExamen.respuestasCorrectas(), coreccionExamen.numeroPreguntas()));


        }
    }

