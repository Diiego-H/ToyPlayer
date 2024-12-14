package ub.info.prog2.JimenezVictorHernandezDiego.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import ub.info.prog2.utils.*;

/**
 * La classe LlistaFitxers conte la llista de fitxers multimedia
 * i defineix el seu comportament.
 */

public class LlistaFitxers implements InFileList, Serializable {

    /**
     * Atributs
     */
    
    protected final ArrayList<FitxerMultimedia> llista;
    private final int maxSize;
    
    /**
     * Constructor per defecte, s'inicialitza la llista de fitxers
     * i es defineix un tamany maxim per defecte(100)
     */
    
    protected LlistaFitxers() {
        maxSize = 100;
        llista = new ArrayList(maxSize);
    }
    
    /**
     * Constructor amb parametres
     * 
     * @param n tamany maxim de la llista
     */
    
    protected LlistaFitxers(int n) {
        maxSize = n;
        llista = new ArrayList(maxSize);
    }

    /**
     * Retorna la mida de la llista
     * 
     * @return int
     */
    
    @Override
    public int getSize() {
        return llista.size();
    }
    
    /**
     * Retorna l'element i-essim de la llista
     * 
     * @param i posicio del fitxer a la llista
     * 
     * @return File
     */
    
    @Override
    public File getAt(int i) {
        return llista.get(i);
    }
    
    /**
     * Es comprova si la llista esta plena
     * 
     * @return boolean
     */
    
    @Override
    public boolean isFull() {
        return llista.size() >= maxSize;
    }
    
    /**
     * Es comprova si la llista esta buida
     * 
     * @return boolean
     */
    
    public boolean isEmpty() {
        return llista.isEmpty();
    }

    /**
     * S'afegeix un fitxer a la llista (si existeix a disc)
     *
     * @param fitxer fitxer a afegir
     */

    @Override
    public void addFitxer(File fitxer) throws ReproException {
        if (!fitxer.exists())
            throw new ReproException("El fitxer no existeix!");
        
        llista.add((FitxerMultimedia) fitxer);
    }
    
    /**
     * S'elimina un fitxer de la llista
     * 
     * @param file fitxer a esborrar
     */
    
    @Override
    public void removeFitxer(File file){
        llista.remove((FitxerMultimedia) file);
    }

    /**
     * S'eliminen tots els elements de la llista
     */

    @Override
    public void clear() {
        llista.clear();
    }
}