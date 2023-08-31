package Primates;

/**
 * The enum class to store the preassigned value of the monkey's species as below
 * DRILL(0),
 * GUEREZA(1),
 * HOWLER(2),
 * MANGABEY(3),
 * SAKI(4),
 * SPIDER(5),
 * SQUIRREL(6),
 * TAMARIN(7);
 */

public enum Species {

    DRILL(0),
    GUEREZA(1),
    HOWLER(2),
    MANGABEY(3),
    SAKI(4),
    SPIDER(5),
    SQUIRREL(6),
    TAMARIN(7);
    public final int value;

    /**
     * Initialise the preassigned value of the species
     *
     * @param value preassigned value of the species
     */
    private Species(int value) {
        this.value = value;
    }

    /**
     * Return the preassigned value fo the species
     *
     * @return the preassigned value fo the species
     */
    public int getValue() {
        return value;
    }

}
