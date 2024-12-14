package ub.info.prog2.JimenezVictorHernandezDiego.controlador;

import java.util.List;

import ub.info.prog2.JimenezVictorHernandezDiego.model.*;
import ub.info.prog2.utils.InControlador;
import ub.info.prog2.utils.ReproException;

/**
 * La classe es comunica amb el paquet vista i amb el 
 * paquet model, controla el flux del programa
 */

public class Controlador implements InControlador {

    /**
     * Atributs
     */
    
    private Dades dades;
    private final EscoltadorReproduccio escoltador;
    private final Motor motor;

    /**
     * Constructor
     * 
     * @param frame JFrame de la GUI
     */
    
    public Controlador (javax.swing.JFrame frame) {
        dades = new Dades();
        escoltador = new EscoltadorReproduccio(frame);
        motor = new Motor(escoltador);
    }
    
    /**
     * Afegeix un fitxer d'audio al repositori
     * 
     * @param string cami del fitxer
     * @param string1 cami del fitxer amb la seva imatge associada
     * @param string2 autor del fitxer
     * @param string3 extensio del fitxer
     * @param i qualitat de l'audio (en kbps)
     */
    
    @Override
    public void addAudio(String string, String string1, String string2, String string3, int i) throws ReproException {
        dades.afegirAudio(string, string1, string2, string3, i, motor);
    }

    /**
     * Afegeix un fitxer d'imatge al repositori
     * 
     * @param string cami del fitxer
     * @param string1 autor del fitxer
     * @param string2 extensio del fitxer
     * @param i pixels d'alcada de la imatge
     * @param i1 pixels d'amplada de la imatge
     */
    
    @Override
    public void addImatge(String string, String string1, String string2, int i, int i1) throws ReproException {
        dades.afegirImatge(string, string1, string2, i, i1, motor);
    }

    /**
     * Retorna el repositori
     * 
     * @return List
     */
    
    @Override
    public List<String> showRepositori() {
        return dades.mostrarLlistatRepositori();
    }
    
    /**
     * Elimina un fitxer del repositori
     * 
     * @param i posicio del fitxer a esborrar
     */
    
    @Override
    public void removeFitxer(int i) throws ReproException {
        dades.eliminarARepositori(i);
    }

    /**
     * Es guarda l'estat actual del reproductor en un fitxer a disc
     *
     * @param string cami del fitxer on es guardara
     */

    @Override
    public void saveDades(String string) throws ReproException {
        dades.guardar(string);
    }

    /**
     * Es carrega l'estat d'un reproductor des d'un fitxer a disc
     *
     * @param string cami del fitxer que es carregara
     */

    @Override
    public void loadDades(String string) throws ReproException {
        dades = Dades.carregar(string);
        dades.setMotor(motor);
    }

    /**
     * S'afegeix un portafoli
     * 
     * @param string titol
     */
    
    @Override
    public void addPortafoli(String string) throws ReproException {
        dades.afegirPortafoli(string);
    }

    /**
     * S'afegeix un portafoli amb mida maxima
     * 
     * @param string titol
     * @param mida mida maxima del portafoli
     */
    
    public void addPortafoli(String string, int mida) throws ReproException {
        dades.afegirPortafoli(string, mida);
    }
    
    /**
     * Retorna la llista de portafolis
     * 
     * @return List
     */
    
    @Override
    public List<String> showPortafolis() {
        return dades.mostrarLlistaPortafolis();
    }

    /**
     * Elimina un portafoli
     * 
     * @param string titol del portafoli
     */
    
    @Override
    public void removePortafoli(String string) throws ReproException {
        dades.eliminaPortafoli(string);
    }

    /**
     * Comprova si el portafoli existeix
     * 
     * @param string titol del portafoli
     * 
     * @return true/false
     */
    
    @Override
    public boolean existPortafoli(String string) {
        return dades.existeixPortafoli(string);
    }

    /**
     * Afegeix un fitxer del repositori a un portafoli
     * 
     * @param string titol del portafoli
     * @param i index del fitxer del repositori a afegir
     */
    
    @Override
    public void addFitxer(String string, int i) throws ReproException {
        dades.afegirFitxer(string, i);
    }

    /**
     * Retorna la llista de fitxers d'un portafoli
     * 
     * @param string titol del portafoli
     * 
     * @return List
     */
    
    @Override
    public List<String> showPortafoli(String string) throws ReproException {
        return dades.mostrarPortafoliList(string);
    }

    /**
     * Elimina un fitxer d'un portafoli
     * 
     * @param string titol del portafoli
     * @param i posicio de la llista a esborrar
     */
    
    @Override
    public void removeFitxer(String string, int i) throws ReproException {
        dades.eliminarAPortafoli(string, i);
    }

    /**
     * Es reprodueix el fitxer del repositori amb aquest index
     */ 
    
    @Override
    public void playFitxer(int i) throws ReproException {
        openFinestraReproductor();
        escoltador.iniciarReproduccio(dades.getFitxerList(i), false, false);
    }

    /**
     * S'obre la finestra de reproduccio
     */
    
    @Override
    public void openFinestraReproductor() {
        this.motor.open();
    }

    /**
     * Es tanca la finestra de reproduccio
     */
    
    @Override
    public void closeFinestraReproductor() throws ReproException {
        this.motor.close();
    }

    /**
     * Es reprodueixen tots els fitxers guardats al repositori
     */
    
    @Override
    public void playLlista() throws ReproException {
        if (dades.getRepositori().isEmpty())
            throw new ReproException("El repositori està buit!");
        else {
            openFinestraReproductor();
            escoltador.iniciarReproduccio(dades.getRepositori(), dades.getReproCiclica(), dades.getReproReverse());
        }
    }
    
    /**
     * Es reprodueixen tots els fitxers d'un portafoli
     * 
     * @param string titol del portafoli a reproduir
     */
    
    @Override
    public void playLlista(String string) throws ReproException {
        PortafoliFitxersMultimedia portafoli = dades.getPortafoli(string);
        
        if (portafoli.isEmpty())
            throw new ReproException("El portafoli està buit!");
        else {
            openFinestraReproductor();
            escoltador.iniciarReproduccio(portafoli, dades.getReproCiclica(), dades.getReproReverse());
        }
    }

    /**
     * Re-empren la reproduccio
     */
    
    @Override
    public void resumeReproduccio() throws ReproException {
        motor.resume();
    }

    /**
     * Pausa la reproduccio
     */
    
    @Override
    public void pauseReproduccio() throws ReproException {
        motor.pause();
    }

    /**
     * Atura la reproduccio
     */
    
    @Override
    public void stopReproduccio() throws ReproException {
        motor.stop();
    }

    /**
     * Salta al seguent/anterior fitxer a reproduir
     */
    
    @Override
    public void jumpReproduccio() throws ReproException {
        //Parem la reproduccio primer per si no s'ha de seguir reproduint
        stopReproduccio();
        escoltador.onEndFile();
    }
    
    /**
     * Activa/Desactiva el mode ciclic de reproduccio
     * 
     * @param b activar o desactivar el mode ciclic
     */
    
    public void modeCiclic(boolean b) {
        dades.setReproCiclica(b);
    }
    
    /**
     * Retorna si la reproduccio ciclica esta activada
     * 
     * @return boolean
     */
    
    public boolean getCiclic() {
        return dades.getReproCiclica();
    }
    
    /**
     * Activa/Desactiva el mode reverse de reproduccio
     * 
     * @param b activar o desactivar el mode reverse
     */
    
    public void modeReverse(boolean b) {
        dades.setReproReverse(b);
    }
    
    /**
     * Retorna si la reproduccio reverse esta activada
     * 
     * @return boolean
     */
    
    public boolean getReverse() {
        return dades.getReproReverse();
    }
}