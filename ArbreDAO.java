package fr.afcepf.ai104.dao;

import fr.afcepf.ai104.entidades.Arbre;
import fr.afcepf.ai104.entidades.Node;
import fr.afcepf.ai104.entidades.Stagiaire;
import fr.afcepf.ai104.sources.AnnuaireGlobalVariables;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class ArbreDAO implements AnnuaireGlobalVariables {

    private static String contenu;
    private static Arbre arbre = new Arbre();

    public static void creationArbre() throws IOException {

        try {
            RandomAccessFile recupBinaire = new RandomAccessFile(fichierBinaire, "rw");
            int nombreStagiaires = (int) recupBinaire.length() / TAILLE_OCTETS_STAGIAIRE;
            int compteur = 1;
            for (int x = 0; x < nombreStagiaires; x++) {
                Stagiaire stagiaire = new Stagiaire();
                Node n = new Node();
                int idNode = 0;
                for (int y = 0; y < 9; y++) {
                    contenu = "";
                    switch (y) {
                        case 0:
                            contenu = FichierBinaireDAO.recupererDonnee(TAILLE_NOM, recupBinaire);
                            stagiaire.setNomStagiaire(contenu);
                            break;
                        case 1:
                            contenu = FichierBinaireDAO.recupererDonnee(TAILLE_PRENOM, recupBinaire);
                            stagiaire.setPrenomStagiaire(contenu);
                            break;
                        case 2:
                            contenu = FichierBinaireDAO.recupererDonnee(TAILLE_DEPARTAMENT, recupBinaire);
                            stagiaire.setDepartementStagiare(contenu);
                            break;
                        case 3:
                            contenu = FichierBinaireDAO.recupererDonnee(TAILLE_PROMO, recupBinaire);
                            stagiaire.setPromoStagiaire(contenu);
                            break;
                        case 4:
                            int anneePromo = recupBinaire.readInt();
                            stagiaire.setAnneePromoStagiaire(anneePromo);
                            break;
                        case 5:
                            idNode = recupBinaire.readInt();
                            break;
                        case 6:
                        case 7:
                        case 8:
                            recupBinaire.readInt();
                            break;
                        default:
                            break;
                    }
                }
                n.setStagiaire(stagiaire);
                n.setNodeId(compteur);
                arbre.ajouterNode(n);
                compteur++;
            }

            //arbre.afficherArbre();
            insertionArbreFichierBinaire(arbre.getRacine());
            recupBinaire.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void insertionArbreFichierBinaire(Node racine) {
        try {
            RandomAccessFile recupFichier = new RandomAccessFile(fichierBinaire, "rw");
            if (racine != null) {
                insertionArbreFichierBinaire(racine.getNodeGauche());
                if (racine.getNodeId() == 1) {
                    recupFichier.seek(POSITION_ID_NODE_PERE);
                    recupFichier.writeInt(0);
                } else {
                    recupFichier.seek(((racine.getNodeId() - 1) * TAILLE_OCTETS_STAGIAIRE) + POSITION_ID_NODE_PERE);
                    recupFichier.writeInt(racine.getNodePere().getNodeId());
                }
                if (racine.getNodeGauche() != null) {
                    recupFichier.seek(((racine.getNodeId() - 1) * TAILLE_OCTETS_STAGIAIRE) + POSITION_ID_NODE_PERE + 4);
                    recupFichier.writeInt(racine.getNodeGauche().getNodeId());
                }
                if (racine.getNodeDroite() != null) {
                    recupFichier.seek(((racine.getNodeId() - 1) * TAILLE_OCTETS_STAGIAIRE) + POSITION_ID_NODE_PERE + 8);
                    recupFichier.writeInt(racine.getNodeDroite().getNodeId());
                }
                insertionArbreFichierBinaire(racine.getNodeDroite());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afficherArbre() {
        arbre.afficherArbre();
    }

    /*
     Fonction qui genere les espaces dans les chaines pour completer la taille
     */
    public static String ajouterEspaces(int tailleString, int nbMax) {
        String str = "";
        for (int x = tailleString; x < nbMax + 1; x++) {
            str += " ";
        }
        return str;
    }
}
