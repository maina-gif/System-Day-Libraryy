package br.school.com.systemday;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

// Cadastra alunos e livros fictícios ao iniciar a aplicação.
// Nada é duplicado: o que já existe no banco é mantido, inclusive se o livro está emprestado.
@Component
public class DataInitializer implements CommandLineRunner {

    // Livro inicial do acervo: código e título temático.
    private record BookSeed(String code, String title) {
    }

    private static final List<BookSeed> BOOKS = List.of(
            new BookSeed("L001", "Frieren's Grimoire of Flowers"),
            new BookSeed("L002", "Madoka's Wish: A Magical Girl's Diary"),
            new BookSeed("L003", "Megumin's Guide to Explosion Magic"),
            new BookSeed("L004", "Merlin's Library of Forbidden Spells"),
            new BookSeed("L005", "Kazuma's Guide to Lucky Adventures"),
            new BookSeed("L006", "Aqua's Handbook of Healing Magic"),
            new BookSeed("L007", "Stark's Notes on Heavy Axes"),
            new BookSeed("L008", "Fern's Rules of Quick Magic"),
            new BookSeed("L009", "Himmel's Tales of the Hero Party"),
            new BookSeed("L010", "Homura's Timeline Notes")
    );

    private final StudentRepository students;
    private final BookRepository books;

    public DataInitializer(StudentRepository students, BookRepository books) {
        this.students = students;
        this.books = books;
    }

    @Override
    public void run(String... args) {
        if (students.count() == 0) {
            students.saveAll(List.of(
                    new Student("1001", false),
                    new Student("1002", true),   // possui multa pendente
                    new Student("1003", false)
            ));
        }

        // Cria os livros que faltam e atualiza o título dos que já existem.
        for (BookSeed seed : BOOKS) {
            Book book = books.findById(seed.code())
                    .orElseGet(() -> new Book(seed.code(), seed.title()));
            book.setTitle(seed.title());
            books.save(book);
        }
    }
}
