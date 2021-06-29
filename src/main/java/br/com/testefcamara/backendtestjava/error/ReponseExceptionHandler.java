package br.com.testefcamara.backendtestjava.error;

import br.com.testefcamara.backendtestjava.dto.ErrorDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Classe genérica para tratamento de erros.
 */
@ControllerAdvice
public class ReponseExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LogManager.getLogger();

    /**
     * Método genérico para tratamento de erros.
     * @param exc
     * @return
     */
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDto> handlerException(@NotNull ResponseStatusException exc) {
        logger.info(" ---------------------------- WARN ERROR  ----------------------------");
        logger.trace("TRACE ERROR: " + exc.getStackTrace());
        logger.error("ERROR CAUSE: " + exc.getCause().toString());
        logger.info(" ------------------------- FINAL WARN ERROR  -------------------------");
        return new ResponseEntity(new ErrorDto(exc.getRawStatusCode(), exc.getReason()), exc.getStatus());
    }
}
