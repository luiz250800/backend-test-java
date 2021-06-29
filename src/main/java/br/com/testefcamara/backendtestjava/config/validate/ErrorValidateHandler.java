package br.com.testefcamara.backendtestjava.config.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para tratamento de erros de validação de usuário.
 */
@RestControllerAdvice
public class ErrorValidateHandler {

    @Autowired
    private MessageSource messageSource;

    /**
     * Método para tratamento de retorno de erros de usuário.
     * @param exc
     * @return
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FormErrorDto> handle(MethodArgumentNotValidException exc){
        List<FormErrorDto> formErrorDto = new ArrayList<>();
        List<FieldError> fieldErrors = exc.getBindingResult().getFieldErrors();

        fieldErrors.forEach(error -> {
            FormErrorDto err = new FormErrorDto(error.getField(), messageSource.getMessage(error, LocaleContextHolder.getLocale()));
            formErrorDto.add(err);
        });

        return formErrorDto;
    }
}
