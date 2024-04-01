import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class Terrain {

    private int hauteur, largeur;
    private Case[][] carte;

    /* Initialisation d'un terrain à partir de la description donnée par
       un fichier texte. Format du fichier de description :
       - hauteur et largeur sur la première ligne
       - puis dessin du terrain (un caractère == une case) avec le codage
         suivant
         '#' pour un mur
         ' ' (espace) pour une case libre
         'o' pour une sortie
         '@' pour une case libre contenant un obstacle
         '^', 'v', '>', '<' pour une case libre contenant un personnage
         'm', 'w', '»', '«' pour une case libre contenant un monstre
    */
    public Terrain(String file) {
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            this.hauteur = sc.nextInt();
            this.largeur = sc.nextInt();
            sc.nextLine();
            this.carte = new Case[hauteur][largeur];
            for (int l=0; l<hauteur; l++) {
                String line = sc.nextLine();
                for (int c=0; c<largeur; c++) {
                    Case cc;
                    Character ch = line.charAt(c);
                    switch (ch) {
                        case '#': cc = new CaseIntraversable(l, c); break;
                        case ' ': cc = new CaseLibre(l, c); break;
                        case 'o': cc = new Sortie(l, c); break;
                        case '@': cc = new CaseLibre(l, c, new Obstacle()); break;
                        case '^': case '>': case 'v': case '<':
                            cc = new CaseLibre(l, c, new Personnage(Direction.ofChar(ch)));
                            break;
                        case 'm': case '»': case 'w': case '«':
                            cc = new CaseLibre(l, c, new Monstre(Direction.ofChar(ch)));
                            break;
                        default:  cc = null; break;
                    }
                    carte[l][c] = cc;
                }
            }
            sc.close();
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public void joueCarte(int x, int y) {
        if (carte[x][y] instanceof CaseTraversable) {
            CaseTraversable c = (CaseTraversable)carte[x][y];
            if (c.getContenu() instanceof EntiteMobile) {
                EntiteMobile e = (EntiteMobile)c.getContenu();
                Direction d = e.getDirection();
                switch (d) {
                    case nord:
                        e.action(carte[x][y], carte[x-1][y]);
                        break;
                    case sud:
                        e.action(carte[x][y], carte[x+1][y]);
                        break;
                    case est:
                        e.action(carte[x][y], carte[x][y+1]);
                        break;
                    default:
                        e.action(carte[x][y], carte[x][y-1]);
                        break;
                }
            } else {
                return ;
            }
        } else {
            throw new InvalidParameterException("Coordonnees non valides");
        }
    }

    public Case[][] getCases() {
        return carte;
    }

    public void print() {
        for (Case c_y[] : carte) {
            for (Case c : c_y) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

}
