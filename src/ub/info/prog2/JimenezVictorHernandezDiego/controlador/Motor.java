package ub.info.prog2.JimenezVictorHernandezDiego.controlador;

import ub.info.prog2.utils.MotorBasic;
import ub.info.prog2.utils.ReproException;
import ub.info.prog2.JimenezVictorHernandezDiego.model.Audio;
import ub.info.prog2.JimenezVictorHernandezDiego.model.Imatge;
import java.io.File;

/**
 * La classe motoritza el reproductor
 */

public class Motor extends MotorBasic {
    
    /**
     * Constructor
     * 
     * @param escoltador escoltador que controla els fitxers que reprodueix el motor
     */
    
    public Motor(EscoltadorReproduccio escoltador) {
        super("C:\\Program Files\\VideoLAN\\VLC", escoltador);
    }
    
    /**
     * Reproduccio d'un fitxer d'imatge
     * 
     * @param im imatge a reproduir
     */
    
    public void reprodueix(Imatge im) throws ReproException {
        show(im);
    }
    
    /**
     * Reproduccio d'un fitxer d'audio i la seva imatge associada
     *
     * @param audio audio a reproduir
     * @param fitxerImatge imatge que representa l'audio
     */
    
    public void reprodueix(Audio audio, File fitxerImatge) throws ReproException {
        play(audio, fitxerImatge);
    }
}