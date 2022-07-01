package Biblioteca;

public class Artigo extends ItemAcervo {
    private String resenha;
    private String tema;
    private int numPaginas;

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public Artigo(String titulo, String autor, int ano, String resenha, String tema, int numPaginas) {
        super(titulo, autor, ano);
        this.resenha = resenha;
        this.tema = tema;
        this.numPaginas = numPaginas;
    }

    public String toString() {
        String obj = super.toString();
        return String.format(
                """
                %s
                Resenha: %s
                Tema: %s
                Número de Páginas: %d
                """, obj, resenha, tema, numPaginas
        );
    }
}
