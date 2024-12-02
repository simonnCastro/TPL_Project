import javax.swing.*;

public class Main {
    private JFrame mainFrame;
    Main(String[] args) {
        // Invoked on the event dispatching thread.
        // Do any initialization here.
        mainFrame = new JFrame();

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