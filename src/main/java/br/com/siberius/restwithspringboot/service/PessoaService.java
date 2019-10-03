package br.com.siberius.restwithspringboot.service;


import br.com.siberius.restwithspringboot.domain.Pessoa;
import br.com.siberius.restwithspringboot.exception.ResourceNotFoundException;
import br.com.siberius.restwithspringboot.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;


    public List<Pessoa> findAll(){
       return repository.findAll();
    }

    public Pessoa create(Pessoa pessoa) {
       return repository.save(pessoa);
    }

   public Pessoa findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nao encontramos nenhum registro para esse ID!"));
   }

    public Pessoa update(Pessoa pessoa) {
        Pessoa entity = repository.findById(pessoa.getId()).orElseThrow(
                                            () -> new ResourceNotFoundException("Nao encontramos nenhum registro para esse ID!"));

       entity.setPrimeiroNome(pessoa.getPrimeiroNome());
       entity.setUltimoNome(pessoa.getUltimoNome());
       entity.setEndereco(pessoa.getEndereco());
       entity.setGenero(pessoa.getGenero());

       return repository.save(entity);

    }

    public void delete(Long id) {
        Pessoa entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Nao encontramos nenhum registro para esse ID!"));
        repository.delete(entity);
    }

}
