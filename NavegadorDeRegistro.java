import java.sql.*; // Importa classes para manipulação de SQL.

public class NavegadorDeRegistro extends TelaDePesquisa {
    // Método para realizar a pesquisa.
    public static void pesquisar() {
        try {
            // Verifica se o texto de pesquisa foi alterado.
            if (!txtPesquisa.getText().trim().equals(txtUsuario)) {
                limparCampos(""); // Limpa os campos e mensagens.
                Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados.
                
                // SQL para buscar registros que correspondem ao nome ou email.
                String strSqlPesquisa = "SELECT * FROM `db_senac`.`tbl_senac` WHERE `nome` LIKE '%" + txtPesquisa.getText() + "%' OR `email` LIKE '%" + txtPesquisa.getText() + "%' ORDER BY `id` ASC;";
                
                Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
                
                // Verifica se algum registro foi encontrado.
                if (rstSqlPesquisa.next()) {
                    rstSqlPesquisa.last(); // Vai para o último registro.
                    int rowNumbers = rstSqlPesquisa.getRow(); // Conta o número de registros.
                    rstSqlPesquisa.first(); // Volta para o primeiro registro.

                    // Exibe o número de resultados encontrados.
                    lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram) encontrado(s) " + rowNumbers + " resultado(s)."));
                    
                    // Preenche os campos de texto com os dados do primeiro registro encontrado.
                    txtId.setText(rstSqlPesquisa.getString("id"));
                    txtNome.setText(rstSqlPesquisa.getString("nome"));
                    txtEmail.setText(rstSqlPesquisa.getString("email"));
                    
                    txtUsuario = txtPesquisa.getText(); // Atualiza o texto de pesquisa.
                    btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.

                    // Habilita os botões de navegação se houver mais de um registro.
                    if (rowNumbers > 1) {
                        btnProximo.setEnabled(true);
                        btnUltimo.setEnabled(true);
                    }
                } else {
                    // Se nenhum resultado for encontrado.
                    txtUsuario = txtPesquisa.getText(); // Atualiza o texto de pesquisa.
                    btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.
                    lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\".")); // Mensagem de erro.
                }
                stmSqlPesquisa.close(); // Fecha o Statement.
            }
        } catch (Exception e) {
            // Trata exceções e exibe mensagem de erro.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe erro no console.
        }
    }

    // Método para ir ao primeiro registro.
    public static void primeiroRegistro() {
        try {
            limparCampos("Você está no primeiro registro."); // Limpa os campos e exibe mensagem.
            Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados.
            String strSqlPesquisa = "SELECT * FROM `db_senac`.`tbl_senac` WHERE `nome` LIKE '%" + txtPesquisa.getText() + "%' OR `email` LIKE '%" + txtPesquisa.getText() + "%' ORDER BY `id` ASC;";
            
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            
            // Verifica se algum registro foi encontrado.
            if (rstSqlPesquisa.next()) {
                // Preenche os campos com os dados do primeiro registro.
                txtId.setText(rstSqlPesquisa.getString("id"));
                txtNome.setText(rstSqlPesquisa.getString("nome"));
                txtEmail.setText(rstSqlPesquisa.getString("email"));
                
                btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.
                btnProximo.setEnabled(true); // Habilita o botão de próximo registro.
                btnUltimo.setEnabled(true); // Habilita o botão de último registro.
            } else {
                // Se nenhum resultado for encontrado.
                txtUsuario = txtPesquisa.getText(); // Atualiza o texto de pesquisa.
                btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.
                lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\".")); // Mensagem de erro.
            }
            stmSqlPesquisa.close(); // Fecha o Statement.
        } catch (Exception e) {
            // Trata exceções e exibe mensagem de erro.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe erro no console.
        }
    }

    // Método para ir ao registro anterior.
    public static void registroAnterior() {
        try {
            String idAtual = txtId.getText(); // Armazena o ID atual.
            String nomeAtual = txtNome.getText(); // Armazena o Nome atual.
            String emailAtual = txtEmail.getText(); // Armazena o Email atual.
            limparCampos("Registro anterior posicionado com sucesso."); // Limpa os campos e exibe mensagem.
            Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados.

            // SQL para buscar o registro anterior.
            String strSqlProximoRegistro = "SELECT * FROM `db_senac`.`tbl_senac` WHERE (`nome` LIKE '%" + txtPesquisa.getText() + "%' OR `email` LIKE '%" + txtPesquisa.getText() + "%') AND `id` < " + idAtual + " ORDER BY `id` DESC;";
            
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            
            // Verifica se algum registro foi encontrado.
            if (rstSqlProximoRegistro.next()) {
                // Preenche os campos com os dados do registro encontrado.
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                
                // Habilita os botões de navegação.
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                // Se não houver registros anteriores.
                txtId.setText(idAtual); // Mantém o ID atual.
                txtNome.setText(nomeAtual); // Mantém o Nome atual.
                txtEmail.setText(emailAtual); // Mantém o Email atual.
                btnProximo.setEnabled(true); // Habilita o botão de próximo registro.
                btnUltimo.setEnabled(true); // Habilita o botão de último registro.
                lblNotificacoes.setText("Você chegou ao primeiro registro."); // Mensagem informativa.
            }
            stmSqlProximoRegistro.close(); // Fecha o Statement.
        } catch (Exception e) {
            // Trata exceções e exibe mensagem de erro.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe erro no console.
        }
    }

    // Método para ir ao próximo registro.
    public static void proximoRegistro() {
        try {
            String idAtual = txtId.getText(); // Armazena o ID atual.
            String nomeAtual = txtNome.getText(); // Armazena o Nome atual.
            String emailAtual = txtEmail.getText(); // Armazena o Email atual.
            limparCampos("Próximo registro posicionado com sucesso."); // Limpa os campos e exibe mensagem.
            Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados.

            // SQL para buscar o próximo registro.
            String strSqlProximoRegistro = "SELECT * FROM `db_senac`.`tbl_senac` WHERE (`nome` LIKE '%" + txtPesquisa.getText() + "%' OR `email` LIKE '%" + txtPesquisa.getText() + "%') AND `id` > " + idAtual + " ORDER BY `id` ASC;";
            
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            
            // Verifica se algum registro foi encontrado.
            if (rstSqlProximoRegistro.next()) {
                // Preenche os campos com os dados do registro encontrado.
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                
                // Habilita os botões de navegação.
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                // Se não houver registros seguintes.
                txtId.setText(idAtual); // Mantém o ID atual.
                txtNome.setText(nomeAtual); // Mantém o Nome atual.
                txtEmail.setText(emailAtual); // Mantém o Email atual.
                btnPrimeiro.setEnabled(true); // Habilita o botão de primeiro registro.
                btnAnterior.setEnabled(true); // Habilita o botão de anterior registro.
                lblNotificacoes.setText("Você chegou ao último registro."); // Mensagem informativa.
            }
            stmSqlProximoRegistro.close(); // Fecha o Statement.
        } catch (Exception e) {
            // Trata exceções e exibe mensagem de erro.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe erro no console.
        }
    }

    // Método para ir ao último registro.
    public static void ultimoRegistro() {
        try {
            String idAtual = txtId.getText(); // Armazena o ID atual.
            String nomeAtual = txtNome.getText(); // Armazena o Nome atual.
            String emailAtual = txtEmail.getText(); // Armazena o Email atual.
            limparCampos(""); // Limpa os campos.
            Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados.

            // SQL para buscar o último registro.
            String strSqlProximoRegistro = "SELECT * FROM `db_senac`.`tbl_senac` WHERE `nome` LIKE '%" + txtPesquisa.getText() + "%' OR `email` LIKE '%" + txtPesquisa.getText() + "%' ORDER BY `id` DESC;";
            
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            
            // Verifica se algum registro foi encontrado.
            if (rstSqlProximoRegistro.next()) {
                // Preenche os campos com os dados do registro encontrado.
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                
                btnPrimeiro.setEnabled(true); // Habilita o botão de primeiro registro.
                btnAnterior.setEnabled(true); // Habilita o botão de anterior registro.
                lblNotificacoes.setText("Você chegou ao último registro."); // Mensagem informativa.
            } else {
                // Se não houver registros.
                txtId.setText(idAtual); // Mantém o ID atual.
                txtNome.setText(nomeAtual); // Mantém o Nome atual.
                txtEmail.setText(emailAtual); // Mantém o Email atual.
                btnPrimeiro.setEnabled(true); // Habilita o botão de primeiro registro.
                btnAnterior.setEnabled(true); // Habilita o botão de anterior registro.
                lblNotificacoes.setText("Você chegou ao último registro."); // Mensagem informativa.
            }
            stmSqlProximoRegistro.close(); // Fecha o Statement.
        } catch (Exception e) {
            // Trata exceções e exibe mensagem de erro.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o último registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe erro no console.
        }
    }
}
