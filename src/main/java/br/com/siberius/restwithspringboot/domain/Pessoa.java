package br.com.siberius.restwithspringboot.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "pessoa")

public class Pessoa implements Serializable {

    private static final long serialVersionUID = -5001504690838018338L;

    public Pessoa() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String primeiroNome;

    @Column
    private String ultimoNome;

    @Column
    private String endereco;

    @Column
    private String genero;

    @Column(nullable = false)
    private Boolean enabled;

}
