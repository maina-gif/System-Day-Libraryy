package br.school.com.systemday;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Livro do acervo. O código é a chave da tabela.
@Entity
public class Book {

    @Id
    private String code;

    // Título temático exibido na página inicial.
    private String title;

    // false enquanto o livro está emprestado.
    private boolean available = true;

    protected Book() {
        // Construtor exigido pelo JPA.
    }

    public Book(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
