package org.life;

import java.util.Random;

public class Organism {

    private int energy;
    private Position position;
    private Random random = new Random();

    public Organism(int energy) {
        this.energy = energy;
    }

    public void move() {
        int newX, newY;


        do {
            newX = position.getX() + random.nextInt(3) - 1;
            newY = position.getY() + random.nextInt(3) - 1;
        } while (!isValidMove(newX, newY));


        Organism otherOrganism = position.getBoard().getOrganismAt(newX, newY);
        if (otherOrganism != null && !otherOrganism.equals(this)) {
            consume(otherOrganism);
            return; // Zakończ ruch po zjedzeniu innego organizmu
        }
        position.getBoard().moveOrganism(this, newX, newY);
        System.out.println("Organism at (" + position.getX() + ", " + position.getY() + ") moved to (" + newX + ", " + newY + ")");

    }

    public void consume(Organism otherOrganism) {
        int consumedEnergy = otherOrganism.getEnergy();
        setEnergy(getEnergy() + consumedEnergy);
        otherOrganism.setEnergy(0);
        otherOrganism.getPosition().getBoard().removeOrganism(otherOrganism);
        System.out.println("Organism at (" + getPosition().getX() + ", " + getPosition().getY() +
                ") consumed organism at (" + otherOrganism.getPosition().getX() + ", " + otherOrganism.getPosition().getY() + ")!!!");
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    protected boolean isValidMove(int x, int y) {
        return x >= 0 && x < position.getBoard().getWidth() && y >= 0 && y < position.getBoard().getHeight();
    }
}