package m09_uf2_activitat6;

public class CuentaBancaria {

    private int contenido=1000;
    private boolean contenedorLleno = Boolean.FALSE;

    public synchronized void ingreso(int value) {
        while (contenedorLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        contenedorLleno = !contenedorLleno;
        contenido += value;
        System.out.println("El saldo actual es: "+ contenido);
        notifyAll();
    }

    public synchronized void extraccion(int value) {
        while (!contenedorLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        contenedorLleno = !contenedorLleno;
        contenido -= value;
        System.out.println("El saldo actual es: "+ contenido);
        notifyAll();
    }

    public int getContenido() {
        return contenido;
    }
    
    
}
