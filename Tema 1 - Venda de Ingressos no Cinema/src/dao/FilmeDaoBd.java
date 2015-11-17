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
import model.Filme;

/**
 *
 * @author gserafini
 */
public class FilmeDaoBd implements FilmeDao {

    private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void inserir(Filme filme) {
        int cod = 0;
        try {
            String sql = "INSERT INTO filme (nomefilme, generofilme, sinopsefilme) "
                    + "VALUES(?,?,?)";

            conectarObtendoId(sql);
            comando.setString(1, filme.getNomeFilme());
            comando.setString(2, filme.getGeneroFilme());
            comando.setString(3, filme.getSinopseFilme());

            comando.executeUpdate();

            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                cod = resultado.getInt(1);
                filme.setIdFilme(cod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void deletar(Filme filme) {
        try {
            String sql = "DELETE FROM filme WHERE idFilme = ?";

            conectar(sql);
            comando.setInt(1, filme.getIdFilme());
            comando.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void atualizar(Filme filme) {
        try {
            String sql = "UPDATE filme SET nomeFilme=?, generoFilme=?, sinopseFilme=? "
                    + "WHERE idfilme=?";

            conectar(sql);
            comando.setString(1, filme.getNomeFilme());
            comando.setString(2, filme.getGeneroFilme());
            comando.setString(3, filme.getSinopseFilme());            
            comando.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public List<Filme> listar() {
        List<Filme> listaFilmes = new ArrayList<>();

        String sql = "SELECT * FROM filme";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int idFilme = resultado.getInt("idFilme");
                String nomeFilme = resultado.getString("nomeFilme");
                String generoFilme = resultado.getString("generoFilme");
                String sinopseFilme = resultado.getString("sinopseFilme");

                Filme filme = new Filme(idFilme, nomeFilme, generoFilme, sinopseFilme);
                listaFilmes.add(filme);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (listaFilmes);
    }

    @Override
    public Filme procurarPorIdFilme(int idFilme) {
        String sql = "SELECT * FROM filme WHERE idFilme = ?";

        try {
            conectar(sql);
            comando.setInt(1, idFilme);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                String nomeFilme = resultado.getString("nomefilme");
                String generoFilme = resultado.getString("generofilme");
                String sinopseFilme = resultado.getString("sinopsefilme");

                Filme filme = new Filme(idFilme, nomeFilme, generoFilme, sinopseFilme);
                return filme;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (null);
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
            Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
