import java.awt.*; // Importa a biblioteca AWT para criar componentes gráficos
import java.awt.event.*; // Importa eventos AWT
import javax.swing.*; // Importa a biblioteca Swing para criar interfaces gráficas

public class TelaDeAtualizacao extends JFrame { // Classe principal que estende JFrame
    // Declaração de componentes da interface
    public static JLabel lblId; // Rótulo para ID
    public static JComboBox<String> cbxId; // Combo box para selecionar o ID
    public static String[] ids; // Array para armazenar IDs

    public static JLabel lblNome; // Rótulo para Nome
    public static JTextField txtNome; // Campo de texto para entrada do Nome
    public static String nomeAtual;

    public static JLabel lblEmail; // Rótulo para Email
    public static JTextField txtEmail; // Campo de texto para entrada do Email
    public static String emailAtual;

    public static JLabel lblSenha; // Rótulo para Senha
    public static JPasswordField txtSenha; // Campo de senha para entrada da Senha
    public static String senhaAtual;

    public static JLabel lblNotificacoes; // Rótulo para notificações

    public static JButton btnAtualizar; // Botão para atualizar dados
    public static JButton btnCancelar; // Botão para cancelar a operação

    public static int tamanhoInputs = 20; // Tamanho dos campos de entrada

    public TelaDeAtualizacao() { // Construtor da classe

        super("Tela de Atualização"); // Título da janela
        setLayout(new GridLayout(6, 1, 5, 5)); // Define o layout da janela

        // Painel para linha de ID
        JPanel linha_id = new JPanel(new GridLayout(1, 2));
        lblId = new JLabel("Id:", SwingConstants.RIGHT); // Rótulo para ID
        linha_id.add(lblId); // Adiciona rótulo ao painel

        NavegadorDeRegistro.popularIds(); // Popula os IDs
        cbxId = new JComboBox<>(ids); // Cria combo box com IDs
        linha_id.add(cbxId); // Adiciona combo box ao painel

        add(linha_id); // Adiciona painel de ID à janela

        // Painel para linha de Nome
        JPanel linha_nome = new JPanel(new GridLayout(1, 2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Rótulo para Nome
        linha_nome.add(lblNome); // Adiciona rótulo ao painel

        txtNome = new JTextField(tamanhoInputs); // Campo de texto para Nome
        linha_nome.add(txtNome); // Adiciona campo de texto ao painel

        add(linha_nome); // Adiciona painel de Nome à janela

        // Painel para linha de Email
        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Rótulo para Email
        linha_email.add(lblEmail); // Adiciona rótulo ao painel

        txtEmail = new JTextField(tamanhoInputs); // Campo de texto para Email
        linha_email.add(txtEmail); // Adiciona campo de texto ao painel

        add(linha_email); // Adiciona painel de Email à janela

        // Painel para linha de Senha
        JPanel linha_senha = new JPanel(new GridLayout(1, 2));

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT); // Rótulo para Senha
        linha_senha.add(lblSenha); // Adiciona rótulo ao painel

        txtSenha = new JPasswordField(tamanhoInputs); // Campo de senha
        linha_senha.add(txtSenha); // Adiciona campo de senha ao painel

        add(linha_senha); // Adiciona painel de Senha à janela

        // Painel para os botões
        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));

        btnAtualizar = new JButton("Atualizar"); // Botão para atualizar
        linha_botoes.add(btnAtualizar); // Adiciona botão de atualizar ao painel

        btnCancelar = new JButton("Cancelar"); // Botão para cancelar
        linha_botoes.add(btnCancelar); // Adiciona botão de cancelar ao painel

        add(linha_botoes); // Adiciona painel de botões à janela

        // Painel para notificações
        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));
        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Rótulo de notificações
        linha_notificacoes.add(lblNotificacoes); // Adiciona rótulo ao painel

        add(linha_notificacoes); // Adiciona painel de notificações à janela

        // Ação do botão Atualizar
        btnAtualizar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.atualizarId();// Aqui você pode adicionar a lógica para atualizar os dados
                }
            }
        );

        // Ação do botão Cancelar
        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.limparCampos();// Aqui você pode adicionar a lógica para cancelar a operação
                }
            }
        );

        // Ação ao selecionar um ID na combo box
        cbxId.addItemListener(
            new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        NavegadorDeRegistro.atualizarCampos(cbxId.getSelectedItem().toString());
                        // Aqui você pode atualizar os campos com base no ID selecionado
                    }
                } 
            }
        );

        // Configurações da janela
        setSize(250, 300); // Define o tamanho da janela
        ImageIcon img = new ImageIcon("./senac-logo.png"); // Define o ícone da janela
        setIconImage(img.getImage()); // Aplica o ícone à janela
        setVisible(true); // Torna a janela visível
        cbxId.requestFocus(); // Define o foco no combo box de ID
    }

    // Método para formatar texto em HTML
    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    // Método principal para executar a aplicação
    public static void main(String[] args) {
        TelaDeAtualizacao appTelaDeAtualizacao = new TelaDeAtualizacao(); // Cria uma instância da janela
        appTelaDeAtualizacao.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela
    }
}
