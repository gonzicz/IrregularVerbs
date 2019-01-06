import javax.swing.*;
import java.awt.*;

public class IrregularVerbs
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                Frame frame = new Frame();
                frame.setTitle("IrregularVerbs");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setResizable(false);      // zablokowanie rozszerzania ramki
            }
        });

    }
}
