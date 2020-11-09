/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplesocketclientexample;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johne
 */
public class Servidor implements Runnable  
{

    void Recibir() 
    {
       Thread hilo = new Thread(this);
       hilo.start();
    }

    @Override
    public void run() 
    {
        try {
            // System.out.println("Estoy A La Escucha");
            ServerSocket server = new ServerSocket(9999);
            Socket misocket = server.accept();//Acepte conexiones
            DataInputStream flujoentrada = new DataInputStream(misocket.getInputStream());
            
            String mensaje= flujoentrada.readUTF();
            System.out.println("Ingreso Del Mesaje");
            System.out.println(mensaje);
            misocket.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}












