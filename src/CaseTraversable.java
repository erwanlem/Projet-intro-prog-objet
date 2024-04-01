abstract class CaseTraversable extends Case {
    private Entite contenu;

    public CaseTraversable(int lig, int col, Entite contenu) {
        super(lig, col);
        this.contenu = contenu;
    }

    public CaseTraversable(int lig, int col) {
        super(lig, col);
        this.contenu = null;
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
}
