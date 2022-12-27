package com.company;

import java.io.*;
import java.net.*;
public class Main{

    public static void main(String args[])
    {
        try
        {
            ServerSocket ss =new ServerSocket();
            Socket soc = new Socket();
            DataInputStream dis =new DataInputStream(soc.getInputStream());
            String str = dis.readUTF();
            System.out.println("Message"+str);
            ss.close();
        }
        catch(Exception e){
            System.out.println(e);

        }
    }
}

