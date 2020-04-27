import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;


class MosaicFrame extends JFrame implements ActionListener{
    private ArrayList<LetterTile> letterTileList;

    MosaicFrame() {
        System.out.println("MosaicFrame starting up...");

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        setTitle("Mosaic");
        setDefaultLookAndFeelDecorated(true);
        setBounds(400, 10, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton fill = new JButton("Fill");
        container.add(fill, BorderLayout.SOUTH);

        fill.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                for(LetterTile myTile : letterTileList) {
                    myTile.setBlack();
                }
                repaint();
            }
        });

        JButton white = new JButton("Erase"); //ERASE LINES
        container.add(white, BorderLayout.NORTH);

        white.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                for(LetterTile myTile : letterTileList) {
                    myTile.setWhite();
                }
                repaint();
            }
        });

        JPanel letterTileGridPanel = new JPanel();
        container.add(letterTileGridPanel, BorderLayout.CENTER);
        letterTileGridPanel.setLayout(new GridLayout(12,12));

        letterTileList = new ArrayList<LetterTile>();
        for (int i = 1; i < 8000; i++) { //should have 144 total tiles
            LetterTile myTile = new LetterTile();
            letterTileList.add(myTile);
            letterTileGridPanel.add(myTile);
        }
    }
    
    public void actionPerformed(ActionEvent e) { //can use a string to randomize shape
        for(LetterTile tile : letterTileList) {
            tile.setBlack();
        }
        repaint();
    }
}