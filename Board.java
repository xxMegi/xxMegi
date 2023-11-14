package org.life;

public class Board {

    private int width;
    private int height;
    private Organism[][] organisms;
    private int iteration;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.organisms = new Organism[width][height];
        this.iteration = 0;
    }

    public void addOrganism(Organism organism, int x, int y) {
        if (organisms[x][y] == null) {
            organisms[x][y] = organism;
            organism.setPosition(new Position(x, y, this));
        } else {
            System.out.println("Position already occupied!");
        }
    }

    public void moveOrganism(Organism organism, int newX, int newY) {
        if (newX >= 0 && newX < width && newY >= 0 && newY < height && organisms[newX][newY] == null) {
            organisms[organism.getPosition().getX()][organism.getPosition().getY()] = null;
            organisms[newX][newY] = organism;
            organism.setPosition(new Position(newX, newY, this));
        } else {
            System.out.println("Invalid move!");
        }
    }

    public int getOrganismCount() {
        int count = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (organisms[i][j] != null) {
                    count++;
                }
            }
        }
        return count;
    }

    public void removeOrganism(Organism organism) {
        organisms[organism.getPosition().getX()][organism.getPosition().getY()] = null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getIteration() {
        return iteration;
    }

    public void incrementIteration() {
        iteration++;
        System.out.println("Iteration: " + iteration);
    }

    public Organism getOrganismAt(int x, int y) {
        return organisms[x][y];
    }
}
