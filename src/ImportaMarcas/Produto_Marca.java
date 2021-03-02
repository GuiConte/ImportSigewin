/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportaMarcas;

/**
 *
 * @author LAB
 */
public class Produto_Marca {
    private final String cod_produto;
    private final String cod_marca;
    
    public Produto_Marca(String cod_produto,String cod_marca){
        this.cod_produto = cod_produto;
        this.cod_marca = cod_marca;
    }

    /**
     * @return the cod_produto
     */
    public String getCod_produto() {
        return cod_produto;
    }

    /**
     * @return the cod_marca
     */
    public String getCod_marca() {
        return cod_marca;
    }
    
    
    
}
