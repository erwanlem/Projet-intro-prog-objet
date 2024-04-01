public class CaseIntraversable extends Case {

    public CaseIntraversable(int lig, int col) {
        super(lig, col);
    }

    public boolean estLibre() {
        return false;
    }

    public String toString() {
        return "###";
    }
}

