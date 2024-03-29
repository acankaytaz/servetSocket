/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author ahmet
 */
public class ServerSocket {

    public ServerSocket(int par) {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
          String clientGelen;
          ServerSocket serverSocket = null;
          Socket clientSocket = null;
 
          int sayi;
 
          try {
               //*Server 7755 portundan Client'ı dinliyor *//
               serverSocket = new ServerSocket(7755);
          } catch (Exception e) {
               System.out.println("Port Hatası!");
          }
          System.out.println("SERVER BAŞLANTI İÇİN HAZIR...");
           //* Bağlantı sağlamadan program bir alt satırdaki kod parçasına geçmez (accept) *//
          clientSocket = serverSocket.accept();
 
          //* Client'a veri gönderimi için kullandığımız PrintWriter nesnesi oluşturulur *//
          PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
 
          //* Client'dan gelen verileri tutan BufferedReader nesnesi oluşturulur *//
          BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
 
          while((clientGelen = in.readLine()) != null) {
               System.out.println("Client'dan gelen veri = " + clientGelen);
               sayi = Integer.valueOf(clientGelen);
               out.println(sayi*sayi);
          }
          out.close();
          in.close();
          clientSocket.close();
          serverSocket.close();
     }
    
}
