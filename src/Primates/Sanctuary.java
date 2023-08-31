package Primates;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * This class represents a sanctuary. A sanctuary has enclosures and isolation
 */
public class Sanctuary {

    private EnclosureHabitat enclosure;
    private IsolationHabitat isolation;


    /**
     * Construct a sanctuary by initialising its isolation, enclosure and the ArrayList(its data structure)
     */
    public Sanctuary() {
        this.isolation = new Isolation();
        this.enclosure = new Enclosure();
    }

    /**
     * Return the Sanctuary's isolation
     *
     * @return the Sanctuary's isolation
     */
    public IsolationHabitat getIsolation() {
        return this.isolation;
    }

    /**
     * Return the Sanctuary's enclosure
     *
     * @return the Sanctuary's enclosure
     */
    public EnclosureHabitat getEnclosure() {
        return this.enclosure;
    }

    /**
     * return a list that includes the monkey's name from the sanctuary, in alphabetical order of the name
     *
     * @return the list that includes the monkey's name from the sanctuary
     */
    public String listAllMonkey() {
        ArrayList<Monkey> sanctuaryList = new ArrayList<Monkey>();
        int i;
        for (i = 0; i < this.isolation.getNumberOfMonkey(); i++) {
            sanctuaryList.add(this.isolation.getList().get(i));
        }
        for (i = 0; i < this.enclosure.getCapacity(); i++) {
            for (int j = 0; j < this.enclosure.getList()[i].size(); j++) {
                sanctuaryList.add(this.enclosure.getList()[i].get(j));
            }
        }
        Collections.sort(sanctuaryList, Comparator.comparing(Monkey::getName));
        StringBuilder s = new StringBuilder();
        for (i = 0; i < sanctuaryList.size(); i++) {
            if (i > 0) {
                s.append(",");
            }
            s.append(sanctuaryList.get(i).getName());
        }
        return s.toString();
    }

    /**
     * Calling the constructor in the Monkey class to create a monkey
     *
     * @param name    the name of the monkey
     * @param species the species of the monkey
     * @param sex     the sez of the monkey
     * @param size    the size of the monkey
     * @param weight  the weight of the monkey
     * @param age     the age of the monkey
     * @param food    the food of the monkey
     * @return the monkey being created
     */
    public Monkey createMonkey(String name, Species species, Sex sex, String size, String weight, String age, Food food) {
        Monkey m = new Monkey(name, species, sex, size, weight, age, food);
        return m;
    }

    /**
     * Calling the getName method in the Monkey class
     *
     * @param m the monkey object
     * @return the name of the monkey
     */
    public String getMonkeyName(Monkey m) {
        return m.getName();
    }

    /**
     * Calling the getSpeciesValue method in the Monkey class
     *
     * @param m the monkey object
     * @return the species value of the monkey
     */

    public int getMonkeySpeciesValue(Monkey m) {
        return m.getSpeciesValue();
    }

    /**
     * calling setHealthiness method in the Monkey class
     *
     * @param m the monkey object
     */
    public void setMonkeyHealthiness(Monkey m) {
        m.setHealthiness(this);
    }

    /**
     * Get all the monkey's species
     *
     * @return an array to store all the monkey's species
     */

    public Species[] getAllSpecies() {
        return Species.values();
    }

    /**
     * Get all the monkey's sex
     *
     * @return an array to store all the monkey's sex
     */
    public Sex[] getAllSex() {
        return Sex.values();
    }

    /**
     * Get all the monkey's favourite food
     *
     * @return an array to store all the monkey's favourite food
     */
    public Food[] getAllFood() {
        return Food.values();
    }

}

