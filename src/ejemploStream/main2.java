package ejemploStream;

import bpc.daw.objetos.DepositoAgua;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main2 {
    public static void main(String[] args) {
        //Sumamos todos los números entre 1000 y 8000 incluidos
        long suma = IntStream.rangeClosed(1000,8000)
                .sum();
        System.out.println(suma);
        System.out.println("-----------------------------------------------------------------");
        //Suma entre los numeros 1000 y 8000 pero no incluye los extremos
        long suma2 = IntStream.range(100,8000)
                .skip(1)
                .sum();
        System.out.println(suma);
        System.out.println("-----------------------------------------------------------------");
        //Generamos 20 números aleatorios entre 0 y 10
        Stream.generate(()->new Random().nextInt(0,10))
                .limit(20)
                .forEach( x -> System.out.print(x+" "));
        System.out.println("");
        System.out.println("-----------------------------------------------------------------");
        //Genera 20 depositos de agua maximo 100 litros, el primero tendrá 2 litros y por cada deposito se suman 3 litros
        //Forma 1
        List<DepositoAgua> listaAgua = Stream.iterate(new DepositoAgua(2,100),deposito -> new DepositoAgua(deposito.getCantidadActual()+3, deposito.getCapacidadMaxima()))
                .limit(20)
                .toList();
        //Forma 2
        List<DepositoAgua> listaAgua2 = Stream.iterate(2, capacidad -> capacidad+3)
                .limit(20)
                .map(capacidad -> new DepositoAgua(capacidad,100))
                .toList();
    }
}
