package C1.T1;

/*
    En este ejemplo:
    - counter es el nombre de la clase.
    - count es una variable miembro de tipo entero largo (long) que almacena un valor numérico.
    - SetCount y GetValue son funciones miembro. SetCount establece un nuevo valor para count, mientras que GetValue devuelve el valor actual de count.
 */

public class Counter {

    private long count; // Variable miembro de la clase

    public void setCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }
}