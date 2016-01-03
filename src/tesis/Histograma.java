package tesis;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author SARA
 */
public class Histograma extends javax.swing.JFrame {

    /**
     * Creates new form GraficoDispersion
     */
    JFreeChart chart;
    BufferedImage imgHisto = null;
    int H[] = new int[256];
    int m,n,tam=400;
    String Titulo;    
    int filas;
    int columnas;

    public Histograma(Imagen img, String titulo) {
        
        inicializarHistograma();
        obtenerHistograma(img);
        //verH();
        Titulo=titulo;
        this.filas=img.filas;
        this.columnas=img.columnas;
        initComponents();
        this.setSize(tam + 50, tam + 50);
    }
    
    public Histograma(double [][] img,int f,int c,String titulo) {
        
        inicializarHistograma();
        obtenerotroHistograma(img,f,c);
        //verH();
        Titulo=titulo;
        this.filas=f;
        this.columnas=c;
        initComponents();
        this.setSize(tam + 50, tam + 50);
    }
    
    public void inicializarHistograma(){
        for (int i = 0; i < 256; i++) {
            H[i] = 0;
        }
    }
  
    public void obtenerHistograma(Imagen img){
            double[][] I;
            I=img.matrizImg;
        for (int i = 0; i < img.filas; i++) {
            for (int j = 0; j < img.columnas; j++) {
                H[(int) I[i][j]] = H[(int) I[i][j]] + 1;
                
            }
        }

    }
    
    public void obtenerotroHistograma(double [][] I,int f,int c){
            
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                H[(int) I[i][j]] = H[(int) I[i][j]] + 1;
                
            }
        }
       
    }
    /*
    public void verH(){
        System.out.print("H=[");
        for (int i = 0; i < 256; i++) {
            System.out.print(+H[i]+", ");
        }
        System.out.println("");
    }*/

    public int IndiceMenor() {
        int m = 0;
        while (H[m] < 200)//Aquel valor de color q llegue a los 199 ocurrencias
        {
            m++;
        }
        /*System.out.println("m es " + m);*/
        return m;
    }

    public int IndiceMayor() {
        int M = 255;
        System.out.println("h[M]="+H[M]);
        while (H[M] < 2000) {
            //System.out.println("MMMM= "+M);
            M--;
        }
        //System.out.println("M es " + M);
        return M;
    }
    
    public int CalcularUmbral(double [][] I){ //ALGORITMO ISODATA
    //se calcula el valor inicial del umbral
    double umbral0 = 0;    
    
    for (int i = 0; i < filas; i++){

        for (int j = 0; j < columnas; j++){
            umbral0 += I[i][j];
        } 
    } 
    umbral0 = umbral0 / (filas*columnas); 

    //vamos a calcular el valor real 

    double umbral1 = 0; 
    double umbral_der = 0; 
    double umbral_izq = 0; 
    int cont_izq = 0; 
    int cont_der = 0; 

    int contadorW=0;
    while( Math.abs(umbral0 - umbral1) > 0){
        
        contadorW++;
        
        umbral1 = umbral0;
        umbral_der = 0;
        umbral_izq = 0;
        cont_izq = 0;
        cont_der = 0;

        for (int i = 0; i < filas; i ++){

            for (int j = 0; j < columnas; j++){ 

                if (I[i][j] < umbral1){
                    umbral_izq += I[i][j];
                    cont_izq ++;
                }

                else{
                    umbral_der += I[i][j];
                    cont_der ++;
                }
            } 
        }

        umbral0 = (umbral_izq/cont_izq + umbral_der/cont_der)/2;
    }
        System.out.println("contadorW= "+contadorW);
        System.out.println("el umbral es: "+(int)umbral0);
        return (int)umbral0;        
    }
    
    
    
    
    

    public BufferedImage Grafico() {   //un variable serie para asignar al rreglo
        XYSeries serie1 = new XYSeries(" Incidencias & Color");
        for (int i = 0; i < H.length; i++) {
            serie1.add((i + 1), H[i]);
        }
        //Se define un arreglo H
        XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(serie1);

        //chart = ChartFactory.createXYLineChart("HISTOGRAMA DE IMAGEN", "Colores", "Incidencias del Color", 
        chart = ChartFactory.createHistogram(Titulo, "Colores", "Incidencias del Color",
                collection, PlotOrientation.VERTICAL, true, true, true);

        chart.setBackgroundPaint(Color.WHITE);
        //chart.setBorderPaint(Color.BLUE);
        imgHisto = chart.createBufferedImage(tam, tam);

        return imgHisto;
    }

    public void paint(java.awt.Graphics g) {
        if (imgHisto == null) {
            imgHisto = this.Grafico();
        }
        g.drawImage(imgHisto, 30, 30, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
