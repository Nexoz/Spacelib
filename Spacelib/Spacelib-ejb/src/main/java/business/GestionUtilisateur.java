/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Utilisateur;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.UtilisateurFacadeLocal;

/**
 *
 * @author jb
 */
@Stateless
public class GestionUtilisateur implements GestionUtilisateurLocal {

    @EJB
    private UtilisateurFacadeLocal ufl;
    
    @Override
    public Utilisateur authentifier(String login, String password) {
        return ufl.authentifier(login, password);
    }

    @Override
    public long creerCompte(Utilisateur u) {
        ufl.create(u);
        return u.getId();
    }
}
