package TP4;

import java.util.ArrayList;

public class Consumidor extends Thread {

    ArrayList<Integer> Lista;
    int Num;

    public Consumidor(ArrayList<Integer> lista, int num) {
        Lista = lista;
        Num = num;
    }

    public void run() {

        synchronized(Lista) {

            //puedo usar un if
            while (Lista.size() == 0) {
                
                System.out.println("Consu (" + Num + "): No hay elementos para consumir, me duermo");
                try {
                    Lista.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Consu(" + Num + "): Me despertaron");

            }

            int consumido = Lista.remove(0);
            System.out.println("Consu (" + Num + ") Consumido: " + consumido);

        }

    }

}
