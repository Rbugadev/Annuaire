package fr.afcepf.ai104.entidades;

public class Node {

    private Stagiaire stagiaire;
    private int nodeId;
    private Node nodePere;
    private Node nodeGauche;
    private Node nodeDroite;


    public Node(Stagiaire stagiaire, Node pere, Node gauche, Node droite, int id) {
        this.stagiaire = stagiaire;
        this.nodePere = pere;
        this.nodeGauche = gauche;
        this.nodeDroite = droite;
        this.nodeId = id;
    }

    public Node(Stagiaire stagiaire, int id) {
        this.stagiaire = stagiaire;
        this.nodeId = id;
    }

    public Node() {
        this.stagiaire = null;
        this.nodeId =-1;
        this.nodePere = null;
        this.nodeGauche = null;
        this.nodeDroite = null;
    }

    public Node(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    public Node getNodePere() {
        return nodePere;
    }

    public void setNodePere(Node nodePere) {
        this.nodePere = nodePere;
    }

    public Node getNodeGauche() {
        return nodeGauche;
    }

    public void setNodeGauche(Node nodeGauche) {
        this.nodeGauche = nodeGauche;
    }

    public Node getNodeDroite() {
        return nodeDroite;
    }

    public void setNodeDroite(Node nodeDroite) {
        this.nodeDroite = nodeDroite;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int idNode) {
        this.nodeId = idNode;
    }

    @Override
    public String toString() {
        return "IdNode = "+nodeId+" "+stagiaire.toString() +
                ", nodePere = " + nodePere.getNodeId() +
                ", nodeGauche = " + nodeGauche.getNodeId() +
                ", nodeDroite = " + nodeDroite.getNodeId();
    }
}
