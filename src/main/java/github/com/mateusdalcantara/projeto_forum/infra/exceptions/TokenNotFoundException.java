package github.com.mateusdalcantara.projeto_forum.infra.exceptions;

public class TokenNotFoundException extends RuntimeException{
    
    public TokenNotFoundException(){
        super("Token Not Found");
    }
}
