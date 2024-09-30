import java.sql.*; // Importa as classes necessárias para trabalhar com JDBC (Java Database Connectivity).

public class MySQLConnector {
    // Método que estabelece a conexão com o banco de dados MySQL.
    public static Connection conectar() throws Exception {
        // Inicializa uma variável para armazenar o status da conexão.
        String status = "Nada aconteceu ainda...";
        // Definições das informações de conexão ao banco de dados.
        String mysqlHost = "127.0.0.1"; // Endereço do host MySQL (localhost).
        String mysqlDb = "db_senac"; // Nome do banco de dados.
        String mysqlUser = "root"; // Nome de usuário do banco de dados.
        String mysqlPassword = "senac@02"; // Senha do usuário do banco de dados.
        String mysqlPort = "3306"; // Porta padrão do MySQL.
        // Monta a URL de conexão ao banco de dados.
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;

        Connection conn = null; // Inicializa a variável de conexão como nula.
        try {
            // Carrega o driver JDBC do MySQL.
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            // Estabelece a conexão com o banco de dados utilizando a URL.
            conn = DriverManager.getConnection(mysqlUrl);
            status = "Conexão realizada com sucesso!"; // Atualiza o status se a conexão for bem-sucedida.
        } catch (Exception e) {
            // Se ocorrer um erro, atualiza o status com a mensagem do erro.
            status = "Ops! Algo de errado não está certo com a conexão com o banco de dados MySQL! Mensagem do servidor: " + e;
        }
        // Imprime o status da conexão.
        status.length();
        // Retorna a conexão (pode ser nula se falhar).
        return conn;
    }
}


