package com.company;
import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String[] args) { try
    {
        Socket soc=new Socket("localhost",6666);
        DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
        dout.writeUTF("Hello GFG Readers!");
        dout.flush();
        dout.close();
        soc.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    }


}