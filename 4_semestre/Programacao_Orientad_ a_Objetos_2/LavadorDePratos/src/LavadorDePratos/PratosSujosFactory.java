package LavadorDePratos;

import java.util.Random;

public class PratosSujosFactory {

    private Random rand;
    private static int quantidadePratos;
    

    public PratosSujosFactory() {
        rand = new Random();
        quantidadePratos = 0;
    }
    
    public Prato getNewPrato() {
        int i = rand.nextInt(100) + 1;
        Prato p;
        
        if (i < 10) {
            p = new Prato(++quantidadePratos, Estado.ENGORDURADO);
            
        } else if (i >= 10 && i < 30) {
            p = new Prato(++quantidadePratos, Estado.BAIXO);
            
        } else {
            p = new Prato(++quantidadePratos, Estado.MEDIO);
        }
        
        return p;
    }
    
    
    
}
