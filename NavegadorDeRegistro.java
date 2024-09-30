import java.sql.*;
import java.util.*;

public class NavegadorDeRegistro extends TelaDeAtualizacao {
    
    // Populates a list of IDs from the database
    public static void popularIds() {
        try {
            ArrayList<String> idsTemp = new ArrayList<>();
            idsTemp.add("Selecione aqui o id"); // Add prompt for selection
            Connection conexao = MySQLConnector.conectar(); // Establish database connection
            String strSqlPopularIds = "select * from `db_senac`.`tbl_senac` order by `id` asc;"; // SQL query to select IDs
            Statement stmSqlPopularIds = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPopularIds = stmSqlPopularIds.executeQuery(strSqlPopularIds); // Execute query
            
            // Loop through result set to add IDs to the list
            while (rstSqlPopularIds.next()) {
                idsTemp.add(rstSqlPopularIds.getString("id"));
            }
            ids = idsTemp.toArray(new String[0]); // Convert list to array
            stmSqlPopularIds.close(); // Close statement
        } catch (Exception e) {
            // Handle errors by notifying the user
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Log error
        }
    }

    // Updates the ID based on user input
    public static void atualizarId() {
        try {
            String atualizarNome = "";
            String atualizarEmail = "";
            String atualizarSenha = "";

            // Check if the name has changed
            if (!txtNome.getText().trim().equals(nomeAtual)) {
                atualizarNome = "`nome` = '" + txtNome.getText() + "'";
            }

            // Check if the email has changed
            if (!txtEmail.getText().trim().equals(emailAtual)) {
                if (atualizarNome.length() > 0) {
                    atualizarEmail = " and "; // Add 'and' if name is also being updated
                }
                atualizarEmail += "`email` = '" + txtEmail.getText() + "'";
            }

            // Check if the password has changed
            if (!String.valueOf(txtSenha.getPassword()).trim().equals(senhaAtual)) {
                if (atualizarNome.length() > 0 || atualizarEmail.length() > 0) {
                    atualizarSenha = " and "; // Add 'and' if other fields are also being updated
                }
                atualizarSenha += "`senha` = '" + String.valueOf(txtSenha.getPassword()) + "'";
            }

            // If any fields have changed, proceed with update
            if (atualizarNome.length() > 0 || atualizarEmail.length() > 0 || atualizarSenha.length() > 0) {
                Connection conexao = MySQLConnector.conectar(); // Establish database connection
                String strSqlAtualizarId = "update `db_senac`.`tbl_senac` set " + atualizarNome + atualizarEmail + atualizarSenha + " where `id` = " + cbxId.getSelectedItem().toString() + ";";
                Statement stmSqlAtualizarId = conexao.createStatement(); // Create statement
                stmSqlAtualizarId.addBatch(strSqlAtualizarId); // Add update to batch
                stmSqlAtualizarId.executeBatch(); // Execute batch
                // Update current values
                nomeAtual = txtNome.getText();
                emailAtual = txtEmail.getText();
                senhaAtual = String.valueOf(txtSenha.getPassword());
                stmSqlAtualizarId.close(); // Close statement
                lblNotificacoes.setText("O id " + cbxId.getSelectedItem().toString() + " foi atualizado com sucesso!"); // Notify success
            } else {
                lblNotificacoes.setText("Não foram encontradas alterações para atualizar o id " + cbxId.getSelectedItem().toString()); // Notify no changes
            }
        } catch (Exception e) {
            // Handle errors during update
            lblNotificacoes.setText(setHtmlFormat("Não foi possível atualizar o id! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Log error
        }
    }

    // Clears input fields
    public static void limparCampos() {
        txtNome.setText(""); // Clear name field
        txtEmail.setText(""); // Clear email field
        txtSenha.setText(""); // Clear password field
        cbxId.setSelectedIndex(0); // Reset ID selection
    }

    // Updates input fields with selected ID information
    public static void atualizarCampos(String id) {
        try {
            if (cbxId.getSelectedIndex() > 0) { // Check if an ID is selected
                Connection conexao = MySQLConnector.conectar(); // Establish database connection
                String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where `id` = " + id + ";"; // SQL query to select fields
                Statement stmSqlAtualizarCampos = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos); // Execute query
                
                // If results found, populate fields
                if (rstSqlAtualizarCampos.next()) {
                    txtNome.setText(rstSqlAtualizarCampos.getString("nome"));
                    nomeAtual = txtNome.getText();
                    txtEmail.setText(rstSqlAtualizarCampos.getString("email"));
                    emailAtual = txtEmail.getText();
                    txtSenha.setText(rstSqlAtualizarCampos.getString("senha"));
                    senhaAtual = String.valueOf(txtSenha.getPassword());
                    lblNotificacoes.setText("Campos atualizados com sucesso!"); // Notify success
                } else {
                    lblNotificacoes.setText("Ops! Não foi encontrado o id selecionado. Por favor, verifique e tente novamente."); // Notify ID not found
                }
                stmSqlAtualizarCampos.close(); // Close statement
            } else {
                lblNotificacoes.setText("Selecione um id para continuar."); // Prompt to select an ID
                limparCampos(); // Clear fields
            }
        } catch (Exception e) {
            // Handle errors during field update
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Log error
        }
    }
}
