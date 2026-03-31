package server.Service;

import server.Database.BookingDAO;
import server.Log.Logger;

public class BookingService {
    private BookingDAO dao;

    public BookingService(int serverId) {
        dao = new BookingDAO(serverId);
    }

    public void book(String user, String flight) {
        dao.insert(user, flight);
        Logger.log("BOOKING", user + " booked " + flight);
    }
}