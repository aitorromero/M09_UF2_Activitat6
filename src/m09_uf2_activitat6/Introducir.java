package m09_uf2_activitat6;

import java.util.Random;

public class Introducir implements Runnable{
    
    private final Random aleatorio;
    private final CuentaBancaria cuenta;
    private final int idintroductir;
    private final int TIEMPOESPERA = 1500;
    
    public Introducir(CuentaBancaria cuenta, int idintroductir) {
        this.cuenta = cuenta;
        this.idintroductir = idintroductir;
        aleatorio = new Random();
    }

    @Override
    public void run() {
        while (Boolean.TRUE) {
            int poner = aleatorio.nextInt(300);
            cuenta.ingreso(poner);
            System.out.println("El productor " + idintroductir + " pone: " + poner+" queda disponible-->");
            try {
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                System.err.println("Productor " + idintroductir + ": Error en run -> " + e.getMessage());
            }
        }
    }

}
