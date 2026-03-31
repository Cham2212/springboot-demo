package server.Log;

public class Logger {
    public static synchronized void log(String group, String message) {
        System.out.println("[" + group + "] " + message);
    }
}