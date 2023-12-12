package com.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HousieTicketGenerator {

    public static void main(String[] args) {
        int[][] ticket = generateHousieTicket();
        displayHousieTicket(ticket);
    }

    private static int[][] generateHousieTicket() {
        int[][] ticket = new int[3][9];

        for (int i = 0; i < 3; i++) {
            List<Integer> columnIndices = generateRandomColumns();
            Collections.shuffle(columnIndices);

            for (int j = 0; j < 5; j++) {
                int columnIndex = columnIndices.get(j);
                int startValue = columnIndex * 10 + 1;
                ticket[i][columnIndex] = generateRandomNumberInRange(startValue, startValue + 9);
            }
        }

        return ticket;
    }

    private static List<Integer> generateRandomColumns() {
        List<Integer> columns = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            columns.add(i);
        }
        Collections.shuffle(columns);
        return columns.subList(0, 5);
    }

    private static int generateRandomNumberInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    private static void displayHousieTicket(int[][] ticket) {
        System.out.println("Housie Ticket:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(ticket[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
