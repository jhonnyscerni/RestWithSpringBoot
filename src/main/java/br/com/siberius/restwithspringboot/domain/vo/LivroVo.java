package br.com.siberius.restwithspringboot.domain.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.dozermapper.core.Mapping;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.hateoas.ResourceSupport;

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
public class LivroVo extends ResourceSupport implements Serializable {


    private static final long serialVersionUID = 1L;

    @Mapping("id")
    private Long key;

    private String autor;

    private Date dataLancamento;

    private Double preco;

    private String titulo;

}
