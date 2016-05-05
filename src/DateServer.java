/**
 * Created by Joel on 02/05/2016.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class DateServer {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        int port = 9090;
        ServerSocket listener = new ServerSocket(port);
        System.out.print("Server started on " + port);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
//                    out.println(new Date().toString());
                    out.println("Hello from the server");
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}