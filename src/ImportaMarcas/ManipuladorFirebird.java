/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportaMarcas;

import ImportadorNTS.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB
 */
public class ManipuladorFirebird {

    private int maior = 0;

    //
    public void desativarId() throws ClassNotFoundException, SQLException, IOException {
        Connection con = new Conexao().getConnectionFirebird();
        //String SQL = "delete from es_marca where id_marca = 1;";
        String SQL = "delete from es_grupo where id_grupo = 1;";
        PreparedStatement pst = con.prepareStatement(SQL);
        pst.execute();
        pst.close();
        //************************** CERRI ******
        //SQL = "insert into es_grupo(id_grupo,descricao) values (0,'DIVERSOS');";
        //pst = con.prepareStatement(SQL);
        //pst.execute();
        //pst.close();
        //************************************
        con.close();
    }

    public void cadastrarMarca(ArrayList<Marcas> marcas) throws SQLException, ClassNotFoundException, IOException {
        //String SQL = "insert into es_marca(id_marca,descricao) values (?,?);";
        String SQL = "insert into es_grupo(id_grupo,descricao) values (?,?);";

        Iterator<Marcas> it = marcas.iterator();
        int i = 0, x = 0, c = 0;
        Marcas marca = null;
        Connection con = new Conexao().getConnectionFirebird();
        PreparedStatement pst = con.prepareStatement(SQL);

        while (it.hasNext()) {
            x++;
            try {
                marca = it.next();
                if (Integer.parseInt(marca.getCod_marca()) > maior) {
                    maior = Integer.parseInt(marca.getCod_marca());
                }
                pst = con.prepareStatement(SQL);
                pst.setString(1, marca.getCod_marca());
                pst.setString(2, marca.getMarca());

                pst.execute();
                pst.close();
                i++;

            } catch (SQLException ex) {
                System.out.println("RESOLVENDO ERRO >>>>>>> " + marca.getCod_marca());
                try {
                    pst = con.prepareStatement(SQL);
                    pst.setString(1, marca.getCod_marca());
                    pst.setString(2, marca.getMarca() + "(" + marca.getCod_marca() + ")");

                    pst.execute();
                    pst.close();
                    i++;
                } catch (SQLException ex1) {
                    c++;
                    System.out.println("MARCA COM ERRO >>>>>>> " + marca.getCod_marca());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }

            }
            System.out.println(marca.getCod_marca() + " " + marca.getMarca());
        }
        con.close();
        String msg = "Importação Concluida.\nMarcas Importados: " + i
                + "\nMarcas com erro: " + c
                + "\nCiclos Totais: " + x;

        JOptionPane.showMessageDialog(null, msg, "Concluido", JOptionPane.INFORMATION_MESSAGE);

        // System.out.println("Importados: " + i);
        // System.out.println("Ciclos: " + x);
        // System.out.println("Erros: " + c);
    }

    public void atualizarProduto(ArrayList<Produto_Marca> produtos_marcas) throws ClassNotFoundException, SQLException, IOException {
        //String SQL = "update es_produto set id_marca = ? where id_produto = ?";
        String SQL = "update es_produto set id_grupo = ? where id_produto = ?";
        Iterator<Produto_Marca> it = produtos_marcas.iterator();
        int i = 0, x = 0, c = 0;
        Produto_Marca produto_marca = null;
        Connection con = new Conexao().getConnectionFirebird();
        PreparedStatement pst = con.prepareStatement(SQL);

        while (it.hasNext()) {
            x++;
            try {
                produto_marca = it.next();

                pst = con.prepareStatement(SQL);
                pst.setString(1, produto_marca.getCod_marca());
                pst.setString(2, produto_marca.getCod_produto());

                pst.execute();
                pst.close();
                i++;

            } catch (SQLException ex) {
                if (ex.getErrorCode() != 335544466) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }
                try {
                    pst = con.prepareStatement(SQL);
                    pst.setString(1, "0"); // DIVERSOS 
                    pst.setString(2, produto_marca.getCod_produto());
                    pst.execute();
                    i++;
                } catch (SQLException ex1) {
                    c++;
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
 
            }
            System.out.println(produto_marca.getCod_produto() + " " + produto_marca.getCod_marca());
        }
        con.close();
        String msg = "Importação Concluida.\nMarcas Importados: " + i
                + "\nMarcas com erro: " + c
                + "\nCiclos Totais: " + x;

        JOptionPane.showMessageDialog(null, msg, "Concluido", JOptionPane.INFORMATION_MESSAGE);
    }
}
