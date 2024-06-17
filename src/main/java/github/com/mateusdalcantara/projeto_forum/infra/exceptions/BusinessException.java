package github.com.mateusdalcantara.projeto_forum.infra.exceptions;

public class BusinessException extends  RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
