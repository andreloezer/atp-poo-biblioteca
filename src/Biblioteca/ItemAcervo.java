package Biblioteca;
import java.io.Serializable;

public abstract class ItemAcervo implements Serializable {
    private String titulo;
    private String autor;
    private int ano;

    public ItemAcervo(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String toString() {
        return String.format(
               """
               Título: %s,
               Autor: %s,
               Ano: %d""", getTitulo(), getAutor(), getAno()
        );
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
