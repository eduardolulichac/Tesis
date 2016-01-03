package tesis;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Contraste {
    
    static int fil,col;
    
    public static double [][] mejorarContraste(Imagen img)
    {
        Histograma histo1 = new Histograma(img,"Histograma Inicial");
        
        double [][]M;
        M=img.matrizImg; fil=img.filas; col=img.columnas;
        int menor,mayor,i;
        double [][]nuevaMatriz= M;
        
        menor=histo1.IndiceMenor();
        mayor=histo1.IndiceMayor();
        System.out.println("Indi m= "+menor);
        System.out.println("Indi M= "+mayor);

        i=menor;
        while(i<mayor){
            operacion(mayor,i,menor,M,nuevaMatriz,fil,col);
            i++;
        }
        //histo1.setVisible(true);
        Histograma histo2 = new Histograma(nuevaMatriz,fil,col,"Histograma Contraste");
        //histo2.setVisible(true);
        
        return nuevaMatriz;
        
    }
    
    public static void operacion(int M,int m,int men,double [] [] I, double [][] NM,int f, int c){
        
        double val =0;
        
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                if (I[i][j]==m) {
                    val = Math.round((m-men)*255/(M-men));
                    NM[i][j]=val;
                }
            }
            
        }
        
    }
}