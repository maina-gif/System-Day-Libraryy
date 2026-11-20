package br.school.com.systemday;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    // Quantos empréstimos a matrícula já possui.
    long countByEnrollment(String enrollment);
}
