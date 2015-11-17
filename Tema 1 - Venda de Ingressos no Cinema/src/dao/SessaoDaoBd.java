package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Filme;
import model.Sala;
import model.Sessao;

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
            String sql = "INSERT INTO sessao (horario, idfilme, idsala, assentosdisponiveis) "
                    + "VALUES (?,?,?,?)";

            conectarObtendoId(sql);
            java.sql.Timestamp timestSql = new java.sql.Timestamp(sessao.getHorario().getTime());
            comando.setTimestamp(1, timestSql);
            comando.setInt(2, sessao.getFilme().getIdFilme());
            comando.setInt(3, sessao.getSala().getIdSala());
            comando.setInt(4, sessao.getSala().getQuantidadeAssentos());
            comando.executeUpdate();
            //Obtém o resultSet para pegar o id
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                //seta o id para o objeto
                cod = resultado.getInt(1);
                sessao.setCodSessao(cod);
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

        String sql = "SELECT * FROM sessao ORDER BY idsessao";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int idSessao = resultado.getInt("idSessao");
                //Trabalhando com data: lembrando dataSql -> dataUtil
                java.sql.Timestamp dataSql = resultado.getTimestamp("horario");
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
                Filme filme = this.getFilme(resultado.getInt("idfilme"));
                Sala sala = this.getSala(resultado.getInt("idsala"));
                int assentosDisponiveis = resultado.getInt("assentosdisponiveis");

                Sessao sessao = new Sessao(idSessao, dataUtil, filme, sala, assentosDisponiveis);

                listaSessaos.add(sessao);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (listaSessaos);

    }
//
//    @Override
//    public List<Sessao> procurarPorHorario(Date horario) {
//        List<Sessao> listaHorarios = new ArrayList<>();
//
//        String sql = "SELECT * FROM sessao WHERE horario=?";
//
//        try {
//            conectar(sql);
//
//            ResultSet resultado = comando.executeQuery();
//
//            java.sql.Timestamp timestSql = new java.sql.Timestamp(sessao.getHorario().getTime());
//            comando.setTimestamp(1, timestSql);
//            java.sql.Timestamp dataSql = resultado.getTimestamp("horario");
//            java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
//
//            String sql = "DELETE FROM medicamento WHERE codigo=?";
//
//            conectar(sql);
//            comando.setInt(1, medicamento.getCodigo());
//            comando.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(PacienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            fecharConexao();
//        }
//    }

    private Filme getFilme(int idFilme) {
        return (new FilmeDaoBd().procurarPorIdFilme(idFilme));
    }

    private Sala getSala(int idSala) {
        return (new SalaDaoBd().procurarPorId(idSala));
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
