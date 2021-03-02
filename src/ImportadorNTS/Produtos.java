package ImportadorNTS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LAB
 */
public class Produtos {

    private String cod_produto;
    private String descricao;
    private String cod_barras;
    private String cod_fabrica;
    private String complemento;
    private String preco_compra;
    private String preco_venda;
    private String ncm;
    private String cest;
    private String csosn;
    private String art_fiscal;
    private String origem;
    private String pis;
    private String cofins;
    private String ipi;
    private String qtd_estoque;

    public Produtos() {

    }

    public Produtos(String cod_produto, String descricao, String cod_barras, String cod_fabrica,
            String complemento, String preco_compra, String preco_venda, String ncm, String cest,
            String csosn, String art_fiscal, String origem, String pis, String cofins, String ipi,
            String qtd_estoque) {
        this.cod_produto = cod_produto.replace("\"", "");
        this.descricao = descricao.replace("\"", "");
        this.cod_barras = cod_barras.replace("\"", "");
        this.cod_fabrica = cod_fabrica.replace("\"", "");
        this.complemento = complemento.replace("\"", "");
        this.preco_compra = preco_compra.replace("\"", "");
        this.preco_venda = preco_venda.replace("\"", "");
        this.ncm = ncm.replace("\"", "");
        this.cest = cest.replace("\"", "");
        this.csosn = csosn.replace("\"", "");
        this.art_fiscal = art_fiscal.replace("\"", "");
        this.origem = origem.replace("\"", "");
        this.pis = pis.replace("\"", "");
        this.cofins = cofins.replace("\"", "");
        this.ipi = ipi.replace("\"", "");
        this.qtd_estoque = qtd_estoque.replace("\"", "");
    }

    public String getCod_produto() {
        return cod_produto;
    }

    /**
     * @param cod_produto the cod_produto to set
     */
    public void setCod_produto(String cod_produto) {
        this.cod_produto = cod_produto.replace("\"", "");;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao.trim().replace("\"", "");
    }

    /**
     * @return the cod_barras
     */
    public String getCod_barras() {
        return cod_barras;
    }

    /**
     * @param cod_barras the cod_barras to set
     */
    public void setCod_barras(String cod_barras) {
        this.cod_barras = cod_barras.replace("\"", "");;
    }

    /**
     * @return the cod_fabrica
     */
    public String getCod_fabrica() {
        return cod_fabrica;
    }

    /**
     * @param cod_fabrica the cod_fabrica to set
     */
    public void setCod_fabrica(String cod_fabrica) {
        this.cod_fabrica = cod_fabrica.replace("\"", "");;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento.replace("\"", "");;
    }

    /**
     * @return the preco_compra
     */
    public String getPreco_compra() {
        return preco_compra;
    }

    /**
     * @param preco_compra the preco_compra to set
     */
    public void setPreco_compra(String preco_compra) {
        this.preco_compra = preco_compra.replace("\"", "");;
    }

    /**
     * @return the preco_venda
     */
    public String getPreco_venda() {
        return preco_venda;
    }

    /**
     * @param preco_venda the preco_venda to set
     */
    public void setPreco_venda(String preco_venda) {
        this.preco_venda = preco_venda.replace("\"", "");;
    }

    /**
     * @return the ncm
     */
    public String getNcm() {
        return ncm;
    }

    /**
     * @param ncm the ncm to set
     */
    public void setNcm(String ncm) {
        this.ncm = ncm.replace("\"", "");;
    }

    /**
     * @return the cest
     */
    public String getCest() {
        return cest;
    }

    /**
     * @param cest the cest to set
     */
    public void setCest(String cest) {
        this.cest = cest.replace("\"", "");;
    }

    /**
     * @return the csosn
     */
    public String getCsosn() {
        return csosn;
    }

    /**
     * @param csosn the csosn to set
     */
    public void setCsosn(String csosn) {
        this.csosn = csosn.replace("\"", "");;
    }

    /**
     * @return the art_fiscal
     */
    public String getArt_fiscal() {
        return art_fiscal;
    }

    /**
     * @param art_fiscal the art_fiscal to set
     */
    public void setArt_fiscal(String art_fiscal) {
        this.art_fiscal = art_fiscal;
    }

    /**
     * @return the origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(String origem) {
        this.origem = origem.replace("\"", "");;
    }

    /**
     * @return the pis
     */
    public String getPis() {
        return pis;
    }

    /**
     * @param pis the pis to set
     */
    public void setPis(String pis) {
        this.pis = pis.replace("\"", "");;
    }

    /**
     * @return the cofins
     */
    public String getCofins() {
        return cofins;
    }

    /**
     * @param cofins the cofins to set
     */
    public void setCofins(String cofins) {
        this.cofins = cofins.replace("\"", "");;
    }

    /**
     * @return the ipi
     */
    public String getIpi() {
        return ipi;
    }

    /**
     * @param ipi the ipi to set
     */
    public void setIpi(String ipi) {
        this.ipi = ipi.replace("\"", "");;
    }

    /**
     * @return the qtd_estoque
     */
    public String getQtd_estoque() {
        return qtd_estoque;
    }

    /**
     * @param qtd_estoque the qtd_estoque to set
     */
    public void setQtd_estoque(String qtd_estoque) {
        this.qtd_estoque = qtd_estoque.replace("\"", "");;
    }

}
