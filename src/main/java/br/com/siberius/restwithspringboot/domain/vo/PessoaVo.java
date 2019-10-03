package br.com.siberius.restwithspringboot.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
public class PessoaVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String primeiroNome;

    private String ultimoNome;

    private String endereco;

    private String genero;

}
