package C2.T2;

/*
 
    Explicación del Código:

    - Banderas: flag1 y flag2 indican si los procesos P1 y P2, respectivamente, están en la sección crítica o tienen la intención de entrar.
    - Métodos bloquear y desbloquear: Estos métodos encapsulan la lógica para adquirir y liberar el acceso a la región crítica.
    - Proceso P1 y P2: Cada proceso llama a bloquear antes de entrar a la sección crítica y a desbloquear después de salir.
    - Sección crítica: Dentro de cada proceso, la sección crítica es donde se ejecuta el código que solo un proceso puede ejecutar a la vez.

 */

public class ExclusionMutuaDosBanderas {
    private boolean flag1 = false;
    private boolean flag2 = false;

    public void procesoP1() {
        while (true) {
            // Bloquear
            bloquear(flag1, flag2);

            // Sección crítica
            System.out.println("Proceso P1 en la sección crítica");

            // Desbloquear
            desbloquear(flag1);
        }
    }

    public void procesoP2() {
        while (true) {
            // Bloquear
            bloquear(flag2, flag1);

            // Sección crítica
            System.out.println("Proceso P2 en la sección crítica");

            // Desbloquear
            desbloquear(flag2);
        }
    }

    private void bloquear(boolean miFlag, boolean otraFlag) {
        miFlag = true; // Indico mi intención de entrar
        while (otraFlag) {
            // Espero a que el otro proceso salga
        }
    }

    private void desbloquear(boolean miFlag) {
        miFlag = false; // Indico que he salido
    }

    public static void main(String[] args) {
        ExclusionMutuaDosBanderas ejemplo = new ExclusionMutuaDosBanderas();

        Thread hiloP1 = new Thread(ejemplo::procesoP1);
        Thread hiloP2 = new Thread(ejemplo::procesoP2);

        hiloP1.start();
        hiloP2.start();
    }
}

/*

    EN PSEUDOCOIGO

    Explicación Detallada

    - Dos Banderas:

    Se definen dos variables booleanas, flag1 y flag2, asociadas a cada proceso.
    flag1 indica si el proceso P1 tiene la intención de entrar a la región crítica.
    flag2 indica si el proceso P2 tiene la intención de entrar a la región crítica.

    - Procedimiento bloqueo:

    Este procedimiento toma como parámetros las dos banderas y establece la bandera del proceso actual en true para indicar su intención de entrar.
    Luego, entra en un bucle de espera mientras la bandera del otro proceso esté en true, esperando que el otro proceso salga de la región crítica.
  
    - Procedimiento desbloqueo:

    Este procedimiento simplemente establece la bandera del proceso en false para indicar que ha salido de la región crítica.
    
    - Procesos P1 y P2:

    Cada proceso llama al procedimiento bloqueo antes de entrar a la región crítica y al procedimiento desbloqueo después de salir.
    Al utilizar las dos banderas, se evita la condición de carrera que ocurría con una sola bandera, ya que ambos procesos deben esperar activamente a que el otro termine antes de entrar.

 */


/*

    Explicación del Código:

    procedure bloqueo(var mi_flag, su_flag: boolean);
    begin
        mi_flag := true;  // Indico mi intención de entrar
        while su_flag do  // Mientras el otro proceso esté activo
            mi_flag := false;  // Desactivo temporalmente mi bandera
            mi_flag := true;  // Vuelvo a activarla
        end;
    end bloqueo;

    mi_flag: Indica si el proceso actual tiene la intención de entrar a la región crítica.
    su_flag: Indica si el otro proceso tiene la intención de entrar a la región crítica.

    Cómo Funciona:

    Un proceso establece su bandera en true para indicar su intención de entrar.
    Comienza a verificar la bandera del otro proceso.
    Si la bandera del otro proceso está en true, desactiva temporalmente su propia bandera y vuelve a verificarla.
    Al desactivar su propia bandera, si el otro proceso también está verificando las banderas y encuentra que la primera está en false, puede entrar a la región crítica.
    Una vez que el otro proceso sale de la región crítica, el primer proceso volverá a encontrar su bandera en true y podrá entrar.

 */


/*

    ALGORITMO DE PETERSON

    Código en Pseudocódigo:
    
    Algoritmo de Peterson

    Variables:
        flag1, flag2: booleano;
        turno: integer;

    Proceso P1:
        loop
            bloqueo(flag1, flag2, 2);  // Bloquea el proceso P1
            // Sección crítica
            desbloqueo(flag1);
        end loop;

    Proceso P2:
        loop
            bloqueo(flag2, flag1, 1);  // Bloquea el proceso P2
            // Sección crítica
            desbloqueo(flag2);
        end loop;

    Procedimiento bloqueo(var mi_flag, su_flag: boolean; su_turno: integer):
        mi_flag := true;
        turno := su_turno;
        while su_flag and (turno = su_turno) do
        end while;

    Procedimiento desbloqueo(var mi_flag: boolean):
        mi_flag := false;

 */

/*

    ALGORITMO DE DEKKER

    Código en Pseudocódigo (basado en la imagen proporcionada):

    Algoritmo de Dekker

    Variables:
        flag1, flag2: booleano;
        turno: integer;

    Proceso P1:
        loop
            bloqueo(flag1, flag2, 2);  // Bloquea el proceso P1
            // Sección crítica
            turno := 2;              // Asigna el turno al otro proceso
            desbloqueo(flag1);
        end loop;

    Proceso P2:
        // Código similar para P2, intercambiando flag1 y flag2

 */

 