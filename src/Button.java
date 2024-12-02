import javax.swing.*;

public class Button extends JButton {
    private JButton button;

    public Button(String text){
        initialize(text);
    }
    private void initialize(String text){
        setText(text);
    }
}
