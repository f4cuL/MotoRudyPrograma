/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.Principal;
import Vista.agregarRemito;
import Vista.cargarClientes;
import Vista.modificarCliente;
import Vista.nuevoCliente;
import Vista.remitosVer;

/**
 *
 * @author facue
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador();
        
        Principal principal = new Principal();
        cargarClientes cg = new cargarClientes();
        nuevoCliente nc = new nuevoCliente();
        modificarCliente mc = new modificarCliente();
        remitosVer rv = new remitosVer();
        agregarRemito ar = new agregarRemito();
        
        
        
        modelo.setControlador(controlador);
        principal.setControlador(controlador);
        cg.setControlador(controlador);
        nc.setControlador(controlador);
        mc.setControlador(controlador);
        rv.setControlador(controlador);
        ar.setControlador(controlador);
        
        
        
        controlador.setCargar(cg);
        controlador.setModelo(modelo);
        controlador.setPri(principal);
        controlador.setNuevoCliente(nc);
        controlador.setModificarCliente(mc);
        controlador.setRemitosVer(rv);
        controlador.setAgregarRemito(ar);
        principal.setVisible(true);
        
    }
    
}
