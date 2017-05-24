/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Grafica {
    private String titulo;
    private XYSeriesCollection coleccion;
    private JFreeChart grafica;

    public Grafica(String titulo) {
       this.titulo = titulo;
       this.coleccion = new XYSeriesCollection();
    }
    // metodo para crear series y agregarlas a la coleccion
    public void crearSerie(double[] datos, String nombre){
        XYSeries serie = new XYSeries(nombre);
        // leemos los datos 
        for(int x=0; x<datos.length;x++){
            serie.add(x, datos[x]);
        }
        // agregamoss la serie a la coleccion 
        this.coleccion.addSeries(serie);
    }
    
    public void mostrarGrafica(){
    
        this.grafica = ChartFactory.createHistogram(titulo,"Nivel Gris","Frecuencia", coleccion, PlotOrientation.VERTICAL, false, false, false);
        ChartFrame frame = new ChartFrame(titulo, grafica);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    
}
