/**
 * @author Luis Barrera
 **/

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

class QDBrush extends JPanel {

    private int xCoordinate;
    private int yCoordinate;

    private int brushWidth = 3;
    private int brushHeight = 3;

    public int colorR;
    public int colorG;
    public int colorB;

    public boolean brushBoolean = true;

    public QDBrush() {

        if (brushBoolean == false) {
            setWhite();
        }

        if (brushBoolean == true) {
            setBlack();
        }

        //colorR = 0;
        //colorG = 0;
        //colorB = 255;
        
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(final MouseEvent e) {
                xCoordinate = e.getX();
                yCoordinate = e.getY();
                repaint();
            }
            public void mouseMoved(final MouseEvent e) {
            }
        });
    }

    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.setColor(new Color(colorR,colorG,colorB));
        g.fillOval(xCoordinate, yCoordinate, brushWidth, brushHeight);
    }

    public Dimension getPreferredSize() {
        int canvasWidth = 500;
        int canvasHeight = 350;
        return new Dimension(canvasWidth, canvasHeight);
    }

    public void setWhite() {
        colorR = 255;
        colorG = 255;
        colorB = 255;
    }

    public void setBlack() {
        colorR = 0;
        colorG = 0;
        colorB = 0;
    }
}