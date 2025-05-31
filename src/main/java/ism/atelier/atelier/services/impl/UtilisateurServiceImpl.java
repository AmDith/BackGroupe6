package ism.atelier.atelier.services.impl;

import ism.atelier.atelier.data.models.Utilisateur;
import ism.atelier.atelier.data.repository.UtilisateurRepository;
import ism.atelier.atelier.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur seConnecter(Utilisateur utilisateur) {
        if (utilisateur.getLogin() == null || utilisateur.getPassword() == null) {
            throw new IllegalArgumentException("Login et mot de passe sont requis");
        }

        return utilisateurRepository.findByLogin(utilisateur.getLogin())
                .filter(u -> u.getPassword().equals(utilisateur.getPassword()))
                .orElseThrow(() -> new RuntimeException("Login ou mot de passe incorrect"));
    }
}
