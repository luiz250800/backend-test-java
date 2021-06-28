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

@ControllerAdvice
public class ReponseExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LogManager.getLogger();

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handlerException(@NotNull ResponseStatusException exc) {
        logger.info(" ---------------------------- WARN ERROR  ----------------------------");
        logger.trace("TRACE ERROR: " + exc.getStackTrace());
        logger.error("ERROR CAUSE: " + exc.getCause().toString());
        logger.info(" ------------------------- FINAL WARN ERROR  -------------------------");
        return new ResponseEntity(new ErrorDto(exc.getRawStatusCode(), exc.getReason()), exc.getStatus());
    }
}
