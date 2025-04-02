import bpc.daw.consola.Consola;
import bpc.daw.consola.Teclado;
import bpc.daw.mario.Mario;
import bpc.daw.objetos.DepositoAgua;
import bpc.daw.consola.CapaCanvas;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio7 {
    public static void main(String[] args) {
        //a
        Mario mario1 = new Mario(100,100);
        Mario mario2 = new Mario(150,100);
        Mario mario3 = new Mario(200,100);
        Mario mario4 = new Mario(250,100);
        Mario mario5 = new Mario(300,100);

        List<Mario> listaMario = new ArrayList<>(List.of(mario1,mario2,mario3,mario4,mario5));
        listaMario.forEach(x -> x.saltar());
        //b
        DepositoAgua deposito1 = new DepositoAgua(100,500);
        DepositoAgua deposito2 = new DepositoAgua(200,500);
        DepositoAgua deposito3 = new DepositoAgua(300,500);
        DepositoAgua deposito4 = new DepositoAgua(400,500);
        DepositoAgua deposito5 = new DepositoAgua(250,500);

        List<DepositoAgua> listaAgua = new ArrayList<>(List.of(deposito1,deposito2,deposito3,deposito4,deposito5));
        listaAgua.forEach(depositoAgua -> System.out.println(depositoAgua.getCantidadActual()));
        listaAgua.forEach(depositoAgua -> depositoAgua.añadirLitro());
        listaAgua.forEach(depositoAgua -> System.out.println(depositoAgua.getCantidadActual()));
        //c
        List<String> listaDiasMinusculas = new ArrayList<>(List.of("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"));
        File file = new File("dias.txt");

        try (FileWriter fileWriter = new FileWriter(file)) {
            listaDiasMinusculas.forEach(dia -> {
                try {
                    fileWriter.write(dia + "\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //d
        Rectangle rectangle1 = new Rectangle(0,300,100,50);
        Rectangle rectangle2 = new Rectangle(200,300,100,50);
        Rectangle rectangle3 = new Rectangle(400,300,100,50);
        Rectangle rectangle4 = new Rectangle(600,300,100,50);
        Rectangle rectangle5 = new Rectangle(100,100,100,50);
        List<Rectangle> listaRectangulos = new ArrayList<>(List.of(rectangle1,rectangle2,rectangle3,rectangle4,rectangle5));
        Consola consola = new Consola();
        CapaCanvas capaCanvas = consola.getCapaCanvas();
        Graphics graphics = capaCanvas.getGraphics();
        listaRectangulos.forEach(rectangulo -> graphics.drawRect(rectangulo.x,rectangulo.x,rectangulo.width,rectangulo.height));
        Teclado teclado = consola.getTeclado();
        teclado.leerNumeroEntero();
        //e
        //f
    }
}
