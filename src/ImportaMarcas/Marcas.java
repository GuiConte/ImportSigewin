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
public class Marcas {

    private final String cod_marca;
    private final String marca;

    public Marcas(String cod_marca, String marca) {
        this.cod_marca = cod_marca;
        this.marca = marca;
    }

    /**
     * @return the cod_marca
     */
    public String getCod_marca() {
        return cod_marca;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

}
