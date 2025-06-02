package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.data.repository.UtilisateurRepository;
import ism.atelier.atelier.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Utilisateur seConnecter(Utilisateur utilisateur) {
        if (utilisateur.getLogin() == null || utilisateur.getPassword() == null) {
            throw new IllegalArgumentException("Login et mot de passe sont requis");
        }

        return utilisateurRepository.findByLogin(utilisateur.getLogin())
                .filter(u -> passwordEncoder.matches(utilisateur.getPassword(), u.getPassword()))
                .orElseThrow(() -> new RuntimeException("Login ou mot de passe incorrect"));
    }
}
