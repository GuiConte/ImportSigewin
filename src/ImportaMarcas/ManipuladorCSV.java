package ImportaMarcas;

import ImportadorNTS.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LAB
 */
public class ManipuladorCSV {

    public ArrayList<Marcas> lerCSV(String pathCSV) throws IOException {
        ArrayList<Marcas> marcas;
        Properties confs = ManipuladorProperties.returnProperties();

        marcas = new ArrayList<>();

        int cod_marca = -1, nr_marca = -1;

        BufferedReader conteudoCSV = null;
        String linha = "";
        String separador = ";";
        int i = 1;

        if (!confs.getProperty("prop.cod_marca").equals("")) {
            cod_marca = Integer.parseInt(confs.getProperty("prop.cod_marca"));
        }
        if (!confs.getProperty("prop.marca").equals("")) {
            nr_marca = Integer.parseInt(confs.getProperty("prop.marca"));
        }

        conteudoCSV = new BufferedReader(new FileReader(pathCSV));
        conteudoCSV.readLine(); // Pular cabecalho
        while ((linha = conteudoCSV.readLine()) != null) {
            linha = linha.replace("\"", "");
            //System.out.println(linha);
            String[] marca = linha.split(separador);
            try {

                marcas.add(new Marcas(marca[cod_marca], marca[nr_marca]));

                i++;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("linha erro: " + i);
                System.out.println("conteudo: " + linha);
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

                break;
            }
        }
        System.out.println("Leitura Concluida - Registros Lidos: " + i);
        return marcas;
    }

    public ArrayList<Produto_Marca> lerCSVProdMarca(String pathCSV) throws IOException {
        ArrayList<Produto_Marca> produtos_marcas = new ArrayList<>();
        Properties confs = ManipuladorProperties.returnProperties();

        int cod_prod = 0, cod_marca = 1;

        BufferedReader conteudoCSV = null;
        String linha = "";
        String separador = ";";
        int i = 1;

        conteudoCSV = new BufferedReader(new FileReader(pathCSV));
        conteudoCSV.readLine(); // Pular cabecalho
        while ((linha = conteudoCSV.readLine()) != null) {
            linha = linha.replace("\"", "");
            //System.out.println(linha);
            String[] prod_marc = linha.split(separador);
            try {

                produtos_marcas.add(new Produto_Marca(prod_marc[cod_prod], prod_marc[cod_marca]));

                i++;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("linha erro: " + i);
                System.out.println("conteudo: " + linha);
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

                break;
            }
        }
        System.out.println("Leitura Concluida - Registros Lidos: " + i);
        return produtos_marcas;
    }

}
