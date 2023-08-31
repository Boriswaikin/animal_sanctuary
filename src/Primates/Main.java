package Primates;

/**
 * run the Primate GUI interactively on the console
 */
public class Main {

    /**
     * run the Primate GUI interactively on the console
     * @param args not used
     */
    public static void main(String[] args) {

        Sanctuary sanctuary1 = new Sanctuary();
        PrimatesView v = new SwingPrimatesView("Primates");
        PrimatesController c = new SwingPrimatesController(v, sanctuary1);
        c.playGame();
    }
}
