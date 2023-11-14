package org.life;

public class Position {

    private int x;
    private int y;
    private Board board;

    public Position(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Board getBoard() {
        return board;
    }
}