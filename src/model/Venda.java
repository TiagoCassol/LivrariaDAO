/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author jairb
 */
public class Venda {
    
    private int idVenda;
    private int idCliente;
    private int idLivro;
    private int qtd;
    private float subTotal;
    private LocalDate dataVenda;

    public Venda() {
    }

    public Venda(int idVenda,int idCliente, int idLivro, int qtd, float subTotal, LocalDate dataVenda) {
        this.idVenda = idVenda;
        this.idCliente = idCliente;
        this.idLivro = idLivro;
        this.qtd = qtd;
        this.subTotal = subTotal;
        this.dataVenda = dataVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "idVenda=" + idVenda + ", idCliente=" + idCliente + ", idLivro=" + idLivro + ", qtd=" + qtd + ", subTotal=" + subTotal + ", dataVenda=" + dataVenda + '}';
    }
    

    
}
