package com.company;
//Server.java
import java.lang.*;
import java.io.*;
import java.net.*;
public class Server1 {
    public static void main(String args[]) {
        String data = "Networks Lab";
        try {
            ServerSocket srvr = new ServerSocket(1234);
            Socket skt = srvr.accept();
            System.out.print("Server has connected!\n");
            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            System.out.print("Sending string: '" + data + "'\n");
            out.print(data);
            out.close();
            skt.close();
            srvr.close();
        }
        catch(Exception e) {
            System.out.print("Whoops! It didn't work!\n");
        }
    }
}

