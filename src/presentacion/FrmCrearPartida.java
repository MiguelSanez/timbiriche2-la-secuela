/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import socket.Cliente;
import socket.Servidor;

/**
 *
 * @author Equipo 5
 */
public class FrmCrearPartida extends javax.swing.JFrame {

    private static FrmCrearPartida instance;

    public static FrmCrearPartida getInstance() {
        if (instance == null) {
            instance = new FrmCrearPartida();
        }
        return instance;
    }

    /**
     * Creates new form FrmCrearPartida
     */
    private FrmCrearPartida() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPantalla = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbTamano = new javax.swing.JComboBox<>();
        fondoCrear = new javax.swing.JPanel();
        fondoCancelar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPantalla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.setContentAreaFilled(false);
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        panelPantalla.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 130, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelPantalla.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 130, 40));

        cmbTamano.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbTamano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10x10" }));
        panelPantalla.add(cmbTamano, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 230, -1));

        fondoCrear.setBackground(new java.awt.Color(3, 152, 158));
        panelPantalla.add(fondoCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 130, 40));

        fondoCancelar.setBackground(new java.awt.Color(255, 87, 87));
        panelPantalla.add(fondoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 130, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/CrearPartida.png"))); // NOI18N
        panelPantalla.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            InetAddress dirServidor = InetAddress.getLocalHost(); // Obtener la dirección del servidor dada en forma de parámetro
            FrmSalaDeEspera partida = FrmSalaDeEspera.getInstance();
            Servidor servidor = Servidor.getServidor();
            servidor.start();
            Cliente cliente = Cliente.getCliente();
            cliente.setIp(dirServidor);
            cliente.start();
            cliente.registrar(FrmIngresarNombre.getInstance().getJugador());
            Juego partida= new Juego();
            this.dispose();
            partida.setVisible(true);
            partida.setLocationRelativeTo(this);
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        FrmMenuJuego partida = FrmMenuJuego.getInstance();
        partida.setVisible(true);
        partida.setLocationRelativeTo(this);

    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> cmbTamano;
    private javax.swing.JPanel fondoCancelar;
    private javax.swing.JPanel fondoCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelPantalla;
    // End of variables declaration//GEN-END:variables
}