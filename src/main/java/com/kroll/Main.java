package com.kroll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema(5, 10, 20);
        int choice;

        do {
            displayMenu();
            System.out.println("Оберіть опцію:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введіть номер залу:");
                    int hallNumber = scanner.nextInt();
                    cinema.printSeatingArrangement(hallNumber);
                    break;
                case 2:
                    bookSeats(scanner, cinema);
                    break;
                case 3:
                    cancelBooking(scanner, cinema);
                    break;
                case 4:
                    checkAvailability(scanner, cinema);
                    break;

            }
        } while (choice != 6);
    }

    private static void displayMenu() {
        System.out.println("1. Вивести схему розміщення місць");
        System.out.println("2. Забронювати місце");
        System.out.println("3. Скасувати бронювання");
        System.out.println("4. Перевірити доступність місць");
        System.out.println("5. Автоматичне бронювання");
        System.out.println("6. Вийти");
    }

    private static void bookSeats(Scanner scanner, Cinema cinema) {
        System.out.println("Введіть номер залу:");
        int hallNumber = scanner.nextInt();
        System.out.println("Введіть номер ряду:");
        int row = scanner.nextInt();
        System.out.println("Введіть номери місць (розділені пробілами):");
        scanner.nextLine();
        String[] seatsArray = scanner.nextLine().split(" ");
        int[] seats = new int[seatsArray.length];
        for (int i = 0; i < seatsArray.length; i++) {
            seats[i] = Integer.parseInt(seatsArray[i]);
        }

        cinema.bookSeats(hallNumber, row, seats);
    }


    private static void cancelBooking(Scanner scanner, Cinema cinema) {
        System.out.println("Введіть номер залу:");
        int hallNumber = scanner.nextInt();
        System.out.println("Введіть номер ряду:");
        int row = scanner.nextInt();
        scanner.nextLine();  // Додайте цей рядок, щоб позбавитися відповіді Enter
        System.out.println("Введіть номери місць (розділені пробілами):");
        String[] seatsArray = scanner.nextLine().split(" ");

        int[] seats = new int[seatsArray.length];
        for (int i = 0; i < seatsArray.length; i++) {
            if (!seatsArray[i].isEmpty()) {
                seats[i] = Integer.parseInt(seatsArray[i]);
            }
        }

        cinema.cancelBooking(hallNumber, row, seats);
    }


    private static void checkAvailability(Scanner scanner, Cinema cinema) {
        System.out.println("Введіть номер залу:");
        int hallNumber = scanner.nextInt();
        System.out.println("Введіть кількість місць:");
        int numSeats = scanner.nextInt();

        boolean isAvailable = cinema.checkAvailability(hallNumber, numSeats);
        if (isAvailable) {
            System.out.println("Доступно");
        } else {
            System.out.println("Не доступно");
        }
    }
}
