package github.com.mateusdalcantara.projeto_forum.infra.exceptions;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}