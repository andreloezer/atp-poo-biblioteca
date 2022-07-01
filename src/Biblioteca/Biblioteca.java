package Biblioteca;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Biblioteca {
    private ArrayList<ItemAcervo> acervo;
    private final String filepath = "C:\\temp\\arquivo.dat";

    public Biblioteca() {
        acervo = new ArrayList<ItemAcervo>();;
    }

    private String[] getItemInfo(String[] dadosIn) {
        String [] dadosOut = new String[dadosIn.length];
        for (int i = 0; i < dadosIn.length; i++) {
            dadosOut[i] = JOptionPane.showInputDialog(String.format("Entre com %s: ", dadosIn[i]));
        }
        return dadosOut;
    }

    private boolean intValido(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private int inteiro(String entrada) {
        while (!intValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null,
                    "Valor incorreto!\n\nDigite um número inteiro.");
        }

        return Integer.parseInt(entrada);
    }

    private Livro leLivro() {
        String [] valores = new String[8];
        String [] nomeValores = {"titulo", "autor", "ano", "ISBN", "resenha", "editora", "numPaginas", "genero"};
        valores = getItemInfo(nomeValores);

        int ano = inteiro(valores[2]);
        int ISBN = inteiro(valores[3]);
        int numPaginas = inteiro(valores[6]);

        return new Livro(valores[0], valores[1], ano, ISBN, valores[4], valores[5], numPaginas, valores[7]);
    }

    private Artigo leArtigo() {
        String [] valores = new String[6];
        String [] nomeValores = {"titulo", "autor", "ano", "resenha", "tema", "numPaginas"};
        valores = getItemInfo(nomeValores);

        int ano = inteiro(valores[2]);
        int numPaginas = inteiro(valores[5]);

        return new Artigo(valores[0], valores[1], ano, valores[3], valores[4], numPaginas);
    }

    private Filme leFilme() {
        String [] valores = new String[6];
        String [] nomeValores = {"titulo", "autor", "ano", "duracao", "sinopse", "produtora"};
        valores = getItemInfo(nomeValores);

        int ano = inteiro(valores[2]);
        int duracao = inteiro(valores[3]);

        return new Filme(valores[0], valores[1], ano, duracao, valores[4], valores[5]);
    }

    public String getAcervo() {
        String dados = "";
        for (ItemAcervo item: acervo) {
            dados = dados.concat(item.toString() + "---------------\n");
        }
        return dados;
    }

    public void gravarAcervo(ArrayList<ItemAcervo> acervo) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (ItemAcervo item: acervo) {
                objectOutputStream.writeObject(item);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao criar arquivo.");
            ex.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao gravar arquivo.");
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Acervo salvo com sucesso.");
    }

    public ArrayList<ItemAcervo> recuperaAcervo() {
        ArrayList<ItemAcervo> acervo = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object item = null;
            while ((item = objectInputStream.readObject()) != null) {
                acervo.add((ItemAcervo) item);
            }
        } catch (EOFException ex) {
            JOptionPane.showMessageDialog(null, "Acervo recuperado com sucesso.");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo corrompido.");
            ex.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao ler arquivo.");
            ex.printStackTrace();
        }
        return acervo;
    }

    private void menuAddItem() {
        String menu = """
                      Entrada de Item
                      Opções:
                      1. Livro
                      2. Artigo
                      3. Filme
                      """;
        String entrada = JOptionPane.showInputDialog(menu + "\n\n");
        int opc = inteiro(entrada);
        switch (opc) {
            case 1 -> acervo.add(leLivro());
            case 2 -> acervo.add(leArtigo());
            case 3 -> acervo.add(leFilme());
            default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
        }
    }

    private void menuBiblioteca() {
        int opc;
        do {
            String menu = """
                   Biblioteca
                   
                   Opções:
                   
                   1. Entrar Item
                   2. Exibir Acervo
                   3. Limpar Acervo
                   4. Gravar Acervo
                   5. Recuperar Acervo
                   
                   9. Sair
                   """;

            String entrada = JOptionPane.showInputDialog(menu + "\n\n");
            opc = inteiro(entrada);

            switch (opc) {
                case 1 -> menuAddItem();
                case 2 -> {
                    if (acervo.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Acervo vazio");
                        break;
                    }
                    JOptionPane.showMessageDialog(null, getAcervo());
                }
                case 3 -> {
                    acervo.clear();
                    JOptionPane.showMessageDialog(null, "Acervo limpo com sucesso.");
                }
                case 4 -> gravarAcervo(acervo);
                case 5 -> acervo = recuperaAcervo();
                case 9 -> JOptionPane.showMessageDialog(null, "Encerrando...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (opc != 9);
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.menuBiblioteca();
    }
}
