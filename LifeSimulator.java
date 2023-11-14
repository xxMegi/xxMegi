package org.life;

public class LifeSimulator {

    public static void main(String[] args) {
        Board board = new Board(10, 10);

        JumpingOrganism jumpingOrganism = new JumpingOrganism(80);
        SightOrganism sightOrganism = new SightOrganism(90, 3);

        board.addOrganism(jumpingOrganism, 2, 2);
        board.addOrganism(sightOrganism, 8, 8);

        int cycles = 0;
        while (cycles < 1000 && board.getOrganismCount() > 1) {
            System.out.println("Cycle: " + cycles);
            jumpingOrganism.move();
            sightOrganism.move();

            if (board.getOrganismCount() == 1) {
                System.out.println("WINNER FOUND!");
                break;
            }

            cycles++;
        }

        System.out.println("THE END! SIMULATION ENDED AFTER " + cycles + " CYCLES!");

    }
}