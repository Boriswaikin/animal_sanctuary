package Primates;

/**
 * This class represents the controller in MVC model. It defines the operation mandated by the PrimatesController and
 * Features interface
 */
public class SwingPrimatesController implements PrimatesController, Features {

    private Sanctuary sanctuaryModel;
    private PrimatesView view;

    /**
     * Construct a Primate Controller by initialling its view and model
     *
     * @param v the view of the Primate GUI
     * @param s the model of the Primate GUI
     */
    public SwingPrimatesController(PrimatesView v, Sanctuary s) {
        view = v;
        sanctuaryModel = s;
    }

    @Override
    public void playGame() {

        for (Species species : sanctuaryModel.getAllSpecies()) {
            view.addSpeciesBoxForMonkeyCreation(species);
        }

        for (Sex sex : sanctuaryModel.getAllSex()) {
            view.addSexBoxForMonkeyCreation(sex);
        }

        for (Food food : sanctuaryModel.getAllFood()) {
            view.addFoodBoxForMonkeyCreation(food);
        }

        for (Species species : sanctuaryModel.getAllSpecies()) {
            view.addSpeciesBox(species);
        }

        view.addFeatures(this);
    }

    @Override
    public void registerMonkey(String name, Species species, Sex sex, String size, String weight, String age, Food food) {
        String regex = "[0-9]+[\\.]?[0-9]*";

        if (name.trim().equals("")) {
            view.setMsgEmptyName();
        } else if (!name.trim().matches("[a-zA-Z]+")) {
            view.setMsgInvalidName();
        } else if (!size.matches(regex) || Double.parseDouble(size) < 0) {
            view.setMsgInvalidSize();
        } else if (!weight.matches(regex) || Double.parseDouble(weight) < 0) {
            view.setMsgInvalidWeight();
        } else if (!age.matches(regex) || Double.parseDouble(age) < 0) {
            view.setMsgInvalidAge();
        } else {
            Monkey m = sanctuaryModel.createMonkey(name, species, sex, size, weight, age, food);

            int col = sanctuaryModel.getIsolation().getNumberOfMonkey();

            if (sanctuaryModel.getIsolation().getNumberOfMonkey() == sanctuaryModel.getIsolation().getCapacity()) {
                view.setMsgIsolationFull();
            } else {
                int fCheck = 0;
                for (int i = 0; i < sanctuaryModel.getEnclosure().getCapacity(); i++) {
                    if (this.sanctuaryModel.getEnclosure().getList()[i].size() > 0) {
                        for (int j = 0; j < this.sanctuaryModel.getEnclosure().getList()[i].size(); j++) {
                            if (this.sanctuaryModel.getEnclosure().getList()[i].get(j).getName().equals(sanctuaryModel.getMonkeyName(m))) {
                                view.setMsgSameNameEnclosure();
                                fCheck = 1;
                            }
                        }
                    }
                }
                for (int i = 0; i < sanctuaryModel.getIsolation().getNumberOfMonkey(); i++) {
                    if (sanctuaryModel.getIsolation().getList().get(i).getName().equals(sanctuaryModel.getMonkeyName(m))) {
                        view.setMsgSameNameIsolation();
                        fCheck = 1;
                    }
                }
                if (fCheck == 0) {
                    sanctuaryModel.getIsolation().addMonkey(m);
                    view.setButtonDisplay(sanctuaryModel.getMonkeyName(m), col);
                    view.addMonkeyToEnclosureBox(m);
                }
            }
        }
    }

    @Override
    public void moveMonkeyToEnclosure() {
        if (view.selectMonkeyBox() == null) {
            view.setMsgNoMonkeyLeftInIsolation();
        } else {
            Monkey m = view.selectMonkeyBox();
            view.setMonkeyToEnclosure(sanctuaryModel.getMonkeyName(m), sanctuaryModel.getMonkeySpeciesValue(m));
            sanctuaryModel.setMonkeyHealthiness(m);
            view.removeButtonDisplay(sanctuaryModel.getMonkeyName(m));
            view.removeMonkeyFromEnclosureBox(m);
            view.addButton();
        }
    }

    @Override
    public void listEnclosure() {
        Species species = view.selectSpeciesBox();
        String s = "List of " + species;
        String s2 = sanctuaryModel.getEnclosure().listAllMonkey(species);
        view.getListOfEnclosure(s, s2);
    }

    @Override
    public void listSanctuary() {
        String s = "List Of Sanctuary:";
        String s2 = sanctuaryModel.listAllMonkey();
        view.getListOfSanctuary(s, s2);
    }
}
