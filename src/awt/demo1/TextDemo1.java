package awt.demo1;

import java.awt.*;
import java.awt.event.*;

public class TextDemo1 {
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;
    private TextField textField;

    public TextDemo1(){
        preareGUI();
    }

    public static void main(String[] args) {
        TextDemo1 demo1 = new TextDemo1();
        demo1.showTextListenerDemo();
    }

    private void showTextListenerDemo(){
        headerLabel.setText("this is something...");
        textField = new TextField(10);

        textField.addTextListener(new CustomTextListener());
        Button okBtn = new Button("OK");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Entered text:"+textField.getText());
            }
        });
        controlPanel.add(textField);
        controlPanel.add(okBtn);
        mainFrame.setVisible(true);
    }

    class CustomTextListener implements TextListener {
        @Override
        public void textValueChanged(TextEvent e) {
            statusLabel.setText("Enter text:"+textField.getText());
        }
    }

    private void preareGUI(){
        mainFrame = new Frame("Java Awt Text...");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350,100);

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(statusLabel);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }
}
