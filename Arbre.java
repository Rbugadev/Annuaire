package fr.afcepf.ai104.entidades;

import fr.afcepf.ai104.sources.AnnuaireGlobalVariables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arbre implements AnnuaireGlobalVariables {

    private Node racine;
    List<Node> listaNodesStagiaires = new ArrayList<Node>();

    public Arbre() {
    }

    public void ajouterNode(Node node, Node racine) {
        if (racine == null) {
            this.setRacine(node);
        } else {
            if (node.getStagiaire().getNomStagiaire().compareToIgnoreCase(racine.getStagiaire().getNomStagiaire()) <= 0) {
                if (racine.getNodeGauche() == null) {
                    racine.setNodeGauche(node);
                    node.setNodePere(racine);
                } else {
                    ajouterNode(node, racine.getNodeGauche());
                }
            } else {
                if (racine.getNodeDroite() == null) {
                    racine.setNodeDroite(node);
                    node.setNodePere(racine);
                } else {
                    ajouterNode(node, racine.getNodeDroite());
                }
            }
        }
    }

    public void ajouterNode(Node node) throws IOException {
        ajouterNode(node, this.racine);
    }


    public Node getRacine() {
        return racine;
    }

    public void setRacine(Node racine) {
        this.racine = racine;
    }


    public void afficherArbre(Node racine) {
        if (racine != null) {
            afficherArbre(racine.getNodeGauche());
            System.out.print(racine.getStagiaire().getNomStagiaire() + "\t" + racine.getNodeId());
            if (racine.getNodePere() != null) {
                System.out.print("\t" + racine.getNodePere().getNodeId());
            } else {
                System.out.print("\t");
            }
            if (racine.getNodeGauche() != null) {
                System.out.print("\t" + racine.getNodeGauche().getNodeId());
            } else {
                System.out.print("\t");
            }
            if (racine.getNodeDroite() != null) {
                System.out.println("\t" + racine.getNodeDroite().getNodeId());
            } else {
                System.out.println("\t");
            }
            afficherArbre(racine.getNodeDroite());
        }
    }

    public void afficherArbre() {
        afficherArbre(this.getRacine());
    }

    public static boolean supprimerNode(Node node) {
        boolean existeNodeDroite = node.getNodeDroite() != null;
        boolean existeNodeGauche = node.getNodeGauche() != null;

        if (!existeNodeDroite && !existeNodeGauche) {
            return supprimerNodeSansEnfants(node);
        }

        if ((existeNodeDroite && !existeNodeGauche) || (existeNodeGauche && !existeNodeDroite)) {
            return supprimerNodeAvec1Enfant(node);
        }

        if (existeNodeGauche && existeNodeDroite) {
            return supprimerNodeAvec2Enfants(node);
        }

        return false;
    }

    private static boolean supprimerNodeSansEnfants(Node node) {
        Node gauche = node.getNodePere().getNodeGauche();
        Node droite = node.getNodePere().getNodeDroite();

        if (gauche == node) {
            node.getNodePere().setNodeGauche(null);
            return true;
        }

        if (droite == node) {
            node.getNodePere().setNodeDroite(null);
            return true;
        }

        return false;
    }

    private static boolean supprimerNodeAvec1Enfant(Node node) {
        Node gauche = node.getNodePere().getNodeGauche();
        Node droite = node.getNodePere().getNodeDroite();

        Node enfantActuel = node.getNodeGauche() != null ? node.getNodeGauche() : node.getNodeDroite();

        if (gauche == node) {
            node.getNodePere().setNodeGauche(enfantActuel);
            enfantActuel.setNodePere(node.getNodePere());
            node.setNodeDroite(null);
            node.setNodeGauche(null);
            return true;
        }

        if (droite == node) {
            node.getNodePere().setNodeDroite(enfantActuel);
            node.setNodeDroite(null);
            node.setNodeGauche(null);
            return true;
        }

        return false;
    }

    private static boolean supprimerNodeAvec2Enfants(Node node) {
        Node nodePlusAGauche = parcourirGauche(node.getNodeDroite());
        if (nodePlusAGauche != null) {
            supprimerNode(nodePlusAGauche);
            return true;
        }
        return false;
    }

    private static Node parcourirGauche(Node node) {
        if (node.getNodeGauche() != null) {
            return parcourirGauche(node.getNodeGauche());
        }
        return node;
    }

    @Override
    public String toString() {
        return "Arbre [racine=" + racine + "]";
    }


    public List<Node> getListaNodesStagiaires() {
        return listaNodesStagiaires;
    }

    public void setListaNodesStagiaires(List<Node> listaNodesStagiaires) {
        this.listaNodesStagiaires = listaNodesStagiaires;
    }

    private Node recherche = null;


}