abstract class EntiteMobile extends Entite {
    protected Direction direction;

    public EntiteMobile(Direction direction) {
        super(3);
        this.direction = direction;
    }

    abstract void action(Case courante, Case cible);

    public Direction getDirection() {
        return direction;
    }
}
