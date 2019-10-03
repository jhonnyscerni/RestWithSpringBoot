package br.com.siberius.restwithspringboot.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "Pessoa")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor

public class Pessoa implements Serializable {

    private static final long serialVersionUID = -5001504690838018338L;


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

}
