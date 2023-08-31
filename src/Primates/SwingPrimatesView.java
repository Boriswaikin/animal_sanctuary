package Primates;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the view in MVC model. It defines the operation mandated by the PrimatesView
 */
public class SwingPrimatesView extends JFrame implements PrimatesView {

    private JButton RegisterMonkeyButton, addMonkeyToIEnclosureButton, enclosureListButton, sanctuaryListButton;
    private ArrayList<JButton> isolationButtonsList = new ArrayList<>();
    private ImageIcon monkeyIcon, newMonkeyIcon;

    private Image monkeyImage, newMonkeyImage;

    private JLabel rows[] = new JLabel[8];

    private JTextArea headerOfList, contentOfList;

    private JTextField nameOfMonkey, sizeOfMonkey, weightOfMonkey, ageOfMonkey;

    private final JComboBox<Monkey> monkeyBox;
    private final JComboBox<Species> speciesBox;

    private final JComboBox<Species> speciesBoxForMonkeyCreation;
    private final JComboBox<Sex> sexBoxForMonkeyCreation;
    private final JComboBox<Food> foodBoxForMonkeyCreation;

    private JPanel panel1, panel1a, panel1b, panel1c, panel2, panel2a, panel2b, panel3, panel3a, panel3b, panel3c;

    /**
     * Construct the primates GUI which consist of three main panels.
     * The first main panel would be the panel for monkey creation.
     * It contains three subPanels:
     * First subPanel(panel 1a) is to input the attribute of the monkeys
     * Second subPanel(panel 1b) is to register the monkey and move the monkey to enclosure
     * Third subPanel(panel 1c) is to display the list of monkey in enclousure and the list of monkey in sanctuary
     * The second main panel would be the panel for enclosure.
     * It contains two subPanels:
     * First subPanel(panel 2a) is the header of enclosure
     * Second subPanel(panel 2b) is to display the eight rows, each rows stands for a specific enclosure
     * The third main panel would be the panel for isolation and the list required to be displayed.
     * It contains three subPanels:
     * First subPanel(panel 3a) is the header of isolation
     * Second subPanel (panel 3b) is the isolation panel which contains 20 buttons for the room of isolation
     * Third subPanel(panel 3c) is the panel for enclosure list and sanctuary list
     *
     * @param caption the name of primates GUI
     */
    public SwingPrimatesView(String caption) {
        super(caption);

        this.setPreferredSize(new Dimension(1000, 635));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        panel2 = new JPanel();
        panel3 = new JPanel();
        java.net.URL imgURL = getClass().getResource("/Primates/monkey.png");
        monkeyIcon = new ImageIcon(imgURL);
        monkeyImage = monkeyIcon.getImage(); // transform it
        newMonkeyImage = monkeyImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        newMonkeyIcon = new ImageIcon(newMonkeyImage);

        //Panel 1: control panel:
        panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setLayout(new BorderLayout());
        //sub panel1a for the textfield of monkey's attributes
        panel1a = new JPanel();
        panel1a.setBackground(Color.WHITE);
        //sub panel1b for the buttons and comboBox (Button of registering a monkey, comboBox for monkeys
        // and Button of moving monkey to enclosure)
        panel1b = new JPanel();
        panel1b.setBackground(Color.LIGHT_GRAY);
        //sub panel1c for the buttons and comboBox ( comboBox for species to be selected;
        // button of listing out monkeys in specific enclosure and Button of list out monkeys in sanctuary)
        panel1c = new JPanel();
        panel1c.setBackground(Color.LIGHT_GRAY);


        //the textfield of monkey's attributes
        JLabel labelNameOfMonkey = new JLabel("Name:");
        nameOfMonkey = new JTextField(5);
        JLabel labelSpeciesOfMonkey = new JLabel("Species:");
        JLabel labelSexOfMonkey = new JLabel("Sex:");
        JLabel labelSizeOfMonkey = new JLabel("Size:");
        sizeOfMonkey = new JTextField(5);
        JLabel labelWeightOfMonkey = new JLabel("Weight:");
        weightOfMonkey = new JTextField(5);
        JLabel labelAgeOfMonkey = new JLabel("Age:");
        ageOfMonkey = new JTextField(5);
        JLabel labelFoodOfMonkey = new JLabel("Food:");
        speciesBoxForMonkeyCreation = new JComboBox<Species>();
        sexBoxForMonkeyCreation = new JComboBox<Sex>();
        foodBoxForMonkeyCreation = new JComboBox<Food>();

        //add the text fields to the panel1a
        panel1a.add(labelNameOfMonkey);
        panel1a.add(nameOfMonkey);
        panel1a.add(labelSpeciesOfMonkey);
        panel1a.add(speciesBoxForMonkeyCreation);
        panel1a.add(labelSexOfMonkey);
        panel1a.add(sexBoxForMonkeyCreation);
        panel1a.add(labelSizeOfMonkey);
        panel1a.add(sizeOfMonkey);
        panel1a.add(labelWeightOfMonkey);
        panel1a.add(weightOfMonkey);
        panel1a.add(labelAgeOfMonkey);
        panel1a.add(ageOfMonkey);
        panel1a.add(labelFoodOfMonkey);
        panel1a.add(foodBoxForMonkeyCreation);

        RegisterMonkeyButton = new JButton("Register Monkey");
        addMonkeyToIEnclosureButton = new JButton("Move to Enclosure");
        enclosureListButton = new JButton("Specific Enclosure List");
        sanctuaryListButton = new JButton("Sanctuary List");

        panel1b.add(RegisterMonkeyButton);
        monkeyBox = new JComboBox<Monkey>();
        panel1b.add(monkeyBox);
        panel1b.add(addMonkeyToIEnclosureButton);
        panel1c.add(new JLabel("Species :"));
        speciesBox = new JComboBox<Species>();
        panel1c.add(speciesBox);
        panel1c.add(enclosureListButton);
        panel1c.add(sanctuaryListButton);


        //panel 2: Enclosure panel:
        panel2.setLayout(new BorderLayout());
        //panel 2a: Enclosure header subpanel:
        panel2a = new JPanel();
        panel2a.setBackground(Color.gray);
        panel2a.add(new JLabel("Enclosure"));

        //panel 2b: Enclosure subpanel:
        panel2b = new JPanel();
        panel2b.setBackground(Color.GREEN);
        panel2b.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        rows[0] = new JLabel("Enclosure for species - DRILL");
        rows[1] = new JLabel("Enclosure for species - GUEREZA");
        rows[2] = new JLabel("Enclosure for species - HOWLER");
        rows[3] = new JLabel("Enclosure for species - MANGABEY");
        rows[4] = new JLabel("Enclosure for species - SAKI");
        rows[5] = new JLabel("Enclosure for species - SPIDER");
        rows[6] = new JLabel("Enclosure for species - SQUIRREL");
        rows[7] = new JLabel("Enclosure for species - TAMARIN");
        for (int i = 0; i < 8; i++) {
            gbc.gridy = i;
            panel2b.add(rows[i], gbc);
        }

        //panel 3: Isolation panel:
        panel3.setLayout(new BorderLayout());

        //panel 3a: Isolation header panel:
        panel3a = new JPanel();
        panel3a.setBackground(Color.gray);
        panel3a.add(new JLabel("Isolation"));

        //panel 3b: Isolation panel:
        panel3b = new JPanel();
        panel3b.setBackground(Color.lightGray);
        panel3b.setLayout(new GridLayout(4, 5, 0, 10));
        //Construct 20 isolation panels
        for (int i = 0; i < 20; i++) {
            isolationButtonsList.add(new JButton());

        }
        for (JButton jButton : isolationButtonsList) {
            panel3b.add(jButton);
        }
        //panel3c: panel for enclosure list and sanctuary list
        panel3c = new JPanel();
        panel3c.setLayout(new BoxLayout(panel3c, BoxLayout.Y_AXIS));
        panel3c.setBackground(Color.white);
        headerOfList = new JTextArea(1, 10);
        contentOfList = new JTextArea(10, 10);
        panel3c.add(headerOfList);
        panel3c.add(Box.createRigidArea(new Dimension(0, 10)));
        panel3c.add(contentOfList);


        //Set size for different panels
        panel1.setPreferredSize(new Dimension(1000, 120));
        panel1a.setPreferredSize(new Dimension(1000, 40));
        panel1b.setPreferredSize(new Dimension(1000, 40));
        panel1c.setPreferredSize(new Dimension(1000, 40));

        panel2.setPreferredSize(new Dimension(1000, 240));
        panel2a.setPreferredSize(new Dimension(1000, 25));
        panel2b.setPreferredSize(new Dimension(1000, 200));

        panel3.setPreferredSize(new Dimension(1000, 275));
        panel3a.setPreferredSize(new Dimension(1000, 25));
        panel3b.setPreferredSize(new Dimension(1000, 150));
        panel3c.setPreferredSize(new Dimension(1000, 100));

        //add the subPanels to the main panel
        panel1.add(panel1a, BorderLayout.NORTH);
        panel1.add(panel1b, BorderLayout.CENTER);
        panel1.add(panel1c, BorderLayout.SOUTH);
        panel2.add(panel2a, BorderLayout.NORTH);
        panel2.add(panel2b, BorderLayout.CENTER);
        panel3.add(panel3a, BorderLayout.NORTH);
        panel3.add(panel3b, BorderLayout.CENTER);
        panel3.add(panel3c, BorderLayout.SOUTH);

        //add the main panels to the layout
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);
        setLocation(200, 200);

        this.pack();
    }

    @Override
    public void addFeatures(Features features) {
        RegisterMonkeyButton.addActionListener(evt -> features.registerMonkey(
                nameOfMonkey.getText(), (Species) this.speciesBoxForMonkeyCreation.getSelectedItem()
                , (Sex) this.sexBoxForMonkeyCreation.getSelectedItem(), sizeOfMonkey.getText()
                , weightOfMonkey.getText(), ageOfMonkey.getText()
                , (Food) this.foodBoxForMonkeyCreation.getSelectedItem()));
        addMonkeyToIEnclosureButton.addActionListener(evt -> features.moveMonkeyToEnclosure());
        enclosureListButton.addActionListener(evt -> features.listEnclosure());
        sanctuaryListButton.addActionListener(evt -> features.listSanctuary());
    }

    @Override
    public void addSpeciesBox(Species species) {

        this.speciesBox.addItem(species);
    }

    @Override
    public void addSpeciesBoxForMonkeyCreation(Species species) {

        this.speciesBoxForMonkeyCreation.addItem(species);
    }

    @Override
    public void addSexBoxForMonkeyCreation(Sex sex) {

        this.sexBoxForMonkeyCreation.addItem(sex);
    }

    @Override
    public void addFoodBoxForMonkeyCreation(Food food) {

        this.foodBoxForMonkeyCreation.addItem(food);
    }

    @Override
    public void setMsgEmptyName() {
        JOptionPane.showMessageDialog(null, "The name of the monkey is empty");
    }

    @Override
    public void setMsgInvalidName() {
        JOptionPane.showMessageDialog(null, "The name of the monkey contains non alphabets");
    }

    @Override
    public void setMsgSameNameIsolation() {
        JOptionPane.showMessageDialog(null, "Same name of the monkey in isolation");
    }

    @Override
    public void setMsgSameNameEnclosure() {
        JOptionPane.showMessageDialog(null, "Same name of the monkey in Enclosure");
    }

    @Override
    public void setMsgInvalidSize() {
        JOptionPane.showMessageDialog(null, "The size of the monkey is invalid");
    }

    @Override
    public void setMsgInvalidAge() {
        JOptionPane.showMessageDialog(null, "The Age of the monkey is invalid");
    }

    @Override
    public void setMsgInvalidWeight() {
        JOptionPane.showMessageDialog(null, "The Weight of the monkey is invalid");
    }

    @Override
    public void setMsgIsolationFull() {
        JOptionPane.showMessageDialog(null, "The isolation is full");
    }

    @Override
    public void setMsgNoMonkeyLeftInIsolation() {
        JOptionPane.showMessageDialog(null, "No monkey left in Isolation");
    }

    @Override
    public void setButtonDisplay(String s, int col) {
        this.isolationButtonsList.get(col).setText(s);
        this.isolationButtonsList.get(col).setIcon(newMonkeyIcon);

    }

    @Override
    public void removeButtonDisplay(String s) {
        int index = 0;
        for (int i = 0; i < 20; i++) {
            if (this.isolationButtonsList.get(i).getText().equals(s)) {
                index = i;
            }
        }
        panel3b.remove(this.isolationButtonsList.get(index));
        this.isolationButtonsList.remove(index);
    }

    @Override
    public void addButton() {
        //Add back the button
        this.isolationButtonsList.add(new JButton());
        panel3b.add(this.isolationButtonsList.get(this.isolationButtonsList.size() - 1));

    }

    @Override
    public void addMonkeyToEnclosureBox(Monkey m) {
        this.monkeyBox.addItem(m);
    }

    @Override
    public void removeMonkeyFromEnclosureBox(Monkey m) {
        this.monkeyBox.removeItem(m);
    }

    @Override
    public Monkey selectMonkeyBox() {
        return (Monkey) this.monkeyBox.getSelectedItem();
    }

    @Override
    public Species selectSpeciesBox() {
        return (Species) this.speciesBox.getSelectedItem();
    }

    @Override
    public void setMonkeyToEnclosure(String s, int speciesValue) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = speciesValue;
        JLabel monkeyPic = new JLabel(s, new ImageIcon(newMonkeyImage), 0);
        panel2b.add(monkeyPic, gbc);
    }

    @Override
    public void getListOfEnclosure(String s, String s2) {
        headerOfList.setText(s);
        contentOfList.setText(s2);
        contentOfList.setLineWrap(true);
    }

    @Override
    public void getListOfSanctuary(String s, String s2) {
        //Add back the button
        headerOfList.setText(s);
        contentOfList.setText(s2);
        contentOfList.setLineWrap(true);
    }
}