package br.school.com.systemday;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Aluno cadastrado na biblioteca. A matrícula é a chave da tabela.
@Entity
public class Student {

    @Id
    private String enrollment;

    // true quando o aluno possui multa pendente.
    private boolean pendingFine;

    protected Student() {
        // Construtor exigido pelo JPA.
    }

    public Student(String enrollment, boolean pendingFine) {
        this.enrollment = enrollment;
        this.pendingFine = pendingFine;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public boolean isPendingFine() {
        return pendingFine;
    }
}
