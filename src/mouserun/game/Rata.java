/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouserun.game;

import jade.core.AID;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JLabel;

/**
 *
 * @author jcsp0003
 */
public class Rata {

    private final String nombre;
    private int x;
    private int y;
    private final ImagedPanel panel;
    private final JLabel label;
    private final int GRID_LENGTH = 30;

    private final AID aid;

    private int bombasColocadas;

    private int quesos;

    private final String izquierdaImg;
    private final String derechaImg;
    private final String abajoImg;
    private final String arribaImg;

    /**
     * Constructor parametrizado de la clase Rata
     *
     * @param _nombre Nombre del agente al que representa
     * @param _x Valor del eje x en que se crea
     * @param _y Valor del eje y en que se crea
     * @param _aid
     * @throws IOException An IOException can occur when the required game
     * assets are missing.
     */
    public Rata(String _nombre, int _x, int _y, AID _aid) throws IOException {
        this.izquierdaImg = "assets/mouseleft.png";
        this.derechaImg = "assets/mouseright.png";
        this.abajoImg = "assets/mousedown.png";
        this.arribaImg = "assets/mouseup.png";
        this.nombre = _nombre;
        this.x = _x;
        this.y = _y;
        this.bombasColocadas = 0;
        this.aid = _aid;

        panel = new ImagedPanel(derechaImg, GRID_LENGTH - 5, GRID_LENGTH - 5);
        panel.setBounds(x * GRID_LENGTH, y * GRID_LENGTH, GRID_LENGTH * 2, 20);
        panel.setOpaque(false);
        label = new JLabel(nombre);
        label.setForeground(Color.RED);
        label.setBounds(x * GRID_LENGTH, y * GRID_LENGTH - 5, GRID_LENGTH * 2, 20);

        this.quesos = 0;
    }

    /**
     * Aumenta las bombas colocadas
     */
    public void incrementaBombasColocadas() {
        ++bombasColocadas;
    }

    /**
     *
     * @return Quesos obtenidos por el raton
     */
    public int getQuesos() {
        return this.quesos;
    }

    /**
     * Incrementa el numero de quesos logrados
     */
    public void incrementaQueso() {
        ++quesos;
    }

    /**
     * @return panel Imagen del raton
     */
    public ImagedPanel getPanel() {
        return panel;
    }

    /**
     * Mueve la rata a una nueva posicion
     *
     * @param _x Nuevo valor en el eje x
     * @param _y Nuevo valor en el eje y
     * @throws java.io.IOException
     */
    public void setPosicion(int _x, int _y) throws IOException {
        int xx = this.x - _x;
        int yy = this.y - _y;
        if (xx == 1) {
            panel.setImage(izquierdaImg);
        } else {
            if (xx == -1) {
                panel.setImage(derechaImg);
            } else {
                if (yy == 1) {
                    panel.setImage(arribaImg);
                } else {
                    if (yy == -1) {
                        panel.setImage(abajoImg);
                    }
                }
            }
        }

        this.x = _x;
        this.y = _y;
        panel.setBounds(getX() * GRID_LENGTH, getY() * GRID_LENGTH, GRID_LENGTH * 2, 20);
        label.setBounds(getX() * GRID_LENGTH, getY() * GRID_LENGTH - 5, GRID_LENGTH * 2, 20);
    }

    /**
     * @return label Texto del raton
     */
    public JLabel getJLabel() {
        return label;
    }

    /**
     * @return x Posicion x donde esta el raton
     */
    public int getX() {
        return x;
    }

    /**
     * @return y Posicion y donde esta el raton
     */
    public int getY() {
        return y;
    }

    /**
     * @return aid AID del agente raton
     */
    public AID getAid() {
        return aid;
    }

    /**
     * @return bombasColocadas Bombas colocadas por el raton
     */
    public int getBombasColocadas() {
        return bombasColocadas;
    }

}
