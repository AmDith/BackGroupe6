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
        return utilisateurRepository.findByLogin(utilisateur.getLogin())
                .filter(u -> u.getPassword().equals(utilisateur.getPassword()))
                .orElseThrow(() -> new NoSuchElementException("Login ou mot de passe incorrect"));
    }
}
