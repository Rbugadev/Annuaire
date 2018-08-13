package fr.afcepf.ai104.dao;

import fr.afcepf.ai104.entidades.Stagiaire;
import fr.afcepf.ai104.sources.AnnuaireGlobalVariables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnnuaireDAO implements AnnuaireGlobalVariables {

    private static List<Stagiaire> liste = new ArrayList<>();

    public static void annuaireDAO() {

        FichierExterneDAO fichierTexteExterne = new FichierExterneDAO();
        FichierExterneDAO.lireFichierTexteExterne();
        liste = FichierExterneDAO.getListeStagiaires();

        FichierBinaireDAO fb = new FichierBinaireDAO();
        try {
            FichierBinaireDAO.ecritureFichierBinaire(liste);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
