/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author casso
 */
public class Conexao {
    //cria uma constante com endereço do BD e schema
  private static String url = "jdbc:mysql://localhost:3306/livrariadao";
  //cria uma constante com o user de conexão do banco
  private static String user = "root";
  //cria uma constante com a senha de acesso ao BD
  private static String pass = "";
  public static Connection getConexao() throws SQLException{
      //iniciar conexão nula,ainda não estabelecida
      Connection c = null;
      //tenta estabelecer conexão
      try {
          c = DriverManager.getConnection(url, user, pass);
          //CAso haja falha na conexão gera uma exceção
      } catch (SQLException e) {
          throw new SQLException("Erro ao conectar! \n"+ e.getMessage());
      }
      return c;
  }

}
