package ub.info.prog2.JimenezVictorHernandezDiego.model;

import ub.info.prog2.utils.InFile;
import java.io.File;
import java.util.Date;
import ub.info.prog2.utils.ReproException;
import ub.info.prog2.JimenezVictorHernandezDiego.controlador.Motor;

/**
 * La classe defineix els atributs i el comportament dels
 * fitxers que es reproduiran
 */

public abstract class FitxerMultimedia extends File implements InFile {
    
    /**
     * Atributs
     */
    
    private final String nomFitxer;
    private final Date ultimaModificacio;
    private final String camiAbsolut;
    private String autor;
    private final String codec;
    protected transient Motor motor;

    /**
     * Constructor, es crida primer al constructor de la classe 
     * File i despres s'inicialitzen els atributs:
     * 
     * -el nom del fitxer
     * -l'autor
     * -la data de l'ultima modificacio
     * -el cami complet a disc
     * -l'extensio
     * -el motor de reproduccio que utilitza
     * 
     * @param cami cami del fitxer
     * @param autor autor del fitxer
     * @param codec extensió del fitxer
     * @param motor que utilitza 
     */
    
    protected FitxerMultimedia(String cami, String autor, String codec, Motor motor) {
        super(cami);
        this.nomFitxer = this.getName();
        this.autor = autor;
        this.ultimaModificacio = new Date(this.lastModified());
        this.camiAbsolut = super.getAbsolutePath();
        this.codec = codec;
        this.motor = motor;
    }

    /**
     * Es fixa el motor de reproducció
     * 
     * @param motor motor que reproduira els fitxers multimedia
     */

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    /**
     * Retorna la data de l'ultima modificacio del fitxer
     * 
     * @return Date
     */
    
    @Override
    public Date getUltimaModificacio() {
        return ultimaModificacio;
    }

    /**
     * Retorna el cami complet del fitxer
     * 
     * @return String
     */
    
    @Override
    public String getCamiAbsolut() {
        return camiAbsolut;
    }
    
    /**
     * Retorna el nom del fitxer
     * 
     * @return String
     */
    
    @Override
    public String getNomFitxer() {
        return nomFitxer;
    }
    
    /**
     * Retorna l'autor del fitxer
     * 
     * @return String
     */
    
    @Override
    public String getAutor() {
        return autor;
    }

    /**
     * Estableix un nou autor del fitxer
     * 
     * @param string nou autor del fitxer
     */
    
    @Override
    public void setAutor(String string) {
        autor = string;
    }

    /**
     * Comprova si dos fitxers son iguals
     * 
     * @param fitxerMultimedia objecte a comprovar amb l'actual
     * 
     * @return boolean: true/false
     */
    
    @Override
    public boolean equals(Object fitxerMultimedia) {
        FitxerMultimedia fitxerMultimedia1 = (FitxerMultimedia) fitxerMultimedia;
        boolean comparison = false;
        
        if(this.getNomFitxer().equals(fitxerMultimedia1.getNomFitxer()) && this.ultimaModificacio.equals(fitxerMultimedia1.ultimaModificacio) && this.camiAbsolut.equals(fitxerMultimedia1.getCamiAbsolut()) && this.getAutor().equals(fitxerMultimedia1.getAutor()))
            comparison = true;
        
        return comparison;
    }

    /**
     * Retorna una cadena que representa el fitxer
     * 
     * @return String
     */
    
    @Override
    public String toString() {
        String toShow = "";
        toShow += "Nom: " + getNomFitxer() + "\n";
        toShow += "Autor: " + getAutor() + "\n";
        toShow += "Data: " + getUltimaModificacio() + "\n";
        toShow += "Camí Absolut: " + getCamiAbsolut() + "\n";
        return toShow;
    }
    
    /**
     * Reprodueix el fitxer multimedia
     */
    
    public abstract void reproduir() throws ReproException;
}