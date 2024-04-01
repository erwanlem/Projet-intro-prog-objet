/**
 * Case
 */
abstract class Case {
    private final int lig, col;

    public Case(int lig, int col) {
        this.lig = lig;
        this.col = col;
    }

    abstract boolean estLibre();
    public abstract String toString();
}