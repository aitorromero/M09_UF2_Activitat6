package m09_uf2_activitat6;

import java.util.Random;

public class Introducir implements Runnable{
    
    /**
     * Declarem les variables.
     */
    private final Random aleatorio;
    private final CuentaBancaria cuenta;
    private final int idintroductir;
    private final int TIEMPOESPERA = 1500;
    
    /**
     * Constructor de Introducir amb els parametres següents.
     * @param cuenta
     * @param idintroductir 
     */
    public Introducir(CuentaBancaria cuenta, int idintroductir) {
        this.cuenta = cuenta;
        this.idintroductir = idintroductir;
        aleatorio = new Random();
    }

    /**
     * Run on es crea aleatoriament en valor que introduirem a cuentaBancaria.
     */
    @Override
    public void run() {
        while (Boolean.TRUE) {
            int poner = aleatorio.nextInt(300);
            cuenta.ingreso(poner);
            try {
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                System.err.println("Productor " + idintroductir + ": Error en run -> " + e.getMessage());
            }
        }
    }

}
