package C1.T1;

/*
    Explicación del Código Java
    - public class Counter {: Se define una clase pública llamada Counter.
    - private long count;: Se declara una variable miembro privada de tipo long llamada count para almacenar el valor del contador. Al ser privada, solo puede ser accedida desde dentro de la clase.
    - public Counter(long initialValue) { ... }: Este es el constructor de la clase. Se utiliza para inicializar el valor del contador cuando se crea un nuevo objeto de tipo Counter. El parámetro initialValue especifica el valor inicial del contador.
    - public long getCount() { ... }: Este método devuelve el valor actual del contador.
    - public void increment() { ... }: Este método incrementa el valor del contador en 1.
    - public void decrement() { ... }: Este método decrementa el valor del contador en 1.
 */

public class Counter2 {
    private long count; // Variable miembro de la clase

    // Constructor para inicializar el contador
    public Counter2(long initialValue) {
        this.count = initialValue;
    }

    // Método para obtener el valor actual del contador
    public long getCount() {
        return count;
    }

    // Método para incrementar el contador
    public void increment() {
        count++;
    }

    // Método para decrementar el contador
    public void decrement() {
        count--;
    }
}