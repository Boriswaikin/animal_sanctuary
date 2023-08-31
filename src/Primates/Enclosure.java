package Primates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class represents eight enclosures. It defines the operation mandated by the EnclosureHabitat
 */
public class Enclosure implements EnclosureHabitat {

    private int capacity;
    private ArrayList<Monkey> list[];

    /**
     * Construct eight enclosures by initialising an array to store the eight enclosures. The array capacity is eight
     */
    public Enclosure() {
        this.capacity = 8;
        this.list = new ArrayList[capacity];
        for (int i = 0; i < this.capacity; i++) {
            this.list[i] = new ArrayList<Monkey>();
        }
    }

    @Override
    public ArrayList<Monkey>[] getList() {
        return this.list;
    }


    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void addMonkey(Monkey a) throws IllegalStateException {

        if (!a.getHealthiness()) {
            throw new IllegalStateException("Non healthy monkey cannot be added to enclosure");
        }
//    if (RoomNumber!=a.getSpeciesValue()) {
//      throw new IllegalStateException(
//          "Monkey added to the enclosure which should be occupied by other species");
//    }
        for (int i = 0; i < this.getCapacity(); i++) {
            if (this.list[i].size() > 0) {
                for (int j = 0; j < this.list[i].size(); j++) {
                    if (this.list[i].get(j).getName().equals(a.getName())) {
                        throw new IllegalStateException(
                                "Monkey cannot be added to enclosure having the same name monkey");
                    }
                }
            }
        }
        this.list[a.getSpeciesValue()].add(a);
    }

    @Override
    public String listAllMonkey(Species species) {
        StringBuilder s = new StringBuilder();
        Collections.sort(this.list[species.getValue()], Comparator.comparing(Monkey::getName));
        for (int i = 0; i < this.list[species.getValue()].size(); i++) {
            if (i > 0) {
                s.append("; ");
            }
            s.append("Name:");
            s.append(this.list[species.getValue()].get(i).getName());
            s.append(",");
            s.append("Sex:");
            s.append(this.list[species.getValue()].get(i).getSex());
            s.append(",");
            s.append("Favourite Food:");
            s.append(this.list[species.getValue()].get(i).getFood());
        }
        return s.toString();
    }

}
