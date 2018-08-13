package fr.afcepf.ai104.dao;

import fr.afcepf.ai104.entidades.Node;
import fr.afcepf.ai104.entidades.Stagiaire;
import fr.afcepf.ai104.sources.AnnuaireGlobalVariables;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class FichierBinaireDAO implements AnnuaireGlobalVariables {

    private static RandomAccessFile fichierBinaireRecupere;
    private static int nombreStagiaires;


    public static void ecritureFichierBinaire(List<Stagiaire> liste) throws IOException {
        try {
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "rw");
            int compteur = 1;
            for (int x = 0; x < liste.size(); x++) {
                for (int y = 0; y < 5; y++) {
                    String str = "";
                    switch (y) {
                        case 0:
                            str += ajouterEspaces(liste.get(x).getNomStagiaire().length(), TAILLE_NOM);
                            liste.get(x).setNomStagiaire(liste.get(x).getNomStagiaire().concat(str));
                            fichierBinaireRecupere.writeChars(liste.get(x).getNomStagiaire());
                            break;
                        case 1:
                            str += ajouterEspaces(liste.get(x).getPrenomStagiaire().length(), TAILLE_PRENOM);
                            liste.get(x).setPrenomStagiaire(liste.get(x).getPrenomStagiaire().concat(str));
                            fichierBinaireRecupere.writeChars(liste.get(x).getPrenomStagiaire());
                            break;
                        case 2:
                            str += ajouterEspaces(liste.get(x).getDepartementStagiare().length(), TAILLE_DEPARTAMENT);
                            liste.get(x).setDepartementStagiare(liste.get(x).getDepartementStagiare().concat(str));
                            fichierBinaireRecupere.writeChars(liste.get(x).getDepartementStagiare());
                            break;
                        case 3:
                            str += ajouterEspaces(liste.get(x).getPromoStagiaire().length(), TAILLE_PROMO);
                            liste.get(x).setPromoStagiaire(liste.get(x).getPromoStagiaire().concat(str));
                            fichierBinaireRecupere.writeChars(liste.get(x).getPromoStagiaire());
                            break;
                        case 4:
                            fichierBinaireRecupere.writeInt(liste.get(x).getAnneePromoStagiaire());
                            fichierBinaireRecupere.writeInt(compteur);
                            for (int i = 0; i < 3; i++) {
                                fichierBinaireRecupere.writeInt(-1);
                            }
                            compteur++;
                            break;
                        default:
                            break;
                    }
                }
            }
            fichierBinaireRecupere.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String recupererDonnee(int tailleElement, RandomAccessFile recupBinaire) {
        String donnee = "";
        for (int x = 0; x < tailleElement; x++) {
            try {
                donnee += recupBinaire.readChar();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return donnee;

    }

    public static void afficherFichierBinaire() {

        try {

            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "r");
            nombreStagiaires = (int) fichierBinaireRecupere.length() / TAILLE_OCTETS_STAGIAIRE;
            fichierBinaireRecupere.seek(0);
            for (int x = 0; x < nombreStagiaires; x++) {
                String contenu = "";
                for (int y = 0; y < TAILLE_STRINGS_STAGIAIRE; y++) {
                    contenu += fichierBinaireRecupere.readChar();
                }
                for (int y = 0; y < 5; y++) {
                    contenu += ("\t" + fichierBinaireRecupere.readInt());
                }
                System.out.println(contenu);
            }
            fichierBinaireRecupere.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     Fonction qui genere les espaces dans les chaines pour completer la taille
     */
    public static String ajouterEspaces(int tailleString, int nbMax) {
        String str = "";
        for (int x = tailleString; x < nbMax; x++) {
            str += " ";
        }
        return str;
    }

    public Node rechercherNom(Node racine, String nom) throws FileNotFoundException {
        fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "r");
        System.out.println(racine.getStagiaire().toString()+" Nom reçu: "+nom);
        Node recherche = new Node();
        if (racine != null) {
            if (nom.compareToIgnoreCase(racine.getStagiaire().getNomStagiaire()) == 0) {
                recherche = racine;
                System.out.println("Aqui estoy");
            } else {
                if (nom.compareToIgnoreCase(racine.getStagiaire().getNomStagiaire()) < 0) {
                    if (racine.getNodeGauche() != null) {
                        rechercherNom(racine.getNodeGauche(), nom);
                    } else {
                        if (racine.getNodeDroite() != null) {
                            rechercherNom(racine.getNodeDroite(), nom);
                        }
                    }
                } else {
                    if (racine.getNodeDroite() != null) {
                        rechercherNom(racine.getNodeDroite(), nom);
                    } else {
                        if (racine.getNodeGauche() != null) {
                            rechercherNom(racine.getNodeGauche(), nom);
                        }
                    }
                }
            }
        }
        return recherche;
    }

    public static int getNombreStagiaires() {
        return nombreStagiaires;
    }

    public static RandomAccessFile getFichierBinaireRecupere() {
        return fichierBinaireRecupere;
    }

}
