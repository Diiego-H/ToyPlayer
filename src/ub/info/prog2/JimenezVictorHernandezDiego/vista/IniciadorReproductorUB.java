package ub.info.prog2.JimenezVictorHernandezDiego.vista;

/**
 * La classe inicial del programa. 
 * Instanciem un objecte de tipus AplicacioUB4, que inicia la GUI.
 */

public class IniciadorReproductorUB {
    
    public static void main(String[] args) {
        AplicacioUB4 aplicacio = new AplicacioUB4();
        aplicacio.setTitle("Reproductor UB");
        aplicacio.setLocationRelativeTo(null);
        aplicacio.setVisible(true);
    }
}