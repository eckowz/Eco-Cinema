package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.PrintUtil;

/**
 *
 * @author Eckowz
 */
public class ConnectionFactory {

    private final static String HOST = "localhost";
    private final static String PORT = "5432";
    private final static String BD = "eco_cinema";
    private final static String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + BD;
    private final static String USUARIO = "postgres";
    private final static String SENHA = "senac2015";

    /**
     *
     * @return Retorna se a conexão com o banco foi realizada com sucesso
     */
    public static Connection getConnection() {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            PrintUtil.printMessageErro(null, ex);
        }
        return (conexao);
    }

}
