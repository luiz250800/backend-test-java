package br.com.testefcamara.backendtestjava.error;

import br.com.testefcamara.backendtestjava.errorDto.ErrorDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ReponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handlerException(@NotNull ResponseStatusException exc) {
        logger.trace(exc.getStackTrace());
        return new ResponseEntity(new ErrorDto(exc.getRawStatusCode(), exc.getReason()), exc.getStatus());
    }
}
