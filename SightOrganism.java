package org.life;

import java.util.Random;

public class SightOrganism extends Organism {

    private int sightRadius;

    public SightOrganism(int energy, int sightRadius) {
        super(energy);
        this.sightRadius = sightRadius;
    }

    @Override
    public void move() {
        int currentX = getPosition().getX();
        int currentY = getPosition().getY();

        // Check if JumpingOrganism is at the same position
        Organism jumpingOrganism = getPosition().getBoard().getOrganismAt(currentX, currentY);
        if (jumpingOrganism instanceof JumpingOrganism) {

            // JumpingOrganism consumes SightOrganism
            ((JumpingOrganism) jumpingOrganism).consume(this);

        }

        // Detect other organisms within the sight radius
        for (int i = currentX - sightRadius; i <= currentX + sightRadius; i++) {
            for (int j = currentY - sightRadius; j <= currentY + sightRadius; j++) {
                if (i >= 0 && i < getPosition().getBoard().getWidth() && j >= 0 && j < getPosition().getBoard().getHeight() &&
                        getPosition().getBoard().getOrganismAt(i, j) instanceof Organism && !getPosition().getBoard().getOrganismAt(i, j).equals(this)) {
                    System.out.println("Sight organism at (" + currentX + ", " + currentY + ") detected organism at (" + i + ", " + j + ")");


                }
            }
        }


        // Move randomly within the sight radius
        Random random = new Random();
        int newX, newY;

        do {
            newX = currentX + random.nextInt(2 * sightRadius + 1) - sightRadius;
            newY = currentY + random.nextInt(2 * sightRadius + 1) - sightRadius;
        } while (newX == currentX && newY == currentY || !isValidMove(newX, newY));


        // Check if the move is legal and update the board
        getPosition().getBoard().moveOrganism(this, newX, newY);
        System.out.println("Sight organism at (" + currentX + ", " + currentY + ") moved to (" + newX + ", " + newY + ")");
    }

}