/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportaEstoque;

import ImportadorNTS.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

    public void cadastroEstoque(ArrayList<Estoque> estoques) throws SQLException, ClassNotFoundException, IOException {
        String SQL_Estoque = "insert into es_movimento("
                + "id_movimento, id_empresa, id_tipo_estoque, id_tipo_mov, id_produto,"
                + "documento,quantidade,vr_total,id_pessoa,usuario,tipo_mov,mudacusto,"
                + "obs, fg_origem, id_origem, custo, quant_est, valor_est, id_grade,"
                + "id_producao,dt_movimento) "
                + "values "
                + "(?,1,1,5,?,'ACERTO',?,0,1,'MYCOMP','E','N',NULL,'DIG',0,?,0,"
                + "0,NULL,NULL,?)";

        Iterator<Estoque> it_Estoque = estoques.iterator();
        int i = 0, x = 0, c = 0;
        Estoque estoque = null;
        Connection con = new Conexao().getConnectionFirebird();
        PreparedStatement pst = con.prepareStatement(SQL_Estoque);

        while (it_Estoque.hasNext()) {
            x++;
            try {
                estoque = it_Estoque.next();
                pst = con.prepareStatement(SQL_Estoque);
                pst.setInt(1, Estoque.id_movimento);
                pst.setString(2, estoque.getCodigo());
                pst.setString(3, estoque.getEstoque());
                pst.setString(4, estoque.getCusto());
                pst.setString(5, timeStamp());

                pst.execute();
                pst.close();
                i++;
                Estoque.incrementaID();

            } catch (SQLException ex) {
                System.out.println("RESOLVENDO ERRO >>>>>>> " + estoque.getCodigo());
                try {
                    pst = con.prepareStatement(SQL_Estoque);
                    pst.setInt(1, Estoque.id_movimento);
                    pst.setString(2, estoque.getCodigo());
                    pst.setString(3, estoque.getEstoque());
                    pst.setString(4, estoque.getCusto());
                    pst.setString(5, timeStamp());

                    pst.execute();
                    pst.close();
                    i++;
                    Estoque.incrementaID();
                } catch (SQLException ex1) {
                    c++;
                    System.out.println("ESTOQUE COM ERRO >>>>>>> " + estoque.getCodigo());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }

            }
            System.out.println(estoque.getCodigo() + " " + estoque.getEstoque());
        }
        con.close();
        String msg = "Importação Concluida.\nEstoques Importados: " + i
                + "\nEstoques com erro: " + c
                + "\nEstoques Totais: " + x;

        JOptionPane.showMessageDialog(null, msg, "Concluido", JOptionPane.INFORMATION_MESSAGE);

        alterarGenerator();
        // System.out.println("Importados: " + i);
        // System.out.println("Ciclos: " + x);
        // System.out.println("Erros: " + c);
    }

    public void alterarGenerator() throws ClassNotFoundException, SQLException, IOException {
        Connection con = new Conexao().getConnectionFirebird();
        String SQL = "ALTER SEQUENCE SQ_ES_MOVIMENTO RESTART WITH " + Estoque.id_movimento + "; ";;
        PreparedStatement pst = con.prepareStatement(SQL);
        pst.execute();
        pst.close();
        con.close();
    }

    public static String timeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return "" + sdf.format(timestamp);
    }

}
