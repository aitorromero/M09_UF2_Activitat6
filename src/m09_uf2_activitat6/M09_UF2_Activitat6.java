package m09_uf2_activitat6;

public class M09_UF2_Activitat6 {

    private static CuentaBancaria cuentabancaria;
    private static Thread[] introducir;
    private static Thread[] extraer;
    private static final int CANTIDAD = 5;
    
    public static void main(String[] args) {
        
        cuentabancaria = new CuentaBancaria();
        introducir = new Thread[CANTIDAD];
        extraer = new Thread[CANTIDAD];
        
        
        for (int i = 0; i < CANTIDAD; i++) {
            
            if(Math.random()<0.5){
                introducir[i] = new Thread(new Introducir(cuentabancaria, i));
                introducir[i].start();
            }else{
                extraer[i] = new Thread(new Extraer(cuentabancaria, i));
                extraer[i].start();
            }
        }
        
    
    }

}
