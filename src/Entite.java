abstract class Entite {
    protected int resistance;

    public Entite(int resistance) {
        this.resistance = resistance;
    }

    public Entite() {
        resistance = 0;
    }

    public void perdResistance() {
        if (resistance > 0) {
            resistance--;
        }
    }

    abstract String toString(String background);
}
