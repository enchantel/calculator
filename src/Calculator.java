import java.awt.*; //graphics libarty
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*; //events handling
import javax.swing.border.LineBorder;

public class Calculator {
    //create window, initialises dimensions
    int windowWidth = 360;
    int windowHeight = 540;

    //custom colours
    Color customDarkRed = new Color(136,17,17);
    Color customPink = new Color(251,210,204);
    Color customYellow = new Color(254,237,183);
    Color customDarkPink = new Color(244,119,127);
    Color customLightRed = new Color(224,74,78);

    //button arrays
    String[] buttonValues = {
        "C", "%", "<-", "/", 
        "7", "8", "9", "×", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        ".", "0", "√", "="
    };
    String[] rightSymbols = {"/", "×", "-", "+", "="};
    String[] topSymbols = {"C", "%", "<-"};

    //this creates the window and allows it to be edited
    JFrame frame = new JFrame("Calculator");

    //text iinside label isnide panel isnide window
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    //opens the windows
    Calculator() {
        frame.setVisible(true);
        frame.setSize(windowWidth, windowHeight); //sets height and width
        frame.setLocationRelativeTo(null); //centers the window
        frame.setResizable(false); //cant change size of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //app closes when window closed
        frame.setLayout(new BorderLayout()); //components can be placed anywhere within the window.

        //label styling
        displayLabel.setBackground(customYellow);
        displayLabel.setForeground(customDarkRed); //text color
        displayLabel.setFont(new Font("Inter", Font.BOLD, 64));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        //panel styling
        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel); //put label inside of display panel
        frame.add(displayPanel, BorderLayout.NORTH); //puts panel at the very top

        //buttons styling
        buttonsPanel.setLayout(new GridLayout(5, 4));
        buttonsPanel.setBackground(customPink);
        buttonsPanel.setForeground(customDarkRed);
        frame.add(buttonsPanel);

        //iterates through button array and prints every button
        for (int i = 0; i < buttonValues.length; i++) {
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Inter", Font.BOLD, 32));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(customLightRed, 5));
            buttonsPanel.add(button);

            if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                button.setBackground(customDarkPink);
                button.setForeground(customYellow);
                button.setFont(new Font("Inter", Font.BOLD, 40));
            }
            else if (Arrays.asList(topSymbols).contains(buttonValue)) {
                button.setFont(new Font("Inter", Font.BOLD, 40));
                button.setBackground(customPink);
                button.setForeground(customDarkRed);
            }
            else {
                button.setBackground(customPink);
                button.setForeground(customDarkRed);
            }

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();

                    if (Arrays.asList(rightSymbols).contains(buttonValue)) {

                    }
                    else if (Arrays.asList(topSymbols).contains(buttonValue)) {
                    
                    }
                    else { //digits or decimal
                        if (buttonValue == ".") {
                            
                        }
                        else if ("0123456789".contains(buttonValue)) {
                            if (displayLabel.getText() == "0") {
                                displayLabel.setText(buttonValue);
                            }
                            else {
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        }
                        
                    }
                }
            });
        }


    }

}
