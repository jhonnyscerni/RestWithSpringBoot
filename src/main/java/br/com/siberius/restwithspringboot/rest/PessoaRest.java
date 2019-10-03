package br.com.siberius.restwithspringboot.rest;

import br.com.siberius.restwithspringboot.domain.vo.PessoaVo;
import br.com.siberius.restwithspringboot.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("pessoa")
public class PessoaRest {

    @Autowired
    private PessoaService service;

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

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public PessoaVo findById(@PathVariable("id") Long id) {
        PessoaVo pessoaVo = service.findById(id);
        pessoaVo.add(linkTo(methodOn(PessoaRest.class).findById(id)).withSelfRel());
        return pessoaVo;
    }

    @PostMapping(produces = { "application/json", "application/xml" },
            consumes = { "application/json", "application/xml" })
    public PessoaVo create(@RequestBody PessoaVo pessoa) {
        PessoaVo pessoaVO = service.create(pessoa);
        pessoaVO.add(linkTo(methodOn(PessoaRest.class).findById(pessoaVO.getKey())).withSelfRel());
        return pessoaVO;
    }

    @PutMapping(produces = { "application/json", "application/xml" },
            consumes = { "application/json", "application/xml" })
    public PessoaVo update(@RequestBody PessoaVo pessoa) {
        PessoaVo pessoaVO = service.update(pessoa);
        pessoaVO.add(linkTo(methodOn(PessoaRest.class).findById(pessoaVO.getKey())).withSelfRel());
        return pessoaVO;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

