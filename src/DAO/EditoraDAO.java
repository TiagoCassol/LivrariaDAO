/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author casso
 */
public class EditoraDAO {

    public void cadastrarEditora(Editora pVO) throws SQLException {
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            //sql vai receber o comando SQL
            String sql;
            sql = "insert into editora values(null,'" + pVO.getNmEditora() + "','" + pVO.getEndereco() + "','"
                    + pVO.getTelefone() + "','"
                    + pVO.getGerente() + "')";
            //vamos executar o comando  construido na sting aql
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir editora\n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }
    
    public ArrayList<Editora> buscarEditoras() throws SQLException {
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "Select * from editora";
            //atribuo ao rs o resultado da exec~ção da query no banco
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Editora> editoras = new ArrayList<>();
            while (rs.next()) {
                Editora e = new Editora();
                //lado do java||lado do banco
                e.setIdEditora(rs.getInt("idEditora"));
                e.setNmEditora(rs.getString("nmEditora"));
                e.setEndereco(rs.getString("endereco"));
                e.setTelefone(rs.getString("telefone"));
                e.setGerente(rs.getString("Gerente"));
                editoras.add(e);
            }
            return editoras;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar editoras \n" + e.getMessage());

        } finally {
            stat.close();
            con.close();
        }
    }
    
     public Editora getByGerenteBD(String gerente) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        Editora g = new Editora();
        try {
            String sql;
            sql = "select * from editora where gerente = '" + gerente + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                //lado do java||lado do banco
                g.setIdEditora(rs.getInt("idEditora"));
                g.setNmEditora(rs.getString("nmEditora"));
                g.setEndereco(rs.getString("endereco"));
                g.setTelefone(rs.getString("telefone"));
                g.setGerente(rs.getString("gerente"));
               // System.out.println(sql);
            }
        } catch (SQLException e) {
            throw new SQLException("Editora com este gerente não existe. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        return g;
    }
     
     public void atualizarEditora(Editora eVO) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "update editora set "
                    + "nmEditora = '" + eVO.getNmEditora() + "', "
                    + "gerente = '" + eVO.getGerente() + "', "
                    + "endereco = '" + eVO.getEndereco() + "', "
                    + "telefone = '" + eVO.getTelefone() + "' "
                    + "where idEditora = " + eVO.getIdEditora() + "";
            System.out.println(sql);
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar Editora. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
     
     public void deletarEditora(int id) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "delete from editora where idEditora =" + id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar editora. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();

        }
    }
     
      public int getIdEditora(String editora) throws SQLException{
          int idEditora = 0;
          try{
        for (Editora edi : buscarEditoras()) {
            if (edi.getNmEditora().equals(editora)) {
                idEditora = edi.getIdEditora();
                break;
            }
        }
           }catch (SQLException e) {
       throw new SQLException ("editora com este gerente não existe. \n"
       + e.getMessage());
           }
        return idEditora;
    }

}
