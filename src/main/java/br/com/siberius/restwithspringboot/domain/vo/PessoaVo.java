package br.com.siberius.restwithspringboot.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
public class PessoaVo extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    private Long key;

    private String primeiroNome;

    private String ultimoNome;

    private String endereco;

    private String genero;

}
