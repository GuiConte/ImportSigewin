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
public class Endereco {

    static int codigo = 14;
    int id_endereco;
    int id_pessoa;
    String endereco;
    final int grupo_endereco = 1;
    String bairro;
    int id_bairro;
    String cep;
    int id_cidade;
    String telefone;
    String celular;

    public Endereco(int id_endereco,int id_pessoa, String endereco, String bairro, int id_bairro, String cep, int id_cidade, String telefone, String celular) {
        this.id_endereco = id_endereco;
        this.id_pessoa = id_pessoa;
        this.endereco = endereco;
        this.bairro = bairro;
        this.id_bairro = id_bairro;
        this.cep = cep;
        this.id_cidade = id_cidade;
        this.telefone = telefone;
        this.celular = celular;
    }

    public static int getCodigo() {
        return codigo;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
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

    public int getId_bairro() {
        return id_bairro;
    }

    public void setId_bairro(int id_bairro) {
        this.id_bairro = id_bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public static void incrementoID() {
        codigo++;
    }

}
