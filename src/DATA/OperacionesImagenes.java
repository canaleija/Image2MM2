/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Roberto Cruz Leija
 */
public class OperacionesImagenes {
    private Image imagenOriginal;

    public OperacionesImagenes(Image imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
        
    }
    
    public Image obtenerImagenGrises(){
        BufferedImage bi = toBufferedImage(imagenOriginal) ;
        // recorrer los pixels de la imagen
        for (int n=0; n< bi.getWidth();n++){
            for (int m=0;m<bi.getHeight();m++){
              // obtengo el color de cada pixel
              Color colorPixel = new Color(bi.getRGB(n, m));
              int rojo = colorPixel.getRed();
              int verde = colorPixel.getGreen();
              int azul = colorPixel.getBlue();
              int prom = (rojo+verde+azul)/3;
              colorPixel = new Color(prom, prom, prom);
              bi.setRGB(n, m, colorPixel.getRGB());
            }
        }
     return bi.getScaledInstance(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
    public Image obtenerImagenAzul(){
    return null;
    }
    public Image obtenerImagenRoja(){
    return null;
    }
    public static BufferedImage toBufferedImage(Image img){
   
         // Create a buffered image with transparency
    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);

    // Draw the image on to the buffered image
    Graphics2D bGr = bimage.createGraphics();
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();
        
        return bimage;
    }
    
    
}
