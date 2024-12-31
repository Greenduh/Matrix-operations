package app;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[][] matrix = new int[4][4];
        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(1, 50);
            }
        }

//        int[][] matrix = {{7, 12, 1, 14}, {2, 13, 8, 11}, {16, 3, 10, 5}, {9, 6, 15, 4}};
//        Магічний квадрат для перевірки

        System.out.println("Матриця 4x4:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int evenRowSum = 0;
        int oddRowSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 == 0) {
                    evenRowSum += matrix[i][j];
                } else {
                    oddRowSum += matrix[i][j];
                }
            }
        }

        long evenColumnProduct = 1;
        long oddColumnProduct = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j % 2 == 0) {
                    evenColumnProduct *= matrix[i][j];
                } else {
                    oddColumnProduct *= matrix[i][j];
                }
            }
        }

        System.out.println("Сума елементів у парних рядках (рядок 0, 2): " + evenRowSum
                            + "\nСума елементів у непарних рядках (рядок 1, 3): " + oddRowSum
                            + "\nДобуток елементів у парних стовпцях (стовпець 0, 2): " + evenColumnProduct
                            + "\nДобуток елементів у непарних стовпцях (стовпець 1, 3): " + oddColumnProduct);

        System.out.println();

        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    primaryDiagonalSum += matrix[i][j];
                } else if (i + j == 3) {
                    secondaryDiagonalSum += matrix[i][j];
                }
            }
        }
        if (primaryDiagonalSum != secondaryDiagonalSum) {
            System.out.println("Матриця не є магічним квадратом.");
        } else {
            int rowSum;
            int columnSum;
            for (int i = 0; i < matrix.length; i++) {
                rowSum = 0;
                columnSum = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    rowSum += matrix[i][j];
                    columnSum += matrix[j][i];
                }
                if (rowSum != primaryDiagonalSum || columnSum != primaryDiagonalSum) {
                    System.out.println("Матриця не є магічним квадратом.");
                    break;
                } else if (i == 3) {
                    System.out.println("Матриця є магічним квадратом.");
                }
            }
        }
    }
}