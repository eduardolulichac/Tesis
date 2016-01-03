package tesis;

public class Filtros {

    public static double[][] AplicarMaskAMatriz(double[][] img, int fil, int col/*, double[][] GrisZoom, double mask[][]*/) {

//        double[][] GrisOrig;	//matriz de la imagen
//        double[][] GrisEfecto;
//        double[][] GrisZoom;

        double[][] GrisEfecto = new double[fil][fil];
        double[][] GrisEfecto2 = new double[fil][fil];
        int lado = 3;
        double[][] GrisZoom = operadorDuplicarFyC(img, fil, col, lado);
        double[][] mask1 = {{0, 0, 0}, {1, 1, 1}, {0, 0, 0}};
        double[][] mask2 = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int Forig;          //m filas
        int Corig;          //n columnas

//        GrisEfecto = img.getMatrizImg();
//        GrisOrig = img.getMatrizImg();//devuelve la matriz Img y lo asigna a I
        Forig = fil;//medidas del gris origianl
        Corig = col;

        for (int i = 0; i < Forig; i++) {
            for (int j = 0; j < Corig; j++) {
                GrisEfecto[i][j] = multiplicarMatriz(i, j, mask1.length, GrisZoom, mask1);
                
                //  System.out.println(" nueva matricita");
            }
        }
        double[][] GrisZoom2 = operadorDuplicarFyC(GrisEfecto, fil, col, lado);
        for (int m = 0; m < Forig; m++) {
            for (int n = 0; n < Corig; n++) {
                GrisEfecto2[m][n] = multiplicarMatriz(m, n, mask2.length, GrisZoom2, mask2);
            }
        }
        //  System.out.println("matriz Filtro");
        //   mostrarMatriz(GrisEfecto);
        return GrisEfecto2;
    }
    static int cont = 0;

    private static double multiplicarMatriz(int i, int j, int tamMask, double[][] GrisZoom, double mask[][]) {
        double valorPixel = 0;
        double div = 0;
        double auxVP;
//        System.out.println("i y j: "+ i +", "+j);
        int auxJ = j;
        // System.out.println("mask: "+ tamMask);
        for (int f = 0; f < tamMask; f++) {
            for (int c = 0; c < tamMask; c++) {
//                System.out.println("-> "+mask[f][c]);
                div = (double) mask[f][c] + div;

                auxVP = (double) mask[f][c] * GrisZoom[i][j];
                valorPixel = auxVP + valorPixel;
                j++;
                cont++;
            }
            j = auxJ;
            i++;
        }
        return valorPixel / div;
    }

    public static double[][] operadorDuplicarFyC(double[][] GrisOrig, int fil, int col, int lados)//operadorUmbral es es la binarización
    {
//        double[][] GrisOrig;	//matriz de la imagen
        double[][] GrisZoom;
        int Forig;          //m filas
        int Corig;          //n columnas
        int FZo;
        int CZo;
        float io;// fila y columna original de la imagen chiquita original
        float jo;
        int n;

//        GrisOrig = img.getMatrizImg();//devuelve la matriz Img y lo asigna a I
        Forig = fil;//medidas del gris origianl
        Corig = col;

        System.out.println("antigua matriz: " + Forig + "; " + Corig);
        System.out.println("lados: " + lados);
        n = lados - 1;
        System.out.println("n: " + n);
        FZo = Forig + n;
        CZo = Corig + n;
        System.out.println("nueva matriz: " + FZo + "; " + CZo);

        GrisZoom = new double[Forig + n][Corig + n];

        for (int i = 0; i < FZo; i++) {
            for (int j = 0; j < CZo; j++) {
                // volvemos la matriz grande equivalente a la chiquita original
                io = i * (Forig - 1) / (FZo - 1);
                jo = j * (Corig - 1) / (CZo - 1);

                io = (float) Math.round(io);
                jo = (float) Math.round(jo);

                GrisZoom[i][j] = GrisOrig[(int) io][(int) jo];

//                System.out.println("grisZoom: "+"i: "+i+"j: "+j);
            }
        }

        return GrisZoom;//retorna la imagen con ceros y 255 solamente
    }

}
