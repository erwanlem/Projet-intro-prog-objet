public class Monstre extends EntiteMobile {
    
    public Monstre(Direction direction) {
        super(direction);
    }


    public String toString(String background) {
        switch (direction) {
            case nord:
                return background.charAt(0) + "m" + background.charAt(2);
            case sud:
                return background.charAt(0) + "w" + background.charAt(2);
            case est:
                return background.charAt(0) + "»" + background.charAt(2);
            case ouest:
                return background.charAt(0) + "«" + background.charAt(2);
            default:
                return background.charAt(0) + "m" + background.charAt(2);
        }
    }

    public void action(Case courante, Case cible) {
        if (cible.estLibre()) {
            CaseTraversable c = (CaseTraversable)cible;
            CaseTraversable c2 = (CaseTraversable)courante;
            c.entre(c2.getContenu());
            c2.vide();
        } else if (cible instanceof CaseTraversable) {
            CaseTraversable c = (CaseTraversable)cible;
            Entite e = c.getContenu();
            e.perdResistance();
            if (e.resistance <= 0) {
                c.vide();
            } else {
                c.vide();
                c.entre(e);
            }
        } else {
            this.direction = Direction.random();
        }
    }

}
