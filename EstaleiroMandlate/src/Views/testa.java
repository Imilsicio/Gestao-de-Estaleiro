/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.ProdutoController;
import Model.Produto;

/**
 *
 * @author Monteiro
 */
public class testa {
    public static void main(String[] args) {
        
   //Produto p2 = new Produto(0, nome, true, descricao);
        Produto p1 = new Produto(1,1029,"Trigo",true,"Para fazer bolo");
    ProdutoController pro = new ProdutoController();
    pro.registar(p1);
    }
    
}
