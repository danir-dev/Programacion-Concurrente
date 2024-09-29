package C2.T2;

public class Productor_Consumidor {

}

/*

    SIN SEMÁFOROS
 
    var buffer: array[1..N] of dato; // Buffer de tamaño N
    var lleno: boolean; // True si el buffer está lleno, False si está vacío

    process Productor
    begin
    loop
        produce(x);
        while lleno do
        // Esperar hasta que el buffer esté vacío
        end while;
        poner(x, buffer);
        lleno := true;
    end loop;
    end;

    process Consumidor
    begin
    loop
        while not lleno do
        // Esperar hasta que el buffer esté lleno
        end while;
        sacar(x, buffer);
        lleno := false;
        consumir(x);
    end loop;
    end;

    Problemas de esta solución:

    - Eficiencia: Ambos procesos están en un bucle infinito comprobando el estado del buffer, lo que consume muchos ciclos de CPU.
    - No es atómica: La lectura y escritura de la variable lleno no son operaciones atómicas, lo que puede llevar a condiciones de carrera.

    
    
    CON SEMÁFOROS

    var buffer: array[1..N] of dato; // Buffer de tamaño N
    var lleno, vacio: semaforo;

    process Productor
    begin
    loop
        produce(x);
        P(vacio); // Espera si el buffer está lleno
        poner(x, buffer); // Coloca el dato en el buffer
        V(lleno); // Indica que hay un dato más en el buffer
    end loop;
    end;

    process Consumidor
    begin
    loop
        P(lleno); // Espera si el buffer está vacío
        sacar(x, buffer); // Saca un dato del buffer
        V(vacio); // Indica que hay un espacio libre en el buffer
        consumir(x);
    end loop;
    end;

    Pasos:

    Inicialización:

    - lleno se inicializa a 0 (buffer vacío).
    - vacío se inicializa al tamaño del buffer (buffer lleno).
    
    Productor:

    - Antes de producir un dato, el productor verifica si el buffer está lleno (espera si lleno es igual al tamaño del buffer).
    - Produce un dato y lo coloca en el buffer.
    - Incrementa lleno e decrementa vacío.
    
    Consumidor:

    - Antes de consumir un dato, el consumidor verifica si el buffer está vacío (espera si vacío es 0).
    - Toma un dato del buffer y lo consume.
    - Decrementa lleno e incrementa vacío.

 */