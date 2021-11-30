
package presentacion;

import control.Control;
import javax.swing.JOptionPane;
import juegotimbiriche.Jugador;

/**
 *
 * @author Equipo 5
 */
public class IngresarNombre extends javax.swing.JDialog {
    private juegoTimbiriche juego;
    
    public IngresarNombre(java.awt.Frame parent, boolean modal, juegoTimbiriche juego) {
        super(parent, modal);
        this.juego= juego;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbColor = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        fondoAceptar = new javax.swing.JPanel();
        fondoCancelar = new javax.swing.JPanel();
        fondo = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbColor.setBackground(new java.awt.Color(204, 204, 204));
        cmbColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rojo", "Naranja", "Amarillo", "Verde lima", "Verde", "Turquesa", "Celeste", "Azul", "Morado", "Rosa", "Rosa claro" }));
        getContentPane().add(cmbColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 230, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 230, -1));

        btnAceptar.setBackground(new java.awt.Color(3, 152, 158));
        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(null);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 130, 40));

        btnCancelar.setBackground(new java.awt.Color(255, 87, 87));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 130, 40));

        fondoAceptar.setBackground(new java.awt.Color(3, 152, 158));
        getContentPane().add(fondoAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 130, 40));

        fondoCancelar.setBackground(new java.awt.Color(255, 87, 87));
        getContentPane().add(fondoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 130, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IngresarNombre.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu2.setText("Ayuda");
        menu.add(jMenu2);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(validar()){
            Control control= Control.getControl();
            Jugador jugador= control.crearJugador(txtNombre.getText(), (String) cmbColor.getSelectedItem());
            MenuJuego juego = new MenuJuego((java.awt.Frame) this.getParent(), true, this.juego, jugador);
            this.dispose();
            juego.setVisible(true);
            juego.setLocationRelativeTo(this);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        juego.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public boolean validar(){
        if(txtNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog((java.awt.Frame) this.getParent(), "Favor de ingresar nombre", "No válido", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(txtNombre.getText().length()>15){
            JOptionPane.showMessageDialog((java.awt.Frame) this.getParent(), "El nombre es demasiado largo (limitar a 15 caracteres)", "No válido", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmbColor;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel fondoAceptar;
    private javax.swing.JPanel fondoCancelar;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menu;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
