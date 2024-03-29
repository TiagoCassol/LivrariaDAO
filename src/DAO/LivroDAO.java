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
import model.Livro;
import services.ServicosFactory;
import services.VendaService;

/**
 *
 * @author casso
 */
public class LivroDAO {

    public void cadastrarLivro(Livro lVO) throws SQLException {
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            //sql vai receber o comando SQL
            String sql;
            sql = "insert into livro values(null,'" + lVO.getTitulo() + "','" + lVO.getAssunto() + "','"
                    + lVO.getAutor() + "','"
                    + lVO.getIsbn() + "',"
                    + lVO.getEstoque() + ","
                    + lVO.getPreco() + ","
                    + lVO.getIdEditora() + ")";

            //vamos executar o comando  construido na sting aql
            System.out.println(sql);
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir livro\n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    public ArrayList<Livro> buscarLivros() throws SQLException {
        //busca conexão com o BD
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "Select * from livro";
            //atribuo ao rs o resultado da exec~ção da query no banco
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Livro> livros = new ArrayList<>();
            while (rs.next()) {
                Livro l = new Livro();
                //lado do java||lado do banco
                l.setIdLivro(rs.getInt("idLivro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAssunto(rs.getString("assunto"));
                l.setAutor(rs.getString("autor"));
                
                l.setIsbn(rs.getString("isbn"));
                l.setEstoque(rs.getInt("estoque"));
                l.setPreco(rs.getInt("preco"));
                l.setIdEditora(rs.getInt("idEditora"));
                livros.add(l);
            }
            return livros;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar livros \n" + e.getMessage());

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
                l.setAssunto(rs.getString("assunto"));
                l.setAutor(rs.getString("autor"));
                
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
                    + "assunto = '" + lVO.getAssunto() + "', "
                    + "autor = '" + lVO.getAutor() + "', "
                    
                    + "isbn = '" + lVO.getIsbn() + "', "
                    + "estoque= " + lVO.getEstoque() + ","
                    + "preco=" + lVO.getPreco() + ","
                    + "IdEditora=" + lVO.getIdEditora() + " "
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

    public int getIdLivro(String isbn) throws SQLException {
        int idLivro = 0;
        try {
            for (Livro liv : buscarLivros()) {
                
                if (liv.getIsbn().equals(isbn)) {
                    System.out.println("teste: "+liv);
                    idLivro = liv.getIdLivro();
                    break;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Livro com este isbn não existe. \n"
                    + e.getMessage());
        }
        return idLivro;
    }

    public boolean verIsbn(String isbn) throws SQLException {
        Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        boolean verIsbn = true;

        try {
            String sql;
            sql = "select isbn from livro where isbn = '" + isbn + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                verIsbn = rs.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("livro com este isbn não existe. \n" + e.getMessage());

        } finally {
            con.close();
            stat.close();
        }
        return verIsbn;
    }

    public String getNomeLivro(int id) throws SQLException {
        String nomeLivro = null;
        try {
            for (Livro liv : buscarLivros()) {
                if (liv.getIdLivro() == id) {
                    nomeLivro = liv.getTitulo();
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Livro com este id não existe. \n"
                    + e.getMessage());
        }
        return nomeLivro;
    }

    public float getPrecoLivro(int id) throws SQLException {
        float precoLivro = 0;
        try {
            for (Livro liv : buscarLivros()) {
                if (liv.getIdLivro() == id) {
                    precoLivro = liv.getPreco();
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Preco com este id não existe. \n"
                    + e.getMessage());
        }
        return precoLivro;
    }

    public int getEstoqueLivro(int id) throws SQLException {
        int estoqueLivro = 0;
        try {
            for (Livro liv : buscarLivros()) {
                if (liv.getIdLivro() == id) {
                    estoqueLivro = liv.getEstoque();
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Estoque com este id não existe. \n"
                    + e.getMessage());
        }
        return estoqueLivro;
    }
    
  public void diminuirEstoque(int idLivro, int quantCompra) throws SQLException{
      Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try{
        String sql;
        sql="update livro set estoque = estoque -"+quantCompra+" where idLivro = " + idLivro;
        System.out.println(sql);
        stat.executeUpdate(sql);
        }catch (SQLException e){
            throw new SQLException("Erro ao atualizar estoque! "+e.getMessage());
        }finally{ 
        con.close();
        stat.close();
        }
  }
  
  public void aumentarEstoque(int idLivro, int quantCompra) throws SQLException{
      Connection con = Conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try{
        String sql;
        sql="update livro set estoque = estoque +"+quantCompra+" where idLivro = " + idLivro;
        System.out.println(sql);
        stat.executeUpdate(sql);
        }catch (SQLException e){
            throw new SQLException("Erro ao atualizar estoque! "+e.getMessage());
        }finally{ 
        con.close();
        stat.close();
        }
  }
  
      
}
