/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportaEstoque;

/**
 *
 * @author LAB
 */
public class Estoque {
    
    static int id_movimento=1;
    private String codigo;
    private String estoque;
    private String custo;

    public Estoque(String codigo, String estoque,String custo) {
        this.codigo = codigo;
        this.estoque = estoque;
        this.custo = custo;
    }

    public static int getId_movimento() {
        return id_movimento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }
    
    public static void incrementaID(){
        id_movimento++;
    }
    
}
