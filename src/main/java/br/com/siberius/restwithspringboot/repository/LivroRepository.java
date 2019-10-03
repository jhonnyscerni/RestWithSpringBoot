package br.com.siberius.restwithspringboot.repository;

import br.com.siberius.restwithspringboot.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
