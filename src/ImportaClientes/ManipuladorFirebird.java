/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportaClientes;

import ImportaMarcas.*;
import ImportadorNTS.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    private ManipuladorCSV csv;

    private ArrayList<Pessoa> pessoas;
    private ArrayList<Bairro> bairros;
    private ArrayList<Endereco> enderecos;
    private ArrayList<PessoaFisica> pfisicas;
    private ArrayList<PessoaJuridica> pjuridicas;

    public ManipuladorFirebird(ManipuladorCSV csv) {
        this.csv = csv;
    }

    public ManipuladorFirebird() {
    }

    public ArrayList<Cidade> consultaCidades() throws ClassNotFoundException, SQLException, IOException {
        Connection con = new Conexao().getConnectionFirebird();
        String SQL = "select * from ge_cidade";

        PreparedStatement pst = con.prepareStatement(SQL);
        ResultSet rs = pst.executeQuery();

        ArrayList<Cidade> cidades = new ArrayList();
        try {
            if (rs.next()) {
                do {
                    cidades.add(new Cidade(rs.getInt("id_cidade"),
                            rs.getString("nome")
                    ));

                } while (rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //stm.close();
        con.close();

        return cidades;
    }

    public void cadastrarPessoa() throws SQLException, ClassNotFoundException, IOException {
        String SQL_Pessoa = "insert into ge_pessoa(id_pessoa,razao,fantasia,tipo_pessoa,produtor)"
                + " values (?,?,?,?,'N');";

        pessoas = csv.returnPessoas();
        pfisicas = csv.returnPessoasFisicas();
        pjuridicas = csv.returnPessoasJuridicas();
        bairros = csv.returnBairros();
        enderecos = csv.returnEnderecos();

        Iterator<Pessoa> it_Pessoa = pessoas.iterator();
        int i = 0, x = 0, c = 0;
        Pessoa pessoa = null;
        Connection con = new Conexao().getConnectionFirebird();
        PreparedStatement pst = con.prepareStatement(SQL_Pessoa);

        while (it_Pessoa.hasNext()) {
            x++;
            try {
                pessoa = it_Pessoa.next();
                pst = con.prepareStatement(SQL_Pessoa);
                pst.setInt(1, pessoa.getId());
                pst.setString(2, pessoa.getRazao());
                pst.setString(3, pessoa.getFantasia());
                pst.setString(4, pessoa.getPerfil());

                pst.execute();
                pst.close();
                i++;

            } catch (SQLException ex) {
                System.out.println("RESOLVENDO ERRO >>>>>>> " + pessoa.getId());
                try {
                    pst = con.prepareStatement(SQL_Pessoa);
                    pst.setInt(1, pessoa.getId());
                    pst.setString(2, pessoa.getRazao() + " (" + pessoa.getId() + ")");
                    pst.setString(3, pessoa.getFantasia());
                    pst.setString(4, pessoa.getPerfil());

                    pst.execute();
                    pst.close();
                    i++;
                } catch (SQLException ex1) {
                    c++;
                    System.out.println("PESSOA COM ERRO >>>>>>> " + pessoa.getId());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }

            }
            System.out.println(pessoa.getId() + " " + pessoa.getRazao());
        }
        con.close();
        String msg = "Importação Concluida.\nPessoas Importados: " + i
                + "\nPessoas com erro: " + c
                + "\nPessoas Totais: " + x;

        JOptionPane.showMessageDialog(null, msg, "Concluido", JOptionPane.INFORMATION_MESSAGE);

        //*****************************************************************************
        String SQL_Cliente = "INSERT INTO VD_CLIENTE (ID_PESSOA, REVENDA,"
                + " CONTRATO, INATIVO, NEGATIVADO, FG_CONSUMO, FG_REMESSA,"
                + " FG_ATIVO, FG_COMISSAO, DIAS_AVISO, TX_DESCONTO)"
                + " VALUES(?,'N','N','N','N','N','N','S','S',0,0);";


        Iterator<Pessoa> it_Cliente = pessoas.iterator();
        int i_cli = 0, x_cli = 0, c_cli = 0;
        pessoa = null;
        con = new Conexao().getConnectionFirebird();
        pst = con.prepareStatement(SQL_Cliente);

        while (it_Cliente.hasNext()) {
            x_cli++;
            try {
                pessoa = it_Cliente.next();
                pst = con.prepareStatement(SQL_Cliente);
                pst.setInt(1, pessoa.getId());

                pst.execute();
                pst.close();
                i_cli++;

            } catch (SQLException ex) {
                System.out.println("RESOLVENDO ERRO >>>>>>> " + pessoa.getId());
                try {
                    pst = con.prepareStatement(SQL_Cliente);
                    pst.setInt(1, pessoa.getId());

                    pst.execute();
                    pst.close();
                    i_cli++;
                } catch (SQLException ex1) {
                    c_cli++;
                    System.out.println("CLIENTE COM ERRO >>>>>>> " + pessoa.getId());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }

            }
            System.out.println(pessoa.getId() + " " + pessoa.getRazao());
        }
        con.close();
        msg = "Importação Concluida.\nClientes Importados: " + i_cli
                + "\nClientes com erro: " + c_cli
                + "\nClientes Totais: " + x_cli;

        JOptionPane.showMessageDialog(null, msg, "Concluido", JOptionPane.INFORMATION_MESSAGE);

        //*****************************************************************************
        String SQL_PessoaFisica = "INSERT INTO GE_PESSOA_FISICA (ID_PESSOA, CPF, RG, SEXO)"
                + "values (?,?,?,'N');";

        Iterator<PessoaFisica> it_PessoaFisica = pfisicas.iterator();
        int i_PF = 0, x_PF = 0, c_PF = 0;
        PessoaFisica pfisica = null;
        con = new Conexao().getConnectionFirebird();
        pst = con.prepareStatement(SQL_PessoaFisica);

        while (it_PessoaFisica.hasNext()) {
            x_PF++;
            try {
                pfisica = it_PessoaFisica.next();
                pst = con.prepareStatement(SQL_PessoaFisica);
                pst.setInt(1, pfisica.getCodigo());
                pst.setString(2, pfisica.getCpf());
                pst.setString(3, pfisica.getRg());

                pst.execute();
                pst.close();
                i_PF++;

            } catch (SQLException ex) {
                System.out.println("RESOLVENDO ERRO >>>>>>> " + pfisica.getCodigo());
                try {
                    pst = con.prepareStatement(SQL_PessoaFisica);
                    pst.setInt(1, pfisica.getCodigo());
                    pst.setString(2, pfisica.getCodigoString());
                    pst.setString(3, pfisica.getRg());

                    pst.execute();
                    pst.close();
                    i_PF++;
                } catch (SQLException ex1) {
                    c_PF++;
                    System.out.println("PESSOA COM ERRO Fisica >>>>>>> " + pfisica.getCodigo());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }

            }
            System.out.println(pfisica.getCodigo() + " " + pfisica.getCpf());
        }
        con.close();
        msg = "Importação Concluida.\nPessoas Fisicas Importados: " + i_PF
                + "\nPessoas Fisicas com erro: " + c_PF
                + "\nPessoas Fisicas Totais: " + x_PF;

        JOptionPane.showMessageDialog(null, msg, "Concluido", JOptionPane.INFORMATION_MESSAGE);

        //********************************************************************************
        String SQL_PessoaJuridica = "INSERT INTO GE_PESSOA_JURIDICA (ID_PESSOA, CNPJ, INSC_ESTADUAL)"
                + "values (?,?,?);";

        Iterator<PessoaJuridica> it_PessoaJuridica = pjuridicas.iterator();
        int i_PJ = 0, x_PJ = 0, c_PJ = 0;
        PessoaJuridica pjuridica = null;
        con = new Conexao().getConnectionFirebird();
        pst = con.prepareStatement(SQL_PessoaJuridica);

        while (it_PessoaJuridica.hasNext()) {
            x_PJ++;
            try {
                pjuridica = it_PessoaJuridica.next();
                pst = con.prepareStatement(SQL_PessoaJuridica);
                pst.setInt(1, pjuridica.getCodigo());
                pst.setString(2, pjuridica.getCnpj());
                pst.setString(3, pjuridica.getIe());

                pst.execute();
                pst.close();
                i_PJ++;

            } catch (SQLException ex) {
                System.out.println("RESOLVENDO ERRO >>>>>>> " + pjuridica.getCodigo());
                System.out.println(ex.getMessage());
                try {
                    pst = con.prepareStatement(SQL_PessoaJuridica);
                    pst.setInt(1, pjuridica.getCodigo());
                    pst.setString(2, pjuridica.getCodigoString());
                    pst.setString(3, pjuridica.getIe());

                    pst.execute();
                    pst.close();
                    i_PJ++;
                } catch (SQLException ex1) {
                    c_PJ++;
                    System.out.println("PESSOA COM ERRO Juridica >>>>>>> " + pjuridica.getCodigo());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }

            }
            System.out.println(pjuridica.getCodigo() + " " + pjuridica.getCnpj());
        }
        con.close();
        msg = "Importação Concluida.\nPessoas Juridicas Importados: " + i_PJ
                + "\nPessoas Juridicas com erro: " + c_PJ
                + "\nPessoas Juridicas Totais: " + x_PJ;

        JOptionPane.showMessageDialog(null, msg, "Concluido", JOptionPane.INFORMATION_MESSAGE);

        //******************************************************************************
        String SQL_Bairro = "INSERT INTO GE_BAIRRO (ID_BAIRRO, NOME) VALUES (?, ?)";

        Iterator<Bairro> it_Bairro = bairros.iterator();
        int i_Bairro = 0, x_Bairro = 0, c_Bairro = 0;
        Bairro bairro = null;
        con = new Conexao().getConnectionFirebird();
        pst = con.prepareStatement(SQL_Bairro);

        while (it_Bairro.hasNext()) {
            x_Bairro++;
            try {
                bairro = it_Bairro.next();
                pst = con.prepareStatement(SQL_Bairro);
                pst.setInt(1, bairro.getId());
                pst.setString(2, bairro.getBairro());

                pst.execute();
                pst.close();
                i_Bairro++;

            } catch (SQLException ex) {
                System.out.println("RESOLVENDO ERRO >>>>>>> " + bairro.getId());
                try {
                    pst = con.prepareStatement(SQL_Bairro);
                    pst.setInt(1, bairro.getId());
                    pst.setString(2, bairro.getBairro() + " (" + bairro.getId() + ")");

                    pst.execute();
                    pst.close();
                    i_Bairro++;
                } catch (SQLException ex1) {
                    c_Bairro++;
                    System.out.println("BAIRRO COM ERRO >>>>>>> " + bairro.getId());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }

            }
            System.out.println(bairro.getId() + " " + bairro.getBairro());
        }
        con.close();
        msg = "Importação Concluida.\nBairros Importados: " + i_Bairro
                + "\nBairros com erro: " + c_Bairro
                + "\nBairros Totais: " + x_Bairro;

        JOptionPane.showMessageDialog(null, msg, "Concluido", JOptionPane.INFORMATION_MESSAGE);

        //******************************************************************************
        String SQL_Endereco = "INSERT INTO GE_PESSOA_ENDERECO (ID_ENDERECO, ID_PESSOA,"
                + " ID_GRUPO_ENDERECO, ENDERECO, CEP, ID_CIDADE, TELEFONE, ID_BAIRRO,"
                + " CELULAR) VALUES (?, ?, 1, ?, ?, ?, ?, ?, ?)";

        Iterator<Endereco> it_Endereco = enderecos.iterator();
        int i_Endereco = 0, x_Endereco = 0, c_Endereco = 0;
        Endereco endereco = null;
        con = new Conexao().getConnectionFirebird();
        pst = con.prepareStatement(SQL_Endereco);

        while (it_Endereco.hasNext()) {
            x_Endereco++;
            try {
                endereco = it_Endereco.next();
                pst = con.prepareStatement(SQL_Endereco);
                pst.setInt(1, endereco.getId_endereco());
                pst.setInt(2, endereco.getId_pessoa());
                pst.setString(3, endereco.getEndereco());
                pst.setString(4, endereco.getCep());
                pst.setInt(5, endereco.getId_cidade());
                pst.setString(6, endereco.getTelefone());
                pst.setInt(7, endereco.getId_bairro());
                pst.setString(8, endereco.getCelular());

                pst.execute();
                pst.close();
                i_Endereco++;

            } catch (SQLException ex) {
                System.out.println("RESOLVENDO ERRO >>>>>>> " + endereco.getId_endereco());
                try {
                    pst = con.prepareStatement(SQL_Endereco);
                    pst.setInt(1, endereco.getId_endereco());
                    pst.setInt(2, endereco.getId_pessoa());
                    pst.setString(3, endereco.getEndereco());
                    pst.setString(4, endereco.getCep());
                    pst.setInt(5, endereco.getId_cidade());
                    pst.setString(6, endereco.getTelefone());
                    pst.setInt(7, endereco.getId_bairro());
                    pst.setString(8, endereco.getCelular());

                    pst.execute();
                    pst.close();
                    i_Endereco++;
                } catch (SQLException ex1) {
                    c_Endereco++;
                    System.out.println("endereco COM ERRO >>>>>>> " + endereco.getId_endereco() + " \nBairro: " + endereco.getId_bairro() + "CEP" +endereco.getCep());
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }

            }
            System.out.println(endereco.getId_endereco() + " " + endereco.getEndereco());
        }
        con.close();
        msg = "Importação Concluida.\nEnderecos Importados: " + i_Endereco
                + "\nEnderecos com erro: " + c_Endereco
                + "\nEnderecos Totais: " + x_Endereco;

        JOptionPane.showMessageDialog(null, msg, "Concluido", JOptionPane.INFORMATION_MESSAGE);
        // System.out.println("Importados: " + i);
        // System.out.println("Ciclos: " + x);
        // System.out.println("Erros: " + c);
    }

}
