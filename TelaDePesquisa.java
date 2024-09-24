import java.awt.*; // Importa classes para construção da interface gráfica.
import java.awt.event.*; // Importa classes para lidar com eventos de entrada.
import javax.swing.*; // Importa classes para componentes da interface gráfica.
// import java.sql.*; // Importa classes para conexão com banco de dados (não utilizado neste trecho).

public class TelaDePesquisa extends JFrame {
    // Declaração de componentes da interface gráfica.
    public static JLabel lblPesquisa; // Rótulo para pesquisa.
    public static JTextField txtPesquisa; // Campo de texto para entrada de pesquisa.

    public static JLabel lblId; // Rótulo para ID.
    public static JTextField txtId; // Campo de texto para exibir ID.

    public static JLabel lblNome; // Rótulo para Nome.
    public static JTextField txtNome; // Campo de texto para exibir Nome.

    public static JLabel lblEmail; // Rótulo para Email.
    public static JTextField txtEmail; // Campo de texto para exibir Email.

    public static JButton btnPesquisar; // Botão para iniciar a pesquisa.
    public static JButton btnPrimeiro; // Botão para ir ao primeiro registro.
    public static JButton btnAnterior; // Botão para ir ao registro anterior.
    public static JButton btnProximo; // Botão para ir ao próximo registro.
    public static JButton btnUltimo; // Botão para ir ao último registro.

    public static JLabel lblNotificacoes; // Rótulo para exibir notificações.

    public static int tamanhoInputs = 20; // Define o tamanho dos campos de entrada.
    public static String txtUsuario = ""; // Armazena o texto atual do campo de pesquisa.

    // Construtor da classe TelaDePesquisa.
    public TelaDePesquisa() {
        super("Tela de Pesquisa"); // Define o título da janela.
        setLayout(new GridLayout(7, 1, 5, 5)); // Define o layout da janela com 7 linhas e 1 coluna.

        // Painel para o rótulo e botão de pesquisa.
        JPanel linha_lblPesquisa = new JPanel(new GridLayout(1, 2));

        lblPesquisa = new JLabel("Pesquisa:", SwingConstants.CENTER); // Cria o rótulo para pesquisa.
        linha_lblPesquisa.add(lblPesquisa); // Adiciona o rótulo ao painel.

        btnPesquisar = new JButton("🔍"); // Cria o botão de pesquisa.
        btnPesquisar.setToolTipText("Pesquisar"); // Define uma dica para o botão.
        btnPesquisar.setEnabled(false); // Inicialmente, o botão é desabilitado.
        linha_lblPesquisa.add(btnPesquisar); // Adiciona o botão ao painel.

        add(linha_lblPesquisa); // Adiciona o painel à janela.

        // Painel para o campo de entrada de pesquisa.
        JPanel linha_inputPesquisa = new JPanel(new GridLayout(1, 1));
        txtPesquisa = new JTextField(tamanhoInputs); // Cria o campo de texto para pesquisa.
        linha_inputPesquisa.add(txtPesquisa); // Adiciona o campo ao painel.

        add(linha_inputPesquisa); // Adiciona o painel à janela.

        // Painel para o rótulo e campo de ID.
        JPanel linha_id = new JPanel(new GridLayout(1, 2));
        lblId = new JLabel("Id:", SwingConstants.RIGHT); // Rótulo para ID.
        linha_id.add(lblId); // Adiciona o rótulo ao painel.

        txtId = new JTextField(tamanhoInputs); // Cria o campo de texto para ID.
        txtId.setEnabled(false); // Campo desabilitado (apenas leitura).
        linha_id.add(txtId); // Adiciona o campo ao painel.

        add(linha_id); // Adiciona o painel à janela.

        // Painel para o rótulo e campo de Nome.
        JPanel linha_nome = new JPanel(new GridLayout(1, 2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Rótulo para Nome.
        linha_nome.add(lblNome); // Adiciona o rótulo ao painel.

        txtNome = new JTextField(tamanhoInputs); // Cria o campo de texto para Nome.
        txtNome.setEditable(false); // Campo desabilitado (apenas leitura).
        linha_nome.add(txtNome); // Adiciona o campo ao painel.

        add(linha_nome); // Adiciona o painel à janela.

        // Painel para o rótulo e campo de Email.
        JPanel linha_email = new JPanel(new GridLayout(1, 2));
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Rótulo para Email.
        linha_email.add(lblEmail); // Adiciona o rótulo ao painel.

        txtEmail = new JTextField(10); // Cria o campo de texto para Email (tamanho 10).
        txtEmail.setEditable(false); // Campo desabilitado (apenas leitura).
        linha_email.add(txtEmail); // Adiciona o campo ao painel.

        add(linha_email); // Adiciona o painel à janela.

        // Painel para os botões de navegação.
        JPanel linha_botoes = new JPanel(new GridLayout(1, 4));

        btnPrimeiro = new JButton("<<"); // Botão para ir ao primeiro registro.
        btnPrimeiro.setEnabled(false); // Inicialmente, o botão é desabilitado.
        linha_botoes.add(btnPrimeiro); // Adiciona o botão ao painel.

        btnAnterior = new JButton("<"); // Botão para ir ao registro anterior.
        btnAnterior.setEnabled(false); // Inicialmente, o botão é desabilitado.
        linha_botoes.add(btnAnterior); // Adiciona o botão ao painel.

        btnProximo = new JButton(">"); // Botão para ir ao próximo registro.
        btnProximo.setEnabled(false); // Inicialmente, o botão é desabilitado.
        linha_botoes.add(btnProximo); // Adiciona o botão ao painel.

        btnUltimo = new JButton(">>"); // Botão para ir ao último registro.
        btnUltimo.setEnabled(false); // Inicialmente, o botão é desabilitado.
        linha_botoes.add(btnUltimo); // Adiciona o botão ao painel.

        add(linha_botoes); // Adiciona o painel à janela.

        // Painel para exibir notificações.
        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Rótulo para notificações.
        linha_notificacoes.add(lblNotificacoes); // Adiciona o rótulo ao painel.

        add(linha_notificacoes); // Adiciona o painel à janela.

        // Adiciona ação ao botão de pesquisa.
        btnPesquisar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // Verifica se o campo de pesquisa está vazio.
                    if (txtPesquisa.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("Por favor, digite algo e tente novamente.")); // Mensagem de erro.
                        txtPesquisa.requestFocus(); // Foca no campo de pesquisa.
                        return;
                    } else {
                        // Chama o método de pesquisa na classe NavegadorDeRegistro.
                        NavegadorDeRegistro.pesquisar();
                    }
                }
            }
        );

        // Adiciona ação ao botão de ir ao primeiro registro.
        btnPrimeiro.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (!ntfCampoVazio()) { // Verifica se o campo não está vazio.
                        NavegadorDeRegistro.primeiroRegistro(); // Chama método para ir ao primeiro registro.
                    }
                }
            }
        );

        // Adiciona ação ao botão de ir ao registro anterior.
        btnAnterior.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (!ntfCampoVazio()) { // Verifica se o campo não está vazio.
                        NavegadorDeRegistro.registroAnterior(); // Chama método para ir ao registro anterior.
                    }
                }
            }
        );

        // Adiciona ação ao botão de ir ao próximo registro.
        btnProximo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (!ntfCampoVazio()) { // Verifica se o campo não está vazio.
                        NavegadorDeRegistro.proximoRegistro(); // Chama método para ir ao próximo registro.
                    }
                }
            }
        );

        // Adiciona ação ao botão de ir ao último registro.
        btnUltimo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (!ntfCampoVazio()) { // Verifica se o campo não está vazio.
                        NavegadorDeRegistro.ultimoRegistro(); // Chama método para ir ao último registro.
                    }
                }
            }
        );

        // Adiciona um listener para o campo de pesquisa.
        txtPesquisa.addKeyListener(
            new KeyAdapter() {
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
                    }
                }
            }
        );

        setSize(250, 300); // Define o tamanho da janela.
        setVisible(true); // Torna a janela visível.
        txtPesquisa.requestFocus(); // Foca no campo de pesquisa ao abrir.
    }

    // Método para verificar se o campo de pesquisa está vazio.
    public static boolean ntfCampoVazio() {
        if (txtPesquisa.getText().trim().length() <= 0) {
            lblNotificacoes.setText(setHtmlFormat("Ops! Campo vazio. Por favor, digite algo e tente novamente.")); // Mensagem de erro.
            txtPesquisa.requestFocus(); // Foca no campo de pesquisa.
            return true; // Retorna verdadeiro se o campo está vazio.
        } else {
            return false; // Retorna falso se o campo não está vazio.
        }
    }

    // Método para limpar os campos e exibir notificações.
    public static void limparCampos(String notificacao) {
        btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.
        txtId.setText(""); // Limpa o campo de ID.
        txtNome.setText(""); // Limpa o campo de Nome.
        txtEmail.setText(""); // Limpa o campo de Email.
        btnPrimeiro.setEnabled(false); // Desabilita botão de primeiro registro.
        btnAnterior.setEnabled(false); // Desabilita botão de registro anterior.
        btnProximo.setEnabled(false); // Desabilita botão de próximo registro.
        btnUltimo.setEnabled(false); // Desabilita botão de último registro.
        if (!notificacao.equals("")) {
            lblNotificacoes.setText(setHtmlFormat(notificacao)); // Exibe notificação se não for vazia.
        }
    }

    // Método para formatar texto em HTML para exibição.
    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>"; // Retorna o texto formatado.
    }

    // Método principal para executar a aplicação.
    public static void main(String[] args) {
        TelaDePesquisa appTelaDePesquisa = new TelaDePesquisa(); // Cria uma nova instância da tela de pesquisa.
        appTelaDePesquisa.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define a operação padrão ao fechar a janela.
    }
}
