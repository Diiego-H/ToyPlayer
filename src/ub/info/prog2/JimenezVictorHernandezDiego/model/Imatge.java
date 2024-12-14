package ub.info.prog2.JimenezVictorHernandezDiego.model;

import ub.info.prog2.JimenezVictorHernandezDiego.controlador.Motor;
import ub.info.prog2.utils.ReproException;

/**
 * La classe defineix els atributs i el comportament 
 * especifics d'un fitxer d'imatge
 */

public class Imatge extends FitxerMultimedia {
    
    /**
     * Atributs
     */
    
    private final int alcada;
    private final int amplada;
    
    /**
     * Constructor
     * 
     * @param cami cami del fitxer
     * @param autor autor del fitxer
     * @param codec extensio del fitxer
     * @param alcada pixels d'alcada de la imatge
     * @param amplada pixels d'amplada de la imatge
     * @param motor motor que reprodueix la imatge
     */
    
    public Imatge(String cami, String autor, String codec, int alcada, int amplada, Motor motor) {
        super(cami, autor, codec, motor);
        this.alcada = alcada;
        this.amplada = amplada;
    }
    
    /**
     * Es reprodueix un fitxer d'imatge
     */
    
    @Override
    public void reproduir() throws ReproException {
        motor.reprodueix(this);
    }
}