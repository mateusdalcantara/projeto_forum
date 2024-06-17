package github.com.mateusdalcantara.projeto_forum.controllers.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMIN("admin"),
    USER("user");

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }

    @JsonValue
    public String getRole() {
        return role;
    }

    @JsonCreator
    public static RoleEnum fromString(String role) {
        for (RoleEnum b : RoleEnum.values()) {
            if (b.role.equalsIgnoreCase(role)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + role + "'");
    }
}
