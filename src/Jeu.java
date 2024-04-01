import java.util.ArrayList;

public class Jeu {

    Terrain terrain;
    int sortis;
    int nombrePersonnages;

    /* Initialisation d'un jeu avec le terrain initial décrit dans
       le fichier [f] donné en paramètre */
    public Jeu(String f) {
        this.terrain = new Terrain(f);
        this.sortis = 0;
        this.nombrePersonnages = 0;
    }

    public static void main(String[] args) {
        Jeu j = new Jeu("src/laby1.txt");
        
        while (true) {
            j.terrain.print();
            System.out.println();
            j.tour();

            if (j.nombrePersonnages == 0) {
                break;
            }
            
        }
        
    }

    public void tour() {
        sortis = 0;
        this.nombrePersonnages = 0;
        Case[][] t = terrain.getCases();
        ArrayList<ArrayList<Integer>> coord = new ArrayList<>();
        for (int y = 0; y < t.length; y++) {
            for (int x = 0; x < t[y].length; x++) {
                if (t[y][x] instanceof CaseTraversable) {
                    CaseTraversable c = (CaseTraversable) t[y][x];
                    if (c.getContenu() instanceof EntiteMobile) {
                        if (c.getContenu() instanceof Personnage) {
                            nombrePersonnages++;
                        }
                        ArrayList<Integer> a = new ArrayList<>();
                        a.add(y); a.add(x);
                        coord.add(a);
                    }
                }
            }
        }
        for (ArrayList<Integer> a : coord) {
            terrain.joueCarte(a.get(0), a.get(1));
        }
        sortis = Personnage.sauve;
    }
}