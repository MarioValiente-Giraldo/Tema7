package Ejercicio10;

import java.util.function.BiFunction;

public record CoreccionExamen(String alumno, int numeroPreguntas, int respuestasCorrectas) {
     public CoreccionExamen{
        if (numeroPreguntas<=0 || respuestasCorrectas<0){
            throw new IllegalArgumentException("El numero de preguntas o el numero de respuestas corectas no puede ser negativo");
            
        } else if (respuestasCorrectas>numeroPreguntas) {
            throw new IllegalArgumentException("El número de respuestas correctas no puede ser mayor al número de preguntas");

        }
    }
    public int respuestasIncorrectas(){
         return this.numeroPreguntas - this.respuestasCorrectas;
    }
    public double getNota(BiFunction<Integer,Integer,Double> criterioCorrecion){
         return criterioCorrecion.apply(this.respuestasCorrectas,this.respuestasIncorrectas());
    }
}
