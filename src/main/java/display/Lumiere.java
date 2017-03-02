/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.GroupLayout;

/**
 *
 * @author telly
 */
public class Lumiere extends javax.swing.JPanel{
    private Color couleur = Color.YELLOW;
    private int luminosite = 100;
    
    public Lumiere(){
        initComponents();
    }

    public int getLuminosite() {
        return luminosite;
    }

    public void setLuminosite(int luminosite) {
        this.luminosite = luminosite;
    }

    @Override
    public void paintComponent(Graphics grphcs) {
        super.paintComponents(grphcs);
        grphcs.setColor(couleur);
        grphcs.fillOval(0, 0, getWidth(), getHeight());
    }

    public void actualiser(){
        float hsb[] = Color.RGBtoHSB(couleur.getRed(),couleur.getGreen(),couleur.getBlue(),null);
        float hue = hsb[0];
        float saturation = hsb[1];
        float brigthness;
        brigthness = (float) luminosite/100.0f;
        if(brigthness < 0.05f)
            brigthness = 0.05f;
        couleur = new Color(Color.HSBtoRGB(hue, saturation, brigthness));
        repaint();
    }
    
    public void darker(){
        luminosite -= 5;
    }
    
    public void brighter(){
        luminosite += 5;
    }
    
    
    private void initComponents() {
        javax.swing.GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                         .addGap(0,300,Short.MAX_VALUE)
        );
    }
}
