package server.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection(int serverId) {
        try {
            Class.forName("org.sqlite.JDBC");

            return DriverManager.getConnection(
                "jdbc:sqlite:server" + serverId + ".db"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}