package Primates;

/**
 * This is an interface that lists the method a SwingPrimates needs
 */
public interface PrimatesView {

    /**
     * Add the action lister to the buttons as below,
     * so it would trigger the method implemented in the controller to perform the features
     * RegisterMonkeyButton: To trigger the method registerMonkey implemented in SwingPrimatesController
     * addMonkeyToIEnclosureButton: To trigger the method moveMonkeyToEnclosure implemented in SwingPrimatesController
     * enclosureListButton: To trigger the method listEnclosure implemented in SwingPrimatesController
     * sanctuaryListButton: To trigger the method listSanctuary implemented in SwingPrimatesController
     *
     * @param features the object type of the methods
     */
    void addFeatures(Features features);

    /**
     * Add the monkey's species to the comboBox
     *
     * @param species the species of the monkey
     */

    void addSpeciesBox(Species species);

    /**
     * Add the monkey's species to the comboBox for monkey registration
     *
     * @param species the species of the monkey
     */

    void addSpeciesBoxForMonkeyCreation(Species species);

    /**
     * Add the monkey's sex to the comboBox for monkey registration
     *
     * @param sex the sex of the monkey
     */

    void addSexBoxForMonkeyCreation(Sex sex);

    /**
     * Add the monkey's favourite food to the comboBox for monkey registration
     *
     * @param food the favourite food of the monkey
     */
    void addFoodBoxForMonkeyCreation(Food food);

    /**
     * Display a message text to indicate the monkey's name is empty
     */
    void setMsgEmptyName();

    /**
     * Display a message text to indicate the monkey's name is invalid(contain non alphabets)
     */
    void setMsgInvalidName();

    /**
     * Display a message text to indicate the same name monkey in isolation
     */
    void setMsgSameNameIsolation();

    /**
     * Display a message text to indicate the same name monkey in enclosure
     */
    void setMsgSameNameEnclosure();


    /**
     * Display a message text to indicate the monkey's size is invalid (not numeric or less than or equal to zero)
     */
    void setMsgInvalidSize();

    /**
     * Display a message text to indicate the monkey's age is invalid (not numeric or less than or equal to zero)
     */
    void setMsgInvalidAge();

    /**
     * Display a message text to indicate the monkey's weight is invalid (not numeric or less than or equal to zero)
     */
    void setMsgInvalidWeight();


    /**
     * Create a message text to indicate the isolation is full
     */
    void setMsgIsolationFull();

    /**
     * Create a message text to indicate there is no monkey left in the isolation
     */
    void setMsgNoMonkeyLeftInIsolation();

    /**
     * Display the monkey's picture and its name in the isolation button
     *
     * @param s   the string representing the name of the monkey
     * @param col the index position of the isolation button in the arraylist
     */
    void setButtonDisplay(String s, int col);

    /**
     * Remove the button by checking if the button contains the text that equals the monkey's name
     * in which that monkey is being removed from isolation
     *
     * @param s the string representing the name of the monkey
     */
    void removeButtonDisplay(String s);

    /**
     * Add the isolation button for new monkey being registered
     */
    void addButton();

    /**
     * Add the monkey which is in the isolation to the comboBox,
     * so the user can select the monkey to be moved from isolation to enclosure
     *
     * @param m the monkey object
     */
    void addMonkeyToEnclosureBox(Monkey m);

    /**
     * remove the monkey from comboBox after the monkey is moved to enclosure
     * so the user cannot select that monkey to be moved from isolation to enclosure
     *
     * @param m the monkey object
     */
    void removeMonkeyFromEnclosureBox(Monkey m);

    /**
     * select the monkey in the comboBox
     *
     * @return the object of monkey being selected
     */
    Monkey selectMonkeyBox();

    /**
     * select the species of the monkey in the comboBox
     *
     * @return the species of monkey being selected
     */
    Species selectSpeciesBox();

    /**
     * Move the monkey from isolation to specific enclosure according to the monkey's predefined species value
     * Display the monkey's picture and the monkey's name to the specific row of species
     * The predefined species value as below:
     * DRILL(0),
     * GUEREZA(1),
     * HOWLER(2),
     * MANGABEY(3),
     * SAKI(4),
     * SPIDER(5),
     * SQUIRREL(6),
     * TAMARIN(7);
     *
     * @param s            the string representing the monkey's name
     * @param speciesValue the predefined species value
     */
    void setMonkeyToEnclosure(String s, int speciesValue);

    /**
     * To display the list of monkey's name, sex and the favourite food in the selected enclosure
     *
     * @param s  the string representing the header of the list (ie. List of Species: DRILL)
     * @param s2 the string representing the content of the list
     */
    void getListOfEnclosure(String s, String s2);

    /**
     * To display the list of monkey's name in the sanctuary
     *
     * @param s  the string representing the header of the list (ie. List of Sanctuary:)
     * @param s2 the string representing the content of the list
     */
    void getListOfSanctuary(String s, String s2);

}
