/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportadorNTS;

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

    private final String SQL;
    private int maior = 0;

    public ManipuladorFirebird(String SQL) {
        this.SQL = SQL;
    }
    //

    public void desativarTrigger() throws ClassNotFoundException, SQLException, IOException {
        Connection con = new Conexao().getConnectionFirebird();
        String SQL = "ALTER TRIGGER ES_PRODUTO_GEN_ID INACTIVE; ";
        PreparedStatement pst = con.prepareStatement(SQL);
        pst.execute();
        pst.close();
        SQL = "ALTER SEQUENCE SQ_ES_PRODUTO RESTART WITH 0; ";
        pst = con.prepareStatement(SQL);
        pst.execute();
        pst.close();
        con.close();
    }

    public void cadastrarProduto(ArrayList<Produtos> produtos, ProdutosCheck checks, Main janela) throws SQLException, ClassNotFoundException, IOException {
        Iterator<Produtos> it = produtos.iterator();
        int i = 0, x = 0, c = 0;
        int contCheck;
        Produtos produto = null;
        Connection con = new Conexao().getConnectionFirebird();
        PreparedStatement pst = con.prepareStatement(SQL);

        while (it.hasNext()) {
            x++;
            try {
                produto = it.next();
                if (Integer.parseInt(produto.getCod_produto()) > maior) {
                    maior = Integer.parseInt(produto.getCod_produto());
                }
                pst = con.prepareStatement(SQL);
                contCheck = 1;
                if (checks.isCod_produto()) {
                    pst.setString(contCheck, produto.getCod_produto());
                    contCheck++;
                }
                if (checks.isDescricao()) {
                    pst.setString(contCheck, produto.getDescricao());
                    contCheck++;
                }
                if (checks.isCod_barras()) {
                    pst.setString(contCheck, produto.getCod_barras());
                    contCheck++;
                }
                if (checks.isCod_fabrica()) {
                    pst.setString(contCheck, produto.getCod_fabrica());
                    contCheck++;
                }
                if (checks.isComplemento()) {
                    pst.setString(contCheck, produto.getComplemento());
                    contCheck++;
                }
                if (checks.isPreco_compra()) {
                    pst.setString(contCheck, produto.getPreco_compra());
                    contCheck++;
                }
                if (checks.isPreco_venda()) {
                    pst.setString(contCheck, produto.getPreco_venda());
                    contCheck++;
                }
                if (checks.isNcm()) {
                    pst.setString(contCheck, produto.getNcm());
                    contCheck++;
                }
                if (checks.isCest()) {
                    pst.setString(contCheck, produto.getCest());
                    contCheck++;
                }
                if (checks.isCsosn()) {
                    pst.setString(contCheck, produto.getCsosn());
                    contCheck++;
                }
                if (checks.isArt_fiscal()) {
                    pst.setString(contCheck, produto.getArt_fiscal());
                    contCheck++;
                }
                if (checks.isOrigem()) {
                    pst.setString(contCheck, produto.getOrigem());
                    contCheck++;
                }
                if (checks.isPis()) {
                    pst.setString(contCheck, produto.getPis());
                    contCheck++;
                }
                if (checks.isCofins()) {
                    pst.setString(contCheck, produto.getCofins());
                    contCheck++;
                }

                pst.execute();
                pst.close();
                i++;

            } catch (SQLException ex) {
                produto.setCod_barras(produto.getCod_produto() + "2020");
                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                //break;
                try {
                    contCheck = 1;

                    if (checks.isCod_produto()) {
                        pst.setString(contCheck, produto.getCod_produto());
                        contCheck++;
                    }
                    if (checks.isDescricao()) {
                        pst.setString(contCheck, produto.getDescricao());
                        contCheck++;
                    }
                    if (checks.isCod_barras()) {
                        pst.setString(contCheck, produto.getCod_barras());
                        contCheck++;
                    }
                    if (checks.isCod_fabrica()) {
                        pst.setString(contCheck, produto.getCod_fabrica());
                        contCheck++;
                    }
                    if (checks.isComplemento()) {
                        pst.setString(contCheck, produto.getComplemento());
                        contCheck++;
                    }
                    if (checks.isPreco_compra()) {
                        pst.setString(contCheck, produto.getPreco_compra());
                        contCheck++;
                    }
                    if (checks.isPreco_venda()) {
                        pst.setString(contCheck, produto.getPreco_venda());
                        contCheck++;
                    }
                    if (checks.isNcm()) {
                        pst.setString(contCheck, produto.getNcm());
                        contCheck++;
                    }
                    if (checks.isCest()) {
                        pst.setString(contCheck, produto.getCest());
                        contCheck++;
                    }
                    if (checks.isCsosn()) {
                        pst.setString(contCheck, produto.getCsosn());
                        contCheck++;
                    }
                    if (checks.isArt_fiscal()) {
                        pst.setString(contCheck, produto.getArt_fiscal());
                        contCheck++;
                    }
                    if (checks.isOrigem()) {
                        pst.setString(contCheck, produto.getOrigem());
                        contCheck++;
                    }
                    if (checks.isPis()) {
                        pst.setString(contCheck, produto.getPis());
                        contCheck++;
                    }
                    if (checks.isCofins()) {
                        pst.setString(contCheck, produto.getCofins());
                        contCheck++;
                    }

                    pst.execute();
                    pst.close();
                    i++;

                } catch (SQLException ex1) {
                    c++;
                    System.out.println("PRODUTO COM ERRO >>>>>>> " + produto.getCod_produto());
                    System.out.println("Desc: "+produto.getDescricao());
                    System.out.println("Compra: "+produto.getPreco_compra());
                    System.out.println("Venda: "+produto.getPreco_venda());
                    System.out.println("CSOSN: "+produto.getCsosn());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
                    break;
                    /*if (ex1.getErrorCode() != 0) {
                        System.out.println("PRODUTO COM ERRO >>>>>>> " + produto.getCod_produto());
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
                        break;
                    }*/
            }
        }
        janela.appendTxtLog(produto.getCod_produto() + " " + produto.getDescricao());
        //System.out.println(produto.getCod_produto() + " " + produto.getDescricao());
    }

    con.close ();
    String msg = "Importação Concluida.\nProdutos Importados: " + i
            + "\nProduto com erro: " + c
            + "\nCiclos Totais: " + x;

    JOptionPane.showMessageDialog (

null, msg, "Concluido", JOptionPane.INFORMATION_MESSAGE);

        // System.out.println("Importados: " + i);
        // System.out.println("Ciclos: " + x);
        // System.out.println("Erros: " + c);
    }

    public void ativarTrigger() throws ClassNotFoundException, SQLException, IOException {
        Connection con = new Conexao().getConnectionFirebird();
        String SQL = "ALTER TRIGGER ES_PRODUTO_GEN_ID ACTIVE; ";
        PreparedStatement pst = con.prepareStatement(SQL);
        pst.execute();
        pst.close();
        SQL = "ALTER SEQUENCE SQ_ES_PRODUTO RESTART WITH " + maior + "; ";
        pst = con.prepareStatement(SQL);
        pst.execute();
        pst.close();
        con.close();
    }

}
