package br.com.siberius.restwithspringboot.repository;

import br.com.siberius.restwithspringboot.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Modifying
    @Query("UPDATE Pessoa p SET p.enabled = false WHERE p.id =:id")
    void disablePersons(@Param("id") Long id);

}
