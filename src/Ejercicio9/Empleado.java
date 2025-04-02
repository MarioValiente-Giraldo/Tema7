package Ejercicio9;

public class Empleado {
        private String nombre;
        private String departamento;
        private double sueldo;

        public Empleado(String nombre, String departamento, double sueldo){
            this.nombre = nombre;
            this.departamento = departamento;
            this.sueldo = sueldo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDepartamento() {
            return departamento;
        }

        public void setDepartamento(String departamento) {
            this.departamento = departamento;
        }

        public double getSueldo() {
            return sueldo;
        }

        public void setSueldo(double sueldo) {
            this.sueldo = sueldo;
        }

}
