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
public class Bairro {

    static int codigo = 8;
    int id;
    String bairro;

    public Bairro(int id,String bairro) {
        this.id = id;
        this.bairro = bairro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static int getCodigo() {
        return codigo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public static void incrementoID() {
        codigo++;
    }
}
