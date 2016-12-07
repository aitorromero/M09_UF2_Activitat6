package m09_uf2_activitat6;

public class CuentaBancaria {

    /**
     * Declarem les variables
     */
    private int contenido=900;
    private boolean contenedorLleno = Boolean.FALSE;
    
    /**
     * Creem un dels dos synchronized per a poder fer els ingresos amb un wait 
     * per a parar el fill i deixarlo en la cua de processos. Quan aquest rep la 
     * senyal, pugui accedir i cambiar l'estat de contenedorLleno per a evitar 
     * l'access a l'altre shynchronized. A més fem les modificacions en 
     * contenido. Per a despres permetre l'access d'un dels altres fils.
     * @param value 
     */
    public synchronized void ingreso(int value) {
        while (contenedorLleno || contenido+value>1000) {
            try {
                if(contenido-value<0){
                    System.out.println("Intentando INTRODUCIR " +value+ " a "+ contenido);
                }
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        contenedorLleno = !contenedorLleno;
        contenido += value;
        System.out.println("++Ingreso de "+value+" ---- Tienes: "+getContenido());
        contenedorLleno = !contenedorLleno;
        notifyAll();
    }

    /**
     * Creem un dels dos synchronized per a poder fer els extraccions amb un wait 
     * per a parar el fill i deixarlo en la cua de processos. Quan aquest rep la 
     * senyal, pugui accedir i cambiar l'estat de contenedorLleno per a evitar 
     * l'access a l'altre shynchronized. A més fem les modificacions en 
     * contenido. Per a despres permetre l'access d'un dels altres fils.
     * @param value 
     */
    public synchronized void extraccion(int value) {
        while (contenedorLleno || contenido-value<0) {
            try {
                if(contenido-value<0){
                    System.out.println("Intentando EXTRAER " +value+ " a "+ contenido);
                }
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        contenedorLleno = !contenedorLleno;
        contenido -= value;
        System.out.println("--Extraccion de : " + value+" ---- Tienes: "+getContenido());
        contenedorLleno = !contenedorLleno;
        notifyAll();
    }

    /**
     * Un getter muy majo para acceder al contenido.
     * @return 
     */
    public int getContenido() {
        return contenido;
    }
    
    
}
