package tesis;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
/**
 *
 * @author usuario
 */
public class Imagen extends Component{
    
    BufferedImage   img;//img es un objeto de tipo BufferedImage
    double [][]     matrizImg;		     //matrizImg de la imagen en escala de grises
    double [][]     matrizImg_R;         //matrizImg de la imagen en R
    double [][]     matrizImg_G;         //matriz de la imagen en G
    double [][]     matrizImg_B;         //matriz de la imagen en B
    int             columnas;            //numero de filas
    int             filas;               //numero de

    public Imagen(String nombreImagen){
        
        try{
            
            img = ImageIO.read(new File(nombreImagen));//llenamos el buffer con una imagen 
            convertirImagenAMatriz();
        }catch (IOException e){}
    }

    public Imagen(double [][]matriz){
        
        convertirMatrizAImagen(matriz);
    }

    public void convertirImagenAMatriz(){
        
        filas = img.getHeight();//sacamos el ancho de la imagen
    	columnas = img.getWidth();//sacamos el alto de la imagen
        System.out.println("fila= "+filas);
        System.out.println("colu= "+columnas);

    	matrizImg 	= new double [filas][columnas];//inicializo mi matriz
    	matrizImg_R	= new double [filas][columnas];//
     	matrizImg_G     = new double [filas][columnas];
    	matrizImg_B	= new double [filas][columnas];
    	double r;
    	double g;
    	double b;

    	WritableRaster raster=img.getRaster();//creo una variable raster para rasterizar(recorremos todo el buffer y lo rasteriza)
        //al rasterizar ya sabemos el numero de bandas
    	int numBandas=raster.getNumBands(); //obtenemos el numero de bandas de raster
        System.out.println("numero de bandas= "+numBandas);
    	for (int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                if (numBandas==3){   
                    
                    r=raster.getSampleDouble(j,i,0);//0 pertenece a red (obtenemos el canar red)
                    g=raster.getSampleDouble(j,i,1);//1 le corresponde a greenm (obtenemos el canar green)
                    b=raster.getSampleDouble(j,i,2);//2 le corresponde a blue (obtenemos el canar blue)
                    //System.out.println("r="+r+" g="+g+" b="+b);
                    matrizImg[i][j]=(r+g+b)/3; //llenamos la matriz en escalas de grises(con la formula (r+g+b)/3)
                    matrizImg_R[i][j]=r; //llenamos la matriz para poder manipular esto es para el Red
                    matrizImg_G[i][j]=g; //llenamos la matriz para poder manipular esto es para el green
                    matrizImg_B[i][j]=b; //llenamos la matriz para poder manipular esto es para el blue                    
                }
                if (numBandas==1){ 
                    
                    matrizImg[i][j]=raster.getSampleDouble(j,i,0);
                    matrizImg_R[i][j]=255;
                    matrizImg_G[i][j]=255;
                    matrizImg_B[i][j]=255;
                }
            }
        }
    }

    public void convertirMatrizAImagen(double [][] matriz){
        
        int alto = matriz.length;
	int ancho = matriz[0].length;

        img = new BufferedImage(ancho,alto,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = img.getRaster();

        for (int i=0;i<alto;i++){
            for(int j=0;j<ancho;j++){
                wr.setSample(j,i,0,matriz[i][j]);
            }
        }
        img.setData(wr);
    }

    public void guardarImagen(double [][]matriz, String path){       
        
        BufferedImage img = new BufferedImage(matriz[0].length,matriz.length,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = img.getRaster();

        for (int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                wr.setSample(j,i,0,matriz[i][j]);
            }
        }
        img.setData(wr);
        try{
            ImageIO.write(img, "PNG", new File(path+".png"));
        }catch(IOException e){}
    }

public void guardarImagen(double [][]matriz_R, double [][]matriz_G, double [][]matriz_B,String path) {
    
        BufferedImage imgn = new BufferedImage(matriz_R[0].length,matriz_R.length,BufferedImage.TYPE_INT_RGB);//crea un espacio en memoria imgn
        WritableRaster wr = imgn.getRaster();//creo un wr en buffer pero esta vacio

        for (int i=0;i<matriz_R.length;i++){
            for(int j=0;j<matriz_R[0].length;j++){
                
                wr.setSample(j,i,0,matriz_R[i][j]);//paso de la matriz a un bujjer y eso lo hace en el canal 0
                wr.setSample(j,i,1,matriz_G[i][j]);//en la posision j,i en el canal 1 guardo la matriz
                wr.setSample(j,i,2,matriz_B[i][j]);
            }
        }
        img.setData(wr);//aqui la cabezera le cargamos los datos y tenemos unidos la cabezera y los datos
        try{
            ImageIO.write(img, "JPG", new File(path+".jpg"));// ya teniendo la cabezera y los datos sera de tipo jpg creamos la ruta(path) y lo guarda como archivo
        }catch(IOException e){}
    }
   
   @Override
    public void paint(Graphics g){
        int x=0;
        int y=800;  //valor estandar de y
        int p=0;
        int q=0;
        
        x = img.getWidth(null) * y/img.getHeight(null);
        y = img.getHeight(null) * y/img.getHeight(null);
        
        g.drawImage(img, 100, 100, null);
        g.drawImage(img, 0, 0, x, y, 0, 0, img.getWidth(null), img.getHeight(null), null);
        //Graphics2D g2 = (Graphics2D) g;
    }
    @Override
    public Dimension getPreferredSize(){
        int x=0;
    	int y=800;
        if (img == null){
             return new Dimension(100,100);
        } else{
            
            x = img.getWidth(null) * y/img.getHeight(null);
            y = img.getHeight(null) * y/img.getHeight(null);
            return new Dimension(x, y);
          }
    }
   
     /*Coloca una imagen en una ventana*/
    public static void ventana(double matriz[][],String nombre){
        Imagen imagen=new Imagen(matriz);
    	try{
            JFrame f = new JFrame(nombre);
            f.addWindowListener(new WindowAdapter(){
                @Override
               public void windowClosing(WindowEvent e)
               {}
            }
            );
            f.add(imagen);
            f.pack();
            f.setVisible(true);
            f.repaint();
        }catch (Exception e){}
    }
    
    public static void ventana1(double matriz[][],JLabel label){//recibimos la matriz y el lugar donde se verá
        
        Imagen imagen=new Imagen(matriz);//convertimos la matriz a una imagen
        ImageIcon a= new ImageIcon(imagen.getImg());//convertimos la imagen a un icono
        Icon icono = new ImageIcon(//redimencionamos el icono para poder mostrar en pantalla
        a.getImage().getScaledInstance(label.getWidth()-100,label.getHeight()-100,Image.SCALE_DEFAULT));
        label.setIcon(a);//mostramos el icono.
        
    	
    }
    
    public double[][] getMatrizImg() {

        return matrizImg;
    }
    public int getColumnas() {
        return columnas;
    }
    public int getFilas() {
        return filas;
    }
    public BufferedImage getImg() {
        return img;
    }
    public double[][] getMatrizImg_B() {
        return matrizImg_B;
    }
    public double[][] getMatrizImg_G() {
        return matrizImg_G;
    }
    public double[][] getMatrizImg_R() {
        return matrizImg_R;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }
    public void setMatrizImg(double[][] matrizImg) {
        this.matrizImg = matrizImg;
    }
    public void setImg(BufferedImage img) {
        this.img=img;
    }
    public void setMatrizImg_B(double[][] matrizImg_B) {
        this.matrizImg_B = matrizImg_B;
    }
    public void setMatrizImg_G(double[][] matrizImg_G) {
        this.matrizImg_G = matrizImg_G;
    }
    public void setMatrizImg_R(double[][] matrizImg_R) {
        this.matrizImg_R = matrizImg_R;
    }
}