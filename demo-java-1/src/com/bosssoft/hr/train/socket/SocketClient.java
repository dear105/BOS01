package com.bosssoft.hr.train.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class SocketClient {
    public static void main(String[] args) {
        System.out.println("发送");
        DatagramSocket client;
        try {
            client = new DatagramSocket(8888);
            String data = "传递信息";
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost",3030));
            try {
                client.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            client.close();
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
}
