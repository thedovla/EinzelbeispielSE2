package com.example.einzelbeispielse2;

import java.io.*;
import java.net.*;

public class TCP extends Thread {
    String MNr;
    String modifiedSentence;
    public TCP(String MNr){
        this.MNr = MNr;
    }

    public String getModifiedSentence() {
        return modifiedSentence;
    }

    public void run()  {
        try {
            BufferedReader inFormUser = new BufferedReader(new InputStreamReader(System.in));
            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFormServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outputStream.writeBytes(MNr + '\n');
            modifiedSentence = inFormServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
            clientSocket.close();
            } catch (IOException e) {
            throw new RuntimeException(e);}

    }
}
