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

    public boolean brushBoolean = true;
    private Color color;

    public QDBrush(Color x) {
    	super();
    	color = x;

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

    private Color getColor() {
		return color;
    }
    
    public void setColor(Color c) {
        this.color = c;
    }

    public void paintComponent(Graphics g) {
    	g.setColor(getColor());
        g.fillOval(xCoordinate, yCoordinate, getBrushWidth(), getBrushHeight());
    }
    
    private int getBrushWidth() {
		return brushWidth;
    }

    private int getBrushHeight() {
		return brushHeight;
    }

    public void setBrushWidth(int brushWidth) {
        this.brushWidth = brushWidth;
    }

    public void setBrushHeight(int brushHeight) {
        this.brushHeight = brushHeight;
    }

	public Dimension getPreferredSize() {
        int canvasWidth = 600;
        int canvasHeight = 450;
        return new Dimension(canvasWidth, canvasHeight);
    }
 
}