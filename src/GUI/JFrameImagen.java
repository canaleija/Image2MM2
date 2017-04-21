/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DATA.AbrirImagen;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;

/**
 *
 * @author Roberto Cruz Leija
 */
public class JFrameImagen extends JFrame {
    
    private JPanel panelImagen,panelBotones;
    private JButton btnAbrir,btnConvertir,btnCalcularHisto; 
    private Image imgOriginal,imgGrises;
    private JLabel lblImagen;

    public JFrameImagen(){
        initcomponents();
        initListeners();
        this.imgOriginal = null;
        this.imgGrises = null;
    }

    private void initcomponents() {
       // configuración del frame
        setTitle("Practica Imagen");
        setSize(new Dimension(1200, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        // paneles
        this.panelBotones = new JPanel();
        this.panelImagen = new JPanel();
       
        
        this.panelBotones.setLayout(new GridLayout(1,3));
        
        this.btnAbrir = new JButton("Abrir Imagen");
        this.btnCalcularHisto = new JButton("CalcularHistograma");
        this.btnConvertir = new JButton("Convertir a Grises");
        // creamos una fuente nueva con el tamaño distinto
        Font fuente = new Font(this.btnAbrir.getFont().getName(),
                this.btnAbrir.getFont().getStyle(), 30);
        this.btnAbrir.setFont(fuente);
        this.btnConvertir.setFont(fuente);
        this.btnCalcularHisto.setFont(fuente);
        // agregamos los botones al panel
        this.panelBotones.add(this.btnAbrir);
        this.panelBotones.add(this.btnConvertir);
        this.panelBotones.add(this.btnCalcularHisto);
        
        // configurar el panel de la imagen
        this.panelImagen = new JPanel();
        this.lblImagen = new JLabel();
        this.panelImagen.add(this.lblImagen);
        // agregamos los paneles al frame
        
        setLayout(new BorderLayout());
        add(this.panelImagen);
        add(this.panelBotones,BorderLayout.SOUTH);
       
        
        setVisible(true);
    }

    private void initListeners() {
       this.btnAbrir.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              imgOriginal = AbrirImagen.abrir();
              lblImagen.setIcon(new ImageIcon(imgOriginal));
           }
       });
    }

    

}
