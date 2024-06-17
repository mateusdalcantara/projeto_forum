package github.com.mateusdalcantara.projeto_forum.domain.user;

import github.com.mateusdalcantara.projeto_forum.controllers.enums.RoleEnum;
import github.com.mateusdalcantara.projeto_forum.domain.estudante.Estudante;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuarios")
@Table(name = "Usuario")
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false) @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Estudante estudante;

    public Usuario(String nome, String email, String login, String senha, RoleEnum role) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.role = role;
    }

    public Usuario(String nome, String login, String passwordHash, RoleEnum role) {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == RoleEnum.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }
        return List.of(
                new SimpleGrantedAuthority("ROLE_USER")
        );
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}