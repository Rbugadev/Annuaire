package fr.afcepf.ai104.dao;

import fr.afcepf.ai104.entidades.Stagiaire;
import fr.afcepf.ai104.sources.AnnuaireGlobalVariables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FichierExterneDAO implements AnnuaireGlobalVariables {

    private static List<Stagiaire> listeStagiairesFichierExterne = new ArrayList<>();


    // Méthode pour lire le fichier texte externe et creer un liste avec les donneées reçus
    public static void lireFichierTexteExterne() {
        try {


            FileReader fichierEntree = new FileReader(fichierExterne); // Chemin d'accés vers le fichier texte
            BufferedReader br = new BufferedReader(fichierEntree);

            while (br.ready()) {
                Stagiaire stagiaire = new Stagiaire();
                for (int x = 0; x < 6; x++) {
                    switch (x) {
                        case 0:
                            stagiaire.setNomStagiaire(br.readLine());
                            break;
                        case 1:
                            stagiaire.setPrenomStagiaire(br.readLine());
                            break;
                        case 2:
                            stagiaire.setDepartementStagiare(br.readLine());
                            break;
                        case 3:
                            stagiaire.setPromoStagiaire(br.readLine());
                            break;
                        case 4:
                            int annee = Integer.parseInt(br.readLine());
                            stagiaire.setAnneePromoStagiaire(annee);
                            break;
                        case 5:
                            br.readLine();
                            break;
                        default:
                            break;
                    }
                }
                listeStagiairesFichierExterne.add(stagiaire);
            }

            fichierEntree.close();
        } catch (IOException e) {
            System.out.println("Fichier ou dossier non trouvé");
        }
    }

    //Méthode pour afficher la liste recuperée depuis le fichier texte
    public static void afficherListeExterneStagiaires(List<Stagiaire> liste) {
        for (Stagiaire stagiaire : liste) {
            System.out.println(stagiaire.toString());
        }
    }

    // Méthode pour recuperer la liste crée depuis le fichier externe
    public static List<Stagiaire> getListeStagiairesFichierExterne() {
        return listeStagiairesFichierExterne;
    }

}
