import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Matrica {
    private JPanel panel1;
    private JButton kreirajMatricuButton;
    private JTextField brRedova;
    private JLabel txtField1;
    private JTextField brStupaca;


    public Matrica() {
        brRedova.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int brojRedova = Integer.parseInt(brRedova.getText());
            }
        });
        brRedova.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int brojStupaca = Integer.parseInt(brRedova.getText());
            }
        });
        kreirajMatricuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int generiraj = Integer.parseInt(brRedova.getText() + brRedova.getText());
                System.out.println(generiraj);
            }
        });
    }
}


