package aula8.ex2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class janela {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel labelUser = new JLabel("Usuário:");
        JTextField campoUser = new JTextField(15);

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField(15);

        JButton entrar = new JButton("Entrar");

        entrar.addActionListener(e -> {
            String nome = campoUser.getText();
            JOptionPane.showMessageDialog(
                frame,
                "Bem-vindo, " + nome + "!",
                "Mensagem",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        // Adicionando componentes
        panel.add(labelUser);
        panel.add(campoUser);
        panel.add(labelSenha);
        panel.add(campoSenha);
        panel.add(entrar);

        frame.add(panel);
        frame.setVisible(true);
    }
}
