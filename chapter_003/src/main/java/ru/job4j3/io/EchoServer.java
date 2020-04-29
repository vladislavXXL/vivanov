package ru.job4j3.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

/**
 * Class EchoServer on socket.
 *
 * @author v.ivanov
 * @version 1
 * @since 21.03.2020
 */
public class EchoServer {

    /** Logger instance.*/
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    /**
     * Enum MSG with request part and corresponding answer.
     */
    private enum MSG {
        /** Hello.*/
        HELLO("msg=Hello", "Hello"),

        /** Exit.*/
        EXIT("msg=Exit", "Server finished working");

        /** Message name.*/
        private String part;

        /** Message answer.*/
        private String answer;

        /**
         * Enum MSG constructor.
         * @param part part of request value
         * @param answer value to answer
         */
        MSG(String part, String answer) {
            this.part = part;
            this.answer = answer;
        }
    }

    /**
     * Entry method to run program.
     *
     * @param args args
     * @throws IOException throws exception
     */
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean isClosed = false;
            Message msg = new Message();
            while (!isClosed) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream(); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    int inc = 0;
                    do {
                        str = in.readLine();
                        System.out.println(str);
                        if (str != null) {
                            String[] arrStr = str.split("\\?");
                            if (++inc == 1 && arrStr.length > 1) {
                                String msgPart = arrStr[1].substring(0, arrStr[1].length() - 8).trim();
                                if (str.startsWith("GET") && msgPart.equals(MSG.EXIT.part)) {
                                    isClosed = true;
                                    msg.accept(msgPart);
                                    server.close();
                                } else {
                                    msg.accept(msgPart);
                                }
                            }
                        }
                    } while (!str.isEmpty());
                    if (!isClosed) {
                        out.write("HTTP/1.1 200 OK\r\n".getBytes());
                        out.write((msg.answer + "\r\n").getBytes());
                    } else {
                        out.write("HTTP/1.1 503 Service Unavailable\r\n".getBytes());
                        out.write((msg.answer + "\r\n").getBytes());
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("IOException error", e);
        }
    }

    /**
     * Class Message.
     */
    private static class Message implements Consumer<String> {

        /** Result answer.*/
        private String answer;

        @Override
        public void accept(String s) {
            if (s.equals(MSG.EXIT.part)) {
                this.answer = MSG.EXIT.answer;
            } else if (s.equals(MSG.HELLO.part)) {
                this.answer = MSG.HELLO.answer;
            } else {
                this.answer = s.replaceAll("msg=", "");
            }
        }
    }
}
