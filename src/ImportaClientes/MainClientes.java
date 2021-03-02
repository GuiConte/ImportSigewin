/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportaClientes;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author LAB
 */
public class MainClientes {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        String pathCSV = "C:\\Workspace\\agrobel\\clientes.csv";
        ManipuladorCSV csv = new ManipuladorCSV();
        csv.lerCSV(pathCSV);
        ManipuladorFirebird fdb = new ManipuladorFirebird(csv);
        fdb.cadastrarPessoa();
        //csv.returnBairros();
    }
    
}
