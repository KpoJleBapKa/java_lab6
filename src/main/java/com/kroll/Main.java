package com.kroll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(1, 10, 20);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nОберіть опцію:");
            System.out.println("1. Вивести схему розміщення місць");
            System.out.println("2. Забронювати місце");
            System.out.println("3. Скасувати бронювання");
            System.out.println("4. Перевірити доступність місць");
            System.out.println("5. Автоматичне бронювання");
            System.out.println("6. Вийти");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    cinema.displaySeatingArrangement(1);
                    break;
                case 2:
                    bookSeats(cinema, scanner);
                    break;
                case 3:
                    cancelBooking(cinema, scanner);
                    break;
                case 4:
                    checkAvailability(cinema, scanner);
                    break;
                case 5:
                    autoBook(cinema, scanner);
                    break;
                case 6:
                    System.out.println("Дякуємо за користування!");
                    System.exit(0);
                default:
                    System.out.println("Невірна опція. Спробуйте ще раз.");
            }
        }
    }

    private static void bookSeats(Cinema cinema, Scanner scanner) {
        System.out.print("Введіть номер ряду: ");
        int row = scanner.nextInt();
        System.out.print("Введіть номери місць (розділені пробілами): ");
        String seatsInput = scanner.nextLine(); // Виправлення для зчитування рядка після введення кількості місць
        String[] seatStrings = seatsInput.split(" ");
        int[] seats = new int[seatStrings.length];
        for (int i = 0; i < seatStrings.length; i++) {
            seats[i] = Integer.parseInt(seatStrings[i]);
        }

        cinema.bookSeats(1, row, seats);
    }

    private static void cancelBooking(Cinema cinema, Scanner scanner) {
        System.out.print("Введіть номер ряду: ");
        int row = scanner.nextInt();
        System.out.print("Введіть номери місць (розділені пробілами): ");
        String seatsInput = scanner.nextLine(); // Виправлення для зчитування рядка після введення кількості місць
        String[] seatStrings = seatsInput.split(" ");
        int[] seats = new int[seatStrings.length];
        for (int i = 0; i < seatStrings.length; i++) {
            seats[i] = Integer.parseInt(seatStrings[i]);
        }

        cinema.cancelBooking(1, row, seats);
    }

    private static void checkAvailability(Cinema cinema, Scanner scanner) {
        System.out.print("Введіть кількість місць: ");
        int numSeats = scanner.nextInt();

        cinema.checkAvailability(1, numSeats);
    }

    private static void autoBook(Cinema cinema, Scanner scanner) {
        System.out.print("Введіть кількість місць: ");
        int numSeats = scanner.nextInt();

        cinema.autoBook(1, numSeats);
    }
}
