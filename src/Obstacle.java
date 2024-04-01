public class Obstacle extends Entite {

    public Obstacle() {
        super(3);
    }

    public Obstacle(int resistance) {
        super(resistance);
    }

    public String toString(String background) {
        if (resistance >= 3) {
            return "@@@";
        } else if (resistance == 2) {
            return "@@" + background.charAt(2);
        } else {
            return background.charAt(0) + "@" + background.charAt(2);
        }
    }
}
