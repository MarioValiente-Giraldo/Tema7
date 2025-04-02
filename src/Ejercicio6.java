import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import bpc.daw.objetos.DepositoAgua;

public class Ejercicio6 {
    public static void main(String[] args) {
        //a
        List<String> listaSemana = new ArrayList<>(List.of("Lunes",",Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"));
        System.out.println(listaSemana);
        listaSemana.removeIf(dia -> dia.length() > 5);
        System.out.println(listaSemana);

        //b
        List<Integer> listaNumeros = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        System.out.println(listaNumeros);
        listaNumeros.removeIf(numero->numero%2!=0);
        System.out.println(listaNumeros);

        //c
        List<Character> listaCaracteres = new ArrayList<>(List.of('a','A','V','c','d','D','L','g','J','Ñ'));
        System.out.println(listaCaracteres);
        listaCaracteres.removeIf(caracter -> Character.isUpperCase(caracter));
        System.out.println(listaCaracteres);

        //d
        List<LocalDate> listaFechas = new ArrayList<>(List.of(LocalDate.now(),LocalDate.of(2005,10,1),LocalDate.of(2025,3,23),LocalDate.of(1999,6,29),LocalDate.of(2025,6,29)));
        System.out.println(listaFechas);
        listaFechas.removeIf(fecha -> fecha.getYear() !=2025);
        System.out.println(listaFechas);

        //e
        DepositoAgua deposito1 = new DepositoAgua(100,500);
        DepositoAgua deposito2 = new DepositoAgua(200,500);
        DepositoAgua deposito3 = new DepositoAgua(300,500);
        DepositoAgua deposito4 = new DepositoAgua(400,500);
        DepositoAgua deposito5 = new DepositoAgua(250,500);

        List<DepositoAgua> listaAgua = new ArrayList<>(List.of(deposito1,deposito2,deposito3,deposito4,deposito5));
        System.out.println(listaAgua);
        listaAgua.removeIf(deposito -> deposito.getCantidadActual()<250);
        System.out.println(listaAgua);
        //f
        // f
        List<String> listaDiasMinusculas = new ArrayList<>(List.of("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"));
        System.out.println(listaDiasMinusculas);

        listaDiasMinusculas.removeIf(dia -> {
            int suma = 0;
            for (char x : dia.toCharArray()) {
                suma += x;
            }
            double mediaAscii = (double) suma / dia.length();
            return mediaAscii > 110;
        });

        System.out.println(listaDiasMinusculas);



    }
}
