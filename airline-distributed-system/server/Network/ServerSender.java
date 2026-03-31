package server.Network;

import java.io.PrintWriter;
import java.net.Socket;

public class ServerSender {
    public static void send(String host, int port, String msg) {
        try {
            Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(msg);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}