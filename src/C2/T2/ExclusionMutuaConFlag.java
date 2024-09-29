package C2.T2;

/*

    Explicación del Código:

    - Variable flag: Esta variable booleana actúa como una bandera para indicar si la región crítica está ocupada (true) o libre (false).
    - Métodos procesoP1 y procesoP2: Estos métodos representan los dos procesos que compiten por el acceso a la región crítica.
    - Bucle while: Cada proceso entra en un bucle infinito para simular una ejecución continua.
    - Espera Activa: Mientras la bandera flag esté en true, el proceso entra en un bucle de espera, verificando continuamente si la bandera cambia a false. 
                     Esta es la parte menos eficiente del algoritmo.
    - Región Crítica: La sección de código dentro del bloque protegido por la bandera es la región crítica. 
                      Aquí es donde se ejecuta el código que solo un proceso puede ejecutar a la vez.

 */

public class ExclusionMutuaConFlag {
    
    private boolean flag = false;

    public void procesoP1() {
        while (true) {
            // Espera activa mientras el recurso esté ocupado
            while (flag) {
                // ... hacer algo mientras se espera ...
            }

            // Entra a la región crítica
            flag = true;

            // ... código de la región crítica ...

            // Sale de la región crítica
            flag = false;
        }
    }

    public void procesoP2() {
        while (true) {
            // Espera activa mientras el recurso esté ocupado
            while (flag) {
                // ... hacer algo mientras se espera ...
            }

            // Entra a la región crítica
            flag = true;

            // ... código de la región crítica ...

            // Sale de la región crítica
            flag = false;
        }
    }

    public static void main(String[] args) {
        ExclusionMutuaConFlag ejemplo = new ExclusionMutuaConFlag();

        // Crear hilos para ejecutar los procesos
        Thread hiloP1 = new Thread(ejemplo::procesoP1);
        Thread hiloP2 = new Thread(ejemplo::procesoP2);

        hiloP1.start();
        hiloP2.start();
    }
}

/*
 
    EN PSEUDOCODIGO

    Explicación Detallada

    - Variable compartida (flag):

    Se define una variable booleana llamada flag que actúa como un indicador.
    Cuando flag es true, significa que la región crítica está ocupada.
    Cuando flag es false, la región crítica está libre.

    - Procesos P1 y P2:

    Ambos procesos tienen un bucle infinito que representa su ejecución continua.
    Dentro de cada bucle, se encuentra la lógica para acceder a la región crítica.
    
    - Acceso a la Región Crítica:

    Antes de entrar en la región crítica, un proceso verifica si el flag está en false.
    Si está en false, significa que la región crítica está libre, y el proceso puede entrar.
    El proceso establece el flag en true para indicar que está ocupando la región crítica.
    Dentro de la región crítica, el proceso realiza las operaciones necesarias.
    Al finalizar, el proceso establece el flag en false para liberar la región crítica y permitir que otro proceso entre.
    
    - Espera Activa:

    Si un proceso encuentra que el flag está en true, entra en un bucle de espera, verificando continuamente si el flag cambia a false. Esta técnica se conoce como espera activa.

 */