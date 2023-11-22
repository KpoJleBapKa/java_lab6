package com.kroll;

import java.util.Arrays;

public class Cinema {
    private int[][][] seatingArrangement;

    public Cinema(int halls, int rows, int seats) {
        seatingArrangement = new int[halls][rows][seats];
    }

    public void displaySeatingArrangement(int hallNumber) {
        System.out.println("Місця у залі " + hallNumber + ":\n");

        System.out.print("\t|");
        for (int i = 1; i <= seatingArrangement[hallNumber - 1][0].length; i++) {
            System.out.print("\t" + i + "\t|");
        }
        System.out.println("\n");

        for (int row = 0; row < seatingArrangement[hallNumber - 1].length; row++) {
            System.out.print(row + 1 + "\t|");
            for (int seat = 0; seat < seatingArrangement[hallNumber - 1][row].length; seat++) {
                char statusChar = (seatingArrangement[hallNumber - 1][row][seat] == 0) ? '0' : 'X';
                System.out.print("\t" + statusChar + "\t|");
            }
            System.out.println("\n\t|");
        }
        System.out.print("\t|");
        for (int i = 1; i <= seatingArrangement[hallNumber - 1][0].length; i++) {
            System.out.print("\t" + i + "\t|");
        }
        System.out.println("\n");
    }


    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seatingArrangement[hallNumber - 1][row - 1][seat - 1] == 0) {
                seatingArrangement[hallNumber - 1][row - 1][seat - 1] = 1;
                System.out.println("Місце " + seat + " в ряду " + row + " залу " + hallNumber + " заброньоване.");
            } else {
                System.out.println("Місце " + seat + " в ряду " + row + " залу " + hallNumber + " вже заброньоване.");
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seatingArrangement[hallNumber - 1][row - 1][seat - 1] == 1) {
                seatingArrangement[hallNumber - 1][row - 1][seat - 1] = 0;
                System.out.println("Бронь для місця " + seat + " в ряду " + row + " залу " + hallNumber + " скасована.");
            } else {
                System.out.println("Місце " + seat + " в ряду " + row + " залу " + hallNumber + " не було заброньоване.");
            }
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < seatingArrangement[hallNumber - 1].length; row++) {
            int consecutiveAvailable = 0;
            for (int seat = 0; seat < seatingArrangement[hallNumber - 1][row].length; seat++) {
                if (seatingArrangement[hallNumber - 1][row][seat] == 0) {
                    consecutiveAvailable++;
                    if (consecutiveAvailable == numSeats) {
                        System.out.println("Доступно " + numSeats + " послідовних місць у ряду " + (row + 1) + " залу " + hallNumber + ".");
                        return true;
                    }
                } else {
                    consecutiveAvailable = 0;
                }
            }
        }
        System.out.println("Недостатньо послідовних вільних місць у залі " + hallNumber + ".");
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Схема розміщення місць у залі " + hallNumber + ":");
        for (int row = 0; row < seatingArrangement[hallNumber - 1].length; row++) {
            System.out.println("Ряд " + (row + 1) + ": " + Arrays.toString(seatingArrangement[hallNumber - 1][row]));
        }
    }

    public int[] findBestAvailable(int hallNumber, int numSeats) {
        for (int row = 0; row < seatingArrangement[hallNumber - 1].length; row++) {
            int consecutiveAvailable = 0;
            for (int seat = 0; seat < seatingArrangement[hallNumber - 1][row].length; seat++) {
                if (seatingArrangement[hallNumber - 1][row][seat] == 0) {
                    consecutiveAvailable++;
                    if (consecutiveAvailable == numSeats) {
                        int[] result = new int[numSeats];
                        for (int i = 0; i < numSeats; i++) {
                            result[i] = seat - i + 1;
                        }
                        return result;
                    }
                } else {
                    consecutiveAvailable = 0;
                }
            }
        }
        return null;
    }

    public void autoBook(int hallNumber, int numSeats) {
        int[] bestAvailable = findBestAvailable(hallNumber, numSeats);
        if (bestAvailable != null) {
            bookSeats(hallNumber, 1, bestAvailable);
            System.out.println("Автоматично заброньовано " + numSeats + " місць у залі " + hallNumber + ".");
        } else {
            System.out.println("Неможливо забронювати " + numSeats + " місць у залі " + hallNumber + ".");
        }
    }
}
