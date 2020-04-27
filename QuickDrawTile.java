import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.BorderLayout;

import java.util.Random;
import java.util.ArrayList;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class QuickDrawTile extends JPanel implements MouseListener {
    private int colorR;
    private int colorG;
    private int colorB;
    private int colorR2;
    private int colorG2;
    private int colorB2;
    private int shapeSelection;
    private String shapeString;

    QuickDrawTile() {
        super();
        setBlack();
        setWhite();
        addMouseListener(this);
    }

    public void setBlack() {
        Random gen = new Random();
        //create rainbow color by implementing randomized colors
        colorR = 0;
        colorG = 0;
        colorB = 0;

        shapeSelection = 2;

		if (shapeSelection == 1) {
            shapeString = "Square tile";
        }
		if (shapeSelection != 1) {
			shapeString = "Square tile";
        }
    }

    public void setWhite() {

        colorR = 255;
        colorG = 255;
        colorB = 255;

        shapeSelection = 2;
        
		if (shapeSelection == 1) {
            shapeString = "Square tile";
        }
		if (shapeSelection != 1) {
			shapeString = "Square tile";
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(colorR,colorG,colorB));

        int windowWidth = getWidth();
        int windowHeight = getHeight();

        if (shapeSelection == 1) {
            g.fillRect(0, 0, windowWidth, windowHeight);
        }
        if (shapeSelection != 1) {
            g.fillRect(0, 0, windowWidth, windowHeight);
        }
    }

    public void mouseReleased(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
        setBlack();
        repaint();
    }
    public void MouseDragged(MouseEvent e) {
        setBlack();
        repaint();
    }
}