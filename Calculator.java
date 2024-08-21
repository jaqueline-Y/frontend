import java.awt.*; // Importa a biblioteca AWT para criar interfaces gráficas.
import java.awt.event.*; // Importa a biblioteca de eventos AWT.
import javax.swing.*; // Importa a biblioteca Swing para componentes gráficos.

public class Calculator extends JFrame { // Define a classe Calculator que estende JFrame.
    private final JTextField textField1; // Declara um campo de texto (não editável) chamado textField1.
    private final JTextField textField2; // Declara um campo de texto (editável) chamado textField2.

    private final JLabel label1;
    private final JLabel label2;

    private final JButton btnCalcular;
    private final JLabel lblNotificacao;


    public Calculator() // Construtor da classe Calculator.
       {
        super("Calculadora de soma"); // Define o título da janela.
        setLayout(new GridLayout(3,2,5,5)); // Define o layout dos componentes como FlowLayout.

        label1 = new JLabel ("Digite o número 1:", SwingConstants.RIGHT); // Cria um campo de texto com 10 colunas de largura.
        add(label1); // Adiciona textField1 à janela.
        textField1 = new JTextField(10);
        add(textField1);

        label2 = new JLabel("Digite o número 2:", SwingConstants.RIGHT); // Cria um campo de texto com um texto inicial.
        add(label2); // Adiciona textField2 à janela.
        textField2 = new JTextField(10);
        add(textField2);

        btnCalcular = new JButton ("Calcular");
        add(btnCalcular);
        lblNotificacao = new JLabel ("Resultado");
        add(lblNotificacao);

        TextFieldHandler handler = new TextFieldHandler(); // Cria uma instância do manipulador de eventos TextFieldHandler.
        btnCalcular.addActionListener(handler); // Adiciona o manipulador de eventos ao textField1.
    }

    private class TextFieldHandler implements ActionListener { // Define uma classe interna que implementa ActionListener.
        @Override
        public void actionPerformed(ActionEvent event) { // Método chamado quando um evento de ação ocorre.

               if (textField1.getText(). trim () .length == 0) {
                // Noticar usuário que o campo 1 está vazio
                lblNotificacao.setText("O campo 1 está vazio!");
                textField1.requestFocus();
                } else {
                if (textField2.getText(). trim () .length == 0) {
                        // Noticar usuário que o campo 2 está vazio
                        lblNotificacao.setText("O campo 2 está vazio!");
                        textField2.requestFocus();        
                } else {
                    // Aqui será feita a soma
                    try {
                    int soma = Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText());
                    lblNotificacao.setText(String.format("Resultado : %s", soma));
                    } catch (Exception e) {
                    lblNotificacao.setText("<html><body>Ops! Parece que foi digitado alguma coisa errada, favor revisar a digitação, pois podem ser digitados apenas números inteiros.</body></html>");
                    }
                }
        }
        }
    }

    public static void main(String[] args) { // Método principal que inicia o programa.
        Calculator calculator = new Calculator(); // Cria uma instância da classe Calculator.
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação padrão de fechamento da janela.
        calculator.setSize(450, 400); // Define o tamanho da janela.
        calculator.setVisible(true); // Torna a janela visível.
    }
}