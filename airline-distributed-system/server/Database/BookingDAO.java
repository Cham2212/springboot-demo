package server.Database;

import java.sql.*;

public class BookingDAO {
    private Connection conn;

    public BookingDAO(int serverId) {
        conn = DBConnection.getConnection(serverId);
        init();
    }

    private void init() {
        try {
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS booking(user TEXT, flight TEXT)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String user, String flight) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO booking VALUES(?,?)"
            );
            ps.setString(1, user);
            ps.setString(2, flight);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}