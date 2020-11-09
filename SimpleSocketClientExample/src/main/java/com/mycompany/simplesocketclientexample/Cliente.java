
package com.mycompany.simplesocketclientexample;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
/**
 *
 * @author johne
 */
public class Cliente 
{
    public static void main( String[] args )
    {
        Servidor server = new Servidor();
        server.Recibir();
        try
        {
            // Create input and output streams to read from and write to the server
            try ( // Connect to the server
                    Socket socket = new Socket( "192.168.1.116", 9999 )) 
            {
                DataOutputStream flujoSalida= new DataOutputStream(socket.getOutputStream());
                flujoSalida.writeUTF("Hola Socket");
                System.out.println("Sin Problemas Al Tender El Puente");
                flujoSalida.close();
            }
        }
        catch( Exception e )
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}





















