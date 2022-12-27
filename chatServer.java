package com.company;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class chatServer {

    public static void main(String[] args) {
        DataInputStream din = null;
        ServerSocket serverSocket = null;
        DataOutputStream dout = null;
        BufferedReader br = null;
        try {
            /*
             * Creates a server socket, bound to the specified port.
             */
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server is Waiting for client request... ");

        /*
         * Listens for a connection to be made to this socket and
         * accepts it. The method blocks until a connection is
         * made.
         */
        Socket socket = null;
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            din = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dout = new DataOutputStream(outputStream);

        br = new BufferedReader(new InputStreamReader(System.in));

        String strFromClient = "", strToClient = "";
        while (!strFromClient.equals("stop")) {
            try {
                strFromClient = din.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("client says: " + strFromClient);
            try {
                strToClient = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                dout.writeUTF(strToClient);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                dout.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        {
            try {
                if (br != null) {
                    br.close();
                }

                if (din != null) {
                    din.close();
                }
                if (dout != null) {
                    dout.close();
                }
                if (serverSocket != null) {
                    /*
                     * closes the server socket.
                     */
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
