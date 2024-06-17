package github.com.mateusdalcantara.projeto_forum.domain.estudante;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CadastrarEstudante(
        @NotBlank
        String celular,
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
        String cpf,
        @NotBlank
        String curso,
        @NotBlank
        @Pattern(regexp= "\\d{5}")
        String matricula
) {

}