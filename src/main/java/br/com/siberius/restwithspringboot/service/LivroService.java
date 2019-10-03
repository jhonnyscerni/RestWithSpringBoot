package br.com.siberius.restwithspringboot.service;


import br.com.siberius.restwithspringboot.converter.DozerConverter;
import br.com.siberius.restwithspringboot.domain.Livro;
import br.com.siberius.restwithspringboot.domain.Pessoa;
import br.com.siberius.restwithspringboot.domain.vo.LivroVo;
import br.com.siberius.restwithspringboot.domain.vo.PessoaVo;
import br.com.siberius.restwithspringboot.exception.ResourceNotFoundException;
import br.com.siberius.restwithspringboot.repository.LivroRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;


    public List<LivroVo> findAll(){
        return DozerConverter.parseListObjects(repository.findAll(), LivroVo.class) ;
    }

    public LivroVo create(LivroVo livro) {
        var entity = DozerConverter.parseObject(livro, Livro.class);
        var vo = DozerConverter.parseObject(repository.save(entity), LivroVo.class);
        return vo;
    }

   public LivroVo findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nao encontramos nenhum registro para esse ID!"));
        return DozerConverter.parseObject(entity, LivroVo.class);
   }

    public LivroVo update(LivroVo livro) {
        var entity = repository.findById(livro.getKey()).orElseThrow(
                                            () -> new ResourceNotFoundException("Nao encontramos nenhum registro para esse ID!"));

       entity.setAutor(livro.getAutor());
       entity.setDataLancamento(livro.getDataLancamento());
       entity.setPreco(livro.getPreco());
       entity.setTitulo(livro.getTitulo());

       var vo = DozerConverter.parseObject(repository.save(entity), LivroVo.class);

       return vo;

    }

    public void delete(Long id) {
        Livro entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Nao encontramos nenhum registro para esse ID!"));
        repository.delete(entity);
    }

}
