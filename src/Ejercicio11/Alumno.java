package Ejercicio11;

public record Alumno(String nombre,int edad,String ciudad) {
    @Override
    public int edad() {
        return edad;
    }

    @Override
    public String ciudad() {
        return ciudad;
    }

    @Override
    public String nombre() {
        return nombre;
    }
}
