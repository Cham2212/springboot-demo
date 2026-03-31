package server;

import server.Clock.LamportClock;
import server.Service.BookingService;
import server.Log.Logger;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) throws Exception {

        int serverId = Integer.parseInt(args[0]);
        int port = 5000 + serverId;

        LamportClock clock = new LamportClock();
        BookingService service = new BookingService(serverId);

        try (ServerSocket server = new ServerSocket(port)) {
            Logger.log("SYSTEM", "Server " + serverId + " started at port " + port);

            while (true) {
                Socket socket = server.accept();

                clock.tick();

                new MultiThreadHandler(socket, clock, service).start();
            }
        }
    }
}