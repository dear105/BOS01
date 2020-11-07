package com.bosssoft.hr.train.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class SocketServer {
    public static void main(String[] args) {
        System.out.println("接收");
        try {
            DatagramSocket server = new DatagramSocket(3030);
            byte[] container = new byte[1024*70];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length, new InetSocketAddress("localhost", 9999));
            try {
                server.receive(packet);

            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] datas = packet.getData();
            System.out.println(new String(datas,0,datas.length));
            server.close();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
