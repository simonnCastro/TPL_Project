import javax.swing.*;
import java.awt.*;

public class Button extends JPanel{
    JPanel button;


    public Button(){
        initialize();
    }
    private void initialize(){
        new JPanel();
        setBackground(Color.cyan);

        JLabel labelText = new JLabel("true");
        add(labelText);
    }
}
