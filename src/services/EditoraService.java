/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOFactory;
import DAO.EditoraDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author casso
 */
public class EditoraService {
    
    public ArrayList<Editora> getEditoras() throws SQLException {
        EditoraDAO cDAO = DAOFactory.getEditoraDAO();
        return cDAO.buscarEditoras();
    }
    
    public void cadEditora(Editora eVO) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.cadastrarEditora(eVO);
    }
    
    public Editora buscaGerenteBD(String gerente) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.getByGerenteBD(gerente);
    }
    
    public void deletarEditoraBD(int id) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.deletarEditora(id);
    }
    
    public void atualizarEditoraBD(Editora eVO) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.atualizarEditora(eVO);
    }
    public int getIdEditora(String editora) throws SQLException {
    EditoraDAO eDAO = DAOFactory.getEditoraDAO();
    return eDAO.getIdEditora(editora);
    }
    
}
