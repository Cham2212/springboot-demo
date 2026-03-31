package server;

import server.Clock.LamportClock;
import server.Service.BookingService;
import server.Log.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class MultiThreadHandler extends Thread {
    private Socket socket;
    private LamportClock clock;
    private BookingService service;

    public MultiThreadHandler(Socket socket, LamportClock clock, BookingService service) {
        this.socket = socket;
        this.clock = clock;
        this.service = service;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            String msg = in.readLine();
            Logger.log("NETWORK", "Received: " + msg);

            String[] parts = msg.split(",");

            String user = parts[0];
            String flight = parts[1];
            int receivedClock = Integer.parseInt(parts[2]);

            clock.update(receivedClock);
            service.book(user, flight);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}