package Primates;

/**
 * This is the interface features, it contains the method about registering a monkey, move monkey to enclosure,
 * list the monkey's name, sex and its favourite food in the enclosure and list the monkey's name in sanctuary
 */
public interface Features {

    /**
     * The method to register the monkey
     * Will pop up the message if below scenarios happen:
     * The name is not empty or contains non alphabets
     * The size input is not numeric or less than or equal to zero
     * The weight input is not numeric or less than or equal to zero
     * The age input is not numeric or less than or equal to zero
     * If all monkey's attributes are input correctly,
     * it would check and pop up message
     * if there is another monkey in isolation/enclosure which has the same name as the monkey being registered
     * if no another monkey has same name with the monkey being registered, it would register the monkey and put in isolation
     * it would pop up the message if trying to register monkey to a full isolation
     *
     *
     * @param name    name of the monkey
     * @param species species of the monkey
     * @param sex     sex of the monkey
     * @param size    size of the monkey
     * @param weight  weight of the monkey
     * @param age     age of the monkey
     * @param food    food of the monkey
     */

    void registerMonkey(String name, Species species, Sex sex, String size, String weight, String age, Food food);

    /**
     * The method to move the monkey from isolation to enclosure when the monkey received medical attention
     * It would pop out message if no monkey left in isolation which can be moved to enclosure
     */
    void moveMonkeyToEnclosure();

    /**
     * The method to list the monkey's name, sex and its favourite food in the enclosure
     */
    void listEnclosure();

    /**
     * The method to list the monkey's name in the sanctuary
     */
    void listSanctuary();

}
