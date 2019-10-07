package br.com.siberius.restwithspringboot.mocks;

import br.com.siberius.restwithspringboot.domain.Pessoa;
import br.com.siberius.restwithspringboot.domain.vo.PessoaVo;

import java.util.ArrayList;
import java.util.List;

public class MockPessoa {


    public Pessoa mockEntity() {
        return mockEntity(0);
    }

    public PessoaVo mockVO() {
        return mockVO(0);
    }

    public List<Pessoa> mockEntityList() {
        List<Pessoa> persons = new ArrayList<Pessoa>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PessoaVo> mockVOList() {
        List<PessoaVo> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }

    private Pessoa mockEntity(Integer number) {
        Pessoa person = new Pessoa();
        person.setEndereco("Addres Test" + number);
        person.setPrimeiroNome("First Name Test" + number);
        person.setGenero(((number % 2) == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setUltimoNome("Last Name Test" + number);
        return person;
    }

    private PessoaVo mockVO(Integer number) {
        PessoaVo person = new PessoaVo();
        person.setEndereco("Addres Test" + number);
        person.setPrimeiroNome("First Name Test" + number);
        person.setGenero(((number % 2) == 0) ? "Male" : "Female");
        person.setKey(number.longValue());
        person.setUltimoNome("Last Name Test" + number);
        return person;
    }

}