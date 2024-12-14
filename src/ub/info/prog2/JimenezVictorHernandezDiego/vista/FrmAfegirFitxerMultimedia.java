package ub.info.prog2.JimenezVictorHernandezDiego.vista;

import ub.info.prog2.JimenezVictorHernandezDiego.controlador.Controlador;
import ub.info.prog2.utils.ReproException;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FrmAfegirFitxerMultimedia extends javax.swing.JDialog {

    /**
     * Constructor
     * 
     * @param parent       finestra pare, el JDialog es posicionara al centre d'aquesta
     * @param modal        poder navegar o no per altres finestres sense tancar aquesta
     * @param controlador  controlador del reproductor
     */
    
    public FrmAfegirFitxerMultimedia(java.awt.Frame parent, boolean modal, Controlador controlador) {
        super(parent, modal);
        initComponents();
        this.controlador = controlador;
        cmbBoxAudio = true;  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textCami = new javax.swing.JTextField();
        etCami = new javax.swing.JLabel();
        btnAcceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        etAutor = new javax.swing.JLabel();
        textAutor = new javax.swing.JTextField();
        etCodec = new javax.swing.JLabel();
        textCodec = new javax.swing.JTextField();
        cmbBoxAudioImatge = new javax.swing.JComboBox<>();
        etTipus = new javax.swing.JLabel();
        etDades2 = new javax.swing.JLabel();
        textDades2 = new javax.swing.JTextField();
        etDades1 = new javax.swing.JLabel();
        textDades1 = new javax.swing.JTextField();
        btnSeleccionarImatgeAssociada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textCami.setEditable(false);
        textCami.setMaximumSize(new java.awt.Dimension(6, 20));

        etCami.setText("Camí:");

        btnAcceptar.setText("Acceptar");
        btnAcceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSeleccionar.setText("Seleccionar fitxer");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        etAutor.setText("Autor:");

        etCodec.setText("Codec:");

        textCodec.setEditable(false);

        cmbBoxAudioImatge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Audio", "Imatge" }));
        cmbBoxAudioImatge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxAudioImatgeActionPerformed(evt);
            }
        });

        etTipus.setText("Tipus:");

        etDades2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etDades2.setText("Imatge:");

        textDades2.setEditable(false);

        etDades1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etDades1.setText("Qualitat:");

        btnSeleccionarImatgeAssociada.setText("Seleccionar");
        btnSeleccionarImatgeAssociada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImatgeAssociadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(etAutor)
                        .addComponent(etCami))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(etCodec)
                        .addComponent(etTipus)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCami, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(textCodec, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(cmbBoxAudioImatge, javax.swing.GroupLayout.Alignment.LEADING, 0, 91, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(etDades2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textDades2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(etDades1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textDades1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnSeleccionarImatgeAssociada, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAcceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etCami)
                    .addComponent(textCami, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etAutor)
                    .addComponent(textAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAcceptar)
                    .addComponent(textDades1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etDades1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etCodec)
                    .addComponent(textCodec, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar)
                    .addComponent(textDades2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etDades2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBoxAudioImatge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etTipus)
                    .addComponent(btnSeleccionarImatgeAssociada))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Es selecciona el fitxer a afegir amb JFileChooser i 
     * s'omple el camp de text textCodec
     * 
     * @param evt Listener de l'event
     */
    
    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        File fitxer = escollirFitxer();
        
        if (fitxer != null) {
            String cami = fitxer.getAbsolutePath();
            
            //Si el fitxer te extensio s'actualitzen els camps de text
            if (cami.indexOf('.') != -1) {
                textCami.setText(cami);
                textCodec.setText(cami.substring(cami.lastIndexOf('.')));
            } else
                JOptionPane.showMessageDialog(this, "Error de selecció. El fitxer no té extensió.", "Missatge d'avís", 2);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     * Es selecciona la imatge associada a l'audio amb JFileChooser
     * 
     * @param evt Listener de l'event
     */
    
    private void btnSeleccionarImatgeAssociadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImatgeAssociadaActionPerformed
        File fitxer = escollirFitxer();
        
        if (fitxer != null)
            textDades2.setText(fitxer.getAbsolutePath());
    }//GEN-LAST:event_btnSeleccionarImatgeAssociadaActionPerformed

    /**
     * Es canvien les dades demanades al canviar l'element 
     * seleccionat de cmbBoxAudioImatge
     * 
     * @param evt Listener de l'event
     */
    
    private void cmbBoxAudioImatgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxAudioImatgeActionPerformed
        //Depenent del tipus de fitxer que l'usuari vulgui afegir, la informacio
        //que haura d'introduir canvia i, per tant, modifiquem el text de les etiquetes
        
        if (cmbBoxAudioImatge.getModel().getSelectedItem().equals("Audio")) {
            cmbBoxAudio = true;
            etDades1.setText("Qualitat:");
            etDades2.setText("Imatge:");
        } else {
            cmbBoxAudio = false;
            etDades1.setText("Alçada:");
            etDades2.setText("Amplada:");
        }
        
        //Esborrem tot el que s'hagi introduit fins ara
        clean();
        
        //Activem i desactivem depenent de si es vol afegir un fitxer d'audio 
        //(per escollir la imatge associada a ell amb JFileChooser)
        textDades2.setEditable(!cmbBoxAudio);
        btnSeleccionarImatgeAssociada.setVisible(cmbBoxAudio);
        btnSeleccionarImatgeAssociada.setEnabled(cmbBoxAudio);
    }//GEN-LAST:event_cmbBoxAudioImatgeActionPerformed

    /**
     * Es tanca el JDialog, es cancel·la l'operacio
     * 
     * @param evt Listener de l'event
     */
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        tancar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * S'afegeix el fitxer amb les dades donades
     * al repositori (si les dades son valides)
     * 
     * @param evt Listener de l'event
     */
    
    private void btnAcceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptarActionPerformed
        //Si no s'han omplert tots els camps informa l'usuari
        if (textCami.getText().isEmpty()    || textAutor.getText().isEmpty() ||
            textDades1.getText().isEmpty() || textDades2.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Omple tots els camps.", "Error de lectura", 2);
        else {
            //Afegim un audio
            if (cmbBoxAudio) {
                String s = textDades1.getText();
                int kbps = s.isEmpty()? -1 : Integer.parseInt(s);

                if (kbps <= 0)
                    JOptionPane.showMessageDialog(this, "La qualitat ha de ser major a 0.", "Error de lectura", 2);
                else {
                    try {
                        controlador.addAudio(textCami.getText(), textDades2.getText(),
                                             textAutor.getText(), textCodec.getText(), kbps);
                        JOptionPane.showMessageDialog(this,"Àudio afegit amb èxit!","Missatge de finalització",1);
                        tancar();
                    } catch (ReproException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage(), "ReproException", 0);
                    }
                }
            } 
            //Afegim una imatge
            else {
                String alc = textDades1.getText();
                String amp = textDades2.getText();

                int alcada  = alc.isEmpty()? -1 : Integer.parseInt(alc);
                int amplada = amp.isEmpty()? -1 : Integer.parseInt(amp);

                if (alcada <= 0 || amplada <= 0)
                    JOptionPane.showMessageDialog(this, "L'alçada i l'amplada han de ser majors a 0.", "Error de lectura", 2);
                else {
                    try {
                        controlador.addImatge(textCami.getText(), textAutor.getText(),
                                              textCodec.getText(), alcada, amplada);
                        JOptionPane.showMessageDialog(this,"Imatge afegida amb èxit!","Missatge de finalització",1);
                        tancar();
                    } catch (ReproException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage(), "ReproException", 0);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAcceptarActionPerformed

    /**
     * Es selecciona un fitxer amb JFileChooser
     * 
     * @return File
     */
    
    private File escollirFitxer() {
        File fitxer = null;
        JFileChooser seleccio = new JFileChooser();
        int resultat = seleccio.showOpenDialog(this);
        if (resultat == JFileChooser.APPROVE_OPTION)
            fitxer = seleccio.getSelectedFile();
        
        return fitxer;
    }
    
    /**
     * Neteja tots els camps de text
     */
    
    private void clean() {
        textCami.setText("");
        textAutor.setText("");
        textCodec.setText("");
        textDades1.setText("");
        textDades2.setText("");
    }
    
    /**
     * Tanca el JDialog
     */
    
    private void tancar() {
        clean();
        setVisible(false);
        dispose();
    }
    
    /**
     * Atributs
     */
    
    private boolean cmbBoxAudio;
    private final Controlador controlador;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnSeleccionarImatgeAssociada;
    private javax.swing.JComboBox<String> cmbBoxAudioImatge;
    private javax.swing.JLabel etAutor;
    private javax.swing.JLabel etCami;
    private javax.swing.JLabel etCodec;
    private javax.swing.JLabel etDades1;
    private javax.swing.JLabel etDades2;
    private javax.swing.JLabel etTipus;
    private javax.swing.JTextField textAutor;
    private javax.swing.JTextField textCami;
    private javax.swing.JTextField textCodec;
    private javax.swing.JTextField textDades1;
    private javax.swing.JTextField textDades2;
    // End of variables declaration//GEN-END:variables
}
