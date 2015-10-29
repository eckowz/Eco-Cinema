/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Sala;

/**
 *
 * @author 631120345
 *
 * Metodos que realizam conexão com o banco para objeto Sala.
 */
public class SalaDaoBd implements SalaDao {

    private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void inserir(Sala sala) {
        int idSala = 0;
        try {
            String sql = "INSER INTO sala (idsala, quantidadeassentos) "
                    + "VALUES(?,?)";

            conectarObtendoId(sql);
            comando.setInt(1, sala.getIdSala());
            comando.setInt(2, sala.getQuantidadeAssentos());

            comando.executeUpdate();

            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                idSala = resultado.getInt(1);
                sala.setIdSala(idSala);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void deletar(Sala sala) {
        try {
            String sql = "DELETE FROM sala WHERE idsala = ?";

            conectar(sql);
            comando.setInt(1, sala.getIdSala());
            comando.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void atualizar(Sala sala) {
        try {
            String sql = "UPDATE sala SET idsala=?, quantidadeassentos=? "
                    + "WHERE idsala=?";

            conectar(sql);
            comando.setInt(1, sala.getIdSala());
            comando.setInt(2, sala.getQuantidadeAssentos());

            comando.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public List<Sala> listar() {
        List<Sala> listaSalas = new ArrayList<>();

        String sql = "SELECT * FROM sala";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int idSala = resultado.getInt("idsala");
                int qtdAssentos = resultado.getInt("quantidadeassentos");

                Sala sala = new Sala(idSala, qtdAssentos);
                listaSalas.add(sala);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (listaSalas);
    }

    @Override
    public Sala procurarPorId(int idSala) {
        String sql = "SELECT * FROM sala WHERE idSala = ?";

        try {
            conectar(sql);
            comando.setInt(1, idSala);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                int qtdAssentos = resultado.getInt("quantidadeassentos");

                Sala sala = new Sala(idSala, qtdAssentos);
                return sala;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public Sala procurarPorQuantidadeAssentos(int qtdAssentos) {
        String sql = "SELECT * FROM sala WHERE quantidadeassentos = ?";

        try {
            conectar(sql);
            comando.setInt(1, qtdAssentos);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                int idSala = resultado.getInt("idsala");

                Sala sala = new Sala(idSala, qtdAssentos);
                return sala;
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
