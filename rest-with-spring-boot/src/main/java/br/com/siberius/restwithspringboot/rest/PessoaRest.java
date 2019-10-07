package br.com.siberius.restwithspringboot.rest;

import br.com.siberius.restwithspringboot.domain.vo.PessoaVo;
import br.com.siberius.restwithspringboot.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;



@Api(value = "Pessoa Enpoint", tags = "Pessoa Enpoint")
@RestController
@RequestMapping("api/pessoa")
public class PessoaRest {

    @Autowired
    private PessoaService service;

    @Autowired
    private PagedResourcesAssembler<PessoaVo> assembler;


    @ApiOperation(value = "Busca uma pessoa especifica pelo primeiro nome" )
    @GetMapping(value = "/buscarPessoaPorNome/{primeiroNome}", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> findPersonByName(
            @PathVariable("primeiroNome") String primeiroNome,
            @RequestParam(value="page", defaultValue = "0") int page,
            @RequestParam(value="limit", defaultValue = "12") int limit,
            @RequestParam(value="direction", defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "primeiroNome"));

        Page<PessoaVo> pessoas =  service.findPersonByName(primeiroNome, pageable);
        pessoas
                .stream()
                .forEach(p -> p.add(
                        linkTo(methodOn(PessoaRest.class).findById(p.getKey())).withSelfRel()
                        )
                );

        PagedResources<?> resources = assembler.toResource(pessoas);

        return new ResponseEntity<>(resources, HttpStatus.OK);
    }


    @ApiOperation(value = "Lista todas as pessoas")
    @GetMapping(produces = { "application/json", "application/xml"})
    public ResponseEntity<?> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "12") int limit,
            @RequestParam(value = "direction", defaultValue = "asc") String direction
    ) {
        //return service.findAll();

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page,limit, Sort.by(sortDirection, "primeiroNome"));

        Page<PessoaVo> pessoas =  service.findAll(pageable);

        pessoas.stream().forEach(
                p -> p.add(linkTo(methodOn(PessoaRest.class).findById(p.getKey())).withSelfRel()
                )
        );


        PagedResources<?> resources = assembler.toResource(pessoas);

        return new ResponseEntity<>(resources, HttpStatus.OK);

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


    @ApiOperation(value = "Disable a specific person by your ID" )
    @PatchMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public PessoaVo disablePerson(@PathVariable("id") Long id) {
        PessoaVo personVO = service.disablePerson(id);
        personVO.add(linkTo(methodOn(PessoaRest.class).findById(id)).withSelfRel());
        return personVO;
    }

}

