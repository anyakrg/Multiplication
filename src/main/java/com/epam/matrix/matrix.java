package com.epam.matrix;

import javax.swing.JOptionPane;

public class matrix {
    private int matriks[][];
    private int result[][];


    matrix(int n) {


        matriks = new int[n][n];
        /*input random in matrix*/
        for (int i = 0; i < matriks.length; i++)
            for (int j = 0; j < matriks[i].length; j++) {
                matriks[i][j] = (int) (Math.random() * 10);
            }


        System.out.println("Случайное заполнение матрицы: ");
        for (int i = 0; i < matriks.length; i++) {

            for (int j = 0; j < matriks[i].length; j++) {
                System.out.print(matriks[i][j] + "   ");

            }

            System.out.println();
        }

    }

    public void multiply(matrix m1, matrix m2, int M_level) {
        result = new int[M_level][M_level];
        System.out.println("Произведение двух матриц: ");

        int res = 0;
        for (int z = 0; z < M_level; z++) {
            System.out.print("|  ");
            for (int j = 0; j < M_level; j++) {
                res = 0;
                for (int i = 0; i < M_level; i++) {
                    res = res + m1.matriks[z][i] * m2.matriks[i][j];
                    if (i != M_level - 1)
                        System.out.print(m1.matriks[z][i] + " * " + m2.matriks[i][j] + " + ");
                    else
                        System.out.print(m1.matriks[z][i] + " * " + m2.matriks[i][j] + "   ");
                }
                result[z][j] = res;
            }
            System.out.print("|");
            System.out.println();
        }

        System.out.println();

        System.out.println("Результат: ");
        for (int j = 0; j < M_level; j++) {
            for (int i = 0; i < M_level; i++) {

                System.out.print(result[j][i] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        String nam = JOptionPane.showInputDialog("Введите размерность матрицы:");
        int m = Integer.parseInt(nam);
        System.out.println("Размерность матрицы = " + m + " на " + m);
        matrix m1 = new matrix(m);
        matrix m2 = new matrix(m);
        m1.multiply(m1, m2, m);

    }

}
