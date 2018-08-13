package fr.afcepf.ai104.dao;

import fr.afcepf.ai104.entidades.Stagiaire;
import fr.afcepf.ai104.sources.AnnuaireGlobalVariables;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class testAnnuaire implements AnnuaireGlobalVariables {
    private static List<Stagiaire> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        FichierExterneDAO fe = new FichierExterneDAO();
        FichierExterneDAO.lireFichierTexteExterne();
        list = FichierExterneDAO.getListeStagiaires();


        FichierBinaireDAO fb = new FichierBinaireDAO();
        FichierBinaireDAO.ecritureFichierBinaire(list);
        //fb.afficherFichierBinaire();

        ArbreDAO arbreDao = new ArbreDAO();
        ArbreDAO.creationArbre();
        //arbreDao.afficherArbre();

        System.out.println("**************************");


        FichierBinaireDAO.afficherFichierBinaire();
        System.out.println("**************************");
        String rechercheNom = JOptionPane.showInputDialog("Nom a chercher : ");
        FichierBinaireDAO.rechercherNom(rechercheNom);






    }
}
