package br.com.siberius.restwithspringboot.service;


import br.com.siberius.restwithspringboot.converter.DozerConverter;
import br.com.siberius.restwithspringboot.domain.Pessoa;
import br.com.siberius.restwithspringboot.domain.vo.PessoaVo;
import br.com.siberius.restwithspringboot.exception.ResourceNotFoundException;
import br.com.siberius.restwithspringboot.repository.PessoaRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;


    public List<PessoaVo> findAll(){
        return DozerConverter.parseListObjects(repository.findAll(), PessoaVo.class) ;
    }

    public PessoaVo create(PessoaVo pessoa) {
        var entity = DozerConverter.parseObject(pessoa, Pessoa.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PessoaVo.class);
        return vo;
    }

   public PessoaVo findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nao encontramos nenhum registro para esse ID!"));
        return DozerConverter.parseObject(entity, PessoaVo.class);
   }

    public PessoaVo update(PessoaVo pessoa) {
        var entity = repository.findById(pessoa.getKey()).orElseThrow(
                                            () -> new ResourceNotFoundException("Nao encontramos nenhum registro para esse ID!"));

       entity.setPrimeiroNome(pessoa.getPrimeiroNome());
       entity.setUltimoNome(pessoa.getUltimoNome());
       entity.setEndereco(pessoa.getEndereco());
       entity.setGenero(pessoa.getGenero());

       var vo = DozerConverter.parseObject(repository.save(entity), PessoaVo.class);

       return vo;

    }

    public void delete(Long id) {
        Pessoa entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Nao encontramos nenhum registro para esse ID!"));
        repository.delete(entity);
    }

}
