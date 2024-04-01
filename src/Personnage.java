public class Personnage extends EntiteMobile {
    public static int sauve = 0;
    
    public Personnage(Direction direction) {
        super(direction);
        resistance = 3;
    }

    public String toString(String background) {
        switch (direction) {
            case nord:
                return background.charAt(0) + "^" + background.charAt(2);
            case sud:
                return background.charAt(0) + "v" + background.charAt(2);
            case est:
                return background.charAt(0) + ">" + background.charAt(2);
            case ouest:
                return background.charAt(0) + "<" + background.charAt(2);
            default:
                return background.charAt(0) + "^" + background.charAt(2);
        }
    }

    public void action(Case courante, Case cible) {
        if (courante instanceof Sortie) {
            sauve++;
            Sortie c = (Sortie)courante;
            c.vide();
        } else if (cible.estLibre()) {
            CaseTraversable c = (CaseTraversable)cible;
            CaseTraversable c2 = (CaseTraversable)courante;
            c.entre(c2.getContenu());
            c2.vide();
        } else if (cible instanceof CaseTraversable) {
            CaseTraversable c = (CaseTraversable)cible;
            if (c.getContenu() instanceof Obstacle) {
                Entite o = c.getContenu();
                o.perdResistance();
                if (o.resistance <= 0) {
                    c.vide();
                } else {
                    c.vide();
                    c.entre(o);
                }
            } else {
                direction = Direction.random();
            }
        } else {
            direction = Direction.random();
        }
    }
}
