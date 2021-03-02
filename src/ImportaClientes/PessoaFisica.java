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
public class PessoaFisica {

    int codigo;
    String cpf;
    String rg;

    public PessoaFisica(int codigo, String cpf, String rg) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.rg = rg;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCodigoString() {
        return Integer.toString(codigo);
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

}
