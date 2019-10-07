package br.com.siberius.restwithspringboot.converter;



import br.com.siberius.restwithspringboot.domain.Pessoa;
import br.com.siberius.restwithspringboot.domain.vo.PessoaVo;
import br.com.siberius.restwithspringboot.mocks.MockPessoa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class DozerConverterTest {

    MockPessoa inputObject;

    @Before
    public void setUp() {
        inputObject = new MockPessoa();
    }

    @Test
    public void parseEntityToVOTest() {
        PessoaVo output = DozerConverter.parseObject(inputObject.mockEntity(), PessoaVo.class);
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("First Name Test0", output.getPrimeiroNome());
        Assert.assertEquals("Last Name Test0", output.getUltimoNome());
        Assert.assertEquals("Addres Test0", output.getEndereco());
        Assert.assertEquals("Male", output.getGenero());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PessoaVo> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PessoaVo.class);
        PessoaVo outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("First Name Test0", outputZero.getPrimeiroNome());
        Assert.assertEquals("Last Name Test0", outputZero.getUltimoNome());
        Assert.assertEquals("Addres Test0", outputZero.getEndereco());
        Assert.assertEquals("Male", outputZero.getGenero());

        PessoaVo outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("First Name Test7", outputSeven.getPrimeiroNome());
        Assert.assertEquals("Last Name Test7", outputSeven.getUltimoNome());
        Assert.assertEquals("Addres Test7", outputSeven.getEndereco());
        Assert.assertEquals("Female", outputSeven.getGenero());

        PessoaVo outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("First Name Test12", outputTwelve.getPrimeiroNome());
        Assert.assertEquals("Last Name Test12", outputTwelve.getUltimoNome());
        Assert.assertEquals("Addres Test12", outputTwelve.getEndereco());
        Assert.assertEquals("Male", outputTwelve.getGenero());
    }

    @Test
    public void parseVOToEntityTest() {
        Pessoa output = DozerConverter.parseObject(inputObject.mockVO(), Pessoa.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getPrimeiroNome());
        Assert.assertEquals("Last Name Test0", output.getUltimoNome());
        Assert.assertEquals("Addres Test0", output.getEndereco());
        Assert.assertEquals("Male", output.getGenero());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Pessoa> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Pessoa.class);
        Pessoa outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getPrimeiroNome());
        Assert.assertEquals("Last Name Test0", outputZero.getUltimoNome());
        Assert.assertEquals("Addres Test0", outputZero.getEndereco());
        Assert.assertEquals("Male", outputZero.getGenero());

        Pessoa outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getPrimeiroNome());
        Assert.assertEquals("Last Name Test7", outputSeven.getUltimoNome());
        Assert.assertEquals("Addres Test7", outputSeven.getEndereco());
        Assert.assertEquals("Female", outputSeven.getGenero());

        Pessoa outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("First Name Test12", outputTwelve.getPrimeiroNome());
        Assert.assertEquals("Last Name Test12", outputTwelve.getUltimoNome());
        Assert.assertEquals("Addres Test12", outputTwelve.getEndereco());
        Assert.assertEquals("Male", outputTwelve.getGenero());
    }
}