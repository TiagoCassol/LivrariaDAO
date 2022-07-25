/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOFactory;
import DAO.LivroDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Livro;


/**
 *
 * @author casso
 */
public class LivroService {
    
    public ArrayList<Livro> getLivros() throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.buscarLivros();
    }
    public void cadLivro(Livro lVO) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.cadastrarLivro(lVO);
    }
    public int getIdLivro(String isbn) throws SQLException {
    LivroDAO lDAO = DAOFactory.getLivroDAO();
    return lDAO.getIdLivro(isbn);
    }
    public boolean verIsbn(String isbn) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.verIsbn(isbn);
    }
    public Livro buscaLivroBD(String isbn) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getByIsbnBD(isbn);
    }
    
    public String getNomeLivro(int id) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getNomeLivro(id);
    }
    
    public float getPrecoLivro(int id) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getPrecoLivro(id);
    }
    
    public int getEstoqueLivro(int id) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getEstoqueLivro(id);
    }
    
    public void deletarLivroBD(int id) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.deletarLivro(id);
    }
    public void atualizarLivroBD(Livro lVO) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.atualizarLivro(lVO);
    }
    /*
    public int diminuirEstoqueBD(int estoque) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.diminuirEstoqueLivro(estoque);
    }
    */
    public int diminuirEstoqueBD(Livro lVO) throws SQLException {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.diminuirEstoque(lVO);
    }
}
