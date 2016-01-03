/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesis;

import static tesis.Contraste.fil;
import java.math.*;

/**
 *
 * @author SARA
 */
public class Alineacion {

    public static double[][] alinearImagen(double[][] M, int fil, int col) {
        double[][] NM = new double[fil][col];//IMG alineada
        int ix, jx;
        double ang = 5.0 * 6.28 / 360;
        double cos_ang, sin_ang;

        int[] locationPoints = new int[4];

        cos_ang = Math.cos(ang);
        sin_ang = Math.sin(ang);
        System.out.println("(ALINEACIÓN: Cos(A)=" + cos_ang + " Sin(A)=" + sin_ang);
        TopBottom(M, fil, col);
        RightLeft(M, fil, col);
//        BottomTop(M, fil, col);

        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                NM[i][j] = 150;
            }
        }

        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                ix = (int) Math.abs(/*Math.round*/((i * cos_ang) - (j * sin_ang)));
                jx = (int) Math.abs(/*Math.round*/((i * sin_ang) + (j * cos_ang)));
                //System.out.println("P("+i+","+j+")= ("+ix+","+jx+")");
                if (jx >= 0 && jx < col && ix >= 0 && ix < fil) {
                    NM[ix][jx] = M[i][j];
                }

            }
        }

        return NM;
    }

    private static void TopBottom(double[][] M, int fil, int col) {
        int[] locationPoints = new int[4];

        int colLeft = 0;
        int ban1 = 0;
        int ban2 = 0;
        int x1 = 0;
        int aux = fil;
        System.out.println("Recorrido de arriba hacia abajo, izquierda a derecha");
        while ((colLeft < col / 2) && (ban1 == 0)) {
            x1 = 0;
            while ((x1 < fil / 7) && (ban2 == 0)) {

                if (M[x1][colLeft] == 0) {
                    ban2 = 1;
                    if (x1 < aux) {
                        aux = x1;
                    } else {
                        ban1 = 1;
                    }
                    locationPoints[2] = aux;
                    locationPoints[3] = colLeft;
                    System.out.println("fila =" + locationPoints[2] + " columna-left =" + locationPoints[3]);
                }
                x1++;
            }
            ban2 = 0;
            colLeft++;
        }
    }
    
    private static void RightLeft(double[][] M, int fil, int col) {

        System.out.println("Recorrido de arriba hacia abajo, izquierda a derecha, derecha a izquierda");
        int[] locationPoints = new int[4];
        int colLeft = col - 1;
        int ban1 = 0;
        int ban2 = 0;
        int x1 = 0;
        int aux = fil;
        while ((colLeft > col / 2) && (ban1 == 0)) {
            x1 = 0;
            while (x1 < (fil / 6) && (ban2 == 0)) {
                if (M[x1][colLeft] == 0) {
                    ban2 = 1;
                    if (x1 < aux) {
                        aux = x1;
                    } else {
                        ban1 = 1;
                    }
//                    ban1 = 1;
                    locationPoints[2] = x1;
                    locationPoints[3] = colLeft;
                    System.out.println("fila =" + locationPoints[2] + " columna-left =" + locationPoints[3]);
                }
                x1++;
            }
            ban2 = 0;
            colLeft--;
        }

    }
    
    private static void BottomTop(double[][] M, int fil, int col) {

        System.out.println("Recorrido de abajo hacia arriba");
        int[] locationPoints = new int[4];

        int colLeft = 0;
        int ban1 = 0;
        int x1 = fil - 1;

        while ((colLeft < col / 2) && (ban1 == 0)) {
            x1 = fil - 1;

            while ((x1 > (5 * (fil / 6)))) {

                if (M[x1][colLeft] == 0) {
                    ban1 = 1;
                    locationPoints[2] = x1;
                    locationPoints[3] = colLeft;
                    System.out.println("fila =" + locationPoints[2] + " columna-left =" + locationPoints[3]);
                }
                x1--;
            }
            colLeft++;
        }

    }
}
