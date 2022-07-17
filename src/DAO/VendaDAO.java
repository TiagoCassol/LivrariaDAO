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
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Livro;
import model.Venda;

/**
 *
 * @author casso
 */
public class VendaDAO {
    
    public void cadastrarVenda(Venda vVO) throws SQLException {
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            //sql vai receber o comando SQL
            String sql;
            sql = "insert into venda values(null," + vVO.getIdCliente() + "," + vVO.getIdLivro() + ","
                    + vVO.getQtd() + ","
                    + vVO.getSubTotal() + ",'"
                    + vVO.getDataVenda()+")";
                  
           
            //vamos executar o comando  construido na sting aql
            System.out.println(sql);
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir venda\n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    
     public ArrayList<Venda> buscarVenda() throws SQLException {
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "Select * from Venda";
            //atribuo ao rs o resultado da exec~ção da query no banco
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Venda> vendas = new ArrayList<>();
            while (rs.next()) {
                Venda v = new Venda();
                //lado do java||lado do banco
                v.setIdVenda(rs.getInt("idVenda"));
                v.setIdCliente(rs.getInt("idCliente"));
                v.setIdLivro(rs.getInt("idLivro"));
                v.setQtd(rs.getInt("quantCompra"));
                v.setSubTotal(rs.getInt("subTotal"));
               // v.setDataVenda(rs.getDate("dataVenda"));
                vendas.add(v);
            }
            return vendas;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar vendas \n" + e.getMessage());

        } finally {
            stat.close();
            con.close();
        }
    }
     
      public Livro getByIsbnBD(String isbn) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        Livro l = new Livro();
        try {
            String sql;
            sql = "select * from livro where isbn = '" + isbn + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                //lado do java||lado do banco
                l.setIdLivro(rs.getInt("idLivro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setAssunto(rs.getString("assunto"));
                l.setIsbn(rs.getString("isbn"));
                l.setEstoque(rs.getInt("estoque"));
                l.setPreco(rs.getInt("preco"));
                l.setIdEditora(rs.getInt("idEditora"));
               // System.out.println(sql);
            }
        } catch (SQLException e) {
            throw new SQLException("Editora com este isbn não existe. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        return l;
    }
    
      public void atualizarLivro(Livro lVO) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "update livro set "
                    + "titulo = '" + lVO.getTitulo() + "', "
                    + "autor = '" + lVO.getAutor() + "', "
                    + "assunto = '" + lVO.getAssunto() + "', "
                    + "isbn = '" + lVO.getIsbn() + "', "
                    +"estoque= "+ lVO.getEstoque()+","
                    +"preco"+ lVO.getPreco()+","
                    +"IdEditora"+lVO.getIdEditora()+""
                    + "where idLivro = " + lVO.getIdLivro() + "";
            System.out.println(sql);
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar livro. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
      public void deletarLivro(int id) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "delete from livro where idLivro =" + id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar livro. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();

        }
    }
    
}
