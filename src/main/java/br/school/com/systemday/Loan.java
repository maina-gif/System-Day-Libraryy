package br.school.com.systemday;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Empréstimo registrado: qual aluno pegou qual livro e quando.
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enrollment;

    private String bookCode;

    private LocalDateTime loanDate = LocalDateTime.now();

    protected Loan() {
        // Construtor exigido pelo JPA.
    }

    public Loan(String enrollment, String bookCode) {
        this.enrollment = enrollment;
        this.bookCode = bookCode;
    }

    public Long getId() {
        return id;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public String getBookCode() {
        return bookCode;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    // Data formatada para exibir na página de registros.
    public String getLoanDateText() {
        return loanDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
