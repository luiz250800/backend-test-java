package br.com.testefcamara.backendtestjava.dto;

/**
 * Classe DTO para retorno de token de usuário autenticado.
 */
public class TokenDto {

    private String token;
    private String type;

    public TokenDto(String token, String type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }
}
