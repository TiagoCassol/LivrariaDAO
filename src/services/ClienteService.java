/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.ClienteDAO;
import DAO.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author casso
 */
public class ClienteService {
    
    public ArrayList<Cliente> getClientes() throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.buscarClientes();
    }
    
    public boolean verCPF(String cpf) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.verCPF(cpf);
    }
    
    public boolean verCNPJ(String cnpj) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.verCNPJ(cnpj);
    }
    
    public void cadClienteCpf(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.cadastrarClienteCpf(cVO);
    }
   
    
    public void cadClienteCnpj(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.cadastrarClienteCnpj(cVO);
    }
    
    public Cliente buscaClienteBD(String cpf) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.getByDocBD(cpf);
    }
    
    public Cliente buscaClienteCnpjBD(String cnpj) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.getByCnpjBD(cnpj);
    }
    
    public void deletarClienteBD(int id) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.deletarCliente(id);
    }
    public void atualizarClienteBD(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.atualizarCliente(cVO);
    }
    public int getIdCliente(String cpf) throws SQLException {
    ClienteDAO cDAO = DAOFactory.getClienteDAO();
    return cDAO.getIdCliente(cpf);
    }
    
    public void atualizarClienteCnpjBD(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.atualizarClienteCnpj(cVO);
    }
    
     public String getNomeCliente(int id) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.getNomeCliente(id);
    }
}
