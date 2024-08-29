import java.awt.*; // Importa classes relacionadas a gráficos e layout
import java.awt.event.*; // Importa classes para tratamento de eventos
import javax.swing.*; // Importa classes para a interface gráfica baseada em Swing

// Define a classe RadioButtonFrame, que estende JFrame para criar uma janela
public class RadioButtonFrame extends JFrame
{
    // Declara variáveis de instância para os componentes e propriedades
    private JTextField textField;

    private Font plainFont; // Fonte normal
    private Font boldFont; // Fonte negrito
    private Font italicFont; // Fonte itálico
    private Font boldItalicFont; // Fonte negrito e itálico

    private Color blueColor; // Cor azul
    private Color redColor; // Cor vermelha
    private Color yellowColor; // Cor amarela
    private Color blackColor; // Cor preta

    private JRadioButton plainJRadioButton; // Botão de rádio para fonte normal
    private JRadioButton boldJRadioButton; // Botão de rádio para fonte negrito
    private JRadioButton italicJRadioButton; // Botão de rádio para fonte itálico
    private JRadioButton boldItalicJRadioButton; // Botão de rádio para fonte negrito e itálico
    private ButtonGroup radioGroup; // Grupo de botões de rádio para fontes

    private JRadioButton blueJRadioButton; // Botão de rádio para cor azul
    private JRadioButton redJRadioButton; // Botão de rádio para cor vermelha
    private JRadioButton yellowJRadioButton; // Botão de rádio para cor amarela
    private JRadioButton blackJRadioButton; // Botão de rádio para cor preta
    private ButtonGroup colorRadioGroup; // Grupo de botões de rádio para cores

    // Construtor da classe RadioButtonFrame
    public RadioButtonFrame()
    {
        super("RadioButton Test"); // Define o título da janela
        setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout

        textField = new JTextField("Watch the font style change", 25); // Cria um JTextField com texto inicial
        add(textField); // Adiciona o JTextField à janela

        // Cria e adiciona os botões de rádio para estilo de fonte
        plainJRadioButton = new JRadioButton("Plain", true); // Botão de rádio para fonte normal, selecionado por padrão
        boldJRadioButton = new JRadioButton("Bold", false); // Botão de rádio para fonte negrito
        italicJRadioButton = new JRadioButton("Italic", false); // Botão de rádio para fonte itálico
        boldItalicJRadioButton = new JRadioButton("Bold/Italic", false); // Botão de rádio para fonte negrito e itálico
        add(plainJRadioButton);
        add(boldJRadioButton);
        add(italicJRadioButton);
        add(boldItalicJRadioButton);

        radioGroup = new ButtonGroup(); // Cria um grupo de botões de rádio para estilos de fonte
        radioGroup.add(plainJRadioButton);
        radioGroup.add(boldJRadioButton);
        radioGroup.add(italicJRadioButton);
        radioGroup.add(boldItalicJRadioButton);

        // Cria e adiciona os botões de rádio para cores
        blueJRadioButton = new JRadioButton("Blue", false); // Botão de rádio para cor azul
        redJRadioButton = new JRadioButton("Red", false); // Botão de rádio para cor vermelha
        yellowJRadioButton = new JRadioButton("Yellow", false); // Botão de rádio para cor amarela
        blackJRadioButton = new JRadioButton("Black", true); // Botão de rádio para cor preta, selecionado por padrão
        add(blueJRadioButton);
        add(redJRadioButton);
        add(yellowJRadioButton);
        add(blackJRadioButton);

        colorRadioGroup = new ButtonGroup(); // Cria um grupo de botões de rádio para cores
        colorRadioGroup.add(blueJRadioButton);
        colorRadioGroup.add(redJRadioButton);
        colorRadioGroup.add(yellowJRadioButton);
        colorRadioGroup.add(blackJRadioButton);

        // Cria e define as fontes
        plainFont = new Font("Serif", Font.PLAIN, 14); // Fonte normal
        boldFont = new Font("Serif", Font.BOLD, 14); // Fonte negrito
        italicFont = new Font("Serif", Font.ITALIC, 14); // Fonte itálico
        boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // Fonte negrito e itálico
        textField.setFont(plainFont); // Define a fonte inicial do JTextField

        // Cria e define as cores
        blueColor = new Color(0, 0, 255); // Cor azul
        redColor = new Color(255, 0, 0); // Cor vermelha
        yellowColor = new Color(255, 255, 0); // Cor amarela
        blackColor = new Color(0, 0, 0); // Cor preta

        // Adiciona os ouvintes de eventos aos botões de rádio de estilo de fonte
        plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
        boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont));
        italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont));
        boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));

        // Adiciona os ouvintes de eventos aos botões de rádio de cor
        blueJRadioButton.addItemListener(new ColorRadioButtonHandler(blueColor));
        redJRadioButton.addItemListener(new ColorRadioButtonHandler(redColor));
        yellowJRadioButton.addItemListener(new ColorRadioButtonHandler(yellowColor));
        blackJRadioButton.addItemListener(new ColorRadioButtonHandler(blackColor));
    }

    // Classe interna para tratar eventos de mudança de estilo de fonte
    private class RadioButtonHandler implements ItemListener
    {
        private Font font; // Fonte a ser aplicada

        public RadioButtonHandler(Font f) {
            font = f; // Inicializa a fonte
        }

        @Override
        public void itemStateChanged(ItemEvent event) {
            textField.setFont(font); // Atualiza a fonte do JTextField
        }
    }

    // Classe interna para tratar eventos de mudança de cor
    private class ColorRadioButtonHandler implements ItemListener
    {
        private Color color; // Cor a ser aplicada

        public ColorRadioButtonHandler(Color c) {
            color = c; // Inicializa a cor
        }

        @Override
        public void itemStateChanged(ItemEvent event) {
            textField.setForeground(color); // Atualiza a cor do texto do JTextField
        }
    }
}
