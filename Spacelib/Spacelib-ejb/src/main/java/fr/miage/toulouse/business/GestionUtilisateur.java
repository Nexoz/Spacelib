/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.business;

import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Utilisateur;
import fr.miage.toulouse.repositories.MecanicienFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import fr.miage.toulouse.repositories.UtilisateurFacadeLocal;

/**
 *
 * @author jb
 */
@Stateless
public class GestionUtilisateur implements GestionUtilisateurLocal {

    @EJB
    private UtilisateurFacadeLocal ufl;
    
    @EJB
    private MecanicienFacadeLocal mfl;
    
    @Override
    public Utilisateur authentifier(String login, String password) {
        return ufl.authentifier(login, password);
    }

    @Override
    public long creerCompte(long idUtilisateur) {
        final Utilisateur u = this.ufl.find(idUtilisateur);
        if(u!= null){
            ufl.create(u);
            return u.getId();
        }
        return -1;
    }

    @Override
    public long creerMecanicien(String nom, String prenom, String login, String password) {
        Mecanicien m = new Mecanicien(nom, prenom, login, password);
        mfl.create(m);
        return m.getId();
    }
}
