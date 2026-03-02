package areacalculator.view;

// Importa todas as classes de formas geométricas do pacote model.formas
import areacalculator.model.formas.*;

// Imports para componentes gráficos Swing e manipulação de eventos
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe que representa a interface gráfica da calculadora de áreas.
 * Permite ao usuário selecionar uma forma, informar os parâmetros
 * e calcular a área, ou somar áreas de formas pré-definidas.
 */

public class InterfaceGrafica extends JFrame {
    // Componentes da interface
    private JComboBox<String> comboTipos;          // Combo box para selecionar a forma
    private JPanel painelCampos;                    // Painel que conterá os campos dinâmicos
    private JButton btnCalcular;                     // Botão para calcular área da forma atual
    private JButton btnSomar;                        // Botão para somar áreas pré-definidas
    private JLabel lblResultado;                     // Rótulo para exibir o resultado

    // Mapa que associa cada forma (nome) aos nomes dos campos que ela necessita
    private Map<String, String[]> camposPorForma;

    /**
     * Construtor da janela. Configura título, tamanho, layout e adiciona os componentes.
     */
    public InterfaceGrafica() {
        setTitle("Calculadora de Áreas");                // Título da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerra o programa ao fechar
        setSize(500, 400);                               // Largura x Altura
        setLocationRelativeTo(null);                     // Centraliza na tela
        setLayout(new BorderLayout(10, 10));              // Layout com espaçamento de 10px

        // Cor de fundo da janela (cinza claro)
        getContentPane().setBackground(new Color(240, 240, 240));

        // Inicializa o mapa de campos (quais parâmetros cada forma precisa)
        inicializarCampos();

        // Define fontes para os componentes
        Font fonteRotulo = new Font("SansSerif", Font.BOLD, 14);
        Font fonteBotao = new Font("SansSerif", Font.BOLD, 14);
        Font fonteCampo = new Font("SansSerif", Font.PLAIN, 14);

        // Cria a combo box com as opções de formas
        comboTipos = new JComboBox<>(new String[]{
                "Círculo", "Quadrado", "Retângulo", "Triângulo",
                "Losango", "Hipercubo", "Paraboloide", "Trapézio"
        });
        comboTipos.setFont(fonteCampo);
        comboTipos.setBackground(Color.WHITE);
        // Quando o usuário mudar a seleção, o painel de campos é atualizado
        comboTipos.addActionListener(e -> atualizarPainelCampos());

        // Painel que conterá os campos de entrada (será preenchido dinamicamente)
        painelCampos = new JPanel(new GridLayout(0, 2, 10, 10)); // linhas variáveis, 2 colunas
        painelCampos.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(70, 130, 180), 2),
                "Parâmetros",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                fonteRotulo,
                new Color(70, 130, 180)
        ));
        painelCampos.setBackground(Color.WHITE);

        // Botão "Calcular Área" (para a forma selecionada com os valores informados)
        btnCalcular = new JButton("Calcular Área");
        btnCalcular.setFont(fonteBotao);
        btnCalcular.setBackground(new Color(70, 130, 200));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFocusPainted(false);               // Remove contorno de foco
        btnCalcular.setBorder(new EmptyBorder(10, 20, 10, 20));
        btnCalcular.addActionListener(e -> calcularArea());

        // Botão "Somar Áreas Pré-definidas" (usa valores fixos do enunciado)
        btnSomar = new JButton("Somar Áreas Pré-definidas");
        btnSomar.setFont(fonteBotao);
        btnSomar.setBackground(new Color(34, 139, 34));    // Verde
        btnSomar.setForeground(Color.WHITE);
        btnSomar.setFocusPainted(false);
        btnSomar.setBorder(new EmptyBorder(10, 20, 10, 20));
        btnSomar.addActionListener(e -> somarAreasPreDefinidas());

        // Rótulo para exibir o resultado (ou mensagens de erro)
        lblResultado = new JLabel("Área: ");
        lblResultado.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultado.setBorder(new EmptyBorder(10, 0, 10, 0));

        // Painel superior com a seleção da forma
        JPanel topo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topo.setBackground(new Color(240, 240, 240));
        JLabel lblForma = new JLabel("Forma:");
        lblForma.setFont(fonteRotulo);
        topo.add(lblForma);
        topo.add(comboTipos);

        // Painel que agrupa os dois botões lado a lado
        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 10, 0));
        painelBotoes.setBackground(new Color(240, 240, 240));
        painelBotoes.add(btnCalcular);
        painelBotoes.add(btnSomar);

        // Painel inferior que contém os botões e abaixo o resultado
        JPanel inferior = new JPanel(new BorderLayout());
        inferior.setBackground(new Color(240, 240, 240));
        inferior.add(painelBotoes, BorderLayout.CENTER);
        inferior.add(lblResultado, BorderLayout.SOUTH);

        // Adiciona os painéis à janela (norte, centro, sul)
        add(topo, BorderLayout.NORTH);
        add(painelCampos, BorderLayout.CENTER);
        add(inferior, BorderLayout.SOUTH);

        // Adiciona uma margem interna em toda a janela
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

        // Preenche o painel de campos de acordo com a forma inicialmente selecionada
        atualizarPainelCampos();
    }

    /**
     * Inicializa o mapa que relaciona cada forma à lista de nomes de campos que ela exige.
     */
    private void inicializarCampos() {
        camposPorForma = new HashMap<>();
        camposPorForma.put("Círculo", new String[]{"Raio"});
        camposPorForma.put("Quadrado", new String[]{"Lado"});
        camposPorForma.put("Retângulo", new String[]{"Base", "Altura"});
        camposPorForma.put("Triângulo", new String[]{"Base", "Altura"});
        camposPorForma.put("Losango", new String[]{"Diagonal Maior", "Diagonal Menor"});
        camposPorForma.put("Hipercubo", new String[]{"Nº Dimensões (inteiro)", "Aresta"});
        camposPorForma.put("Paraboloide", new String[]{"Curvatura", "Raio Máximo"});
        camposPorForma.put("Trapézio", new String[]{"Base Maior", "Base Menor", "Altura"});
    }

    /**
     * Atualiza o painel de campos de acordo com a forma selecionada na combo.
     * Remove os campos antigos e adiciona os novos (rótulo + caixa de texto).
     */
    private void atualizarPainelCampos() {
        painelCampos.removeAll();   // Limpa o painel
        String formaSelecionada = (String) comboTipos.getSelectedItem();
        String[] campos = camposPorForma.get(formaSelecionada);

        // Para cada campo necessário, cria um rótulo e uma caixa de texto
        for (String campo : campos) {
            JLabel label = new JLabel(campo + ":");
            label.setFont(new Font("SansSerif", Font.BOLD, 14));
            painelCampos.add(label);

            JTextField textField = new JTextField(10);
            textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
            painelCampos.add(textField);
        }

        // Reorganiza o layout e redesenha o painel
        painelCampos.revalidate();
        painelCampos.repaint();
    }

    /**
     * Lê os valores digitados, instancia a forma correspondente e calcula a área.
     * Exibe o resultado ou uma mensagem de erro no rótulo.
     */
    private void calcularArea() {
        try {
            String formaSelecionada = (String) comboTipos.getSelectedItem();
            Forma forma = null;

            // Obtém todos os componentes do painelCampos
            Component[] componentes = painelCampos.getComponents();
            double[] valores = new double[componentes.length / 2];
            int idx = 0;
            // Percorre apenas as caixas de texto (índices ímpares)
            for (int i = 1; i < componentes.length; i += 2) {
                JTextField campo = (JTextField) componentes[i];
                valores[idx++] = Double.parseDouble(campo.getText().trim());
            }

            // Cria a forma específica com base na seleção
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
                    // Verifica se o número de dimensões é inteiro (não pode ter decimal)
                    if (valores[0] != Math.floor(valores[0])) {
                        throw new IllegalArgumentException("Número de dimensões deve ser um inteiro.");
                    }
                    forma = new Hipercubo((int) valores[0], valores[1]);
                    break;
                case "Paraboloide":
                    forma = new Paraboloide(valores[0], valores[1]);
                    break;
                case "Trapézio":
                    forma = new Trapezio(valores[0], valores[1], valores[2]);
                    break;
            }

            // Calcula a área e exibe formatada com duas casas decimais
            double area = forma.calculaArea();
            lblResultado.setText(String.format("Área: %.2f", area));
            lblResultado.setForeground(new Color(0, 100, 0)); // verde escuro

        } catch (NumberFormatException ex) {
            // Erro quando o usuário digita algo que não é número
            lblResultado.setText("Erro: digite números válidos.");
            lblResultado.setForeground(Color.RED);
        } catch (IllegalArgumentException ex) {
            // Erro de validação (ex: raio negativo)
            lblResultado.setText("Erro: " + ex.getMessage());
            lblResultado.setForeground(Color.RED);
        } catch (Exception ex) {
            // Qualquer outro erro inesperado
            lblResultado.setText("Erro inesperado.");
            lblResultado.setForeground(Color.RED);
        }
    }

    /**
     * Calcula a soma das áreas de um conjunto fixo de formas (mesmo do modo console)
     * e exibe o resultado.
     */
    private void somarAreasPreDefinidas() {
        try {
            // Lista de formas com valores pré-definidos (iguais aos do console)
            java.util.List<Forma> formas = new ArrayList<>();
            formas.add(new Circulo(3));
            formas.add(new Quadrado(4));
            formas.add(new Retangulo(3, 6));
            formas.add(new Triangulo(5, 2));
            formas.add(new Losango(6, 4));
            formas.add(new Hipercubo(4, 2));
            formas.add(new Paraboloide(0.5, 3));
            formas.add(new Trapezio(10, 6, 4));

            // Soma as áreas
            double soma = 0;
            for (Forma f : formas) {
                soma += f.calculaArea();
            }

            // Exibe o resultado formatado
            lblResultado.setText(String.format("Soma das áreas pré-definidas: %.2f", soma));
            lblResultado.setForeground(new Color(0, 100, 0));

        } catch (Exception ex) {
            lblResultado.setText("Erro ao somar áreas.");
            lblResultado.setForeground(Color.RED);
        }
    }

    /**
     * Método principal (ponto de entrada da interface gráfica).
     * Tenta aplicar o look and feel Nimbus (mais bonito) e depois abre a janela.
     */
    public static void main(String[] args) {
        // Tenta usar o Nimbus Look and Feel (disponível em versões recentes do Java)
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Se não conseguir, mantém o look and feel padrão (não faz nada)
        }

        // Inicia a interface gráfica na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> new InterfaceGrafica().setVisible(true));
    }
}