/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOFactory;
import DAO.LivroDAO;
import DAO.VendaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Livro;
import model.Venda;

/**
 *
 * @author casso
 */
public class VendaService {
    public ArrayList<Venda> getVendas() throws SQLException {
        VendaDAO vDAO = DAOFactory.getVendaDAO();
        return vDAO.buscarVenda();
    }
    public void cadVenda(Venda vVO) throws SQLException {
        VendaDAO vDAO = DAOFactory.getVendaDAO();
        vDAO.cadastrarVenda(vVO);
    }
}
