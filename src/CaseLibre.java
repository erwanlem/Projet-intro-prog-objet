public class CaseLibre extends CaseTraversable {
    private Entite contenu;

    public CaseLibre(int lig, int col) {
        super(lig, col);
        this.contenu = null;
    }

    public CaseLibre(int lig, int col, Entite contenu) {
        super(lig, col);
        this.contenu = contenu;
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
            return "   ";
        } else {
            return contenu.toString("   ");
        }
    }
}
