import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame mainFrame;
    private int width = 1008;
    private int height= 567;
    Main(String[] args) {
        // Invoked on the event dispatching thread.
        // Do any initialization here.
        mainFrame = new JFrame();
        mainFrame.setTitle("TPL-Project");
        mainFrame.setSize(width, height);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));
        JPanel p3 = new JPanel();

        JButton b1 = new JButton("Open File");
        JButton b2 = new JButton("Lexical Analysis");
        JButton b3 = new JButton("Syntax Analysis");
        JButton b4 = new JButton("Semantic Analysis");
        JButton b5 = new JButton("Clear");

        b1.setMaximumSize(new Dimension(200,0));
        b2.setMaximumSize(new Dimension(200,0));
        b3.setMaximumSize(new Dimension(200,0));
        b4.setMaximumSize(new Dimension(200,0));
        b5.setMaximumSize(new Dimension(200,0));

        b1.setPreferredSize(new Dimension(0,50));
        b2.setPreferredSize(new Dimension(0,50));
        b3.setPreferredSize(new Dimension(0,50));
        b4.setPreferredSize(new Dimension(0,50));
        b5.setPreferredSize(new Dimension(0,50));

        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);
        b5.setAlignmentX(Component.CENTER_ALIGNMENT);

        p2.setBackground(Color.blue);
        p2.setPreferredSize(new Dimension(width/4, height));
        p2.add(Box.createVerticalGlue());
        p2.add(b1);
        p2.add(Box.createVerticalGlue());
        p2.add(b2);
        p2.add(Box.createVerticalGlue());
        p2.add(b3);
        p2.add(Box.createVerticalGlue());
        p2.add(b4);
        p2.add(Box.createVerticalGlue());
        p2.add(b5);
        p2.add(Box.createVerticalGlue());

        p3.setBackground(Color.red);
        p3.setPreferredSize(new Dimension(width, height));

        mainPanel.add(p2, BorderLayout.WEST);
        mainPanel.add(p3, BorderLayout.CENTER);
        mainFrame.add(mainPanel);

    }

    public void show() {
        // Show the UI.
        mainFrame.setVisible(true);
    }

    public static void main(final String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main(args).show();
            }
        });
    }
}
//*vandilizes your project*
//*vandilizes your project again*