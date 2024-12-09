import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.io.File;
import java.util.Arrays;


public class Main {
    CompilerAnalyzer ca = new CompilerAnalyzer();
    String[] lines = new String[100];
    String result;
    private JFrame mainFrame;
    private int width = 1008;
    private int height= 567;
    File file;

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
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.PAGE_AXIS));

        JButton space = new JButton();
        space.setMaximumSize(new Dimension(0,0));
        space.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton b1 = new JButton("Open File");
        JButton b2 = new JButton("Lexical Analysis");
        JButton b3 = new JButton("Syntax Analysis");
        JButton b4 = new JButton("Semantic Analysis");
        JButton b5 = new JButton("Clear");

        JTextArea resultTextArea = new JTextArea(1, 1);
        resultTextArea.setEditable(false);
        resultTextArea.setText("\n      Result: ");
        resultTextArea.setPreferredSize(new Dimension(600, 50));
        resultTextArea.setMaximumSize(resultTextArea.getPreferredSize());
        resultTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea inputTextArea = new JTextArea(1, 1);
        inputTextArea.setEditable(false);

        inputTextArea.setPreferredSize(new Dimension(600, 300));
        inputTextArea.setMaximumSize(inputTextArea.getPreferredSize());
        inputTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);

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

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("./src"));
                int response = fileChooser.showOpenDialog(null);

                File file = null; // Declare the file variable here

                if (response == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile(); // Assign the selected file
                    System.out.println("Selected file: " + file.getAbsolutePath());
                }

                if (file != null) {
                    System.out.println("File opened!");
                    try {
                        lines = ca.saveLines(file);

                        result = String.join("\n", lines);

                        inputTextArea.setText("");
                        inputTextArea.append(result);

                        System.out.println(Arrays.toString(lines));

                    } catch (IOException ex) {
                        ex.printStackTrace(); // Print stack trace for debugging
                        throw new RuntimeException(ex);
                    }

                    b1.setEnabled(false);
                    b2.setEnabled(true);
                    b5.setEnabled(true);
                } else {
                    System.out.println("No file selected or action canceled.");
                }
            }

        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(ca.lexicalAnalyzer(Arrays.toString(lines))){
                    resultTextArea.setText("\n      Result: Lexical analysis successful!");
                } else{
                    resultTextArea.setText("\n      Result: Lexical analysis unsuccessful!");
                }
                b2.setEnabled(false);
                b3.setEnabled(true);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ca.syntaxAnalyzer(Arrays.toString(lines))){
                    resultTextArea.setText("\n      Result: Syntax analysis successful!");
                } else{
                    resultTextArea.setText("\n      Result: Syntax analysis unsuccessful!");
                }
                System.out.println("Syntax analysis successful!");
                b3.setEnabled(false);
                b4.setEnabled(true);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ca.semanticAnalyzer(Arrays.toString(lines))){
                    resultTextArea.setText("\n      Semantic analysis successful!");
                } else{
                    resultTextArea.setText("\n      Result: Semantic analysis unsuccessful!");
                }
                System.out.println("Semantic analysis successful!");
                b4.setEnabled(false);
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("File cleared!");

                inputTextArea.setText(" ");

                System.out.println(result);
                Arrays.fill(lines, null);
                System.out.println(result);

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
        bodyPanel.add(space);
        bodyPanel.add(Box.createVerticalGlue());
        bodyPanel.add(resultTextArea);
        bodyPanel.add(Box.createVerticalGlue());
        bodyPanel.add(inputTextArea);
        bodyPanel.add(Box.createVerticalGlue());



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