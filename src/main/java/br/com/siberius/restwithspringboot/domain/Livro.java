package br.com.siberius.restwithspringboot.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "Livro")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Livro implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String autor;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;

    @Column
    private Double preco;

    @Column
    private String titulo;

}
