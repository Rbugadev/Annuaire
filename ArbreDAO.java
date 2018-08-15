package fr.afcepf.ai104.dao;

import fr.afcepf.ai104.entidades.Arbre;
import fr.afcepf.ai104.entidades.Node;
import fr.afcepf.ai104.entidades.Stagiaire;
import fr.afcepf.ai104.sources.AnnuaireGlobalVariables;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;


public class ArbreDAO implements AnnuaireGlobalVariables {

    private static String contenu;
    private static Arbre arbre = new Arbre();
    private static Node racine;

    public static void creationArbre() throws IOException {

        try {
            try
                (RandomAccessFile recupBinaire = new RandomAccessFile(fichierBinaire, "rw")) {
                int nombreStagiaires = getnombreStagiaires(recupBinaire);
                int compteur = 1;
                for (int x = 0; x < nombreStagiaires; x++) {
                    Stagiaire stagiaire = new Stagiaire();
                    Node n = new Node();
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
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void afficherArbre() {
        arbre.afficherArbre();
    }

    public Node getDernierNodeParId(){
        List<Node> listeNodes = arbre.getListeNodesArbre(arbre.getRacine());
        int aux=0;
        Node dernierNodeparId = null;
        for (Node node:listeNodes) {
            aux = node.getNodeId() > aux ? node.getNodeId() : aux;
            if (node.getNodeId()==aux){
                dernierNodeparId = node;
            }
        }
        return dernierNodeparId;
    }

    public boolean eliminar(int idNode){
        racine = getRacine();
        Node nodeAux = racine;
        Node nodePere = racine;
        boolean filsGauche=true;
        while (nodeAux.getNodeId()!=idNode){
            nodePere = nodeAux;
            if (idNode < nodeAux.getNodeId()){
                filsGauche = true;
                nodeAux = nodeAux.getNodeGauche();
            } else {
                filsGauche = false;
                nodeAux = nodeAux.getNodeDroite();
            }
            if (nodeAux==null){
                return false;
            }
        }
        if (nodeAux.getNodeGauche()==null && nodeAux.getNodeDroite()==null){
            if (nodeAux==racine){
                racine=null;
            } else if (filsGauche){
                nodePere.setNodeGauche(null);
            } else {
                nodePere.setNodeDroite(null);
            }
        } else if (nodeAux.getNodeDroite()==null){
            if (nodeAux==racine){
                racine=nodeAux.getNodeGauche();
            } else if (filsGauche){
                nodePere.setNodeGauche(nodeAux.getNodeGauche());
            } else {
                nodePere.setNodeDroite(nodeAux.getNodeGauche());
            }
        }else if (nodeAux.getNodeGauche()==null){
            if (nodeAux==racine){
                racine=nodeAux.getNodeDroite();
            } else if (filsGauche){
                nodePere.setNodeGauche(nodeAux.getNodeDroite());
            } else {
                nodePere.setNodeDroite(nodeAux.getNodeGauche());
            }
        } else {
            Node reemplazo = obtenerNodoreemplazo(nodeAux);
            if (nodeAux == racine){
                racine = reemplazo;
            } else if (filsGauche){
                nodePere.setNodeGauche(reemplazo);
            } else {
                nodePere.setNodeDroite(reemplazo);
            }
            reemplazo.setNodeGauche(nodeAux.getNodeGauche());
        }
        return true;
    }

    public Node obtenerNodoreemplazo(Node nodoReemplazo){
        Node reemplazarPadre = nodoReemplazo;
        Node reemplazo = nodoReemplazo;
        Node nodeAux = nodoReemplazo.getNodeDroite();
        while (nodeAux!=null){
            reemplazarPadre = reemplazo;
            reemplazo=nodeAux;
            nodeAux=nodeAux.getNodeGauche();
        }
        if (reemplazo!=nodoReemplazo.getNodeDroite()){
            reemplazarPadre.setNodeGauche(reemplazo.getNodeDroite());
            reemplazo.setNodeDroite(nodoReemplazo.getNodeDroite());
        }
        System.out.println("El nodo reemplazo es "+reemplazo);
        return reemplazo;
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

    public static int getnombreStagiaires(RandomAccessFile recupBinaire) throws IOException {
        int nombreStagiaires=0;
        nombreStagiaires = (int) recupBinaire.length() / TAILLE_STAGIAIRE_OCTETS;

        return nombreStagiaires;
    }

    public static Node getRacine() {
        racine = arbre.getRacine();
        return racine;
    }

}
