/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportadorNTS;

/**
 *
 * @author LAB
 */
public class ProdutosCheck {

    private final boolean cod_produto;
    private final boolean descricao;
    private final boolean cod_barras;
    private final boolean cod_fabrica;
    private final boolean complemento;
    private final boolean preco_compra;
    private final boolean preco_venda;
    private final boolean ncm;
    private final boolean cest;
    private final boolean csosn;
    private final boolean art_fiscal;
    private final boolean origem;
    private final boolean pis;
    private final boolean cofins;
    private final boolean ipi;
    private final boolean qtd_estoque;
    
    public ProdutosCheck(boolean cod_produto, boolean descricao, boolean cod_barras, boolean cod_fabrica,
            boolean complemento, boolean preco_compra, boolean preco_venda, boolean ncm, boolean cest,
            boolean csosn, boolean art_fiscal, boolean origem, boolean pis, boolean cofins, boolean ipi,
            boolean qtd_estoque) {
        this.cod_produto = cod_produto;
        this.descricao = descricao;
        this.cod_barras = cod_barras;
        this.cod_fabrica = cod_fabrica;
        this.complemento = complemento;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.ncm = ncm;
        this.cest = cest;
        this.csosn = csosn;
        this.art_fiscal = art_fiscal;
        this.origem = origem;
        this.pis = pis;
        this.cofins = cofins;
        this.ipi = ipi;
        this.qtd_estoque = qtd_estoque;
    }

    /**
     * @return the cod_produto
     */
    public boolean isCod_produto() {
        return cod_produto;
    }

    /**
     * @return the descricao
     */
    public boolean isDescricao() {
        return descricao;
    }

    /**
     * @return the cod_barras
     */
    public boolean isCod_barras() {
        return cod_barras;
    }

    /**
     * @return the cod_fabrica
     */
    public boolean isCod_fabrica() {
        return cod_fabrica;
    }

    /**
     * @return the complemento
     */
    public boolean isComplemento() {
        return complemento;
    }

    /**
     * @return the preco_compra
     */
    public boolean isPreco_compra() {
        return preco_compra;
    }

    /**
     * @return the preco_venda
     */
    public boolean isPreco_venda() {
        return preco_venda;
    }

    /**
     * @return the ncm
     */
    public boolean isNcm() {
        return ncm;
    }

    /**
     * @return the cest
     */
    public boolean isCest() {
        return cest;
    }

    /**
     * @return the csosn
     */
    public boolean isCsosn() {
        return csosn;
    }

    /**
     * @return the art_fiscal
     */
    public boolean isArt_fiscal() {
        return art_fiscal;
    }

    /**
     * @return the origem
     */
    public boolean isOrigem() {
        return origem;
    }

    /**
     * @return the pis
     */
    public boolean isPis() {
        return pis;
    }

    /**
     * @return the cofins
     */
    public boolean isCofins() {
        return cofins;
    }

    /**
     * @return the ipi
     */
    public boolean isIpi() {
        return ipi;
    }

    /**
     * @return the qtd_estoque
     */
    public boolean isQtd_estoque() {
        return qtd_estoque;
    }
}
