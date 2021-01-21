/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author facue
 */
import Modelo.Cliente;
import Modelo.Modelo;
import Vista.Principal;
import Vista.agregarRemito;
import Vista.cargarClientes;
import Vista.modificarCliente;
import Vista.nuevoCliente;
import Vista.remitosVer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author facue
 */
public class Controlador{
    
    private Principal pri;
    private cargarClientes cargar;
    private Modelo modelo;
    private nuevoCliente nuevoCliente;
    private modificarCliente modificarCliente;
    private remitosVer remitosVer;
    private agregarRemito agregarRemito;

    public agregarRemito getAgregarRemito() {
        return agregarRemito;
    }

    public void setAgregarRemito(agregarRemito agregarRemito) {
        this.agregarRemito = agregarRemito;
    }
    
    public modificarCliente getModificarCliente() {
        return modificarCliente;
    }

    public remitosVer getRemitosVer() {
        return remitosVer;
    }

    public void setRemitosVer(remitosVer remitosVer) {
        this.remitosVer = remitosVer;
    }

    public void setModificarCliente(modificarCliente modificarCliente) {
        this.modificarCliente = modificarCliente;
    }

    public nuevoCliente getNuevoCliente() {
        return nuevoCliente;
    }

    public void setNuevoCliente(nuevoCliente nuevoCliente) {
        this.nuevoCliente = nuevoCliente;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    public Controlador()
    {   
        
    }

    public Principal getPri() {
        return pri;
    }

    public void setPri(Principal pri) {
        this.pri = pri;
    }


    public cargarClientes getCargar() {
        return cargar;
    }

    public void setCargar(cargarClientes cargar) {
        this.cargar = cargar;
    }
    
}
