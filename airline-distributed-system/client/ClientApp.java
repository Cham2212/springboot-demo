package client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("User: ");
            String user = sc.nextLine();

            System.out.print("Flight: ");
            String flight = sc.nextLine();

            Socket socket = new Socket("localhost", 5001);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(user + "," + flight + ",0");

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}