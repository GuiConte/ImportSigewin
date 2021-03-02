/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportaClientes;

/**
 *
 * @author LAB
 */
public class Pessoa {

    static int codigo = 12;
    int id;
    String razao;
    String fantasia;
    String perfil;
    String cnpj_cpf;
    String rg_ie;
    String endereco;
    String bairro;
    String cidade;
    String cep;
    String tel1;
    String tel2;

    public Pessoa(int id, String razao, String fantasia, String perfil, String cnpj_cpf, String rg_ie, String endereco, String bairro, String cidade, String cep, String tel1, String tel2) {
        this.id = id;
        this.razao = razao;
        this.fantasia = fantasia;
        this.perfil = perfil;
        this.cnpj_cpf = cnpj_cpf;
        this.rg_ie = rg_ie;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.tel1 = tel1;
        this.tel2 = tel2;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getCnpj_cpf() {
        return cnpj_cpf;
    }

    public void setCnpj_cpf(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }

    public String getRg_ie() {
        return rg_ie;
    }

    public void setRg_ie(String rg_ie) {
        this.rg_ie = rg_ie;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }
    
    public static void incrementoID(){
        codigo++;
    }

}
