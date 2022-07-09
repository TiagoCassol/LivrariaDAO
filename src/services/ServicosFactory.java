/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author casso
 */
public class ServicosFactory {
  private static ClienteService clienteService = new ClienteService();
  private static EditoraService editoraService = new EditoraService();
  private static VendaService vendaService = new VendaService();
  private static LivroService livroService = new LivroService();
  
  public static ClienteService getClienteService(){
      return clienteService;
  }
  
   public static EditoraService getEditoraService(){
      return editoraService;
  }
   
    public static VendaService getVendaService(){
      return vendaService;
  }
    
     public static LivroService getLivroService(){
      return livroService;
  }
  
}
