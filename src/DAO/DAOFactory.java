/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author casso
 */
public class DAOFactory {
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static EditoraDAO editoraDAO = new EditoraDAO();
    private static VendaDAO vendaDAO = new VendaDAO();
    private static LivroDAO livroDAO = new LivroDAO();
    
    public static ClienteDAO getClienteDAO(){
        return clienteDAO;
    }
    public static EditoraDAO getEditoraDAO(){
        return editoraDAO;
    }
    public static LivroDAO getLivroDAO(){
        return livroDAO;
    }
    public static VendaDAO getVendaDAO(){
        return vendaDAO;
    }
}
