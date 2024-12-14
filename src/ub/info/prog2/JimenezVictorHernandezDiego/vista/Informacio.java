package ub.info.prog2.JimenezVictorHernandezDiego.vista;

/**
 * La classe mostra un diàleg informant l'usuari sobre
 * les funcionalitats que ofereix el reproductor.
 */

public class Informacio extends javax.swing.JDialog {

    /**
     * Constructor de la classe
     * 
     * @param parent JFrame pare del JDialog
     * @param modal  permetre o no accedir a altres finestres sense tancar aquesta
     */
    
    public Informacio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panell = new javax.swing.JPanel();
        scrollPanel = new javax.swing.JScrollPane();
        textInformacio = new javax.swing.JTextArea();
        etBenvinguda = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        textInformacio.setEditable(false);
        textInformacio.setColumns(20);
        textInformacio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        textInformacio.setRows(5);
        textInformacio.setText("Repositori: Es mostra la llista de fitxers multimèdia del repositori, permetent les següents accions:\n\n  - Afegir fitxer:                       S'obre un formulari que permet entrar les dades d'un fitxer multimèdia.\n  - Eliminar fitxer:                    S'eliminen els fitxers seleccionats del repositori.\n  - Reproduir:                          Es reprodueix tot el repositori o el fitxer seleccionat.\n\nPortafolis: Es mostra la llista de portafolis i la llista de fitxers d'un portafoli quan un és seleccionat, permetent les següents accions:\n\n  - Crear portafoli:                   Es crea un nou portafoli amb el nom i la mida escollits.\n  - Eliminar portafoli:                S'elimina el portafoli seleccionat.\n  - Afegir fitxer al portafoli:       S'afegeix el fitxer seleccionat del repositori al portafoli seleccionat.\n  - Eliminar fitxer del portafoli:  S'elimina el fitxer seleccionat del portafoli seleccionat.\n  - Reproduir:                          Es reprodueix el portafoli seleccionat.\n\nControls de reproducció:          Permeten controlar el flux de la reproducció.\n\nGuardar/Recuperar dades:       Es guarden/recuperen les dades a un/des d'un fitxer escollit per l'usuari.");
        textInformacio.setOpaque(false);
        scrollPanel.setViewportView(textInformacio);

        etBenvinguda.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        etBenvinguda.setText("Benvingut al reproductor de la UB, l'aplicació ofereix les següents funcionalitats:\n");

        btnOK.setText("D'acord");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panellLayout = new javax.swing.GroupLayout(panell);
        panell.setLayout(panellLayout);
        panellLayout.setHorizontalGroup(
            panellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panellLayout.createSequentialGroup()
                .addGroup(panellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panellLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPanel))
                    .addGroup(panellLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(etBenvinguda)
                        .addGap(0, 125, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(308, 308, 308))
        );
        panellLayout.setVerticalGroup(
            panellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panellLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etBenvinguda, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOK)
                .addContainerGap())
        );

        getContentPane().add(panell, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    /**
     * Es tanca el JDialog quan l'usuari prem el botó
     * 
     * @param evt Listener de l'event
     */
    
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    /**
     * Atributs
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel etBenvinguda;
    private javax.swing.JPanel panell;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTextArea textInformacio;
    // End of variables declaration//GEN-END:variables
}