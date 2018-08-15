package fr.afcepf.ai104.dao;

import fr.afcepf.ai104.entidades.Node;
import fr.afcepf.ai104.entidades.Stagiaire;
import fr.afcepf.ai104.sources.AnnuaireGlobalVariables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class testAnnuaire implements AnnuaireGlobalVariables {

    public static void main(String[] args) throws IOException {
        List<Stagiaire> list = new ArrayList<Stagiaire>();
        FichierExterneDAO fe = new FichierExterneDAO();
        fe.lireFichierTexteExterne();
        list = fe.getListeStagiairesFichierExterne();

        System.out.println("*********************************");

        FichierBinaireDAO fb = new FichierBinaireDAO();
       // fb.ecritureFichierBinaire(list);
        //fb.afficherFichierBinaire();

        System.out.println("*********************************");
        System.out.println("Arbre\n\r");

        ArbreDAO arbre = new ArbreDAO();
        //arbre.creationArbre();
       //arbre.afficherArbre();

        System.out.println("*********************************");
        System.out.println("Fichier Binaire\n\r");

        //fb.insertionArbreFichierBinaire(arbre.getRacine());
      //  fb.afficherFichierBinaire();


      /*  try {
            fb.rechercherParNom("hebert");
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
/*

        try {
            list = fb.rechercheNom("Bugarin");
            if (list !=null){
                for (Stagiaire stagiaire:list) {
                    System.out.println(stagiaire.toString());
                }
            } else {
                System.out.println("No se encontro nada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        fb.modifierStagiaireFichierBinaire(31, "BUGARIN","Roque","91","AI 104",2018);
        arbre.creationArbre();
        System.out.println("***************************");
        System.out.println("Nuevo ARBOL = +++++++++");
        arbre.afficherArbre();
        fb.insertionArbreFichierBinaire(arbre.getRacine());


*/



/*
        Stagiaire nuevo = new Stagiaire();
        nuevo.setPrenomStagiaire("Roque");
        nuevo.setNomStagiaire("BUGARIN");
        nuevo.setDepartementStagiare("91");
        nuevo.setAnneePromoStagiaire(2018);
        nuevo.setPromoStagiaire("AI 104");

        fb.ajouterStagiaireFichierBinaire(nuevo);
        arbre.creationArbre();*/
      //  arbre.afficherArbre();


        //System.out.println("*********************************");

      //  fb.afficherFichierBinaire();
        //System.out.println(arbre.getDernierNodeParId().getStagiaire().toString());

      // fb.insererIdNodesFichierBinaire(arbre.getDernierNodeParId());

        System.out.println("*********************************");
       // System.out.println("Fichier Binaire despues insertion 1 stagiaire \n\r");
        arbre.creationArbre();
        arbre.afficherArbre();
        arbre.eliminar(31);

        System.out.println("Modif ++++++++++++++++");
        arbre.afficherArbre();


       /* list = fb.getAllStagiairesFichierBinaire();
        for (Stagiaire stagiaire:list) {
            System.out.println(stagiaire.toString());
        }*/
/*

        System.out.println("*********************************");


       List<Node> listaNodes = fb.getListeAllNodesFichierBinaire();
        for (Node node:listaNodes) {
            System.out.println(node.toString());
        }
*/


    }
    /* Etapes pour ajouter a nouveau Stagiaire dans le fichier Binaire
        1.- Recuperer les infos (creer le nouveau Stagiaire)
        2.- Inserer les données dans le fichier binaire ==> class FichierBinaireDAO => méthode ajouterFichierBinaire(stagiaire)
        3.- Creer le nouveau arbre ==> class ArbreDAO => méthode creationArbre()
        4.- Recuperer le node crée dans l'arbre avec le dernier stagiaire ajouté ==> class ArbreDAO => méthode getDernierNodeParId()
        5.- Inserer les informations des nodes (pere, gauche et/ou droite) dans le fichier binaire ==> class FichierBinaireDAO => méthode insererIdNodesFichierBinaire(node)


        Rechercher par Nom
        1.- Class FichierBinaireADO => méthode rechercheNom("Nom");



        Modifier le Nom
        1.- Changer le nom dans le fichier binaire
        2.- Generer le nouveau Arbre
        3.- Enregistrer les nouveaux nodes dans le fichier binaire

    */
}
