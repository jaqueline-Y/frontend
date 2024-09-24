import java.sql.*; // Importa as classes necessárias para trabalhar com JDBC (Java Database Connectivity).

public class NavegadorDeRegistro extends TelaDePesquisa {
    // Método para realizar a pesquisa no banco de dados.
    public static void pesquisar() {
        try {
            // Verifica se o texto de pesquisa é diferente do usuário atual.
            if (!txtPesquisa.getText().trim().equals(txtUsuario)) {
                limparCampos(); // Limpa os campos de entrada.
                // Estabelece a conexão com o banco de dados.
                Connection conexao = MySQLConnector.conectar();
                // Monta a consulta SQL para buscar registros que contenham o texto de pesquisa.
                String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` asc;";
                // Cria um Statement para executar a consulta.
                Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                // Executa a consulta e armazena os resultados em um ResultSet.
                ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
                
                // Verifica se há resultados na pesquisa.
                if (rstSqlPesquisa.next()) {
                    rstSqlPesquisa.last(); // Move para o último resultado.
                    int rowNumbers = rstSqlPesquisa.getRow(); // Conta o número de resultados.
                    rstSqlPesquisa.first(); // Volta para o primeiro resultado.

                    // Exibe o número de resultados encontrados.
                    lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram) encontrado(s) " + rowNumbers + " resultado(s)."));
                    // Preenche os campos com os dados do primeiro registro.
                    txtId.setText(rstSqlPesquisa.getString("id"));
                    txtNome.setText(rstSqlPesquisa.getString("nome"));
                    txtEmail.setText(rstSqlPesquisa.getString("email"));
                    txtUsuario = txtPesquisa.getText(); // Atualiza o usuário atual.
                    btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.

                    // Habilita os botões de navegação se houver mais de um registro.
                    if (rowNumbers > 1) {
                        btnProximo.setEnabled(true);
                        btnUltimo.setEnabled(true);
                    }
                } else {
                    // Se não houver resultados, atualiza o usuário e exibe uma mensagem.
                    txtUsuario = txtPesquisa.getText();
                    btnPesquisar.setEnabled(false);
                    lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
                }
                stmSqlPesquisa.close(); // Fecha o Statement após uso.
            }
        } catch (Exception e) {
            // Captura exceções e exibe uma mensagem de erro.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Imprime o erro no console.
        }
    }

    // Método para buscar o primeiro registro (chama o método de pesquisa).
    public static void primeiroRegistro() {
        pesquisar();
    }

    // Método para navegar para o registro anterior (ainda não implementado).
    public static void registroAnterior() {
    }

    // Método para buscar o próximo registro.
    public static void proximoRegistro() {
        try {
            // Armazena os dados atuais para referência.
            String idAtual = txtId.getText();
            String nomeAtual = txtNome.getText();
            String emailAtual = txtEmail.getText();
            limparCampos(); // Limpa os campos de entrada.

            // Estabelece a conexão com o banco de dados.
            Connection conexao = MySQLConnector.conectar();
            // Monta a consulta SQL para buscar o próximo registro baseado no ID atual.
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` > " + idAtual + " order by `id` asc;";
            // Cria um Statement para executar a consulta.
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // Executa a consulta e armazena os resultados em um ResultSet.
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            
            // Verifica se há um próximo registro.
            if (rstSqlProximoRegistro.next()) {
                // Preenche os campos com os dados do próximo registro.
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                // Habilita os botões de navegação.
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                // Se não houver próximo registro, restaura os dados atuais e exibe uma mensagem.
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao último registro.");
            }
            stmSqlProximoRegistro.close(); // Fecha o Statement após uso.
        } catch (Exception e) {
            // Captura exceções e exibe uma mensagem de erro.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Imprime o erro no console.
        }
    }

    // Método para buscar o último registro (ainda não implementado).
    public static void ultimoRegistro() {
    }
}
