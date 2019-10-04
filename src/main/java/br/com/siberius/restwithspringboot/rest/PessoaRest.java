package br.com.siberius.restwithspringboot.rest;

import br.com.siberius.restwithspringboot.domain.vo.PessoaVo;
import br.com.siberius.restwithspringboot.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Api(value = "Pessoa Enpoint", tags = "Pessoa Enpoint")
@RestController
@RequestMapping("api/pessoa")
public class PessoaRest {

    @Autowired
    private PessoaService service;

    @ApiOperation(value = "Lista todas as pessoas")
    @GetMapping(produces = { "application/json", "application/xml"})
    public List<PessoaVo> findAll() {
        //return service.findAll();

        List<PessoaVo> pessoas =  service.findAll();

        pessoas.stream().forEach(
                p -> p.add(linkTo(methodOn(PessoaRest.class).findById(p.getKey())).withSelfRel()
                )
        );
        return pessoas;
    }

    @ApiOperation(value = "Buscar uma pessoa especifica pelo seu ID")
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public PessoaVo findById(@PathVariable("id") Long id) {
        PessoaVo pessoaVo = service.findById(id);
        pessoaVo.add(linkTo(methodOn(PessoaRest.class).findById(id)).withSelfRel());
        return pessoaVo;
    }

    @ApiOperation(value = "Criar uma nova pessoa")
    @PostMapping(produces = { "application/json", "application/xml" },
            consumes = { "application/json", "application/xml" })
    public PessoaVo create(@RequestBody PessoaVo pessoa) {
        PessoaVo pessoaVO = service.create(pessoa);
        pessoaVO.add(linkTo(methodOn(PessoaRest.class).findById(pessoaVO.getKey())).withSelfRel());
        return pessoaVO;
    }

    @ApiOperation(value = "Atualizar uma pessoa")
    @PutMapping(produces = { "application/json", "application/xml" },
            consumes = { "application/json", "application/xml" })
    public PessoaVo update(@RequestBody PessoaVo pessoa) {
        PessoaVo pessoaVO = service.update(pessoa);
        pessoaVO.add(linkTo(methodOn(PessoaRest.class).findById(pessoaVO.getKey())).withSelfRel());
        return pessoaVO;
    }

    @ApiOperation(value = "Deletar uma pessoa especifica pelo seu ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

