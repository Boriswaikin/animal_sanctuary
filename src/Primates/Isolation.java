package Primates;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/**
 * This class represents an isolation. It defines the operation mandated by the IsolationHabitat
 */
public class Isolation implements IsolationHabitat {

    private ArrayList<Monkey> list;
    private int capacity;
    private int numberOfMonkey;

    /**
     * Construct an isolation enclosures by initialising an arraylist(the data structure of an isolation),
     * the capacity and the number of monkey an isolation contains
     */
    public Isolation() {
        this.numberOfMonkey = 0;
        this.capacity = 20;
        this.list = new ArrayList<Monkey>();
    }

    @Override
    public ArrayList<Monkey> getList() {
        return this.list;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfMonkey() {
        return this.numberOfMonkey;
    }

    @Override
    public void addMonkey(Monkey a) throws IllegalStateException {

        if (this.numberOfMonkey > 0) {
            for (int i = 0; i < this.numberOfMonkey; i++) {
                if (this.list.get(i).getName().equals(a.getName())) {
                    throw new IllegalStateException(
                            "Monkey cannot be added to isolation having the same name monkey");
                }
            }
        }

        if (a.getHealthiness()) {
            throw new IllegalStateException("Healthy monkey cannot be added to isolation");
        }

        this.list.add(a);
        this.numberOfMonkey++;

        if (this.numberOfMonkey > this.capacity) {
            throw new IllegalStateException("Over capacity");
        }

    }

    @Override
    public void removeMonkey(Monkey a) throws IllegalStateException {
        this.list.remove(a);
        this.numberOfMonkey--;
        if (this.numberOfMonkey < 0) {
            throw new IllegalStateException("No monkey can be removed");
        }
    }

    @Override
    public String listAllMonkey() {
        StringBuilder s = new StringBuilder();
        Collections.sort(this.list, Comparator.comparing(Monkey::getName));
        for (int i = 0; i < this.list.size(); i++) {
            if (i > 0) {
                s.append(",");
            }
            s.append(this.getList().get(i).getName());
        }
        return s.toString();
    }
}
