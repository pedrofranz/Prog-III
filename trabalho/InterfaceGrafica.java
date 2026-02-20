import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class InterfaceGrafica extends JFrame {

    private JComboBox<String> comboTipos;
    private JPanel painelCampos;
    private JButton btnCalcular;
    private JLabel lblResultado;

    // Mapeia cada forma para os nomes dos campos necessários
    private Map<String, String[]> camposPorForma;

    public InterfaceGrafica() {
        setTitle("Calculadora de Áreas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Inicializa o mapa de campos
        inicializarCampos();

        // Componente de seleção da forma
        comboTipos = new JComboBox<>(new String[]{
                "Círculo", "Quadrado", "Retângulo", "Triângulo",
                "Losango", "Hipercubo", "Paraboloide", "Trapézio"
        });
        comboTipos.addActionListener(e -> atualizarPainelCampos());

        // Painel que conterá os campos dinâmicos
        painelCampos = new JPanel(new GridLayout(0, 2, 5, 5));
        painelCampos.setBorder(BorderFactory.createTitledBorder("Parâmetros"));

        // Botão de calcular
        btnCalcular = new JButton("Calcular Área");
        btnCalcular.addActionListener(e -> calcularArea());

        // Rótulo para exibir o resultado
        lblResultado = new JLabel("Área: ");
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);

        // Montagem da janela
        JPanel topo = new JPanel();
        topo.add(new JLabel("Forma:"));
        topo.add(comboTipos);

        add(topo, BorderLayout.NORTH);
        add(painelCampos, BorderLayout.CENTER);
        add(btnCalcular, BorderLayout.SOUTH);
        add(lblResultado, BorderLayout.SOUTH); // Ajuste: colocar abaixo do botão? Melhor usar outro painel.

        // Para organizar melhor, vamos criar um painel inferior com botão e resultado
        JPanel inferior = new JPanel(new BorderLayout());
        inferior.add(btnCalcular, BorderLayout.CENTER);
        inferior.add(lblResultado, BorderLayout.SOUTH);
        add(inferior, BorderLayout.SOUTH);

        // Exibe os campos iniciais
        atualizarPainelCampos();
    }

    private void inicializarCampos() {
        camposPorForma = new HashMap<>();
        camposPorForma.put("Círculo", new String[]{"Raio"});
        camposPorForma.put("Quadrado", new String[]{"Lado"});
        camposPorForma.put("Retângulo", new String[]{"Base", "Altura"});
        camposPorForma.put("Triângulo", new String[]{"Base", "Altura"});
        camposPorForma.put("Losango", new String[]{"Diagonal Maior", "Diagonal Menor"});
        camposPorForma.put("Hipercubo", new String[]{"Nº Dimensões", "Aresta"});
        camposPorForma.put("Paraboloide", new String[]{"Curvatura", "Raio Máximo"});
        camposPorForma.put("Trapézio", new String[]{"Base Maior", "Base Menor", "Altura"});
    }

    private void atualizarPainelCampos() {
        painelCampos.removeAll();
        String formaSelecionada = (String) comboTipos.getSelectedItem();
        String[] campos = camposPorForma.get(formaSelecionada);

        for (String campo : campos) {
            painelCampos.add(new JLabel(campo + ":"));
            painelCampos.add(new JTextField(10));
        }

        // Revalidar e repintar o painel
        painelCampos.revalidate();
        painelCampos.repaint();
    }

    private void calcularArea() {
        try {
            String formaSelecionada = (String) comboTipos.getSelectedItem();
            Forma forma = null;

            // Obter os valores dos campos de texto
            Component[] componentes = painelCampos.getComponents();
            double[] valores = new double[componentes.length / 2];
            int idx = 0;
            for (int i = 1; i < componentes.length; i += 2) {
                JTextField campo = (JTextField) componentes[i];
                valores[idx++] = Double.parseDouble(campo.getText().trim());
            }

            // Instanciar a forma correspondente
            switch (formaSelecionada) {
                case "Círculo":
                    forma = new Circulo(valores[0]);
                    break;
                case "Quadrado":
                    forma = new Quadrado(valores[0]);
                    break;
                case "Retângulo":
                    forma = new Retangulo(valores[0], valores[1]);
                    break;
                case "Triângulo":
                    forma = new Triangulo(valores[0], valores[1]);
                    break;
                case "Losango":
                    forma = new Losango(valores[0], valores[1]);
                    break;
                case "Hipercubo":
                    // O primeiro valor é número de dimensões (deve ser int)
                    forma = new Hipercubo((int) valores[0], valores[1]);
                    break;
                case "Paraboloide":
                    forma = new Paraboloide(valores[0], valores[1]);
                    break;
                case "Trapézio":
                    forma = new Trapezio(valores[0], valores[1], valores[2]);
                    break;
            }

            double area = forma.calculaArea();
            lblResultado.setText("Área: " + area);
            lblResultado.setForeground(Color.BLACK);

        } catch (NumberFormatException ex) {
            lblResultado.setText("Erro: digite números válidos.");
            lblResultado.setForeground(Color.RED);
        } catch (IllegalArgumentException ex) {
            lblResultado.setText("Erro: " + ex.getMessage());
            lblResultado.setForeground(Color.RED);
        } catch (Exception ex) {
            lblResultado.setText("Erro inesperado.");
            lblResultado.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfaceGrafica().setVisible(true));
    }
}