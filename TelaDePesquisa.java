import java.awt.*; // Importa classes para construção da interface gráfica.
import java.awt.event.*; // Importa classes para lidar com eventos de entrada.
import javax.swing.*; // Importa classes para componentes da interface gráfica.
// import java.sql.*; // Importa classes para conexão com banco de dados (não usado neste trecho).

public class TelaDePesquisa extends JFrame {
    // Declaração de componentes da interface gráfica.
    public static JLabel lblPesquisa;
    public static JTextField txtPesquisa;

    public static JLabel lblId;
    public static JTextField txtId;

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JButton btnPesquisar;
    public static JButton btnPrimeiro;
    public static JButton btnAnterior;
    public static JButton btnProximo;
    public static JButton btnUltimo;

    public static JLabel lblNotificacoes;

    public static int tamanhoInputs = 20; // Define o tamanho dos campos de entrada.
    public static String txtUsuario = ""; // Armazena o texto do usuário.

    // Construtor da classe TelaDePesquisa.
    public TelaDePesquisa() {
        super("Tela de Pesquisa"); // Define o título da janela.
        setLayout(new GridLayout(7, 1, 5, 5)); // Define o layout da janela com 7 linhas e 1 coluna.

        // Painel para o rótulo e botão de pesquisa.
        JPanel linha_lblPesquisa = new JPanel(new GridLayout(1, 2));

        lblPesquisa = new JLabel("Pesquisa:", SwingConstants.CENTER); // Rótulo para pesquisa.
        linha_lblPesquisa.add(lblPesquisa); // Adiciona o rótulo ao painel.

        btnPesquisar = new JButton("🔍"); // Botão de pesquisa.
        btnPesquisar.setToolTipText("Pesquisar"); // Dica ao passar o mouse.
        btnPesquisar.setEnabled(false); // Botão desabilitado inicialmente.
        linha_lblPesquisa.add(btnPesquisar); // Adiciona o botão ao painel.

        add(linha_lblPesquisa); // Adiciona o painel à janela.

        // Painel para o campo de entrada de pesquisa.
        JPanel linha_inputPesquisa = new JPanel(new GridLayout(1, 1));
        txtPesquisa = new JTextField(tamanhoInputs); // Campo de texto para pesquisa.
        linha_inputPesquisa.add(txtPesquisa); // Adiciona o campo ao painel.

        add(linha_inputPesquisa); // Adiciona o painel à janela.

        // Painel para o rótulo e campo de ID.
        JPanel linha_id = new JPanel(new GridLayout(1, 2));
        lblId = new JLabel("Id:", SwingConstants.RIGHT); // Rótulo para ID.
        linha_id.add(lblId); // Adiciona o rótulo ao painel.

        txtId = new JTextField(tamanhoInputs); // Campo de texto para ID.
        txtId.setEnabled(false); // Campo desabilitado (apenas leitura).
        linha_id.add(txtId); // Adiciona o campo ao painel.

        add(linha_id); // Adiciona o painel à janela.

        // Painel para o rótulo e campo de Nome.
        JPanel linha_nome = new JPanel(new GridLayout(1, 2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Rótulo para Nome.
        linha_nome.add(lblNome); // Adiciona o rótulo ao painel.

        txtNome = new JTextField(tamanhoInputs); // Campo de texto para Nome.
        txtNome.setEditable(false); // Campo desabilitado (apenas leitura).
        linha_nome.add(txtNome); // Adiciona o campo ao painel.

        add(linha_nome); // Adiciona o painel à janela.

        // Painel para o rótulo e campo de Email.
        JPanel linha_email = new JPanel(new GridLayout(1, 2));
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Rótulo para Email.
        linha_email.add(lblEmail); // Adiciona o rótulo ao painel.

        txtEmail = new JTextField(10); // Campo de texto para Email (tamanho 10).
        txtEmail.setEditable(false); // Campo desabilitado (apenas leitura).
        linha_email.add(txtEmail); // Adiciona o campo ao painel.

        add(linha_email); // Adiciona o painel à janela.

        // Painel para os botões de navegação.
        JPanel linha_botoes = new JPanel(new GridLayout(1, 4));
        btnPrimeiro = new JButton("<<"); // Botão para ir ao primeiro registro.
        btnPrimeiro.setEnabled(false); // Botão desabilitado inicialmente.
        linha_botoes.add(btnPrimeiro); // Adiciona o botão ao painel.

        btnAnterior = new JButton("<"); // Botão para ir ao registro anterior.
        btnAnterior.setEnabled(false); // Botão desabilitado inicialmente.
        linha_botoes.add(btnAnterior); // Adiciona o botão ao painel.

        btnProximo = new JButton(">"); // Botão para ir ao próximo registro.
        btnProximo.setEnabled(false); // Botão desabilitado inicialmente.
        linha_botoes.add(btnProximo); // Adiciona o botão ao painel.

        btnUltimo = new JButton(">>"); // Botão para ir ao último registro.
        btnUltimo.setEnabled(false); // Botão desabilitado inicialmente.
        linha_botoes.add(btnUltimo); // Adiciona o botão ao painel.

        add(linha_botoes); // Adiciona o painel à janela.

        // Painel para exibir notificações.
        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));
        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Rótulo para notificações.
        linha_notificacoes.add(lblNotificacoes); // Adiciona o rótulo ao painel.

        add(linha_notificacoes); // Adiciona o painel à janela.

        // Adiciona ação ao botão de pesquisa.
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Verifica se o campo de pesquisa está vazio.
                if (txtPesquisa.getText().trim().length() <= 0) {
                    lblNotificacoes.setText(setHtmlFormat("Por favor, digite algo e tente novamente."));
                    txtPesquisa.requestFocus(); // Foca no campo de pesquisa.
                    return;
                } else {
                    // Chama o método de pesquisa na classe NavegadorDeRegistro.
                    NavegadorDeRegistro.pesquisar();
                }
            }
        });

        // Adiciona ação ao botão de ir ao primeiro registro.
        btnPrimeiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!ntfCampoVazio()) { // Verifica se o campo não está vazio.
                    NavegadorDeRegistro.primeiroRegistro();
                }
            }
        });

        // Adiciona ação ao botão de ir ao registro anterior.
        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!ntfCampoVazio()) { // Verifica se o campo não está vazio.
                    NavegadorDeRegistro.registroAnterior();
                }
            }
        });

        // Adiciona ação ao botão de ir ao próximo registro.
        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!ntfCampoVazio()) { // Verifica se o campo não está vazio.
                    NavegadorDeRegistro.proximoRegistro();
                }
            }
        });

        // Adiciona ação ao botão de ir ao último registro.
        btnUltimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!ntfCampoVazio()) { // Verifica se o campo não está vazio.
                    NavegadorDeRegistro.ultimoRegistro();
                }
            }
        });

        // Adiciona um listener para o campo de pesquisa.
        txtPesquisa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Verifica se o texto de pesquisa mudou.
                if (!txtPesquisa.getText().trim().equals(txtUsuario) && txtPesquisa.getText().trim().length() > 0) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Verifica se a tecla Enter foi pressionada.
                        NavegadorDeRegistro.pesquisar(); // Realiza a pesquisa.
                    }
                    btnPesquisar.setEnabled(true); // Habilita o botão de pesquisa.
                } else {
                    btnPesquisar.setEnabled(false); // Desabilita o botão se não houver mudanças.
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        limparCampos(); // Limpa os campos se Enter for pressionado.
                    }
                }
            }
        });

        setSize(250, 300); // Define o tamanho da janela.
        setVisible(true); // Torna a janela visível.
        txtPesquisa.requestFocus(); // Foca no campo de pesquisa ao abrir.
    }

    // Método para verificar se o campo de pesquisa está vazio.
    public static boolean ntfCampoVazio() {
        if (txtPesquisa.getText().trim().length() <= 0) {
            lblNotificacoes.setText(setHtmlFormat("Ops! Campo vazio. Por favor,
