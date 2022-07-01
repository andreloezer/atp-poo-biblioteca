package Biblioteca;

public class Livro extends ItemAcervo {
    private int ISBN;
    private String resenha;
    private String editora;
    private int numPagina;
    private String genero;

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Livro(String titulo, String autor, int ano, int ISBN, String resenha, String editora, int numPagina, String genero) {
        super(titulo, autor, ano);
        this.ISBN = ISBN;
        this.resenha = resenha;
        this.editora = editora;
        this.numPagina = numPagina;
        this.genero = genero;
    }

    @Override
    public String toString() {
        String obj = super.toString();
        return String.format(
               """
               %s
               ISBN: %d
               Resenha: %s
               Editora: %s
               Número de Páginas: %d
               Gênero: %s
               """, obj, ISBN, resenha, editora, numPagina, genero
        );
    }
}
