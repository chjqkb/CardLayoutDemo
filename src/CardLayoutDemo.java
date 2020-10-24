import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CardLayoutDemo implements ItemListener {

    JPanel cards;  // main cards; to manage  two card1 and card2 JPanel;

    final static String BUTTONPANEL = "JPanel with JButtons";
    final static String TEXTPANEL = "JPanel with JTextField";





    public void addComponentToPane(Container pane){

        JPanel comboBoxPane = new JPanel(); // use FlowLayout; for JComboBox with itemComboBox

        JPanel card1;  // manages three buttons: but1, but2 and but3;
        JPanel card2;  // manages tout of JTextField;

        JComboBox cb;
        JButton but1, but2, but3;
        JTextField tout;

        CardLayout layout = new CardLayout();
        cards = new JPanel( layout );
        card1 = new JPanel( );
        card2 = new JPanel();

        String [] itemComboBox = {BUTTONPANEL, TEXTPANEL} ;
        cb = new JComboBox( itemComboBox );
        cb.setEditable(false);
        cb.setSize(60, 30);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        pane.add(comboBoxPane, BorderLayout.PAGE_START);

        but1 = new JButton("but1");
        but2 = new JButton("but2");
        but3 = new JButton("but3");
        card1.add( but1 );
        card1.add( but2 );
        card1.add( but3 );

        tout = new JTextField("TextField", 20);
        tout.setSize(50, 20);
        tout.setEditable(false);
        card2.add(tout);

        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);

        pane.add(cards, BorderLayout.CENTER);

    }

    private static void createAndShowGUI(){
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        CardLayoutDemo demo = new CardLayoutDemo();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


    public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, (String)e.getItem());
    }
}



