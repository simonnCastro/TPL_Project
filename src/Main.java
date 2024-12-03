import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.PAGE_AXIS));
        JPanel bodyPanel = new JPanel();

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

        //b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("File opened!");
                b1.setEnabled(false);
                b2.setEnabled(true);
                b5.setEnabled(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Lexical analysis successful!");
                b2.setEnabled(false);
                b3.setEnabled(true);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Syntax analysis successful!");
                b3.setEnabled(false);
                b4.setEnabled(true);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Semantic analysis successful!");
                b4.setEnabled(false);
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("File cleared!");
                b1.setEnabled(true);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
            }
        });


        navigationPanel.setBackground(Color.blue);
        navigationPanel.setPreferredSize(new Dimension(width/4, height));
        navigationPanel.add(Box.createVerticalGlue());
        navigationPanel.add(b1);
        navigationPanel.add(Box.createVerticalGlue());
        navigationPanel.add(b2);
        navigationPanel.add(Box.createVerticalGlue());
        navigationPanel.add(b3);
        navigationPanel.add(Box.createVerticalGlue());
        navigationPanel.add(b4);
        navigationPanel.add(Box.createVerticalGlue());
        navigationPanel.add(b5);
        navigationPanel.add(Box.createVerticalGlue());

        bodyPanel.setBackground(Color.red);
        bodyPanel.setPreferredSize(new Dimension(width, height));

        mainPanel.add(navigationPanel, BorderLayout.WEST);
        mainPanel.add(bodyPanel, BorderLayout.CENTER);
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