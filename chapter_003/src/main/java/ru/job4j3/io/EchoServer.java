package ru.job4j3.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class EchoServer on socket.
 * @author v.ivanov
 * @version 1
 * @since 21.03.2020
 */
public class EchoServer {

    /**
     * Entry method to run program.
     * @param args args
     * @throws IOException throws exception
     */
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean isClosed = false;
            while (!isClosed) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream(); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    int inc = 0;
                    do {
                        str = in.readLine();
                        System.out.println(str);
                        String[] arrStr = str.split("\\?");
                        if (++inc == 1) {
                            if (str.startsWith("GET") && arrStr.length > 1 && arrStr[1].contains("Bye")) {
                                isClosed = true;
                                server.close();
                            }
                        }
                    } while (!str.isEmpty());
                    if (!isClosed) {
                        out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                    } else {
                        out.write("HTTP/1.1 503 Service Unavailable\r\n\\".getBytes());
                    }
                }
            }
        }
    }
}
