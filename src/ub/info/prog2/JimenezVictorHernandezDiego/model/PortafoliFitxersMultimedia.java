package ub.info.prog2.JimenezVictorHernandezDiego.model;

import ub.info.prog2.utils.ReproException;

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;

/**
 * La classe defineix un portafoli de fitxers multimedia 
 * (amb el mateix autor i sota un mateix titol) i les seves
 * funcionalitats
 */

public class PortafoliFitxersMultimedia extends LlistaFitxers implements Serializable {
    
    /**
     * Atributs
     */

    private final String titol;
    private String autor;

    /**
     * Constructor sense especificar mida maxima del portafoli
     * 
     * @param titol titol que identifica el portafoli
     */

    public PortafoliFitxersMultimedia(String titol) {
        super();
        this.titol = titol;
        this.autor = "";
    }

    /**
     * Constructor especificant mida maxima del portafoli
     * 
     * @param titol titol que identifica el portafoli
     * @param n mida maxima del portafoli
     */
    
    public PortafoliFitxersMultimedia(String titol, int n) {
        super(n);
        this.titol = titol;
        this.autor = "";
    }

    /**
     * S'afegeix un fitxer al portafoli
     *
     * @param fitxer fitxer a afegir
     */

    public void addFitxer(File fitxer) throws ReproException {
        FitxerMultimedia file = (FitxerMultimedia) fitxer;
        
        if (!isFull()) {
            if (!isEmpty()) {
                if (file.getAutor().equals(autor))
                    super.addFitxer(file);
                else
                    throw new ReproException("Els autors no son iguals!");
            } else {
                autor = file.getAutor();
                super.addFitxer(file);
            }
        } else 
            throw new ReproException("El portafoli esta ple!");
    }

    /**
     * Retorna el titol del portafoli
     *
     * @return titol
     */
    
    public String getTitol() {
        return titol;
    }

    /**
     * Es comparen els titols de dos portafolis
     *
     * @param portafoli portafoli amb el qual es vol comparar
     * 
     * @return boolean mateix titol o no
     */

    @Override
    public boolean equals(Object portafoli) {
        PortafoliFitxersMultimedia compare = (PortafoliFitxersMultimedia) portafoli;
        return compare.getTitol().equalsIgnoreCase(this.getTitol());
    }

    /**
     * Retorna una cadena que representa el portafoli
     *
     * @return String
     */

    @Override
    public String toString() {
        String sortida = titol + ":\n\n";
        Iterator it = llista.iterator();
        int i = 0;
        
        while (it.hasNext()) {
            i++;
            sortida += "\t\t[" + i + "] -" + ((FitxerMultimedia)it.next()).getNomFitxer() + "\n";  
        }
        
        return sortida;
    }
}