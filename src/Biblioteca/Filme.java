package Biblioteca;

public class Filme extends ItemAcervo {
    private int duracao;
    private String sinopse;
    private String produtora;

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public Filme(String titulo, String autor, int ano, int duracao, String sinopse, String produtora) {
        super(titulo, autor, ano);
        this.duracao = duracao;
        this.sinopse = sinopse;
        this.produtora = produtora;
    }

    @Override
    public String toString() {
        String obj = super.toString();
        return String.format(
                """
                %s
                Duração: %d
                Sinopse: %s
                Produtora: %s
                """, obj, duracao, sinopse, produtora
        );
    }
}
