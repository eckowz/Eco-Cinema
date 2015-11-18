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
import model.Sessao;
import model.VendaIngresso;

/**
 *
 * @author 631120345
 */
public class VendaIngressoDaoBd implements VendaIngressoDao {

    private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void inserir(VendaIngresso vendaIngresso) {
        int cod = 0;
        try {
            String sql = "INSERT INTO vendaIngresso (horariovenda, idsessao) "
                    + "VALUES (?,?)";

            conectarObtendoId(sql);
            java.sql.Timestamp timestSql = new java.sql.Timestamp(vendaIngresso.getHorarioVenda().getTime());
            comando.setTimestamp(1, timestSql);
            comando.setInt(2, vendaIngresso.getSessao().getIdSessao());
            comando.executeUpdate();
            //Obtém o resultSet para pegar o id
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                //seta o id para o objeto
                cod = resultado.getInt(1);
                vendaIngresso.setIdVenda(cod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaIngressoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

    }

    @Override
    public void deletar(VendaIngresso vendaIngresso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(VendaIngresso vendaIngresso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VendaIngresso> listar() {
        List<VendaIngresso> listaVendaIngressos = new ArrayList<>();

        String sql = "SELECT * FROM vendaIngresso ORDER BY idvenda";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int idVenda = resultado.getInt("idvenda");
                //Trabalhando com data: lembrando dataSql -> dataUtil
                java.sql.Timestamp dataSql = resultado.getTimestamp("horariovenda");
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
                Sessao sessao = this.getSessao(resultado.getInt("idsessao"));

                VendaIngresso vendaIngresso = new VendaIngresso(idVenda, dataUtil, sessao);

                listaVendaIngressos.add(vendaIngresso);

            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaIngressoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (listaVendaIngressos);

    }

    private Sessao getSessao(int idSessao) {
        return (new SessaoDaoBd().procurarPorIdSessao(idSessao));
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
            Logger.getLogger(VendaIngressoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
