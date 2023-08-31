package Primates;

import java.util.ArrayList;

/**
 * This interface represents eight enclosures
 */
public interface EnclosureHabitat {

    /**
     * Return an array to store eight arrayLists. Each ArrayList is the data structure of an enclosure
     *
     * @return an array to store the eight arraylists. Each ArrayList is the data structure of an enclosure
     */
    ArrayList<Monkey>[] getList();

    /**
     * Return the capacity of the array
     *
     * @return the capacity of the array
     */
    int getCapacity();


    /**
     * Add the monkey to a specific enclosure according to its species
     *
     * @param a the monkey that is being added to enclosure
     * @throws IllegalStateException throws an exception if non-healthy monkey is added to enclosure or same name monkey is added to an enclosure
     */
    void addMonkey(Monkey a) throws IllegalStateException;

    /**
     * return a list that includes the monkey's name, sex and its favourite food on specific enclosure, in alphabetical order of the name
     *
     * @param species species of the monkey (for choosing which enclosure required)
     * @return the list that includes the monkey's name, sex and its favourite food on specific enclosure
     */
    String listAllMonkey(Species species);

}
