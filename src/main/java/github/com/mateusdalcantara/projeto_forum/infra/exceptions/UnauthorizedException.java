package github.com.mateusdalcantara.projeto_forum.infra.exceptions;

public class UnauthorizedException extends  RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
