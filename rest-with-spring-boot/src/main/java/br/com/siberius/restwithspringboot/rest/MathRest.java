package br.com.siberius.restwithspringboot.rest;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Calculadora Enpoint", tags = "Calculadora Enpoint")
public class MathRest {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Por favor entre com um valor numerico!");
        }

        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value = "/subtration/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtration(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Por favor entre com um valor numerico!");
        }

        Double subtration = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return subtration;
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Por favor entre com um valor numerico!");
        }

        Double multiplication = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return multiplication;
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Por favor entre com um valor numerico!");
        }

        Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return division;
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Por favor entre com um valor numerico!");
        }

        Double mean = (convertToDouble(numberOne) + convertToDouble(numberTwo)) /2;
        return mean;
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) throws Exception {

        if (!isNumeric(number)) {
            throw new UnsupportedOperationException("Por favor entre com um valor numerico!");
        }

        Double squareRoot = (Double) Math.sqrt(convertToDouble(number));
        return squareRoot;
    }


    private Double convertToDouble(String strNumber){

        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private Boolean isNumeric(String strNumber){
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("^[0-9]*$");
    }
}
