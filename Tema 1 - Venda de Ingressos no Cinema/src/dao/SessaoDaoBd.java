package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gserafini
 */
public class SessaoDaoBd implements SessaoDao {

    private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void inserir(Sessao sessao) {
        int cod = 0;
        try {
            String sql = "INSERT INTO sessao (horario, prontuario, idpaciente, finalizado) "
                    + "VALUES (?,?,?,?)";

            conectarObtendoId(sql);
            java.sql.Timestamp timestSql = new java.sql.Timestamp(sessao.getHorario().getTime());
            comando.setTimestamp(1, timestSql);
            comando.setString(2, sessao.getProntuario());
            comando.setInt(3, sessao.getPaciente().getId());
            comando.setBoolean(4, sessao.estaFinalizada());
            comando.executeUpdate();
            //Obtém o resultSet para pegar o id
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                //seta o id para o objeto
                cod = resultado.getInt(1);
                sessao.setCodigo(cod);
            }

            //Inserir todos os itens de receituario no banco
            for (ItemReceituario item : sessao.getReceituario()) {
                this.inserirItemReceituario(cod, item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

    }

    @Override
    public List<Sessao> listar() {
        List<Sessao> listaSessaos = new ArrayList<>();

        String sql = "SELECT * FROM sessao ORDER BY codigo";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                //Trabalhando com data: lembrando dataSql -> dataUtil
                java.sql.Timestamp dataSql = resultado.getTimestamp("horario");
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
                String prontuario = resultado.getString("prontuario");

                Paciente paciente = this.getPaciente(resultado.getInt("idpaciente"));

                Sessao sessao = new Sessao(codigo, dataUtil, paciente, prontuario);

                List<ItemReceituario> itens = getItens(codigo);
                sessao.setReceituario(itens);

                listaSessaos.add(sessao);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (listaSessaos);

    }

    public void conectar(String sql) throws SQLException {
        conexao = ConnectionFactory.getConnection();
        comando = conexao.prepareStatement(sql);
    }

    public void conectarObtendoId(String sql) throws SQLException {
        conexao = ConnectionFactory.getConnection();
        comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
    }

    public void fecharConexao() {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
