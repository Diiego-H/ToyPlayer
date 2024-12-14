package ub.info.prog2.JimenezVictorHernandezDiego.controlador;

import ub.info.prog2.JimenezVictorHernandezDiego.model.FitxerMultimedia;
import ub.info.prog2.utils.EscoltadorReproduccioBasic;
import ub.info.prog2.JimenezVictorHernandezDiego.model.LlistaFitxers;
import ub.info.prog2.utils.ReproException;
import ub.info.prog2.JimenezVictorHernandezDiego.vista.AplicacioUB4;

/**
 * La classe s'encarrega de reproduir un conjunt de fitxers multimedia
 */

public class EscoltadorReproduccio extends EscoltadorReproduccioBasic {

    /**
     * Atributs
     */

    private LlistaFitxers llistaReproduint;
    private boolean reproduccioCiclica, reproduccioReverse;
    private final AplicacioUB4 frame;
    private int current;

    /**
     * Constructor
     * 
     * @param frame JFrame de la GUI
     */

    public EscoltadorReproduccio(javax.swing.JFrame frame) {
        llistaReproduint = null;
        reproduccioCiclica = false;
        reproduccioReverse = false;
        this.frame = (AplicacioUB4) frame;
    }

    /**
     * Metode cridat un cop s'acaba la reproduccio del fitxer, es reprodueix el seguent fitxer
     * si hi ha seguent o, si no, desactiva les components de reproduccio de la interficie
     */

    @Override
    protected void onEndFile() {
        //Comprovem que l'usuari no hagi eliminat tots els fitxers durant la reproduccio
        if (hasNext() && !llistaReproduint.isEmpty())
            next();
        else
            frame.setEnabledReproComponents(false);
    }

    /**
     * Metode que reprodueix el seguent fitxer segons el mode de reproduccio
     * i canvia el text del fitxer que s'esta reproduint, a la interficie
     */

    @Override
    protected void next() {
        try {
            current += reproduccioReverse? -1 : 1;
            
            //Si ha acabat de reproduir-se la llista, tornem a començar
            if (current < 0 || current >= llistaReproduint.getSize())
                iniciarReproduccio(llistaReproduint,reproduccioCiclica,reproduccioReverse);
            else {
                FitxerMultimedia file = (FitxerMultimedia) llistaReproduint.getAt(current);

                file.reproduir();
                frame.setTxtFitxerReproduint(file.toString());
            }
        } catch (ReproException e) {
        }
    }

    /**
     * Metode que indica si hi ha seguent fitxer a reproduir
     * 
     * @return boolean
     */
    
    @Override
    protected boolean hasNext() {
        boolean hasNext;
        if (reproduccioReverse)
            hasNext = current-1 >= 0;
        else
            hasNext = current+1 < llistaReproduint.getSize();
        return hasNext || reproduccioCiclica;
    }

    /**
     * Inicia la reproduccio d'una llista de fitxers
     *
     * @param llistaReproduint llista de fitxers a reproduir
     * @param reproduccioCiclica mode ciclic actiu o no
     * @param reproduccioReverse mode reverse actiu o no
     */

    public void iniciarReproduccio(LlistaFitxers llistaReproduint, boolean reproduccioCiclica, boolean reproduccioReverse) throws ReproException {
        this.llistaReproduint = llistaReproduint;
        this.reproduccioCiclica = reproduccioCiclica;
        this.reproduccioReverse = reproduccioReverse;
        
        current = reproduccioReverse? llistaReproduint.getSize() : -1;
        next();
    }
}