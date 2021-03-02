/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportadorNTS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author LAB
 */
public class ManipuladorProperties {

    static Properties props;
    static FileInputStream file;
    static String path = System.getProperty("user.dir") + "\\conf.properties";

    public static void startProperties() throws FileNotFoundException, IOException {
        props = new Properties();
        file = new FileInputStream(path);
        props.load(file);
    }

    public static Properties returnProperties() throws FileNotFoundException, IOException {
        props = new Properties();
        file = new FileInputStream(path);
        props.load(file);
        return props;
    }

    public static String getPath_banco() throws IOException {
        startProperties();
        return props.getProperty("prop.path_banco");
    }

    public static String getPath_csv() throws IOException {
        startProperties();
        return props.getProperty("prop.path_csv");
    }

    public static void gravarProperties(Properties props) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            props.store(fos, "FILE PROPERTIES:");
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void criarProperties() throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        properties.setProperty("prop.cest", "");
        properties.setProperty("prop.ipi", "");
        properties.setProperty("prop.cod_produto", "");
        properties.setProperty("prop.art_fiscal", "");
        properties.setProperty("prop.qtd_estoque", "");
        properties.setProperty("prop.ncm", "");
        properties.setProperty("prop.descricao", "");
        properties.setProperty("prop.pis", "");
        properties.setProperty("prop.path_banco", "");
        properties.setProperty("prop.origem", "");
        properties.setProperty("prop.csosn", "");
        properties.setProperty("prop.cod_fabrica", "");
        properties.setProperty("prop.preco_compra", "");
        properties.setProperty("prop.cod_barras", "");
        properties.setProperty("prop.complemento", "");
        properties.setProperty("prop.path_csv", "");
        properties.setProperty("prop.cofins", "");
        properties.setProperty("prop.preco_venda", "");
        FileOutputStream fos = new FileOutputStream(path);
        properties.store(fos, "FILE PROPERTIES:");
        fos.close();
    }
}
