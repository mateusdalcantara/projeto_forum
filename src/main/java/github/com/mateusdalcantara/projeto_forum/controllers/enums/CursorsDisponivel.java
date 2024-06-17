package github.com.mateusdalcantara.projeto_forum.controllers.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum CursorsDisponivel {

    PROGRAMACAOJAVA("Java"),
    MEDICINA("Medicina"),
    ELETROELETRONICA("eletroeletronica");

    private String curso;

    CursorsDisponivel(String curso) {
        this.curso = curso;
    }

    @JsonValue
    public String getCurso() {
        return curso;
    }

    @JsonCreator
    public static CursorsDisponivel fromString(String curso) {
        for (CursorsDisponivel b : CursorsDisponivel.values()) {
            if (b.curso.equalsIgnoreCase(curso)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + curso + "'");
    }

}
