package br.com.siberius.restwithspringboot.rest;

import br.com.siberius.restwithspringboot.domain.vo.LivroVo;
import br.com.siberius.restwithspringboot.domain.vo.PessoaVo;
import br.com.siberius.restwithspringboot.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("livro")
public class LivroRest {

    @Autowired
    private LivroService service;

    @GetMapping(produces = { "application/json", "application/xml" })
    public List<LivroVo> findAll() {
        //return service.findAll();

        List<LivroVo> livros =  service.findAll();

        livros.stream().forEach(
                p -> p.add(linkTo(methodOn(LivroRest.class).findById(p.getKey())).withSelfRel()
                )
        );
        return livros;
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public LivroVo findById(@PathVariable("id") Long id) {
        LivroVo livroVo = service.findById(id);
        livroVo.add(linkTo(methodOn(LivroRest.class).findById(id)).withSelfRel());
        return livroVo;
    }

    @PostMapping(produces = { "application/json", "application/xml" },
            consumes = { "application/json", "application/xml" })
    public LivroVo create(@RequestBody LivroVo livro) {
        LivroVo livroVO = service.create(livro);
        livroVO.add(linkTo(methodOn(LivroRest.class).findById(livroVO.getKey())).withSelfRel());
        return livroVO;
    }

    @PutMapping(produces = { "application/json", "application/xml" },
            consumes = { "application/json", "application/xml" })
    public LivroVo update(@RequestBody LivroVo livro) {
        LivroVo livroVO = service.update(livro);
        livroVO.add(linkTo(methodOn(LivroRest.class).findById(livroVO.getKey())).withSelfRel());
        return livroVO;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

