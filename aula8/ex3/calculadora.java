package aula8.ex3;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculadora {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JTextField campo1 = new JTextField(10);
        JTextField campo2 = new JTextField(10);

        String[] operacoes = {"Somar", "Subtrair", "Multiplicar", "Dividir"};
        JComboBox<String> combo = new JComboBox<>(operacoes);

        JCheckBox mostrarPopup = new JCheckBox("Mostrar resultado em janela");

        JLabel labelResultado = new JLabel("Resultado: ");

        JButton calcular = new JButton("Calcular");

        calcular.addActionListener(e -> {
            double n1 = Double.parseDouble(campo1.getText());
            double n2 = Double.parseDouble(campo2.getText());
            String op = (String) combo.getSelectedItem();

            double resultado = 0;

            if (op.equals("Somar")) {
                resultado = n1 + n2;
            } else if (op.equals("Subtrair")) {
                resultado = n1 - n2;
            } else if (op.equals("Multiplicar")) {
                resultado = n1 * n2;
            } else if (op.equals("Dividir")) {
                resultado = n1 / n2;
            }

            if (mostrarPopup.isSelected()) {
                JOptionPane.showMessageDialog(
                    frame,
                    "Resultado: " + resultado
                );
            } else {
                labelResultado.setText("Resultado: " + resultado);
            }
        });

        // Adicionando componentes
        panel.add(new JLabel("Número 1:"));
        panel.add(campo1);

        panel.add(new JLabel("Número 2:"));
        panel.add(campo2);

        panel.add(combo);
        panel.add(mostrarPopup);
        panel.add(calcular);
        panel.add(labelResultado);

        frame.add(panel);
        frame.setVisible(true);
    }
}