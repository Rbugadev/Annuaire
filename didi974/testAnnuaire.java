package fr.afcepf.ai104.dao;

import fr.afcepf.ai104.entidades.Stagiaire;
import fr.afcepf.ai104.sources.AnnuaireGlobalVariables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class testAnnuaire implements AnnuaireGlobalVariables {

    public static void main(String[] args) throws IOException {
        List list = new ArrayList<>();
        FichierExterneDAO fe = new FichierExterneDAO();
        fe.lireFichierTexteExterne();
        list = fe.getListeStagiairesFichierExterne();

        System.out.println("*********************************");

        FichierBinaireDAO fb = new FichierBinaireDAO();
        fb.ecritureFichierBinaire(list);
        //fb.afficherFichierBinaire();

        System.out.println("*********************************");
        System.out.println("Arbre\n\r");

        ArbreDAO arbre = new ArbreDAO();
        arbre.creationArbre();
        arbre.afficherArbre();

        System.out.println("*********************************");
        System.out.println("Fichier Binaire\n\r");

        fb.insertionArbreFichierBinaire(arbre.getRacine());
        //fb.afficherFichierBinaire();

        list = null;
      /*  try {
            fb.rechercherNom("hebert");
            list = fb.getListeStagiairesFichierBinaire();
            if (list !=null){
                for (Stagiaire stagiaire:list) {
                    System.out.println(stagiaire.toString());
                }
            } else {
                System.out.println("No se encontro nada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        try {
            list = fb.recherchePrenom("kevin");
            if (list !=null){
                for (Object stagiaire:list) {
                    System.out.println(stagiaire.toString());
                }
            } else {
                System.out.println("No se encontro nada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
