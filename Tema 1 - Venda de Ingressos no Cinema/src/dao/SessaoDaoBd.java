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
                sessao.setIdSessao(cod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

    }

    @Override
    public List<Sessao> listar() {
        List<Sessao> listaSessao = new ArrayList<>();

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

                listaSessao.add(sessao);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (listaSessao);

    }

    @Override
    public Sessao procurarPorIdSessao(int idSessao) {
        String sql = "SELECT * FROM sessao WHERE idSessao = ?";

        try {
            conectar(sql);
            comando.setInt(1, idSessao);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                java.sql.Timestamp dataSql = resultado.getTimestamp("horario");
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
                Filme filme = this.getFilme(resultado.getInt("idfilme"));
                Sala sala = this.getSala(resultado.getInt("idsala"));
                int assentosDisponiveis = resultado.getInt("assentosdisponiveis");

                Sessao sessao = new Sessao(idSessao, dataUtil, filme, sala, assentosDisponiveis);

                return sessao;
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public void deletar(Sessao sessao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Sessao sessao) {
        try {
            String sql = "UPDATE sessao SET assentosdisponiveis=?"
                    + "WHERE idsessao=?";

            conectar(sql);
            comando.setInt(1, sessao.getAssentosDisponiveis());
            comando.setInt(2, sessao.getIdSessao());
            comando.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }        
    }

    @Override
    public List<Sessao> procurarPorHorario(Date horario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int assentosDisponiveis(int idSessao) {
        Sessao sessao = procurarPorIdSessao(idSessao);
        return sessao.getAssentosDisponiveis();
    }
    
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
