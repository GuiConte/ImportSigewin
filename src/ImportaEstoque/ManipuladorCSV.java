package ImportaEstoque;

import ImportaClientes.*;
import ImportadorNTS.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

    private final int col_codigo;
    private final int col_estoque;
    private final int col_custo;

    public ManipuladorCSV(int col_codigo, int col_estoque, int col_custo) {
        this.col_codigo = col_codigo;
        this.col_estoque = col_estoque;
        this.col_custo = col_custo;
    }

    private ArrayList<Estoque> estoques;

    public ArrayList<Estoque> lerCSV(String pathCSV) throws IOException, ClassNotFoundException, SQLException {
        ManipuladorFirebird fb = new ManipuladorFirebird();

        estoques = new ArrayList<>();
        int i = 0;

        BufferedReader conteudoCSV = null;
        String linha = "";
        String separador = ";";

        conteudoCSV = new BufferedReader(new FileReader(pathCSV));
        conteudoCSV.readLine(); // Pular cabecalho
        while ((linha = conteudoCSV.readLine()) != null) {
            linha = linha.replace("\"", "");
            linha = linha.replace("\'", "");
            //System.out.println(linha);
            String[] estoque = linha.split(separador);
            
            try {
                
                String custo = "0";
                
                if(!estoque[col_custo].equals("")){
                    custo = estoque[col_custo].replace(",", ".");
                }
                    
                estoques.add(new Estoque(estoque[col_codigo],
                        estoque[col_estoque].replace(",", "."),
                        custo)
                );

                i++;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("linha erro: " + i);
                System.out.println("conteudo: " + linha);
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

                break;
            }

        }
        System.out.println("Leitura Concluida - Registros Lidos: " + i);
        return estoques;

    }

}
