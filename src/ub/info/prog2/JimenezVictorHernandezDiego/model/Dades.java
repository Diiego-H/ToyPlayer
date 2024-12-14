package ub.info.prog2.JimenezVictorHernandezDiego.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import ub.info.prog2.JimenezVictorHernandezDiego.controlador.Motor;
import ub.info.prog2.utils.ReproException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * La classe conte totes les dades que el programa gestionara, des d'aquesta classe 
 * gestionen els fitxers, els portafolis i el repositori.
 */

public class Dades implements Serializable {

    /**
     * Atributs
     */

    private final RepositoriFitxersMultimedia repositori;
    private final ArrayList<PortafoliFitxersMultimedia> portafolis;
    boolean reproduccioCiclica;
    boolean reproduccioReverse;

    /**
     * Constructor, s'inicialitzen els atributs:
     * 
     * -un repositori de fitxers multimedia que contindra els fitxers
     * -una ArrayList dels diferents portafolis que hi haura
     * -booleans del tipus de reproduccio
     */

    public Dades() {
        repositori = new RepositoriFitxersMultimedia();
        portafolis = new ArrayList();
        reproduccioCiclica = false;
        reproduccioReverse = false;
    }

    /**
     * Es desen les dades a un fitxer
     *
     * @param string camí del fitxer on es desara
     */

    public void guardar(String string) throws ReproException {
        File file = new File(string);
        FileOutputStream fout;
        ObjectOutputStream oos;

        try {
            fout = new FileOutputStream(file);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            fout.close();
            oos.close();
        } catch (IOException e) {
            throw new ReproException(e.getMessage());
        }
    }

    /**
     * Es carreguen les dades des d'un fitxer
     *
     * @param string camí del fitxer del qual es carregara
     * 
     * @return Dades
     */

    public static Dades carregar(String string) throws ReproException {
        File file = new File(string);
        FileInputStream fin;
        ObjectInputStream ois;
        Dades dades;

        try {
            fin = new FileInputStream(file);
            ois = new ObjectInputStream(fin);
            dades = (Dades) ois.readObject();
            fin.close();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            throw new ReproException(e.getMessage());
        }
        
        return dades;
    }

    /**
     * Es fixa el motor de tots els fitxers multimedia del repositori
     * 
     * @param motor motor que reproduira els fitxers
     */

     public void setMotor(Motor motor) {
        Iterator<FitxerMultimedia> it = repositori.llista.iterator();
        while(it.hasNext())
            it.next().setMotor(motor);
    }

    /**
     * S'afegeix un fitxer d'audio al repositori
     * 
     * @param cami cami del fitxer
     * @param fitxerImatge imatge associada a l'audio
     * @param autor autor del fitxer
     * @param codec extensio del fitxer
     * @param kbps qualitat de l'audio
     * @param motor motor que reprodueix l'audio
     */

    public void afegirAudio(String cami, String fitxerImatge, String autor, String codec, int kbps, Motor motor) throws ReproException {
        File imatge = new File(fitxerImatge);
        
        if (imatge.exists())
            repositori.addFitxer(new Audio(cami, imatge, autor, codec, kbps, motor));
        
        else
            throw new ReproException("El fitxer d'imatge no existeix!");
    }

    /**
     * Afegeix un fitxer d'imatge al repositori
     *
     * @param cami cami del fitxer
     * @param autor autor del fitxer
     * @param codec extensio del fitxer
     * @param alcada pixels d'alcada de la imatge
     * @param amplada pixels d'amplada de la imatge
     * @param motor motor que reprodueix la imatge
     */

    public void afegirImatge(String cami, String autor, String codec, int alcada, int amplada, Motor motor) throws ReproException {
        repositori.addFitxer(new Imatge(cami,autor,codec,alcada,amplada,motor));
    }

    /**
     * Retorna la llista de fitxers del repositori
     *
     * @return List
     */
    
    public List<String> mostrarLlistatRepositori() {
        List<String> fitxers = new ArrayList<>();
        Iterator<FitxerMultimedia> it = repositori.llista.iterator();
        while(it.hasNext())
            fitxers.add(it.next().getNomFitxer());
        return fitxers;
    }

    /**
     * Elimina un fitxer del repositori i actualitza els portafolis
     *
     * @param i posicio del fitxer a esborrar
     */

    public void eliminarARepositori(int i) throws ReproException {
        if (i >= 0 && i < repositori.getSize()) {
            FitxerMultimedia fitxer = (FitxerMultimedia) repositori.getAt(i);
            Iterator<PortafoliFitxersMultimedia> it = portafolis.iterator();
            
            repositori.removeFitxer(fitxer);
            
            while (it.hasNext()) {
                PortafoliFitxersMultimedia portafoli = it.next();
                
                while (portafoli.llista.contains(fitxer))
                    portafoli.removeFitxer(fitxer);
            }
        } else
            throw new ReproException("Índex fora de rang!");
    }

    /**
     * Afegeix un portafoli
     *
     * @param titol titol del portafoli a afegir
     * 
     * @throws ReproException
     */

    public void afegirPortafoli(String titol) throws ReproException {
        if (!existeixPortafoli(titol))
            portafolis.add(new PortafoliFitxersMultimedia(titol));
        else
            throw new ReproException("El portafoli ja existeix!");
    }
    
    /**
     * Afegeix un portafoli amb mida maxima
     *
     * @param titol titol del portafoli a afegir
     * @param mida mida maxima del portafoli
     */

    public void afegirPortafoli(String titol, int mida) throws ReproException {
        if (!existeixPortafoli(titol) && mida > 0)
            portafolis.add(new PortafoliFitxersMultimedia(titol, mida));
        else if (mida <= 0)
            throw new ReproException("Portafoli sense capacitat!");
        else
            throw new ReproException("El portafoli ja existeix!");
    }
    
    /**
     * Retorna la llista de portafolis
     *
     * @return List
     */
    
    public List<String> mostrarLlistaPortafolis() {
        List<String> llista = new ArrayList<>();
        Iterator<PortafoliFitxersMultimedia> it = portafolis.iterator();
        while(it.hasNext())
            llista.add(it.next().getTitol());
        return llista;
    }

    /**
     * Elimina un portafoli
     *
     * @param name nom del portafoli a eliminar
     */
    
    public void eliminaPortafoli(String name) throws ReproException {
        PortafoliFitxersMultimedia portafoli = getPortafoli(name);
        
        if (portafoli != null)
            portafolis.remove(portafoli);
        else
            throw new ReproException("El portafoli no existeix!");
    }

    /**
     * Elimina un portafoli
     *
     * @param namePort nom del portafoli al qual se li afegirà
     * @param iFit índex del fitxer al repositori, el qual vol ser afegit
     */
    
    public void afegirFitxer(String namePort, int iFit) throws ReproException {
        PortafoliFitxersMultimedia portafoli = getPortafoli(namePort);
        
        if (portafoli != null) {
            if (iFit >= 0 && iFit < repositori.getSize())
                portafoli.addFitxer(repositori.getAt(iFit));
            else
                throw new ReproException("Índex fora de rang!");
        } else
            throw new ReproException("El portafoli no existeix!");
    }

    /**
     * Retorna la llista de fitxers d'un portafoli
     *
     * @param titol titol del portafoli
     *
     * @return List
     */

    public List<String> mostrarPortafoliList(String titol) throws ReproException {
        List<String> fitxers = new ArrayList<>();
        PortafoliFitxersMultimedia portafoli = getPortafoli(titol);
        
        if (portafoli != null) {
            Iterator<FitxerMultimedia> it = portafoli.llista.iterator();
            
            while(it.hasNext())
                fitxers.add(it.next().getNomFitxer());
            
            return fitxers;
        } else
            throw new ReproException("El portafoli no existeix!");
    }

    /**
     * Elimina un fitxer d'un portafoli
     *
     * @param name titol del portafoli
     * @param i posicio de la llista a esborrar
     */
    
    public void eliminarAPortafoli(String name, int i) throws ReproException {
        PortafoliFitxersMultimedia portafoli = getPortafoli(name);
        
        if (portafoli != null) {
            if (i >= 0 && i < portafoli.getSize()) {
                portafoli.removeFitxer(portafoli.getAt(i));
            } else
                throw new ReproException("Índex fora de rang!");
        } else
            throw new ReproException("El portafoli no existeix!");
    }
    
    /**
     * Comprova si el portafoli existeix
     * 
     * @param string titol del portafoli
     * 
     * @return true/false
     */
    
    public boolean existeixPortafoli(String string) {
        return getPortafoli(string) != null;
    }
    
    /**
     * Retorna el portafoli amb el titol passat per parametre
     * 
     * @param titol titol del portafoli
     * 
     * @return PortafoliFitxersMultimedia
     */
    
    public PortafoliFitxersMultimedia getPortafoli(String titol) {
        boolean trobat = false;
        PortafoliFitxersMultimedia portafoli = null;
        
        Iterator it = portafolis.iterator();
        
        while (it.hasNext() && !trobat) {
            portafoli = (PortafoliFitxersMultimedia) it.next();
            if (portafoli.getTitol().equalsIgnoreCase(titol))
                trobat = true;
        }
        
        if (!trobat)
            portafoli = null;
        
        return portafoli;
    }
    
    /**
     * Retorna el repositori
     * 
     * @return RepositoriFitxersMultimedia
     */
    
    public RepositoriFitxersMultimedia getRepositori() {
        return repositori;
    }
    
    /**
     * Es fa un resum dels fitxers al repositori i als portafolis
     *
     * @return string resum de les dades.
     */
    
    @Override
    public String toString() {
        int i = 0;
        Iterator it = mostrarLlistatRepositori().iterator();
        String out = "Llista Fitxers del Repositori:\n\n";
        
        while (it.hasNext()) {
            i++;
            out += "\t[" + i + "] - " + it.next() + "\n"; 
        }
        
        out += "Llista Portafolis:\n\n";
        
        for (i = 1; i <= portafolis.size(); i++)
            out += "\t[" + i + "] - " + portafolis.get(i).toString() + "\n";
        
        return out;
    }
    
    /**
     * Guarda el mode de reproduccio ciclica
     * 
     * @param reproCiclica si el reproductor te activada la reproduccio ciclica
     */
    
    public void setReproCiclica(boolean reproCiclica) {
        reproduccioCiclica = reproCiclica;
    }
    
    /**
     * Guarda el mode de reproduccio reverse
     * 
     * @param reproReverse si el reproductor te activada la reproduccio reverse
     */
    
    public void setReproReverse(boolean reproReverse) {
        reproduccioReverse = reproReverse;
    }
    
    /**
     * Retorna si el reproductor te activada la reproduccio ciclica
     * 
     * @return boolean
     */

    public boolean getReproCiclica() {
        return reproduccioCiclica;
    }
    
    /**
     * Retorna si el reproductor te activada la reproduccio reverse
     * 
     * @return boolean
     */

    public boolean getReproReverse() {
        return reproduccioReverse;
    }
    
    /**
     * Retorna el fitxer del repositori que correspon a l'index donat
     * 
     * @param i index del fitxer al repositori
     * 
     * @return FitxerMultimedia
     */
    
    private FitxerMultimedia getFitxer(int i) throws ReproException {
        if (i >= 0 && i < repositori.getSize()) {
            FitxerMultimedia fitxer = (FitxerMultimedia) repositori.getAt(i);
            return fitxer;
        } else
            throw new ReproException("Índex fora de rang!");
    }
    
    /**
     * Retorna una llista que conte el fitxer 
     * del repositori que correspon a l'index donat
     * 
     * @param i index del fitxer al repositori
     * 
     * @return LlistaFitxers
     */
    
    public LlistaFitxers getFitxerList(int i) throws ReproException {
        LlistaFitxers llista = new LlistaFitxers();
        llista.addFitxer(getFitxer(i));
        return llista;
    }
}