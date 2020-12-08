//package henrique.springboot2test.service;
//
//import henrique.springboot2test.repository.UsuarioRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UsuarioDetailsService implements UserDetailsService {
//    private final UsuarioRepository usuarioRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        return Optional.ofNullable(usuarioRepository.findByUsername(username))
//                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
//    }
//}
