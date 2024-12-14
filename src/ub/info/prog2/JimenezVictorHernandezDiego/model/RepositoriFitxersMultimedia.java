package ub.info.prog2.JimenezVictorHernandezDiego.model;

import ub.info.prog2.utils.ReproException;

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;

/**
 * La classe defineix el repositori on s'afegeixen els fitxers multimedia 
 * a reproduir, tambe conte les seves funcionalitats
 */

public class RepositoriFitxersMultimedia extends LlistaFitxers implements Serializable {
    
    /**
     * Constructor
     */

    public RepositoriFitxersMultimedia() {
        super();
    }

    /**
     * S'afegeix un fitxer al repositori
     *
     * @param fitxer fitxer a afegir
     * 
     * @throws ReproException
     */

    @Override
    public void addFitxer(File fitxer) throws ReproException {
        FitxerMultimedia file = (FitxerMultimedia) fitxer;
        
        if (isRepeated(file))
            throw new ReproException("El fitxer ja es troba a la llista!");
        else
            super.addFitxer(file);
    }

    /**
     * Es comprova si un fitxer ja es troba al repositori
     * 
     * @param file fitxer a comprovar
     * 
     * @return boolean si esta repetit o no
     */
    
    private boolean isRepeated(FitxerMultimedia file) {
        boolean repetit = false;
        Iterator it = llista.iterator();
        
        while (it.hasNext() && !repetit)
            if (it.next().equals(file))
                repetit = true;
         
        return repetit;
    }

    /**
     * Es sobreescriu per a que no hi hagi limit de fitxers
     * 
     * @return boolean
     */
    
    @Override
    public boolean isFull() {
        return false;
    }
}