/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import model.Venda;

/**
 *
 * @author jairb
 */
public class CVendaLivros {
    ArrayList<Venda> vendaLivros = new ArrayList<>();
    int idVen = 1;
    
    public void addVendaLivro(Venda vl){
        vendaLivros.add(vl);
    }
    
        public int gerarId() {
        return this.idVen++;
    }

    public ArrayList<Venda> getVendaLivros() {
        return vendaLivros;
    }    
    
}
