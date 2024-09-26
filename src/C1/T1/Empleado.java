package C1.T1;

/*
    Explicación del código Java:
    
    - private String nombre;: Se declara una variable privada de tipo String para almacenar el nombre del empleado.
    - public class Empleado {: Se define una clase pública llamada Empleado.
    - public Empleado(String nombre, double salario) { ... }: Este es el constructor de la clase. Se utiliza para inicializar los atributos del objeto cuando se crea una nueva instancia.
    - private double salario;: Se declara una variable privada de tipo double para almacenar el salario del empleado.
    - public double getSalario() { ... }: Este método devuelve el salario del empleado.
    - public String getNombre() { ... }: Este método devuelve el nombre del empleado.
 */

public class Empleado {
    private String nombre;
    private double salario;

    // Constructor
    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    // Método para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Método para obtener el salario
    public double getSalario() {
        return salario;
    }
}