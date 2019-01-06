import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ta klasa buduję nam ramkę główną
 */
public class Frame extends JFrame implements ActionListener
{
    private JButton OkButton;
    private JButton NextButton;
    private JButton ExitButton;
    private JLabel lNapis, lNapisA, lPolski, lForma1, lForma2, lForma3;
    private JTextField tForma1, tForma2, tForma3;
    Mechanic test = new Mechanic();

    public Frame()
    {
        setSize(950,550);  // na taką rozdzelczość był pisany program
        setLocationByPlatform(true);  // pozwolenie aby system sam ustawiał lokalizacje ranki na ekranie

        setLayout(null);

        OkButton = new JButton("SPRAWDZ");
        OkButton.setBounds(425,375, 100, 50);
        OkButton.addActionListener(this);

        NextButton = new JButton("DALEJ >>");
        NextButton.setBounds(830,420, 100, 50);
        NextButton.addActionListener(this);

        ExitButton = new JButton("KONIEC");
        ExitButton.setBounds(20,420, 100, 50);
        ExitButton.addActionListener(this);

        // dodanie przycisków do ramki
        add(OkButton);
        add(NextButton);
        add(ExitButton);

        lNapis = new JLabel("CZASOWNIKI NIEREGULARNE",JLabel.CENTER);
        lNapis.setForeground(Color.BLUE);       // zmiana koloru napisu ( etykiety)
        lNapis.setFont(new Font("SansSerif", Font.BOLD,40));
        lNapis.setBounds(175, 20,600, 50);

        lNapisA = new JLabel("Inrregular Verbs",JLabel.CENTER);
        lNapisA.setFont(new Font ("SansSerif", Font.PLAIN,20));
        lNapisA.setBounds(375, 70,200, 50);

        lPolski = new JLabel("Czasownik po polsku: TEST", JLabel.CENTER);
        lPolski.setFont(new Font("SansSeries",Font.PLAIN,30));
        lPolski.setBounds(225,130,500,50);

        lForma1 = new JLabel("", JLabel.CENTER);
        lForma1.setFont(new Font("SansSeries",Font.PLAIN,25));
        lForma1.setBounds(50, 280,150,40);

        lForma2 = new JLabel("", JLabel.CENTER);
        lForma2.setFont(new Font("SansSeries",Font.PLAIN,25));
        lForma2.setBounds(400, 280,150,40);

        lForma3 = new JLabel("", JLabel.CENTER);
        lForma3.setFont(new Font("SansSeries",Font.PLAIN,25));
        lForma3.setBounds(750, 280,150,40);

        // dodanie Labela do ramki
        add(lNapis);
        add(lNapisA);
        add(lPolski);
        add(lForma1);
        add(lForma2);
        add(lForma3);

        tForma1 = new JTextField("");
        tForma1.setFont(new Font("SansSeries",Font.PLAIN,25));
        tForma1.setBounds(50, 220,150,40);

        tForma2 = new JTextField("");
        tForma2.setFont(new Font("SansSeries",Font.PLAIN,25));
        tForma2.setBounds(400, 220,150,40);

        tForma3 = new JTextField("");
        tForma3.setFont(new Font("SansSeries",Font.PLAIN,25));
        tForma3.setBounds(750, 220,150,40);
        tForma3.addActionListener(this);

        add(tForma1);
        add(tForma2);
        add(tForma3);

        lPolski.setText(test.getWord());    // pobranie pierwszego słowa z pliku

        // ustwienie stylu ramki Nimbus
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e1)
        {
            e1.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(this);
    }
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        if (source == OkButton || source==tForma3)
        {
            String text1 = tForma1.getText().toLowerCase();
            String text2 = tForma2.getText().toLowerCase();
            String text3 = tForma3.getText().toLowerCase();
            boolean [] tab = test.OkButton(text1, text2, text3);
            if(tab[0]==true)
            {
                lForma1.setText("DOBRZE");
                lForma1.setForeground(Color.GREEN);
            }
            else
            {
                lForma1.setText("ŹLE");
                lForma1.setForeground(Color.RED);
            }

            if(tab[1]==true)
            {
                lForma2.setText("DOBRZE");
                lForma2.setForeground(Color.GREEN);
            }
            else
            {
                lForma2.setText("ŹLE");
                lForma2.setForeground(Color.RED);
            }

            if(tab[2]==true)
            {
                lForma3.setText("DOBRZE");
                lForma3.setForeground(Color.GREEN);
            }
            else
            {
                lForma3.setText("ŹLE");
                lForma3.setForeground(Color.RED);
            }

        }
        else if (source == NextButton)
        {
            tForma1.setText("");
            tForma2.setText("");
            tForma3.setText("");
            lForma1.setText("");
            lForma2.setText("");
            lForma3.setText("");
            lPolski.setText(test.NextButton());
        }

        else if (source == ExitButton)
        {
            dispose();
        }
    }
}
