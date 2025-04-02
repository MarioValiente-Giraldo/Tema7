package Ejercicio10;

import java.util.function.BiFunction;

public class programaEjercicio10 {
    public static void main(String[] args) {
        CoreccionExamen coreccionExamen = new CoreccionExamen("Pepe",12,8);
        BiFunction<Integer,Integer,Double> a  = (Integer correctas,Integer totalPreguntas) -> (((double)correctas/totalPreguntas)*10);
        System.out.println(a.apply(coreccionExamen.respuestasCorrectas(), coreccionExamen.numeroPreguntas()));

        BiFunction<Integer,Integer,Double> b  = (Integer correctas,Integer totalPreguntas) ->(((double)(coreccionExamen.respuestasCorrectas() - coreccionExamen.respuestasIncorrectas())/totalPreguntas)*10);

        System.out.println(b.apply(coreccionExamen.respuestasCorrectas(), coreccionExamen.numeroPreguntas()));

        BiFunction<Integer,Integer,Double> c  = (Integer correctas,Integer totalPreguntas) ->{
        int penalizacion = (coreccionExamen.respuestasCorrectas() - coreccionExamen.respuestasIncorrectas())/2;
            return (((double)penalizacion/totalPreguntas)*10);
        };
        System.out.println(c.apply(coreccionExamen.respuestasCorrectas(), coreccionExamen.numeroPreguntas()));




    }
    }

