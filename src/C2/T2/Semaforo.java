package C2.T2;

public class Semaforo {

}

/*

    SEMAFORO EN PSEUDOCODIGO

    process P1
    begin
        loop
            espera(S);  // Bloquea el proceso si el recurso está ocupado
            // Sección crítica
            señal(S);   // Libera el recurso para otros procesos
        end loop;
    end P1;

    - La luz roja y verde: Simbolizan el estado del semáforo (ocupado o disponible).
    - Operaciones espera y señal: Representan las acciones que un proceso realiza para acceder y liberar el recurso.
    - Región crítica: Es la sección de código a la que solo un proceso puede acceder en un momento dado.
    - Solutions: Indica que los semáforos son una solución para el problema de la exclusión mutua.

 */

/*

    SINCRONIZACIÓN CON SEMAFORO

    module Sincronización; (* Sincronización con semáforo *)

    var sincro: semaforo;

    process P1 (* Proceso que espera *)
    begin
        espera(sincro);
        // Sección crítica de P1
    end P1;

    process P2 (* Proceso que señala *)
    begin
        señal(sincro);
        // Sección crítica de P2
    end P2;

    - Los pingüinos: Representan de forma visual a los procesos P1 y P2.
    - La operación espera: Simboliza el bloqueo de un proceso hasta que se cumpla una condición.
    - La operación señal: Representa la liberación de un proceso bloqueado.
    - Cobegin y coend: Indican el inicio y el final de la ejecución concurrente de los procesos P1 y P2.

|   SOLUCIÓN

    begin (* Sincronización*)
        inicializa(sincro, 0);
        cobegin
            P1;
            P2;
        coend
    end Sincronizacion

 */