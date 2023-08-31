package Primates;

import org.hamcrest.core.Is;

/**
 * This class represents monkey
 */
public class Monkey {

    private String name;

    private final Species species;

    private final Sex sex;

    private double size;

    private double weight;

    private double age;

    private Food food;

    private boolean healthiness;

    /**
     * Construct a monkey by initialising its name, species, sex, size, weight, age, favourite food and not labelled as healthy(healthiness=false)
     *
     * @param name    Name of the monkey
     * @param species Species of the monkey
     * @param sex     Sex of the monkey
     * @param size    Size of the monkey
     * @param weight  Weight of the monkey
     * @param age     Age of the monkey
     * @param food    Favourite food of the monkey
     * @throws IllegalArgumentException throws an exception if the name of the monkey is empty, the name of monkey contains non alpahbets
     *                                  or size, weight and age is less than or equal to zero
     */
    public Monkey
    (String name, Species species, Sex sex, String size, String weight, String age, Food food) throws IllegalArgumentException {

        this.name = name;
        this.species = species;
        this.sex = sex;
        this.size = Double.parseDouble(size);
        this.weight = Double.parseDouble(weight);
        this.age = Double.parseDouble(age);
        this.food = food;
        this.healthiness = false;

        if (this.name.trim().equals("")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (!this.name.trim().matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name cannot contain non alphabets");
        }

        if (this.size <= 0) {
            throw new IllegalArgumentException("Size cannot be less or equal to 0");
        }
        if (this.weight <= 0) {
            throw new IllegalArgumentException("Weight cannot be less or equal to 0");
        }
        if (this.age <= 0) {
            throw new IllegalArgumentException("Age cannot be less or equal to 0");
        }
    }

    /**
     * Return the name of the monkey
     *
     * @return the name of the monkey
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the species of the monkey
     *
     * @return the species of the monkey
     */
    public Species getSpecies() {
        return this.species;
    }

    /**
     * Return the preassigned value of the species of the monkey
     *
     * @return the preassigned value of the species of the monkey
     * DRILL(0),
     * GUEREZA(1),
     * HOWLER(2),
     * MANGABEY(3),
     * SAKI(4),
     * SPIDER(5),
     * SQUIRREL(6),
     * TAMARIN(7);
     */
    public int getSpeciesValue() {
        return this.species.getValue();
    }

    /**
     * Return the Sex of the monkey
     *
     * @return the Sex of the monkey
     */
    public Sex getSex() {
        return this.sex;
    }

    /**
     * Return the size of the monkey
     *
     * @return the size of the monkey
     */
    public double getSize() {
        return this.size;
    }


    /**
     * Return the weight of the monkey
     *
     * @return the weight of the monkey
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Return the age of the monkey
     *
     * @return the age of the monkey
     */
    public double getAge() {
        return this.age;
    }

    /**
     * Return the favourite food of the monkey
     *
     * @return the favourite food of the monkey
     */
    public Food getFood() {
        return this.food;
    }

    /**
     * Return the status of healthy
     *
     * @return the status of medical attention of the monkey
     */
    public boolean getHealthiness() {
        return this.healthiness;
    }

    /**
     * labelling the monkey is healthy and remove the monkey from isolation to enclosure
     *
     * @param s the sanctuary the monkeys live in
     */
    public void setHealthiness(Sanctuary s) {
        if (!this.getHealthiness()) {
            this.healthiness = true;
            s.getIsolation().removeMonkey(this);
            s.getEnclosure().addMonkey(this);
        }
    }

    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}


