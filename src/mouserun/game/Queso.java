/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouserun.game;

import java.io.IOException;


/**
 *
 * @author jcsp0003
 */
public class Queso {
    private int x;
    private int y;
    private ImagedPanel panel;
    private int GRID_LENGTH = 30;
    
    public Queso(int _x, int _y) throws IOException {
        this.x = _x;
        this.y = _y;
        panel = new ImagedPanel("assets/cheese.png", GRID_LENGTH, GRID_LENGTH);
        panel.setBounds(x * GRID_LENGTH, y * GRID_LENGTH, GRID_LENGTH * 2, 20);
        panel.setOpaque(false);
    }
    
    public ImagedPanel getPanel() {
        return panel;
    }
    
    public void setPosicion(int _x, int _y) {
        this.x = _x;
        this.y = _y;
        panel.setBounds(x * GRID_LENGTH, y * GRID_LENGTH, GRID_LENGTH * 2, 20);
    }
    
}