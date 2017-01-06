package algorithm;

import static algorithm.Spiral.Direction.*;

public class Spiral {

    enum Direction {
        EAST, NORTH, WEST, SOUTH
    }

    private static class Coord {
        int x, y;

        @Override
        public String toString() {
            return String.format("[%d,%d]", x, y);
        }
    }

    public static void print(int[][] array) {
        Coord c = new Coord();

        // Begin on pass -1, because we decrement *moves* every 2 passes,
        // but _only_ after the 3rd pass
        //
        int pass  = -1;
        int moves = array.length-1;

        print(c, moves, EAST, pass);
    }

    private static void print(Coord c, int moves, Direction direction, int pass) {

        if (moves < 1) {
            System.out.println(c);
            return;
        }

        int steps = 0;

        do {
            System.out.println(c);
            shiftCoord(c, direction);
            steps++;
        } while (steps < moves);

        // We decrement the number of moves in a 'pass' to crease a spiral
        //
        pass++;
        if (pass > 1) {
            moves--;
            pass = 0;
        }

        // Change direction at end of each pass
        //
        direction = Direction.values()[(direction.ordinal() + 1) % 4];

        print(c, moves, direction, pass);
    }

    private static void shiftCoord(Coord c, Direction direction) {

        switch (direction) {
            case EAST:
                c.x++;
                break;
            case NORTH:
                c.y++;
                break;
            case WEST:
                c.x--;
                break;
            case SOUTH:
                c.y--;
                break;
        }

    }

    public static void main(String[] args) {
        Spiral.print(new int[5][5]);
    }
}
