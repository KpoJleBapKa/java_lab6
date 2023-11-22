package com.kroll;


public class Cinema {
    private int[][][] seats;

    public Cinema(int halls, int rows, int seatsPerRow) {
        seats = new int[halls][rows][seatsPerRow];
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                for (int k = 0; k < seats[i][j].length; k++) {
                    seats[i][j][k] = 0;
                }
            }
        }
    }

    public void bookSeats(int hallNumber, int row, int[] seatNumbers) {
        for (int seat : seatNumbers) {
            seats[hallNumber - 1][row - 1][seat - 1] = 1;
        }
        System.out.println("Місця успішно заброньовані!");
    }

    public void cancelBooking(int hallNumber, int row, int[] seatNumbers) {
        for (int seat : seatNumbers) {
            seats[hallNumber - 1][row - 1][seat - 1] = 0;
        }
        System.out.println("Бронювання скасовано!");
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int i = 0; i < seats[hallNumber - 1].length; i++) {
            int consecutiveEmptySeats = 0;
            for (int j = 0; j < seats[hallNumber - 1][i].length; j++) {
                if (seats[hallNumber - 1][i][j] == 0) {
                    consecutiveEmptySeats++;
                    if (consecutiveEmptySeats == numSeats) {
                        return true;
                    }
                } else {
                    consecutiveEmptySeats = 0;
                }
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.print("\t|");
        for (int i = 1; i <= seats[0][0].length; i++) {
            System.out.print("\t" + i);
        }
        System.out.println("\n");

        for (int i = 0; i < seats[hallNumber - 1].length; i++) {
            System.out.print((i + 1) + "\t|");
            for (int j = 0; j < seats[hallNumber - 1][i].length; j++) {
                System.out.print("\t" + seats[hallNumber - 1][i][j]);
            }
            System.out.println();
        }
    }

    public int[][][] getSeats() {
        return seats;
    }
}
