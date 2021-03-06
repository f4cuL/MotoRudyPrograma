/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;

/**
 *
 * @author facue
 */
public class Principal extends javax.swing.JFrame {
    
    /**
     * Creates new form Principal
     */
    public Principal() {
             try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagen/textura-fondo.jpg"));
        Image image = icon.getImage();
        desktop = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        btnCargarClientes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnVerRemitoCliente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktop.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1444, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
        );

        menuClientes.setText("Clientes");

        btnCargarClientes.setText("Ver clientes");
        btnCargarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarClientesActionPerformed(evt);
            }
        });
        menuClientes.add(btnCargarClientes);

        jMenuBar1.add(menuClientes);

        jMenu2.setText("Remitos");

        btnVerRemitoCliente.setText("Ver remitos por cliente");
        btnVerRemitoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRemitoClienteActionPerformed(evt);
            }
        });
        jMenu2.add(btnVerRemitoCliente);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnCargarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarClientesActionPerformed

        if (!controlador.getCargar().isVisible())
        {
         controlador.getCargar().setVisible(true);
         controlador.getPri().desktop.add(controlador.getCargar(),0);
         controlador.getModelo().limpiarTabla(controlador.getCargar().getTablaClientes());
         controlador.getModelo().listarClientes(controlador.getCargar().getTablaClientes());
        }

    }//GEN-LAST:event_btnCargarClientesActionPerformed

    private void btnVerRemitoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRemitoClienteActionPerformed

        if (!controlador.getRemitosVer().isVisible())
       {
           controlador.getRemitosVer().setVisible(true);
           controlador.getPri().desktop.add(controlador.getRemitosVer(),0);
           controlador.getModelo().limpiarTabla(controlador.getRemitosVer().getTablaClientesRemito());
           controlador.getModelo().listarClientes(controlador.getRemitosVer().getTablaClientesRemito());
           
         }

    }//GEN-LAST:event_btnVerRemitoClienteActionPerformed

    public JMenuItem getBtnVerRemitoCliente() {
        return btnVerRemitoCliente;
    }

    public void setBtnVerRemitoCliente(JMenuItem btnVerRemitoCliente) {
        this.btnVerRemitoCliente = btnVerRemitoCliente;
    }
    private Controlador controlador;
    
    /**
     * @param args the command line arguments
     */

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public JMenuItem getBtnCargarClientes() {
        return btnCargarClientes;
    }

    public void setBtnCargarClientes(JMenuItem btnCargarClientes) {
        this.btnCargarClientes = btnCargarClientes;
    }

    public JDesktopPane getDesktop() {
        return desktop;
    }

    public void setDesktop(JDesktopPane desktop) {
        this.desktop = desktop;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCargarClientes;
    private javax.swing.JMenuItem btnVerRemitoCliente;
    public javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu menuClientes;
    // End of variables declaration//GEN-END:variables
}
