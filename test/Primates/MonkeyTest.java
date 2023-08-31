package Primates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the test class to set up monkeys for unit test
 */
public class MonkeyTest {
    private Monkey monkey1, monkey2, monkey3;

    /**
     * Construct three monkeys for unit test
     */
    @Before
    public void setup() {
        monkey1 = new Monkey("Cute", Species.GUEREZA, Sex.M, "3.4", "7.6", "9.2", Food.FRUITS);
        monkey2 = new Monkey("Stupid", Species.SQUIRREL, Sex.F, "5.2", "13.4", "16.4", Food.SEEDS);
        monkey3 = new Monkey("Apple", Species.TAMARIN, Sex.F, "7.8", "6.4", "5.4", Food.LEAVES);
    }

    @Test
    /**
     * Test the constructor works correctly to create a valid monkey(test all attributes of the monkey)
     */
    public void testCorrectMonkeyCreated() {
        //Try to create a monkey
        monkey1 = new Monkey("Cute", Species.GUEREZA, Sex.M, "7.3", "8.2", "5.1", Food.INSECTS);
        //Test every attribute of the monkey
        assertEquals("Cute", monkey1.getName());
        assertEquals(Species.GUEREZA, monkey1.getSpecies());
        assertEquals(Sex.M, monkey1.getSex());
        assertEquals(7.3, monkey1.getSize(), 0.001);
        assertEquals(8.2, monkey1.getWeight(), 0.001);
        assertEquals(5.1, monkey1.getAge(), 0.001);
        assertEquals(Food.INSECTS, monkey1.getFood());
        assertEquals(false, monkey1.getHealthiness());
    }


    @Test(expected = IllegalArgumentException.class)
    /**
     * Test to throw an exception if creating an empty name monkey
     */
    public void createEmptyNameMonkey() {
        Monkey monkey1 = new Monkey("", Species.SAKI, Sex.F, "20.1", "10.2", "5", Food.FRUITS);
    }

    @Test(expected = IllegalArgumentException.class)
    /**
     * Test to throw an exception if creating an invalid monkey (the name contains non alphabets)
     */
    public void createInvalidNameMonkey() {
        Monkey monkey1 = new Monkey("Cute83%&(", Species.SAKI, Sex.F, "20.1", "10.2", "5", Food.FRUITS);
    }

    @Test(expected = IllegalArgumentException.class)
    /**
     * Test to throw an exception if creating an invalid monkey (invalid size)
     */
    public void createInvalidSizeMonkey() {
        Monkey monkey1 = new Monkey("Apple", Species.SAKI, Sex.F, "0", "10.2", "5", Food.FRUITS);
    }

    @Test(expected = IllegalArgumentException.class)
    /**
     * Test to throw an exception if creating an invalid monkey (invalid weight)
     */
    public void createInvalidWeightMonkey() {
        Monkey monkey1 = new Monkey("Apple", Species.SAKI, Sex.F, "10.5", "-0.2", "5", Food.FRUITS);
    }

    @Test(expected = IllegalArgumentException.class)
    /**
     * Test to throw an exception if creating an invalid monkey (invalid age)
     */
    public void createInvalidAgeMonkey() {
        Monkey monkey1 = new Monkey("Apple", Species.SAKI, Sex.F, "20.1", "10.5", "-3", Food.FRUITS);
    }

    @Test
    /**
     * Test return correct name
     */
    public void testGetName() {
        assertEquals("Cute", monkey1.getName());
        assertEquals("Stupid", monkey2.getName());
        assertEquals("Apple", monkey3.getName());
    }

    @Test
    /**
     * Test return correct species
     */
    public void testGetSpecies() {
        assertEquals(Species.GUEREZA, monkey1.getSpecies());
        assertEquals(Species.SQUIRREL, monkey2.getSpecies());
        assertEquals(Species.TAMARIN, monkey3.getSpecies());
    }

    @Test
    /**
     * Test return correct assigned species value
     */
    public void testGetSpeciesValue() {
        assertEquals(1, monkey1.getSpeciesValue(), 0);
        assertEquals(6, monkey2.getSpeciesValue(), 0);
        assertEquals(7, monkey3.getSpeciesValue(), 0);
    }

    @Test
    /**
     * Test return correct Sex
     */
    public void testGetSex() {
        assertEquals(Sex.M, monkey1.getSex());
        assertEquals(Sex.F, monkey2.getSex());
        assertEquals(Sex.F, monkey3.getSex());
    }

    @Test
    /**
     * Test return correct size
     */
    public void testGetSize() {
        assertEquals(3.4, monkey1.getSize(), 0.1);
        assertEquals(5.2, monkey2.getSize(), 0.1);
        assertEquals(7.8, monkey3.getSize(), 0.1);
    }

    @Test
    /**
     * Test return correct weight
     */
    public void testGetWeight() {
        assertEquals(7.6, monkey1.getWeight(), 0.1);
        assertEquals(13.4, monkey2.getWeight(), 0.1);
        assertEquals(6.4, monkey3.getWeight(), 0.1);
    }

    @Test
    /**
     * Test return correct age
     */
    public void testGetAge() {
        assertEquals(9.2, monkey1.getAge(), 0.1);
        assertEquals(16.4, monkey2.getAge(), 0.1);
        assertEquals(5.4, monkey3.getAge(), 0.1);
    }

    @Test
    /**
     * Test return correct Food
     */
    public void testGetFood() {
        assertEquals(Food.FRUITS, monkey1.getFood());
        assertEquals(Food.SEEDS, monkey2.getFood());
        assertEquals(Food.LEAVES, monkey3.getFood());
    }

    @Test
    /**
     * Test return correct healthiness status
     */
    public void testGetHealthiness() {
        //check initially three monkeys are not labelled as healthy
        assertFalse(monkey1.getHealthiness());
        assertFalse(monkey2.getHealthiness());
        assertFalse(monkey3.getHealthiness());
        Sanctuary s = new Sanctuary();
        //add the monkey1 in isolation
        s.getIsolation().addMonkey(monkey1);
        //monkey1 is checked as healthy, it is labelled as healthy
        monkey1.setHealthiness(s);
        assertTrue(monkey1.getHealthiness());
    }

    @Test
    /**
     * Test able to change the status of healthiness and the monkey is moved from isolation to enclosure
     */
    public void testSetHealthiness() {
        Sanctuary s = new Sanctuary();
        s.getIsolation().addMonkey(monkey1);
        //monkey1 is not labeled as healthy
        assertFalse(monkey1.getHealthiness());
        //monkey1 is added to isolation, so isolation has monkey1 while enclosure does not have
        assertEquals("Cute", s.getIsolation().listAllMonkey());
        assertEquals("", s.getEnclosure().listAllMonkey(Species.GUEREZA));
        monkey1.setHealthiness(s);
        //monkey1 is labeled as healthy
        assertTrue(monkey1.getHealthiness());
        ///monkey1 is moved from isolation to enclosure, so enclosure has monkey1 while isolation does not have
        assertEquals("", s.getIsolation().listAllMonkey());
        assertEquals("Name:Cute,Sex:M,Favourite Food:FRUITS", s.getEnclosure().listAllMonkey(Species.GUEREZA));
    }

    @Test
    /**
     * Test toString method to return correct string representation
     */
    public void testToString() {
        assertEquals("Name: Cute",monkey1.toString());
        assertEquals("Name: Stupid",monkey2.toString());
        assertEquals("Name: Apple",monkey3.toString());
    }
}