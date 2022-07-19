/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
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
                    + vVO.getDataVenda() + "')";

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
                v.setDataVenda(rs.getDate("dataVenda").toLocalDate());
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

   

}
