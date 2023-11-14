package org.life;

import java.util.Random;

public class JumpingOrganism extends Organism {

    public JumpingOrganism(int energy) {
        super(energy);
    }

    @Override
    public void move() {
        int newX, newY;
        Random random = new Random();

        int oldX = getPosition().getX();
        int oldY = getPosition().getY();

        do {
            newX = getPosition().getX() + (random.nextBoolean() ? 2 : -2);
            newY = getPosition().getY() + (random.nextBoolean() ? 2 : -2);
        } while (!isValidMove(newX, newY));

        System.out.println("Jumping organism at (" + oldX + ", " + oldY + ") jumped to (" + newX + ", " + newY + ")");

        Organism otherOrganism = getPosition().getBoard().getOrganismAt(newX, newY);
        if (otherOrganism != null && !otherOrganism.equals(this)) {
            consume(otherOrganism);
            return;
        }

        getPosition().getBoard().moveOrganism(this, newX, newY);

    }
}

