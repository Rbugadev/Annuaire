package fr.afcepf.ai104.dao;

import fr.afcepf.ai104.entidades.Node;
import fr.afcepf.ai104.entidades.Stagiaire;
import fr.afcepf.ai104.sources.AnnuaireGlobalVariables;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FichierBinaireDAO implements AnnuaireGlobalVariables {

    private static RandomAccessFile fichierBinaireRecupere;
    private static List<Stagiaire> listeStagiairesFichierBinaire = new ArrayList<>();

    // Méthode pour créer le fichier binaire a partir de la liste recupere du fichier externe
    public static void ecritureFichierBinaire(List<Stagiaire> liste) throws IOException {
        try {
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "rw");
            for (Stagiaire stagiaire:liste) {
                ajouterStagiaireFichierBinaire(stagiaire);
            }
            fichierBinaireRecupere.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void ajouterStagiaireFichierBinaire(Stagiaire stagiaire) {
        try {
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "rw");
            fichierBinaireRecupere.seek(fichierBinaireRecupere.length());
            int compteur = ((int) fichierBinaireRecupere.length() / TAILLE_STAGIAIRE_OCTETS) + 1;
            for (int y = 0; y < 5; y++) {
                String str = "";
                switch (y) {
                    case 0:
                        str += ajouterEspaces(stagiaire.getNomStagiaire().length(), TAILLE_NOM);
                        stagiaire.setNomStagiaire(stagiaire.getNomStagiaire().concat(str));
                        fichierBinaireRecupere.writeChars(stagiaire.getNomStagiaire());
                        break;
                    case 1:
                        str += ajouterEspaces(stagiaire.getPrenomStagiaire().length(), TAILLE_PRENOM);
                        stagiaire.setPrenomStagiaire(stagiaire.getPrenomStagiaire().concat(str));
                        fichierBinaireRecupere.writeChars(stagiaire.getPrenomStagiaire());
                        break;
                    case 2:
                        str += ajouterEspaces(stagiaire.getDepartementStagiare().length(), TAILLE_DEPARTAMENT);
                        stagiaire.setDepartementStagiare(stagiaire.getDepartementStagiare().concat(str));
                        fichierBinaireRecupere.writeChars(stagiaire.getDepartementStagiare());
                        break;
                    case 3:
                        str += ajouterEspaces(stagiaire.getPromoStagiaire().length(), TAILLE_PROMO);
                        stagiaire.setPromoStagiaire(stagiaire.getPromoStagiaire().concat(str));
                        fichierBinaireRecupere.writeChars(stagiaire.getPromoStagiaire());
                        break;
                    case 4:
                        fichierBinaireRecupere.writeInt(stagiaire.getAnneePromoStagiaire());
                        fichierBinaireRecupere.writeInt(compteur);
                        for (int i = 0; i < 3; i++) {
                            fichierBinaireRecupere.writeInt(-1);
                        }
                        break;
                    default:
                        break;
                }
            }
            fichierBinaireRecupere.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void insertionArbreFichierBinaire(Node racine) {
        try {
            RandomAccessFile recupFichier = new RandomAccessFile(fichierBinaire, "rw");
            if (racine != null) {
                insertionArbreFichierBinaire(racine.getNodeGauche());
                if (racine.getNodeId() == 1) {
                    recupFichier.seek(POSITION_ID_NODE_PERE);
                    recupFichier.writeInt(0);
                } else {
                    recupFichier.seek(((racine.getNodeId() - 1) * TAILLE_STAGIAIRE_OCTETS) + POSITION_ID_NODE_PERE);
                    recupFichier.writeInt(racine.getNodePere().getNodeId());
                }
                if (racine.getNodeGauche() != null) {
                    recupFichier.seek(((racine.getNodeId() - 1) * TAILLE_STAGIAIRE_OCTETS) + POSITION_ID_NODE_PERE + 4);
                    recupFichier.writeInt(racine.getNodeGauche().getNodeId());
                }
                if (racine.getNodeDroite() != null) {
                    recupFichier.seek(((racine.getNodeId() - 1) * TAILLE_STAGIAIRE_OCTETS) + POSITION_ID_NODE_PERE + 8);
                    recupFichier.writeInt(racine.getNodeDroite().getNodeId());
                }
                insertionArbreFichierBinaire(racine.getNodeDroite());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insererIdNodesFichierBinaire(Node node){
        try {
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "rw");
            fichierBinaireRecupere.seek(((node.getNodeId()-1)* TAILLE_STAGIAIRE_OCTETS)+(TAILLE_STRINGS_STAGIAIRE*2)+8);
            System.out.println(node.getNodePere().getNodeId());
            if (node.getNodePere()!=null){
                fichierBinaireRecupere.writeInt(node.getNodePere().getNodeId());
                if (node.getNodeGauche()!=null){
                    fichierBinaireRecupere.writeInt(node.getNodeGauche().getNodeId());
                    if (node.getNodeDroite()!=null){
                        fichierBinaireRecupere.writeInt(node.getNodeDroite().getNodeId());
                    }
                } else {
                    if (node.getNodeDroite()!=null){
                        fichierBinaireRecupere.seek(((node.getNodeId()-1)* TAILLE_STAGIAIRE_OCTETS)+(TAILLE_STRINGS_STAGIAIRE*2)+12);
                        fichierBinaireRecupere.writeInt(node.getNodeDroite().getNodeId());
                    }
                }

            }
            fichierBinaireRecupere.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void afficherFichierBinaire() {

        try {

            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "r");
            fichierBinaireRecupere.seek(0);
            for (int x = 0; x < getNombreStagiaires(fichierBinaireRecupere); x++) {
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

    public static List rechercheNom(String nom) {
        List<Stagiaire> listaStagiaires = new ArrayList<>();
        try {
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "r");
            for (int x=0; x< getNombreStagiaires(fichierBinaireRecupere) ;x++){
                fichierBinaireRecupere.seek(x* TAILLE_STAGIAIRE_OCTETS);
                String nomRecupereFichierBinaire = recupererDonnee(TAILLE_NOM, fichierBinaireRecupere).trim();
                if (nom.compareToIgnoreCase(nomRecupereFichierBinaire) ==0 ){
                    Stagiaire stagiaire = getStagiaireFichierBinaire((x* TAILLE_STAGIAIRE_OCTETS), fichierBinaireRecupere);
                    listaStagiaires.add(stagiaire);
                }
            }
            fichierBinaireRecupere.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return listaStagiaires;
    }

    public void modifierStagiaireFichierBinaire(int idNode, String nom, String prenom, String departement, String promo, int annee){
        try {
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "rw");
            // Modification Nom
            if (nom!=null){
                fichierBinaireRecupere.seek((idNode-1)*TAILLE_STAGIAIRE_OCTETS);
                nom.toUpperCase().trim();
                nom += ajouterEspaces(nom.length(), TAILLE_NOM);
                fichierBinaireRecupere.writeChars(nom);
            }
            // Modification Prenom
            if (prenom!=null){
                fichierBinaireRecupere.seek(((idNode-1)* TAILLE_STAGIAIRE_OCTETS)+TAILLE_NOM*2);
                prenom.trim();
                prenom += ajouterEspaces(prenom.length(), TAILLE_PRENOM);
                fichierBinaireRecupere.writeChars(prenom);
            }
            // Modification Departement
            if (departement!=null){
                fichierBinaireRecupere.seek(((idNode-1)* TAILLE_STAGIAIRE_OCTETS)+TAILLE_NOM*2+TAILLE_PRENOM*2);
                departement.trim();
                departement += ajouterEspaces(departement.length(), TAILLE_DEPARTAMENT);
                fichierBinaireRecupere.writeChars(departement);
            }
            // Modification Promo
            if (promo!=null){
                fichierBinaireRecupere.seek(((idNode-1)* TAILLE_STAGIAIRE_OCTETS)+TAILLE_NOM*2+TAILLE_PRENOM*2+TAILLE_DEPARTAMENT*2);
                promo.trim();
                promo += ajouterEspaces(promo.length(), TAILLE_PROMO);
                fichierBinaireRecupere.writeChars(promo);
            }
            // Modification Année Promo
            if (annee!=0){
                fichierBinaireRecupere.seek(((idNode-1)* TAILLE_STAGIAIRE_OCTETS)+TAILLE_NOM*2+TAILLE_PRENOM*2+TAILLE_DEPARTAMENT*2+TAILLE_PROMO*2);
                fichierBinaireRecupere.writeInt(annee);
            }
            fichierBinaireRecupere.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List recherchePrenom(String prenom){
        List<Stagiaire> listePrenomStagiaires = new ArrayList<>();
        try{
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "r");
            for (int x=0; x< getNombreStagiaires(fichierBinaireRecupere) ;x++){
                fichierBinaireRecupere.seek((x* TAILLE_STAGIAIRE_OCTETS)+TAILLE_NOM*2);
                String prenomRecupereFichierBinaire = recupererDonnee(TAILLE_PRENOM, fichierBinaireRecupere).trim();
                if (prenom.compareToIgnoreCase(prenomRecupereFichierBinaire) == 0){
                    Stagiaire stagiaire = getStagiaireFichierBinaire(x* TAILLE_STAGIAIRE_OCTETS, fichierBinaireRecupere);
                    listePrenomStagiaires.add(stagiaire);
                }
            }
            fichierBinaireRecupere.close();
        }  catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  listePrenomStagiaires;
    }

    public static List rechercheParDepartement(String departement){
        List<Stagiaire> listeDepertementStagiaires = new ArrayList<>();
        try {
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "r");
            for(int x=0; x< getNombreStagiaires(fichierBinaireRecupere) ;x++){
                fichierBinaireRecupere.seek((x* TAILLE_STAGIAIRE_OCTETS)+TAILLE_NOM*2+TAILLE_PRENOM*2);
                String departementRecupereFichierBinaire = recupererDonnee(TAILLE_DEPARTAMENT, fichierBinaireRecupere).trim();
                if (departement.compareToIgnoreCase(departementRecupereFichierBinaire) == 0){
                    Stagiaire stagiaire = getStagiaireFichierBinaire(x* TAILLE_STAGIAIRE_OCTETS, fichierBinaireRecupere);
                    listeDepertementStagiaires.add(stagiaire);
                }
            }
            fichierBinaireRecupere.close();
        } catch (FileNotFoundException e) {
            System.out.println("fichier non trouvé");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listeDepertementStagiaires;
    }

    public static List rechercheParPromo(String promo){
        List<Stagiaire> listePromoStagiaires = new ArrayList<>();
        try {
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "r");
            for (int x=0; x<getNombreStagiaires(fichierBinaireRecupere) ;x++){
                fichierBinaireRecupere.seek((x* TAILLE_STAGIAIRE_OCTETS)+TAILLE_NOM*2+TAILLE_PRENOM*2+TAILLE_DEPARTAMENT*2);
                String promoRecupereFichierBinaire = recupererDonnee(TAILLE_PROMO, fichierBinaireRecupere).trim();
                if (promo.compareToIgnoreCase(promoRecupereFichierBinaire) == 0){
                    Stagiaire stagiaire = getStagiaireFichierBinaire(x* TAILLE_STAGIAIRE_OCTETS, fichierBinaireRecupere);
                    listePromoStagiaires.add(stagiaire);
                }
            }
            fichierBinaireRecupere.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listePromoStagiaires;
    }

    public static List rechercheParAnnee(int annee){
        List<Stagiaire> listeParAnnee = new ArrayList<>();
        try{
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "r");
            for (int x=0; x< getNombreStagiaires(fichierBinaireRecupere) ;x++){
                fichierBinaireRecupere.seek((x* TAILLE_STAGIAIRE_OCTETS)+TAILLE_NOM*2+TAILLE_PRENOM*2+TAILLE_DEPARTAMENT*2+TAILLE_PROMO*2);
                int anneeRecupereFichierBinaire = fichierBinaireRecupere.readInt();
                if (annee == anneeRecupereFichierBinaire){
                    Stagiaire stagiaire = getStagiaireFichierBinaire(x* TAILLE_STAGIAIRE_OCTETS, fichierBinaireRecupere);
                    listeParAnnee.add(stagiaire);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listeParAnnee;
    }

    private static int getNombreStagiaires(RandomAccessFile fichierBinaireRecupere){
        int nombreStagiaires=0;
        try {
            nombreStagiaires = (int) fichierBinaireRecupere.length()/ TAILLE_STAGIAIRE_OCTETS;
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombreStagiaires;
    }

    private static List<Stagiaire> rechercherParNom(String nom, int position) throws Exception {
       try {
           fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "r");
           if (nom != null) {
               position = position - 1;
               fichierBinaireRecupere.seek(position * TAILLE_STAGIAIRE_OCTETS);
               String nomRecupereFichierBinaire = recupererDonnee(TAILLE_NOM, fichierBinaireRecupere).trim();
               int comparaison = nom.compareToIgnoreCase(nomRecupereFichierBinaire);
               if (comparaison == 0) {
                   Stagiaire stagiaire = getStagiaireFichierBinaire(position * TAILLE_STAGIAIRE_OCTETS, fichierBinaireRecupere);
                   listeStagiairesFichierBinaire.add(stagiaire);
                   fichierBinaireRecupere.seek((position * TAILLE_STAGIAIRE_OCTETS) + POSITION_ID_NODE_GAUCHE);
                   int nodeGauche = fichierBinaireRecupere.readInt();
                   rechercheNomNode(nom, position, nodeGauche);
               } else if (comparaison < 0) {
                   fichierBinaireRecupere.seek((position * TAILLE_STAGIAIRE_OCTETS) + POSITION_ID_NODE_GAUCHE);
                   int nodeGauche = fichierBinaireRecupere.readInt();
                   rechercheNomNode(nom, position, nodeGauche);
               } else {
                   fichierBinaireRecupere.seek((position * TAILLE_STAGIAIRE_OCTETS) + POSITION_ID_NODE_DROITE);
                   int nodeDroite = fichierBinaireRecupere.readInt();
                   if (nodeDroite > 0) {
                       rechercherParNom(nom, nodeDroite);
                   } else {
                       fichierBinaireRecupere.seek((position * TAILLE_STAGIAIRE_OCTETS) + POSITION_ID_NODE_GAUCHE);
                       int nodeGauche = fichierBinaireRecupere.readInt();
                       rechercherParNom(nom, nodeGauche);
                   }
               }
           }
           fichierBinaireRecupere.close();
       } catch (IOException e){
           if (listeStagiairesFichierBinaire==null){
                System.out.println("Le nom saisie n'existe pas");
                }
       }
        return listeStagiairesFichierBinaire;
    }

    private static void rechercheNomNode(String nom, int position, int nodeGauche) throws Exception {
        if (nodeGauche > 0){
            rechercherParNom(nom, nodeGauche);
        } else {
            fichierBinaireRecupere.seek((position* TAILLE_STAGIAIRE_OCTETS)+POSITION_ID_NODE_DROITE);
            int nodeDroite = fichierBinaireRecupere.readInt();
            if (nodeDroite > 0){
                rechercherParNom(nom, nodeDroite);
            }
        }
    }


    public List<Stagiaire>  rechercherParNom(String nom) throws Exception {
        return rechercherParNom(nom, 1);
    }


    public static Stagiaire getStagiaireFichierBinaire(int position, RandomAccessFile fichierBinaireRecupere) throws IOException {
        Stagiaire stagiaire = new Stagiaire();
        fichierBinaireRecupere.seek(position);
        stagiaire.setNomStagiaire(recupererDonnee(TAILLE_NOM, fichierBinaireRecupere));
        stagiaire.setPrenomStagiaire(recupererDonnee(TAILLE_PRENOM, fichierBinaireRecupere));
        stagiaire.setDepartementStagiare(recupererDonnee(TAILLE_DEPARTAMENT, fichierBinaireRecupere));
        stagiaire.setPromoStagiaire(recupererDonnee(TAILLE_PROMO, fichierBinaireRecupere));
        stagiaire.setAnneePromoStagiaire(fichierBinaireRecupere.readInt());

        return stagiaire;
    }

    public static List<Stagiaire> getAllStagiairesFichierBinaire(){
        List<Stagiaire> list = new ArrayList<Stagiaire>();
        try {
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "r");
            for (int x=0; x< getNombreStagiaires(fichierBinaireRecupere) ;x++){
                Stagiaire stagiaire = new Stagiaire();
                fichierBinaireRecupere.seek(x* TAILLE_STAGIAIRE_OCTETS);
                for (int y=0;y<5;y++){
                    switch (y){
                        case 0:
                            stagiaire.setNomStagiaire(recupererDonnee(TAILLE_NOM, fichierBinaireRecupere));
                            break;
                        case 1:
                            stagiaire.setPrenomStagiaire(recupererDonnee(TAILLE_PRENOM, fichierBinaireRecupere));
                            break;
                        case 2:
                            stagiaire.setDepartementStagiare(recupererDonnee(TAILLE_DEPARTAMENT, fichierBinaireRecupere));
                            break;
                        case 3:
                            stagiaire.setPromoStagiaire(recupererDonnee(TAILLE_PROMO, fichierBinaireRecupere));
                            break;
                        case 4:
                            stagiaire.setAnneePromoStagiaire(fichierBinaireRecupere.readInt());
                            break;
                        default:break;
                    }
                }
                list.add(stagiaire);
            }
            fichierBinaireRecupere.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Node> getListeAllNodesFichierBinaire(){
        List<Node> listeNodesFichierBinaire = new ArrayList<>();
        try {
            fichierBinaireRecupere = new RandomAccessFile(fichierBinaire, "r");
            for (int x=0; x < getNombreStagiaires(fichierBinaireRecupere); x++ ){
                fichierBinaireRecupere.seek(x* TAILLE_STAGIAIRE_OCTETS);
                Node node = new Node();
                Stagiaire stagiaire = new Stagiaire();
                for (int y=0; y<9; y++){
                    switch (y) {
                        case 0:
                            stagiaire.setNomStagiaire(recupererDonnee(TAILLE_NOM, fichierBinaireRecupere));
                            break;
                        case 1:
                            stagiaire.setPrenomStagiaire(recupererDonnee(TAILLE_PRENOM, fichierBinaireRecupere));
                            break;
                        case 2:
                            stagiaire.setDepartementStagiare(recupererDonnee(TAILLE_DEPARTAMENT, fichierBinaireRecupere));
                            break;
                        case 3:
                            stagiaire.setPromoStagiaire(recupererDonnee(TAILLE_PROMO, fichierBinaireRecupere));
                            break;
                        case 4:
                            stagiaire.setAnneePromoStagiaire(fichierBinaireRecupere.readInt());
                            break;
                        case 5:
                            node.setNodeId(fichierBinaireRecupere.readInt());
                            break;
                        case 6:
                            if (node.getNodePere() == null){
                                Node nodePere = new Node();
                                nodePere.setNodeId(fichierBinaireRecupere.readInt());
                                node.setNodePere(nodePere);
                            } else {
                                node.getNodePere().setNodeId(fichierBinaireRecupere.readInt());
                            }
                            break;
                        case 7:
                            if (node.getNodeGauche() == null){
                                Node nodeGauche = new Node();
                                nodeGauche.setNodeId(fichierBinaireRecupere.readInt());
                                node.setNodeGauche(nodeGauche);
                            } else {
                                node.getNodeGauche().setNodeId(fichierBinaireRecupere.readInt());
                            }
                            break;
                        case 8:
                            if (node.getNodeDroite() == null){
                                Node nodeDroite = new Node();
                                nodeDroite.setNodeId(fichierBinaireRecupere.readInt());
                                node.setNodeDroite(nodeDroite);
                            } else {
                                node.getNodeDroite().setNodeId(fichierBinaireRecupere.readInt());
                            }
                            break;
                        default:break;
                    }
                }
                node.setStagiaire(stagiaire);
                listeNodesFichierBinaire.add(node);
            }
            fichierBinaireRecupere.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listeNodesFichierBinaire;
    }



    public static String recupererDonnee(int tailleElement, RandomAccessFile recupBinaire) throws IOException{
        String donnee = "";
        for (int x = 0; x < tailleElement; x++) { donnee += recupBinaire.readChar(); }
        return donnee;
    }

    public static RandomAccessFile getFichierBinaireRecupere() {
        return fichierBinaireRecupere;
    }

    public static List<Stagiaire> getListeStagiairesFichierBinaire() {
        return listeStagiairesFichierBinaire;
    }
}
