public class Sortie extends CaseTraversable {
    private Entite contenu;

    public Sortie(int lig, int col) {
        super(lig, col);
    }

    public Entite getContenu() {
        return contenu;
    }

    public void vide() {
        contenu = null;
    }

    public boolean estLibre() {
        return contenu == null;
    }

    public void entre(Entite contenu) {
        this.contenu = contenu;
    }

    public String toString() {
        if (estLibre()) {
            return "( )";
        } else {
            return contenu.toString("( )");
        }
        
    }
}
