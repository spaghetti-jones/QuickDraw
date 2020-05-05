/**
 * @author Luis Barrera
 **/

//import java.awt.AlphaComposite;
//import java.awt.Dimension;
//import java.awt.EventQueue;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Point;
//import java.awt.Rectangle;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

//import java.util.ArrayList;
//import java.util.List;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
//import javax.swing.JLabel;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;

public class QDFrame extends QDBrush {

	public QDFrame() {
        JFrame qdFrame = new JFrame("QuickDraw");

        Container pane = qdFrame.getContentPane();
        pane.setLayout(new BorderLayout()); 

        qdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        qdFrame.setBackground(Color.WHITE);
        qdFrame.add(new QDBrush());
        qdFrame.pack();
        qdFrame.setLocationRelativeTo(null);
        qdFrame.setVisible(true);

        //QDBrush qdPanel = new QDBrush();
        //pane.add(qdPanel);

        JToolBar tools = new JToolBar();
        pane.add(tools, BorderLayout.NORTH);

        JButton newPage = new JButton("New Page");
        tools.add(newPage);
        newPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                qdFrame.dispose();
                new QDFrame();
            }
        });

        JButton eraseAll = new JButton("Erase All");
        tools.add(eraseAll, BorderLayout.NORTH);

        eraseAll.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                //qdFrame.setWhite();
                //qdFrame.getContentPane().removeAll();
                qdFrame.repaint();
            }
        });
        
        JRadioButton brushTool = new JRadioButton("Brush", true);
        tools.add(brushTool, BorderLayout.NORTH);

        JRadioButton eraserTool = new JRadioButton("Eraser", false);
        tools.add(eraserTool, BorderLayout.NORTH);

        ButtonGroup toolOptions = new ButtonGroup();
        toolOptions.add(brushTool);
        toolOptions.add(eraserTool);

        eraserTool.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                System.out.println("Eraser tool selected!");
            }
        });
        
        brushTool.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                System.out.println("Brush tool selected!");
            }
        });
    }
}