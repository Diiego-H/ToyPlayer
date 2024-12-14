package ub.info.prog2.JimenezVictorHernandezDiego.model;
import ub.info.prog2.JimenezVictorHernandezDiego.controlador.Motor;
import ub.info.prog2.utils.ReproException;
import java.io.File;

/**
 * La classe defineix els atributs i el comportament 
 * especifics d'un fitxer d'audio
 */

public class Audio extends FitxerMultimedia {
    
    /**
     * Atributs
     */
    
    private final File fitxerImatge;
    private final int kbps;
    
    /**
     * Constructor
     * 
     * @param cami cami del fitxer
     * @param fitxerImatge imatge associada a l'audio
     * @param autor autor del fitxer
     * @param codec extensio del fitxer
     * @param kbps qualitat de l'audio
     * @param motor motor que reprodueix l'audio
     */
    
    public Audio(String cami, File fitxerImatge, String autor, String codec, int kbps, Motor motor) {
        super(cami, autor, codec, motor);
        this.fitxerImatge = fitxerImatge;
        this.kbps = kbps;
    }
    
    /**
     * Es reprodueix un fitxer d'audio
     */
    
    @Override
    public void reproduir() throws ReproException {
        motor.reprodueix(this, fitxerImatge);
    }
}