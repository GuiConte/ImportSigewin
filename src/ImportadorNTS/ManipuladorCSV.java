package ImportadorNTS;

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

    public ArrayList<Produtos> lerCSV(ProdutosCheck checks, Main janela) throws IOException {
        ArrayList<Produtos> produtos;
        Properties confs = ManipuladorProperties.returnProperties();

        produtos = new ArrayList<>();

        int cod_produto = -1, descricao = -1, cod_barras = -1, cod_fabrica = -1,
                complemento = -1, preco_compra = -1, preco_venda = -1, ncm = -1,
                cest = -1, csosn = -1, art_fiscal = -1, origem = -1, pis = -1,
                cofins = -1, ipi = -1, qtd_estoque = -1;

        String pathCSV = confs.getProperty("prop.path_csv");
        BufferedReader conteudoCSV = null;
        String linha = "";
        String separador = ";";
        int i = 1;

        if (!confs.getProperty("prop.cod_produto").equals("")) {
            cod_produto = Integer.parseInt(confs.getProperty("prop.cod_produto"));
        }
        if (!confs.getProperty("prop.descricao").equals("")) {
            descricao = Integer.parseInt(confs.getProperty("prop.descricao"));
        }
        if (!confs.getProperty("prop.cod_barras").equals("")) {
            cod_barras = Integer.parseInt(confs.getProperty("prop.cod_barras"));
        }
        if (!confs.getProperty("prop.cod_fabrica").equals("")) {
            cod_fabrica = Integer.parseInt(confs.getProperty("prop.cod_fabrica"));
        }
        if (!confs.getProperty("prop.complemento").equals("")) {
            complemento = Integer.parseInt(confs.getProperty("prop.complemento"));
        }
        if (!confs.getProperty("prop.preco_compra").equals("")) {
            preco_compra = Integer.parseInt(confs.getProperty("prop.preco_compra"));
        }
        if (!confs.getProperty("prop.preco_venda").equals("")) {
            preco_venda = Integer.parseInt(confs.getProperty("prop.preco_venda"));
        }
        if (!confs.getProperty("prop.ncm").equals("")) {
            ncm = Integer.parseInt(confs.getProperty("prop.ncm"));
        }
        if (!confs.getProperty("prop.cest").equals("")) {
            cest = Integer.parseInt(confs.getProperty("prop.cest"));
        }
        if (!confs.getProperty("prop.csosn").equals("")) {
            csosn = Integer.parseInt(confs.getProperty("prop.csosn"));
        }
        if (!confs.getProperty("prop.art_fiscal").equals("")) {
            art_fiscal = Integer.parseInt(confs.getProperty("prop.art_fiscal"));
        }
        if (!confs.getProperty("prop.origem").equals("")) {
            origem = Integer.parseInt(confs.getProperty("prop.origem"));
        }
        if (!confs.getProperty("prop.pis").equals("")) {
            pis = Integer.parseInt(confs.getProperty("prop.pis"));
        }
        if (!confs.getProperty("prop.cofins").equals("")) {
            cofins = Integer.parseInt(confs.getProperty("prop.cofins"));
        }
        if (!confs.getProperty("prop.ipi").equals("")) {
            ipi = Integer.parseInt(confs.getProperty("prop.ipi"));
        }
        if (!confs.getProperty("prop.qtd_estoque").equals("")) {
            qtd_estoque = Integer.parseInt(confs.getProperty("prop.qtd_estoque"));
        }

        conteudoCSV = new BufferedReader(new FileReader(pathCSV));
        conteudoCSV.readLine(); // Pular cabecalho
        while ((linha = conteudoCSV.readLine()) != null) {
            //linha = linha.replace("\"", "");
            //System.out.println(linha);
            String[] produto = linha.split(separador);
            try {
                boolean codBarras = true;
                String barras = produto[cod_barras];
                String marca = "";
                String aux_ncm = "";
                String aux_cest = "";
                if (barras.equals("") || barras.equals("0")) {
                    barras = produto[cod_produto];
                    codBarras = false;
                }
                if (Main.chkMarca.isSelected()) {
                    int col_marca = Integer.parseInt(Main.txtMarca.getText());
                    if (!produto[col_marca].equals("N")) {
                        marca = " " + produto[col_marca];
                    }
                }
                Produtos prod = new Produtos();
                if (checks.isCod_produto()) {
                    prod.setCod_produto(produto[cod_produto]);
                }
                if (checks.isDescricao()) {
                    String desc;
                    if (!isValidBarCodeEAN(barras.replace(" ", "")) && codBarras) {
                        desc = produto[descricao].trim() + marca + " " + barras.replace(" ", "") + " (" + produto[cod_produto] + ")";
                    } else {
                        desc = produto[descricao].trim() + marca + " (" + produto[cod_produto] + ")";
                    }
                    prod.setDescricao(desc);
                }
                if (checks.isCod_barras()) {
                    prod.setCod_barras(barras.replace(" ", ""));
                }
                if (checks.isCod_fabrica()) {
                    prod.setCod_fabrica(produto[cod_fabrica]);
                }
                if (checks.isComplemento()) {
                    prod.setComplemento(produto[complemento]);
                }
                if (checks.isPreco_compra()) {
                    if (!produto[preco_compra].replace("\"", "").equals("")) {
                        prod.setPreco_compra(produto[preco_compra].replace(",", "."));
                    } else {
                        prod.setPreco_compra("0");
                    }
                }
                if (checks.isPreco_venda()) {
                    if (!produto[preco_venda].replace("\"", "").equals("")) {
                        prod.setPreco_venda(produto[preco_venda].replace(",", "."));
                    } else {
                        prod.setPreco_venda("0");
                    }
                }
                if (checks.isNcm()) {
                    if (!produto[ncm].equals("N") && !produto[ncm].equals("")
                            && !produto[ncm].equals("0") && !produto[ncm].equals("NULL")
                            && !produto[ncm].equals("00000000")) {
                        aux_ncm = produto[ncm];
                    }
                    prod.setNcm(aux_ncm);
                }
                if (checks.isCest()) {
                    if (!produto[cest].equals("NULL")) {
                        aux_cest = produto[cest];
                    }
                    prod.setCest(aux_cest);
                }
                if (checks.isCsosn()) {
                    if (produto[csosn].equals("060") || produto[csosn].equals("60") || 
                              produto[csosn].equals("160") || produto[csosn].equals("260") || 
                              produto[csosn].equals("560") || produto[csosn].equals("06")) {
                        prod.setCsosn("500");
                    } else if (produto[csosn].equals("040") || produto[csosn].equals("140")
                            || produto[csosn].equals("240") || produto[csosn].equals("340")
                            || produto[csosn].equals("540")) {
                        prod.setCsosn("102");
                    } else if (produto[csosn].equals("020")) {
                        prod.setCsosn("101");
                    } else if (produto[csosn].equals("010")) {
                        prod.setCsosn("500");
                    } else if (produto[csosn].equals("051") || produto[csosn].equals("101")) {
                        prod.setCsosn("101");
                    } else if (produto[csosn].equals("500")) {
                        prod.setCsosn("500");
                    } else {
                        prod.setCsosn("");
                    }///*************IMPORTAÇAO BELISCAO***************
                    //prod.setCsosn(produto[csosn]);
                    // prod.setCsosn("400");
                    /*if (produto[csosn].replace("\"", "").equals("500")) {
                        prod.setCsosn("500");
                    } else if (produto[csosn].replace("\"", "").equals("102")) {
                        prod.setCsosn("102");
                    }*/
                }
                if (checks.isArt_fiscal()) {
                    /*if (produto[art_fiscal].equals("5102")) {
                        prod.setArt_fiscal("1");
                    } else if (produto[art_fiscal].equals("5401")) {
                        prod.setArt_fiscal("4");
                    } else if (produto[art_fiscal].equals("6401")) {
                        prod.setArt_fiscal("5");
                    } else if (produto[art_fiscal].equals("5104")) {
                        prod.setArt_fiscal("2");
                    } else if (produto[art_fiscal].equals("5201")) {
                        prod.setArt_fiscal("3");
                    } else {
                        prod.setArt_fiscal("");
                    }*/

 /* if (produto[art_fiscal].equals("010") || produto[art_fiscal].equals("060")
                            || produto[art_fiscal].equals("070") || produto[art_fiscal].equals("110")
                            || produto[art_fiscal].equals("160") || produto[art_fiscal].equals("260")
                            || produto[art_fiscal].equals("510") || produto[art_fiscal].equals("560")
                            || produto[art_fiscal].equals("570")) {
                        prod.setArt_fiscal("6");
                    } else {
                        prod.setArt_fiscal("1");
                    }*/
                    if (produto[art_fiscal].replace("\"", "").equals("5405")) {
                        prod.setArt_fiscal("5");
                    } else if (produto[art_fiscal].replace("\"", "").equals("5102")) {
                        prod.setArt_fiscal(null);
                    }
                }
                if (checks.isOrigem()) {
                    prod.setOrigem(produto[origem]);
                }
                if (checks.isPis()) {
                    if (produto[pis].length() == 1) {
                        prod.setPis("0" + produto[pis]);
                    } else {
                        prod.setPis(produto[pis]);
                    }
                }
                if (checks.isCofins()) {
                    if (produto[cofins].length() == 1) {
                        prod.setCofins("0" + produto[cofins]);
                    } else {
                        prod.setCofins(produto[cofins]);
                    }
                }
                if (checks.isIpi()) {
                    prod.setIpi(produto[ipi]);
                }
                if (checks.isQtd_estoque()) {
                    prod.setQtd_estoque(produto[qtd_estoque]);
                }
                produtos.add(prod);

                System.out.println(prod.getCod_produto()+" - "+prod.getDescricao().trim()+ " - "+prod.getCsosn());
                i++;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("linha erro: " + i);
                System.out.println("conteudo: " + linha);
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

                break;
            }
        }
        janela.appendTxtLog("Leitura Concluida - Registros Lidos: " + i);
        return produtos;
    }

    public boolean isValidBarCodeEAN(String barCode) {
        return barCode.length() >= 8;
    }

    public String geraSQL(ProdutosCheck checks) {
        String insert = "", values = "";

        if (checks.isCod_produto()) {
            insert += "id_produto";
            values += "?";
        }
        if (checks.isDescricao()) {
            insert += ",descricao";
            values += ",?";
        }
        if (checks.isCod_barras()) {
            insert += ",codigo_barras";
            values += ",?";
        }
        if (checks.isCod_fabrica()) {
            insert += ",codfab";
            values += ",?";
        }
        if (checks.isComplemento()) {
            insert += ",complemento";
            values += ",?";
        }
        if (checks.isPreco_compra()) {
            insert += ",preco_compra";
            values += ",?";
        }
        if (checks.isPreco_venda()) {
            insert += ",preco_venda";
            values += ",?";
        }
        if (checks.isNcm()) {
            insert += ",codigo_fiscal";
            values += ",?";
        }
        if (checks.isCest()) {
            insert += ",cest";
            values += ",?";
        }
        if (checks.isCsosn()) {
            insert += ",csosn";
            values += ",?";
        }
        if (checks.isArt_fiscal()) {
            insert += ",id_artigo_fiscal";
            values += ",?";
        }
        if (checks.isOrigem()) {
            insert += ",origem";
            values += ",?";
        }
        if (checks.isPis()) {
            insert += ",cstpis";
            values += ",?";
        }
        if (checks.isCofins()) {
            insert += ",cstcofins";
            values += ",?";
        }
        if (checks.isIpi()) {

        }
        if (checks.isQtd_estoque()) {

        }

        insert += ",id_empresa,id_grupo,emb_compra,emb_venda";
        values += ",1,1,0,0";

        return "Insert into es_produto(" + insert + ") values (" + values + ");";

    }
}
