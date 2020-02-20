package ru.job4j3.io;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Chat.
 *
 * @author v.ivanov
 * @version 1
 * @since 09.02.2020
 */
public class Chat {

    /** Input stream field.*/
    private BufferedReader inStream;

    /** Output stream field.*/
    private PrintWriter outStream;

    /** Field logger.*/
    private ChatLogger logger;

    /** Field word value that stops the output of answers to the user.*/
    private String stopToAnswer;

    /** Field word value that starts the output of answers to the user.*/
    private String continueToAnswer;

    /** Field word value that stops chat.*/
    private String stopChat;

    /** Field words list of possible answers from file.*/
    private List<String> answerList;

    /** Field file separator.*/
    private static final String SEP = System.getProperty("file.separator");

    /** Constructor of class Chat.
     *
     * @param stopToAnswer word to pause answers
     * @param continueToAnswer word to start make answers
     * @param stopChat word to stop program
     */
    public Chat(String stopToAnswer, String continueToAnswer, String stopChat) {
        this.inStream = new BufferedReader(new InputStreamReader(System.in));
        this.outStream = new PrintWriter(System.out, true);
        this.stopToAnswer = stopToAnswer;
        this.continueToAnswer = continueToAnswer;
        this.stopChat = stopChat;
        this.logger = new ChatLogger("chatLog.txt");
        this.answerList = readAnswers("answersList.txt");
    }

    /**
     * Constructor of class Chat for input and output streams replacement.
     *
     * @param inStream value of stream for input
     * @param stopToAnswer word to pause answers
     * @param continueToAnswer word to start make answers
     * @param stopChat word to stop program
     */
    public Chat(BufferedReader inStream, String stopToAnswer, String continueToAnswer, String stopChat) {
        this.inStream = inStream;
        this.outStream = new PrintWriter(System.out);
        this.stopToAnswer = stopToAnswer;
        this.continueToAnswer = continueToAnswer;
        this.stopChat = stopChat;
        this.logger = new ChatLogger("chatLog.txt");
        this.answerList = readAnswers("answersList.txt");
    }

    /**
     * Getter for logger field.
     *
     * @return Logger class instance
     */
    public ChatLogger getLogger() {
        return this.logger;
    }

    /**
     * Method that starts chat with user.
     *
     * @throws IOException throws on logging
     */
    public void startChat() throws IOException {
        boolean isStop = false;
        boolean isAnswer = true;
        while (!isStop) {
            String val = inputValue();
            if (val.equals(this.stopToAnswer)) {
                isAnswer = false;
            }
            if (val.equals(this.stopChat)) {
                isStop = true;
                this.inStream.close();
                this.outStream.close();
            }
            if (val.equals(this.continueToAnswer)) {
                isAnswer = true;
            }
            if (isAnswer && !isStop) {
                printAnswer();
            }
        }
    }

    /**
     * Method to input data to the console.
     *
     * @throws IOException throws on logging
     * @return value that was input
     */
    private String inputValue() throws IOException {
        String result = this.inStream.readLine();
        this.logger.log(result);
        return result;
    }

    /**
     * Method to print random answer from defined answers list.
     */
    private void printAnswer() {
        String answer = this.answerList.get((int) (Math.random() * (this.answerList.size())));
        this.outStream.println(answer);
        this.logger.log(answer);
    }

    /**
     * Method to return random answer.
     *
     * @param fileName file with list of answers
     * @return result list of answers
     */
    private List<String> readAnswers(String fileName) {
        List<String> result = new ArrayList<>();
        File answersFile = new File(
                System.getProperty("user.dir").replace("chapter_003", "") + SEP + "resources" + SEP + fileName
        );
        try (BufferedReader reader = new BufferedReader(new FileReader(answersFile))) {
            result = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

/*
    public static void main(String[] args) throws IOException {
        Chat obj = new Chat("стоп", "продолжить", "закончить");
        obj.startChat();
    }
*/
}
