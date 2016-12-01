package m09_uf2_activitat6;

import java.util.Random;

public class Extraer implements Runnable{

    private final Random aleatorio;
    private final CuentaBancaria cuenta;
    private final int idextraer;
    private final int TIEMPOESPERA = 1500;
    
    public Extraer(CuentaBancaria cuenta, int idextraer) {
        this.cuenta=cuenta;
        this.idextraer=idextraer;
        aleatorio = new Random();
    }

    @Override
    public void run() {
        while (Boolean.TRUE) {
            int poner = aleatorio.nextInt(300);
            cuenta.extraccion(poner);
            System.out.println("El extractor " + idextraer + " extrae: " + poner);
            try {
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                System.err.println("Extractor " + idextraer + ": Error en run -> " + e.getMessage());
            }
        }
    }

}
