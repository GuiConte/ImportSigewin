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
public class PessoaJuridica {

    int codigo;
    String cnpj;
    String ie;

    public PessoaJuridica(int codigo, String cnpj, String ie) {
        this.codigo = codigo;
        this.cnpj = cnpj;
        this.ie = ie;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

}
