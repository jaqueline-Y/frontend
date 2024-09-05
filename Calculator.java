import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

// Definição da classe Calculator que herda de JFrame, permitindo a criação de uma janela gráfica
public class Calculator extends JFrame {
    // Campos de texto onde o usuário digitará os números
    private final JTextField textField1;
    private final JTextField textField2;

    // Rótulos para identificar os campos de texto
    private final JLabel label1;
    private final JLabel label2;

    // Botão de calcular e rótulo para mostrar o resultado
    private final JButton btnCalcular;
    private final JLabel lblNotificacao;

    // Array contendo os números permitidos para verificar a entrada
    private final String[] numeros = {"1","2","3","4","5","6","7","8","9","0"};

    // Constante que define o limite máximo de caracteres permitidos nos campos de texto
    private final int tamanhoTextFields = 9;
 
    // Construtor da classe Calculator
    public Calculator()
    {
        super("Calculadora de soma");  // Define o título da janela
        setLayout(new GridLayout(3,2,5,5));  // Define o layout da janela com 3 linhas, 2 colunas e espaço entre os componentes

        // Inicializa e adiciona o rótulo e o campo de texto para o número 1
        label1 = new JLabel("Digite o número 1:", SwingConstants.RIGHT);
        add(label1);
        textField1 = new JTextField(10); 
        add(textField1);

        // Inicializa e adiciona o rótulo e o campo de texto para o número 2
        label2 = new JLabel("Digite o número 2:", SwingConstants.RIGHT);
        add(label2);
        textField2 = new JTextField(10);
        add(textField2);

        // Inicializa e adiciona o botão "Calcular"
        btnCalcular = new JButton("Calcular");
        add(btnCalcular);

        // Inicializa e adiciona o rótulo para exibir o resultado ou mensagens de notificação
        lblNotificacao = new JLabel("Resultado: ?");
        add(lblNotificacao);

        // Cria um handler para tratar o evento de clique no botão de cálculo
        TextFieldHandler handler = new TextFieldHandler();
        btnCalcular.addActionListener(handler);

        // Adiciona um KeyListener ao campo de texto 1 para limitar o número de caracteres digitados
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (textField1.getText().length() > tamanhoTextFields) {
                    // Se o texto digitado for maior que o limite, corta o excesso e exibe uma notificação
                    String txtTextField1 = textField1.getText();
                    textField1.setText(txtTextField1.substring(0,tamanhoTextFields));
                    lblNotificacao.setText("<html><body>Ops! Este campo está limitado a apenas 9 caracteres.</body></html>");
                }
            }
        });

        // Adiciona um KeyListener ao campo de texto 2 com a mesma função de limitar os caracteres
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (textField2.getText().length() > tamanhoTextFields) {
                    // Corta o excesso e exibe uma notificação se o limite for excedido
                    String txtTextField2 = textField2.getText();
                    textField2.setText(txtTextField2.substring(0,tamanhoTextFields));
                    lblNotificacao.setText("<html><body>Ops! Este campo está limitado a apenas 9 caracteres.</body></html>");
                }
            }
        });
    }

    // Classe interna para tratar eventos quando o botão de calcular for pressionado
    private class TextFieldHandler implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            // Verifica se o campo 1 está vazio
            if (textField1.getText().trim().length() == 0) {
                lblNotificacao.setText("O campo 1 está vazio!");  // Exibe uma notificação
                textField1.requestFocus();  // Coloca o foco no campo 1 para o usuário preenchê-lo
            } else {
                // Verifica se o campo 2 está vazio
                if (textField2.getText().trim().length() == 0) {
                    lblNotificacao.setText("O campo 2 está vazio!");  // Exibe uma notificação
                    textField2.requestFocus();  // Coloca o foco no campo 2
                } else {
                    // Tenta realizar a soma dos valores digitados
                    try {
                        // Remove caracteres não numéricos antes de realizar a soma
                        textField1.setText(somenteNumeros(textField1.getText()));
                        textField2.setText(somenteNumeros(textField2.getText()));
                        
                        // Converte os textos para inteiros e realiza a soma
                        int soma = Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText());
                        
                        // Exibe o resultado da soma
                        lblNotificacao.setText(String.format("Resultado: %s", soma));
                    } catch (Exception e) {
                        // Exibe uma notificação de erro se a entrada não for válida
                        lblNotificacao.setText("<html><body>Ops! Parece que foi digitado alguma coisa errada, favor revisar a digitação, pois podem ser digitados apenas números inteiros.</body></html>");
                    }
                }
            }
        }

        // Método que remove todos os caracteres não numéricos de uma string
        public String somenteNumeros(String strTexto) {
            boolean achouNumero;
            ArrayList<String> caracteresEncontrados = new ArrayList<String>();
            
            // Percorre cada caractere da string e verifica se é um número
            for (int c = 0; c < strTexto.length(); c++) {
                String caracterTemp = strTexto.substring(c,c+1);
                achouNumero = false;
                
                // Verifica se o caractere atual é um número permitido
                for (int n = 0; n < numeros.length; n++) {
                    if (caracterTemp.equals(numeros[n])) {
                        achouNumero = true;
                        break;
                    }
                }
                
                // Se não for número, adiciona o caractere na lista de caracteres a serem removidos
                if (!achouNumero) {
                    caracteresEncontrados.add(caracterTemp);
                }
            }
            
            // Remove todos os caracteres não numéricos encontrados
            for (int c = 0; c < caracteresEncontrados.size(); c++) {
                strTexto = strTexto.replace(caracteresEncontrados.get(c), "");
            }
            return strTexto;  // Retorna a string contendo apenas números
        }
    }

    // Método principal que inicia a aplicação
    public static void main(String[] args)
    { 
        Calculator calculator = new Calculator();  // Cria uma instância da classe Calculator
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Define a ação ao fechar a janela
        calculator.setSize(450, 400);  // Define o tamanho da janela
        calculator.setVisible(true);  // Torna a janela visível
    } 
}
