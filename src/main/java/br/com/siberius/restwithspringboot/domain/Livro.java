package br.com.siberius.restwithspringboot.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "livro")
public class Livro implements Serializable {


    private static final long serialVersionUID = 1L;

    public Livro() {
    }

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
