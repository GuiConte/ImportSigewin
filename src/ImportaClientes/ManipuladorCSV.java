package ImportaClientes;

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

    private int col_codigo = 0;
    private int col_nome = 1;
    private int col_fantasia = 2;
    //private int col_perfil = 3;
    private int col_cnpj_cpf = 3;
    private int col_rg_ie = 4;
    private int col_endereco = 5;
    private int col_bairro = 6;
    private int col_cidade = 7;
    private int col_cep = 8;
    private int col_tel1 = 9;
    private int col_tel2 = 10;

    private ArrayList<Pessoa> pessoas;
    private ArrayList<Bairro> bairros;
    private ArrayList<Cidade> cidades;
    private ArrayList<Endereco> enderecos;
    private ArrayList<PessoaFisica> pfisicas;
    private ArrayList<PessoaJuridica> pjuridicas;

    public ArrayList<Pessoa> lerCSV(String pathCSV) throws IOException, ClassNotFoundException, SQLException {
        ManipuladorFirebird fb = new ManipuladorFirebird();

        pessoas = new ArrayList<>();
        bairros = new ArrayList<>();
        cidades = fb.consultaCidades();
        enderecos = new ArrayList<>();
        pfisicas = new ArrayList<>();
        pjuridicas = new ArrayList<>();

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
            String[] pessoa = linha.split(separador);

            //************* PARAMETROS *********
            int semaforo_bairro = 0;
            int id_bairro = -1;
            int id_cidade = 5285;//CIDADE INDEFINIDA
            String tipo_pessoa = "F";
            //**********************************

            try {

                /*if (pessoa[col_perfil].trim().equals("NULL")
                        || pessoa[col_perfil].trim().equals("0")) {
                    tipo_pessoa = "F";
                } else if (pessoa[col_perfil].trim().equals("1")) {
                    tipo_pessoa = "J";
                }*/

                //****************** PESSOA ******************************
                pessoas.add(new Pessoa(Pessoa.codigo,
                        pessoa[col_nome].trim(),
                        pessoa[col_fantasia].trim(),
                        tipo_pessoa,
                        pessoa[col_cnpj_cpf].trim(),
                        pessoa[col_rg_ie].trim(),
                        pessoa[col_endereco].trim(),
                        pessoa[col_bairro].trim(),
                        pessoa[col_cidade].trim(),
                        pessoa[col_cep].trim(),
                        pessoa[col_tel1].trim(),
                        pessoa[col_tel2].trim())
                );

                //****************** PESSOA FISICA/JURIDICA ******************************
               /* if (pessoa[col_perfil].trim().equals("F")
                        || pessoa[col_perfil].trim().equals("NULL")
                        || pessoa[col_perfil].trim().equals("0")) {*/
                    pfisicas.add(new PessoaFisica(Pessoa.codigo,
                            pessoa[col_cnpj_cpf].trim().replace(".", "").replace("-", ""),
                            pessoa[col_rg_ie].trim())
                    );
               /* } else if (pessoa[col_perfil].trim().equals("J")
                        || pessoa[col_perfil].trim().equals("1")) {
                    pjuridicas.add(new PessoaJuridica(Pessoa.codigo,
                            pessoa[col_cnpj_cpf].trim().replace(".", "").replace("-", "").replace("/", ""),
                            pessoa[col_rg_ie].trim())
                    );
                }*/

                //****************** BAIRRO ******************************
                for (int cont = 0; cont < bairros.size(); cont++) {
                    if (pessoa[col_bairro].trim().equals(bairros.get(cont).getBairro())) {
                        semaforo_bairro = 1;
                        id_bairro = bairros.get(cont).getId();
                    }
                }
                if (semaforo_bairro == 0) {
                    if (!pessoa[col_bairro].trim().equals("CENTRO")) {
                        bairros.add(new Bairro(Bairro.codigo, pessoa[col_bairro].trim()));
                        id_bairro = Bairro.codigo;
                    } else {
                        id_bairro = 1;
                        semaforo_bairro = 1;
                    }
                }

                //****************** CIDADE ******************************
                for (int cont = 0; cont < cidades.size(); cont++) {
                    if (pessoa[col_cidade].trim().toUpperCase().equals(cidades.get(cont).getCidade())) {
                        id_cidade = cidades.get(cont).getCodigo();
                        break;
                    }
                }
                if (id_cidade == 5285) {
                    if (pessoa[col_cidade].trim().equals("S JOSE DO RIO PARDO")
                            || pessoa[col_cidade].trim().equals("SAO JOSE RIO PARDO")
                            || pessoa[col_cidade].trim().equals("SJ DO RIO PARDO")) {
                        id_cidade = 3687;
                    } else if (pessoa[col_cidade].trim().equals("GRAMA")
                            || pessoa[col_cidade].trim().equals("S.S.DA GRAMA")
                            || pessoa[col_cidade].trim().equals("S.S. DA GRAMA")
                            || pessoa[col_cidade].trim().equals("S SEBASTIAO DA GRAMA")
                            || pessoa[col_cidade].trim().equals("S S DA GRAMA")
                            || pessoa[col_cidade].trim().equals("SAO SEBASTIAAO DA GRAMA")
                            || pessoa[col_cidade].trim().equals("SS DA GRAMA")
                            || pessoa[col_cidade].trim().equals("SAO SEB. DA GRAMA")
                            || pessoa[col_cidade].trim().equals("SAO SEBASDTIAO DA GRAMA")
                            || pessoa[col_cidade].trim().equals("S. S. DA GRAMA")
                            || pessoa[col_cidade].trim().equals("SAO SEBASTIA DA GRAMA")
                            || pessoa[col_cidade].trim().equals("SAO SEBASTIAO DA GRMA")
                            || pessoa[col_cidade].trim().equals("SAO SABASTIAO DA GRAMA")
                            || pessoa[col_cidade].trim().equals("SAO SEBSTIAO DA GRAMA")
                            || pessoa[col_cidade].trim().equals("SDAO SEBASTIAO DA GRAMA")) {
                        id_cidade = 3697;
                    } else if (pessoa[col_cidade].trim().equals("PO€OS DE CALDAS")
                            || pessoa[col_cidade].trim().equals("POCOS DE CALDAS-MG")
                            || pessoa[col_cidade].trim().equals("PO€OS DE CALDAS/3663-7884")) {
                        id_cidade = 2747;
                    } else if (pessoa[col_cidade].trim().contains("DIV")
                            || pessoa[col_cidade].trim().contains("DII")
                            || pessoa[col_cidade].trim().equals("DIUVINOLANDIA")
                            || pessoa[col_cidade].trim().equals("DINOLANDIA")
                            || pessoa[col_cidade].trim().equals("CAMPESTRINHO")
                            || pessoa[col_cidade].trim().equals("CENTRO")) {
                        id_cidade = 3296;
                    } else if (pessoa[col_cidade].trim().contains("VARGEM GDE DO SUL")
                            || pessoa[col_cidade].trim().contains("VARGEM GRENDE DO SUL")) {
                        id_cidade = 3296;
                    } else if (pessoa[col_cidade].trim().contains("CACONDE VALDIR 9653-7998")
                            || pessoa[col_cidade].trim().contains("CACANDE")) {
                        id_cidade = 3296;
                    }

                }

                //******************* ENDEREÇO ****************************
                enderecos.add(new Endereco(Endereco.codigo,
                        Pessoa.codigo,
                        pessoa[col_endereco].trim(),
                        pessoa[col_bairro].trim(),
                        id_bairro,
                        pessoa[col_cep].trim(),
                        id_cidade,
                        pessoa[col_tel1].trim(),
                        pessoa[col_tel2].trim())
                );

                Pessoa.incrementoID();
                if (semaforo_bairro == 0) {
                    Bairro.incrementoID();
                }
                Endereco.incrementoID();
                i++;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("linha erro: " + i);
                System.out.println("conteudo: " + linha);
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

                break;
            }
        }
        System.out.println("Leitura Concluida - Registros Lidos: " + i);
        return pessoas;
    }

    public ArrayList<Pessoa> returnPessoas() {
        return pessoas;
    }

    public ArrayList<PessoaFisica> returnPessoasFisicas() {
        return pfisicas;
    }

    public ArrayList<PessoaJuridica> returnPessoasJuridicas() {
        return pjuridicas;
    }

    public ArrayList<Bairro> returnBairros() {
        return bairros;
    }

    public ArrayList<Endereco> returnEnderecos() {
        return enderecos;
    }

}
