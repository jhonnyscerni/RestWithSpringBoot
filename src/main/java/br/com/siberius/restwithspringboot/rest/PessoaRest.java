package br.com.siberius.restwithspringboot.rest;

import br.com.siberius.restwithspringboot.domain.vo.PessoaVo;
import br.com.siberius.restwithspringboot.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaRest {

    @Autowired
    private PessoaService service;

    @GetMapping
    public List<PessoaVo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PessoaVo findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public PessoaVo create(PessoaVo pessoa) {
        return service.create(pessoa);
    }

    @PutMapping
    public PessoaVo update(@RequestBody PessoaVo pessoa) {
        return service.update(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

