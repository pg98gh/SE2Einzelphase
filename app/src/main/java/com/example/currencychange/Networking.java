package com.example.currencychange;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Networking extends Thread {
    private String enter, result;
    private Socket socket;
    private DataOutputStream dos;
    private BufferedReader br;

    public Networking(String enter) {
        this.enter = enter;
    }

    public void run(){
        try{
           socket = new Socket("se2-isys.aau.at", 53212);
            dos = new DataOutputStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dos.writeBytes(enter + '\n');
            result = br.readLine();
            socket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getResult(){
        return this.result;
    }

}

