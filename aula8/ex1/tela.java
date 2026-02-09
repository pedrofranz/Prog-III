package aula8.ex1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tela {
    public static void main(String[] args) {
        JFrame meuJFrame = new JFrame("Primeira tela");
        meuJFrame.setSize(500, 300);
        meuJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel meuJpanel = new JPanel();

        JLabel meuJLabel = new JLabel("Bem vindos");

        JButton fechar = new JButton("Fechar");
        fechar.addActionListener(e -> meuJFrame.dispose());

        //Adicionando componentes
        meuJpanel.add(meuJLabel);
        meuJpanel.add(fechar);
        meuJFrame.add(meuJpanel);
        meuJFrame.setVisible(true);
    }
}
