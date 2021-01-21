/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador;
import Vista.cargarClientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author facue
 */
public class Modelo {
    private Controlador controlador;
    private Cliente clienteAux;
    Conexion conexion;

    public Cliente getClienteAux() {
        return clienteAux;
    }

    public void setClienteAux(Cliente clienteAux) {
        this.clienteAux = clienteAux;
    }

    public Modelo() {
     conexion = new Conexion();
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    

    public void listarClientes(JTable tabla)
    {
        String sql= "select * from persona";
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            Object[]persona= new Object[4];
            DefaultTableModel modelo=(DefaultTableModel)tabla.getModel();
            rs=ps.executeQuery(sql);
            while (rs.next()){
                persona[0]=rs.getString("id");
                persona[1]=rs.getString("nombre");
                persona[2]=rs.getString("apellido");
                persona[3]=rs.getInt("dni");
                modelo.addRow(persona);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
      public void listarRemitos(JTable tabla, Cliente cli)
    {
        String sql= "select * from remito where idcliente="+cli.getId();
        try {
            limpiarTabla(tabla);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            Object[]remito= new Object[5];
            DefaultTableModel modelo=(DefaultTableModel)tabla.getModel();
            rs=ps.executeQuery(sql);
            while (rs.next()){
                remito[0]=rs.getInt("id");
                remito[1]=rs.getInt("idCliente");
                remito[2]=rs.getString("fecha");
                remito[3]=rs.getInt("importe");
                remito[4]=rs.getInt("pagado");
                modelo.addRow(remito);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean agregarCliente() {
        String nombre = controlador.getNuevoCliente().getTxtNombreAdd().getText();
        String apellido = controlador.getNuevoCliente().getTxtApellidoAdd().getText();
        int dni = Integer.parseInt(controlador.getNuevoCliente().getTxtDniAdd().getText());
        String sql = "INSERT INTO persona(nombre,apellido,dni) values('"+nombre+"','"+apellido+"',"+dni+")";
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.execute(sql);
            limpiarTabla(controlador.getCargar().getTablaClientes());
            listarClientes(controlador.getCargar().getTablaClientes());
            controlador.getNuevoCliente().getTxtNombreAdd().setText(null);
            controlador.getNuevoCliente().getTxtApellidoAdd().setText(null);
            controlador.getNuevoCliente().getTxtDniAdd().setText(null);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(sql);
            return false;
        }
}
    public boolean eliminarCliente(Cliente cli)
    {
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        String sql = "delete from persona where id="+cli.getId();
        try {
         ps=con.prepareStatement(sql);
         ps.execute();
         limpiarTabla(controlador.getCargar().getTablaClientes());
         listarClientes(controlador.getCargar().getTablaClientes());
         return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
        public boolean actualizarCliente(Cliente cli)
    {
        PreparedStatement ps = null;
        Connection con = conexion.getConexion();
        
        String sql = "UPDATE persona SET nombre=?, apellido=?, dni=? where id="+cli.getId();
        try {
         ps=con.prepareStatement(sql);
         ps.setString(1, controlador.getModificarCliente().getTxtModificarNombre().getText());
         ps.setString(2, controlador.getModificarCliente().getTxtModificarApellido().getText());
         ps.setInt(3, Integer.parseInt(controlador.getModificarCliente().getTxtModificarDni().getText()));
         ps.execute();
         limpiarTabla(controlador.getCargar().getTablaClientes());
         listarClientes(controlador.getCargar().getTablaClientes());
         controlador.getModificarCliente().getTxtModificarNombre().setText(null);
         controlador.getModificarCliente().getTxtModificarApellido().setText(null);
         controlador.getModificarCliente().getTxtModificarDni().setText(null);
         return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
        public void limpiarTabla(JTable tabla){
         for (int i=0;i<tabla.getRowCount();i++)
            {
                DefaultTableModel tabla2 = (DefaultTableModel)tabla.getModel();
                tabla2.removeRow(i);
                i=i-1;
             }
      }
}