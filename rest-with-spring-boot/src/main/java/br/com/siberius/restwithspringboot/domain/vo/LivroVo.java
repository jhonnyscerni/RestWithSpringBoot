package br.com.siberius.restwithspringboot.domain.vo;


import com.github.dozermapper.core.Mapping;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class LivroVo extends ResourceSupport implements Serializable {


    private static final long serialVersionUID = 1L;

    public LivroVo() {
    }

    @Mapping("id")
    private Long key;

    private String autor;

    private Date dataLancamento;

    private Double preco;

    private String titulo;


}
