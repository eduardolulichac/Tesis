
package tesis;

import static tesis.Contraste.fil;

public class Binarizacion {    
    
    public static double [][] binarizarImagen(double [][] M,int fil, int col)//operadorUmbral es es la binarización
    {
        int umbral;
        Histograma histo = new Histograma(M,fil,col,"Histograma Binarizada");
        umbral=histo.CalcularUmbral(M);
       // histo.setVisible(true);
        
        for(int i=0;i<fil;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(M[i][j]<umbral)
                    M[i][j]=0;
                else
                    M[i][j]=255;
            }
        }
        return M;
    }
    
}
