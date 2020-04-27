import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;


class QuickDrawFrame extends JFrame implements ActionListener{
    private ArrayList<QuickDrawTile> QuickDrawTileList;

    QuickDrawFrame() {
        System.out.println("QuickDrawFrame starting up...");

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        setTitle("QuickDraw");
        setDefaultLookAndFeelDecorated(true);
        setBounds(400, 10, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton fill = new JButton("Fill");
        container.add(fill, BorderLayout.SOUTH);

        fill.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                for(QuickDrawTile myTile : QuickDrawTileList) {
                    myTile.setBlack();
                }
                repaint();
            }
        });

        JButton white = new JButton("Erase"); //ERASE LINES
        container.add(white, BorderLayout.NORTH);

        white.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                for(QuickDrawTile myTile : QuickDrawTileList) {
                    myTile.setWhite();
                }
                repaint();
            }
        });

        JPanel QuickDrawTileGridPanel = new JPanel();
        container.add(QuickDrawTileGridPanel, BorderLayout.CENTER);
        QuickDrawTileGridPanel.setLayout(new GridLayout(12,12));

        QuickDrawTileList = new ArrayList<QuickDrawTile>();
        for (int i = 1; i < 8000; i++) { //should have 144 total tiles
            QuickDrawTile myTile = new QuickDrawTile();
            QuickDrawTileList.add(myTile);
            QuickDrawTileGridPanel.add(myTile);
        }
    }
    
    public void actionPerformed(ActionEvent e) { //can use a string to randomize shape
        for(QuickDrawTile tile : QuickDrawTileList) {
            tile.setBlack();
        }
        repaint();
    }
}