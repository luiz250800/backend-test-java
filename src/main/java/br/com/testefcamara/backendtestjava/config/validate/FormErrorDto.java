package br.com.testefcamara.backendtestjava.config.validate;

/**
 * Classe DTO para retorno de validação de usuário.
 */
public class FormErrorDto {
    private String field;
    private String error;

    /**
     * @param field
     * @param error
     */
    public FormErrorDto(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
