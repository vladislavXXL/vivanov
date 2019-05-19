package ru.job4j3.threads.bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class Board.
 *
 * @author v.ivanov
 * @version 1
 * @since 12.05.2019
 */
public class Board {

    /** Field board.*/
    private final ReentrantLock[][] board;

    /** Field participants on the board.*/
    private final List<Participant> participants;

    /** Field board dimensions.*/
    private final int size;

    /** Field to stop thread.*/
    private volatile boolean isStop = false;

    /**
     * Class Board singleton constructor.
     *
     * @param size board dimension value
     */
    public Board(int size) {
        this.size = size;
        this.board = new ReentrantLock[size][size];
        this.participants = new ArrayList<>();
    }

    /**
     * Getter of field board.
     */
    public void setBoard() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.board[i][j] = new ReentrantLock();
            }
        }
    }

    /**
     * Method to add a new participant to the board.
     *
     * @param list of participants
     */
    public void addParticipant(List<Participant> list) {
        this.participants.addAll(list);
    }

    /**
     * Method to move hero.
     *
     * @param source start position
     * @param dest destination position
     * @return result of operation
     * @throws InterruptedException exception
     */
    private boolean move(Cell source, Cell dest) throws InterruptedException {
        ReentrantLock sourceLock = this.board[source.getX()][source.getY()];
        sourceLock.lock();
        boolean isDest = this.board[dest.getX()][dest.getY()].tryLock(500, TimeUnit.MILLISECONDS);
        if (isDest) {
            this.board[dest.getX()][dest.getY()].lock();
            Participant curParticipant = find(source);
            curParticipant.setPosition(dest);
            sourceLock.unlock();
            Thread.sleep(1000);
        }
        return isDest;
    }

    /**
     * Method to start thread of a participant.
     *
     * @param par Participant instance
     */
    public void startParticipant(Participant par) {
        new Thread(() -> {
            while (!isStop) {
                Cell newCell = generateDest(par.getPosition());
                try {
                    System.out.println("New position value: " + newCell);
                    this.move(par.getPosition(), newCell);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    /**
     * Method to stop Participant thread.
     */
    public void stopParticipant() {
        this.isStop = true;
    }

    /**
     * Method to get participant by position.
     *
     * @param position current position of participant
     * @return Participant result instance
     */
    private Participant find(Cell position) {
        Participant obj = this.participants.stream()
                .filter(p -> p.getPosition().equals(position))
                .findFirst()
                .get();
        return obj;
    }

    /**
     * Method to random generate Cell coordinates values.
     *
     * @param start current position
     * @return new cell result
     */
    private Cell generateDest(Cell start) {
        Cell result;
        while (true) {
            int x = new Random().nextInt(this.size);
            int y = new Random().nextInt(this.size);
            if (x >= 0 && y >= 0 && x < this.size && y < this.size) {
                result = new Cell(x, y);
                break;
            }
        }
        return result;
    }

    /**
     * Getter of field participants.
     *
     * @return participants list field
     */
    public List<Participant> getParticipants() {
        return this.participants;
    }
}
