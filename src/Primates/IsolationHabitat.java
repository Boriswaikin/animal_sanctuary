package Primates;

import java.util.ArrayList;

/**
 * This interface represents an isolation
 */
public interface IsolationHabitat {

    /**
     * Return an arraylist(data structure of an isolation)
     *
     * @return an arraylist(data structure of an isolation)
     */
    ArrayList<Monkey> getList();

    /**
     * Return the capacity of an isolation
     *
     * @return the capacity of an isolation
     */
    int getCapacity();

    /**
     * Return the number of monkeys the isolation contains
     *
     * @return the number of monkeys the isolation contains
     */
    int getNumberOfMonkey();

    /**
     * Add a monkey to the isolation
     *
     * @param a the monkey being added to the isolation
     * @throws IllegalStateException throws an exception if healthy monkey is added to isolation or adding monkey to a full isolation
     *                               or same name monkey is added to an isolation
     */
    void addMonkey(Monkey a) throws IllegalStateException;

    /**
     * Remove a monkey from the isolation
     *
     * @param a the monkey being removed from the isolation
     * @throws IllegalStateException throws an exception if monkey is removed from an empty isolation
     */
    void removeMonkey(Monkey a) throws IllegalStateException;

    /**
     * return a list that includes the monkey's name from the isolation, in alphabetical order of the name
     *
     * @return the list that includes the monkey's name from the isolation
     */
    String listAllMonkey();

}
