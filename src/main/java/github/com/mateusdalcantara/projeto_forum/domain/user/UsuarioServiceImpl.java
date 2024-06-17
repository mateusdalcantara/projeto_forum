package github.com.mateusdalcantara.projeto_forum.domain.user;

import github.com.mateusdalcantara.projeto_forum.infra.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto salvar(UsuarioDto usuarioDto) {

        Usuario usuarioJaExiste = usuarioRepository.findByLogin(usuarioDto.login());

        if (usuarioJaExiste != null) {
            throw new BusinessException("Usuário já existe!");
        }

        var passwordHash = passwordEncoder.encode(usuarioDto.senha());

        Usuario entity = new Usuario(usuarioDto.nome(), usuarioDto.email(), usuarioDto.login(), passwordHash, usuarioDto.role());
        Usuario novoUsuario = usuarioRepository.save(entity);

        return new UsuarioDto (novoUsuario.getNome(), novoUsuario.getEmail(), novoUsuario.getLogin(), novoUsuario.getSenha(), novoUsuario.getRole());    }
}