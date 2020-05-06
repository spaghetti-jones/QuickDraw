/**
 * @author Luis Barrera
 **/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class QDFrame  {
	public QDFrame() {
        JFrame qdFrame = new JFrame("QuickDraw");
        
        Container pane = qdFrame.getContentPane();
        pane.setLayout(new BorderLayout()); 
        pane.setBackground(Color.WHITE);
  
        QDBrush brush = new QDBrush(Color.BLACK);
        pane.add(brush);
        
        qdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        qdFrame.pack();
        qdFrame.setLocationRelativeTo(null); //center frame
        qdFrame.setVisible(true);

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
                brush.setColor(Color.WHITE);
            }
        });

        
        brushTool.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                System.out.println("Brush tool selected!");
                brush.setColor(Color.BLACK);
            }
        });

        JToolBar colors = new JToolBar();
        pane.add(colors, BorderLayout.SOUTH);

        JRadioButton red = new JRadioButton("red", false);
        colors.add(red, BorderLayout.NORTH);

        JRadioButton green = new JRadioButton("green", false);
        colors.add(green, BorderLayout.NORTH);

        JRadioButton blue = new JRadioButton("blue", false);
        colors.add(blue, BorderLayout.NORTH);

        JRadioButton yellow = new JRadioButton("yellow", false);
        colors.add(yellow, BorderLayout.NORTH);

        JRadioButton black = new JRadioButton("black", true);
        colors.add(black, BorderLayout.NORTH);

        ButtonGroup ColorPicker = new ButtonGroup();
        ColorPicker.add(red);
        ColorPicker.add(green);
        ColorPicker.add(blue);
        ColorPicker.add(yellow);
        ColorPicker.add(black);

        red.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                System.out.println("red selected!");
                brush.setColor(Color.RED);
            }
        });

        green.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                System.out.println("green selected!");
                brush.setColor(Color.green);
            }
        });

        blue.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                System.out.println("blue selected!");
                brush.setColor(Color.blue);
            }
        });

        yellow.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                System.out.println("yellow selected!");
                brush.setColor(Color.yellow);
            }
        });

        black.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                System.out.println("black selected!");
                brush.setColor(Color.black);
            }
        });

        JToolBar sizes = new JToolBar();
        pane.add(sizes, BorderLayout.EAST);

        JRadioButton s = new JRadioButton("S", true);
        sizes.add(s, BorderLayout.NORTH);

        JRadioButton m = new JRadioButton("M", false);
        sizes.add(m, BorderLayout.CENTER);

        JRadioButton l = new JRadioButton("L", false);
        sizes.add(l, BorderLayout.SOUTH);

        ButtonGroup sizePicker = new ButtonGroup();
        sizePicker.add(s);
        sizePicker.add(m);
        sizePicker.add(l);

        s.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                System.out.println("small selected!");
                brush.setBrushWidth(6);
                brush.setBrushHeight(6);
            }
        });

        m.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                System.out.println("medium selected!");
                brush.setBrushWidth(12);
                brush.setBrushHeight(12);
            }
        });

        l.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                System.out.println("large selected!");
                brush.setBrushWidth(24);
                brush.setBrushHeight(24);
            }
        });
    }
}