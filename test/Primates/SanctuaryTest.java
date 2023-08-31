package Primates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the test class to set up the sanctuary and monkeys for unit test
 */
public class SanctuaryTest {

    private Monkey monkey1, monkey2, monkey3, monkey4, monkey5,
            monkey6, monkey7, monkey8, monkey9, monkey10, monkey11,
            monkey12, monkey13, monkey14, monkey15, monkey16, monkey17, monkey18, monkey19, monkey20, monkey21;
    private Sanctuary sanctuary1;

    /**
     * Construct three monkeys and a sanctuary for unit test
     */
    @Before
    public void setup() {

        sanctuary1 = new Sanctuary();
        monkey1 = sanctuary1.createMonkey("Cute", Species.GUEREZA, Sex.M, "3.4", "7.6", "9.2", Food.FRUITS);
        monkey2 = sanctuary1.createMonkey("Stupid", Species.SQUIRREL, Sex.F, "5.2", "13.4", "16.4", Food.SEEDS);
        monkey3 = sanctuary1.createMonkey("Apple", Species.TAMARIN, Sex.F, "7.8", "6.4", "5.4", Food.LEAVES);

    }

    @Test(expected = IllegalStateException.class)
    /**
     * Test to verify monkey cannot be added to isolation if it is already full
     */
    public void testOverCapacityIsolation() {
        //create 20 monkeys
        monkey1 = sanctuary1.createMonkey("Abu", Species.DRILL, Sex.F, "8.3", "2.4", "12.3", Food.SEEDS);
        monkey2 = sanctuary1.createMonkey("Bear", Species.GUEREZA, Sex.M, "28.2", "5.4", "13.4", Food.FRUITS);
        monkey3 = sanctuary1.createMonkey("Clyde", Species.HOWLER, Sex.F, "8.5", "9.2", "12.1", Food.INSECTS);
        monkey4 = sanctuary1.createMonkey("Marcel", Species.MANGABEY, Sex.F, "7.5", "1.2", "5.6", Food.LEAVES);
        monkey5 = sanctuary1.createMonkey("Mizaru", Species.SAKI, Sex.M, "9.2", "4.3", "7.5", Food.NUTS);
        monkey6 = sanctuary1.createMonkey("Ella", Species.SPIDER, Sex.F, "9.1", "8.4", "4.2", Food.NUTS);
        monkey7 = sanctuary1.createMonkey("Nim", Species.SQUIRREL, Sex.M, "3.4", "5.3", "4.5", Food.TREESAP);
        monkey8 = sanctuary1.createMonkey("Pipsqueak", Species.TAMARIN, Sex.F, "5.6", "10.2", "3.2", Food.INSECTS);
        monkey9 = sanctuary1.createMonkey("Bingo", Species.DRILL, Sex.F, "2.7", "10.5", "9.5", Food.SEEDS);
        monkey10 = sanctuary1.createMonkey("Fiona", Species.GUEREZA, Sex.M, "5.1", "18.3", "4.3", Food.TREESAP);
        monkey11 = sanctuary1.createMonkey("Aldo", Species.HOWLER, Sex.F, "4.7", "8.2", "1.2", Food.SEEDS);
        monkey12 = sanctuary1.createMonkey("Space", Species.MANGABEY, Sex.M, "13.2", "4.3", "5.6", Food.TREESAP);
        monkey13 = sanctuary1.createMonkey("Tala", Species.SAKI, Sex.M, "11.2", "9.4", "6.7", Food.EGGS);
        monkey14 = sanctuary1.createMonkey("Papina", Species.SPIDER, Sex.M, "8.6", "7.2", "5.3", Food.EGGS);
        monkey15 = sanctuary1.createMonkey("Totit", Species.SQUIRREL, Sex.F, "7.3", "1.2", "7.6", Food.EGGS);
        monkey16 = sanctuary1.createMonkey("Crystal", Species.SQUIRREL, Sex.F, "8.3", "10.2", "14.5", Food.SEEDS);
        monkey17 = sanctuary1.createMonkey("Kikazaru", Species.SQUIRREL, Sex.F, "11.2", "19.2", "4.5", Food.TREESAP);
        monkey18 = sanctuary1.createMonkey("Koko", Species.SQUIRREL, Sex.F, "1.3", "12.3", "2.3", Food.INSECTS);
        monkey19 = sanctuary1.createMonkey("Ffion", Species.SQUIRREL, Sex.F, "4.5", "2.4", "10.2", Food.NUTS);
        monkey20 = sanctuary1.createMonkey("Ampelio", Species.SQUIRREL, Sex.F, "6.2", "15.6", "10.4", Food.NUTS);
        //add 20 monkeys in isolation
        sanctuary1.getIsolation().addMonkey(monkey1);
        sanctuary1.getIsolation().addMonkey(monkey2);
        sanctuary1.getIsolation().addMonkey(monkey3);
        sanctuary1.getIsolation().addMonkey(monkey4);
        sanctuary1.getIsolation().addMonkey(monkey5);
        sanctuary1.getIsolation().addMonkey(monkey6);
        sanctuary1.getIsolation().addMonkey(monkey7);
        sanctuary1.getIsolation().addMonkey(monkey8);
        sanctuary1.getIsolation().addMonkey(monkey9);
        sanctuary1.getIsolation().addMonkey(monkey10);
        sanctuary1.getIsolation().addMonkey(monkey11);
        sanctuary1.getIsolation().addMonkey(monkey12);
        sanctuary1.getIsolation().addMonkey(monkey13);
        sanctuary1.getIsolation().addMonkey(monkey14);
        sanctuary1.getIsolation().addMonkey(monkey15);
        sanctuary1.getIsolation().addMonkey(monkey16);
        sanctuary1.getIsolation().addMonkey(monkey17);
        sanctuary1.getIsolation().addMonkey(monkey18);
        sanctuary1.getIsolation().addMonkey(monkey19);
        sanctuary1.getIsolation().addMonkey(monkey20);
        assertEquals("Abu,Aldo,Ampelio,Bear,Bingo,Clyde,Crystal,Ella,Ffion,Fiona,Kikazaru,Koko,Marcel" +
                        ",Mizaru,Nim,Papina,Pipsqueak,Space,Tala,Totit",
                sanctuary1.getIsolation().listAllMonkey());
        //create 21st monkey with different name than previous 20 monkeys
        monkey21 = sanctuary1.createMonkey("Caesar", Species.GUEREZA, Sex.M, "3.4", "7.6", "9.2", Food.FRUITS);
        //add 21st monkey to isolation
        sanctuary1.getIsolation().addMonkey(monkey21);
    }

    @Test(expected = IllegalStateException.class)
    /**
     * Test to verify cannot remove a monkey if isolation is empty
     */
    public void RemoveMonkeyInEmptyIsolation() {
        // add monkey1 to isolation first
        sanctuary1.getIsolation().addMonkey(monkey1);
        // then remove monkey1 from isolation
        sanctuary1.getIsolation().removeMonkey(monkey1);
        //isolation should be empty now:
        assertEquals("", sanctuary1.getIsolation().listAllMonkey());
        //try to remove monkey from an empty isolation
        sanctuary1.getIsolation().removeMonkey(monkey1);
    }

    @Test(expected = IllegalStateException.class)
    /**
     * Test cannot add same name monkey to isolation
     */
    public void testAddSameNameMonkeyToIsolation() {
        sanctuary1.getIsolation().addMonkey(monkey1);
        sanctuary1.getIsolation().addMonkey(monkey2);
        //Create another monkey4 with the same name "Cute" as monkey1
        Monkey monkey4 = sanctuary1.createMonkey("Cute", Species.SQUIRREL, Sex.F, "6.3", "7.2", "9.4", Food.TREESAP);
        sanctuary1.getIsolation().addMonkey(monkey4);
    }

    @Test(expected = IllegalStateException.class)
    /**
     * Test cannot add same name monkey to the enclosure
     */
    public void testAddSameNameMonkeyToEnclosure() {
        //add monkey1 and monkey2 to isolation
        sanctuary1.getIsolation().addMonkey(monkey1);
        sanctuary1.getIsolation().addMonkey(monkey2);
        //labeling monkey1 and monkey2 as healthy, they will be moved from isolation to enclosure
        sanctuary1.setMonkeyHealthiness(monkey1);
        sanctuary1.setMonkeyHealthiness(monkey2);
        //Create another monkey4 with the same name "Cute" as monkey1
        Monkey monkey4 = sanctuary1.createMonkey("Cute", Species.GUEREZA, Sex.F, "6.3", "7.2", "9.4", Food.TREESAP);
        // monkey4 is added to isolation first
        sanctuary1.getIsolation().addMonkey(monkey4);
        //add same name monkey to the enclosure by labeling it is healthy
        sanctuary1.setMonkeyHealthiness(monkey4);
    }

    @Test(expected = IllegalStateException.class)
    /**
     * Check cannot add to enclosure if the monkey is not labeled as healthy
     */
    public void testCannotAddToEnclosure() {
        assertEquals(false, monkey1.getHealthiness());
        sanctuary1.getEnclosure().addMonkey(monkey1);
    }

    @Test
    /**
     * Test to verify a monkey can be added to an isolation successfully
     */
    public void testCanAddToIsolation() {
        //Initially isolation is empty
        assertEquals("", sanctuary1.getIsolation().listAllMonkey());
        sanctuary1.getIsolation().addMonkey(monkey1);
        sanctuary1.getIsolation().addMonkey(monkey2);
        sanctuary1.getIsolation().addMonkey(monkey3);
        //after addling three monkeys to isolation, now list of isolation has their name
        assertEquals("Apple,Cute,Stupid", sanctuary1.getIsolation().listAllMonkey());
    }

    @Test
    /**
     * Test able to get the number of monkeys in isolation
     */
    public void testGetNumberOfMonkeyInIsolation() {
        //adding monkey
        sanctuary1.getIsolation().addMonkey(monkey1);
        assertEquals(1, sanctuary1.getIsolation().getNumberOfMonkey(), 0);
        sanctuary1.getIsolation().addMonkey(monkey2);
        assertEquals(2, sanctuary1.getIsolation().getNumberOfMonkey(), 0);
        sanctuary1.getIsolation().addMonkey(monkey3);
        assertEquals(3, sanctuary1.getIsolation().getNumberOfMonkey(), 0);
        //Removing monkey
        sanctuary1.getIsolation().removeMonkey(monkey3);
        assertEquals(2, sanctuary1.getIsolation().getNumberOfMonkey(), 0);
        sanctuary1.getIsolation().removeMonkey(monkey2);
        assertEquals(1, sanctuary1.getIsolation().getNumberOfMonkey(), 0);
        sanctuary1.getIsolation().removeMonkey(monkey3);
        assertEquals(0, sanctuary1.getIsolation().getNumberOfMonkey(), 0);
    }

    @Test
    /**
     * Test able to get the capacity of isolation
     */
    public void testGetCapacityOfIsolation() {
        assertEquals(20, sanctuary1.getIsolation().getCapacity());
    }

    @Test
    /**
     * Test to verify a monkey can be moved from an isolation to an enclosure
     */
    public void testCanMoveFromIsolationToEnclosure() {
        //Add three monkeys to isolation
        //monkey1, Species.GUEREZA
        //monkey2, Species.SQUIRREL
        //monkey3, Species.TAMARIN
        sanctuary1.getIsolation().addMonkey(monkey1);
        sanctuary1.getIsolation().addMonkey(monkey2);
        sanctuary1.getIsolation().addMonkey(monkey3);
        //check if three monkeys are in isolation
        assertEquals("Apple,Cute,Stupid", sanctuary1.getIsolation().listAllMonkey());
        //check if no monkeys in three enclosure
        assertEquals("", sanctuary1.getEnclosure().listAllMonkey(Species.GUEREZA));
        assertEquals("", sanctuary1.getEnclosure().listAllMonkey(Species.SQUIRREL));
        assertEquals("", sanctuary1.getEnclosure().listAllMonkey(Species.TAMARIN));
        // labelling monkey1 (Cute) and monkey3(Apple) as healthy
        sanctuary1.setMonkeyHealthiness(monkey1);
        sanctuary1.setMonkeyHealthiness(monkey3);
        //check if only monkey2 (name:Stupid) is in isolation
        assertEquals("Stupid", sanctuary1.getIsolation().listAllMonkey());
        //check if monkey1, monkey3 (name:Cute;Apple) are moved from isolation to enclosure
        assertEquals("Name:Cute,Sex:M,Favourite Food:FRUITS", sanctuary1.getEnclosure().listAllMonkey(Species.GUEREZA));
        assertEquals("", sanctuary1.getEnclosure().listAllMonkey(Species.SQUIRREL));
        assertEquals("Name:Apple,Sex:F,Favourite Food:LEAVES", sanctuary1.getEnclosure().listAllMonkey(Species.TAMARIN));
    }

    @Test
    /**
     * Test able to get the capacity of enclosure
     */
    public void testGetCapacityOfEnclosure() {
        assertEquals(8, sanctuary1.getEnclosure().getCapacity());
    }

    @Test
    /**
     * Test the list for a given enclosure is correct
     */
    public void testCorrectListEnclosure() {
        //Initially the enclosure for species TAMARIN is empty
        assertEquals("", sanctuary1.getEnclosure().listAllMonkey(Species.TAMARIN));
        monkey1 = sanctuary1.createMonkey("Apple", Species.TAMARIN, Sex.M, "8.3", "9.4", "10.2", Food.SEEDS);
        monkey2 = sanctuary1.createMonkey("Banana", Species.TAMARIN, Sex.F, "4.2", "2.4", "14.5", Food.FRUITS);
        monkey3 = sanctuary1.createMonkey("Chicken", Species.TAMARIN, Sex.M, "1.2", "5.6", "4.3", Food.NUTS);
        monkey4 = sanctuary1.createMonkey("Dick", Species.TAMARIN, Sex.F, "6.5", "9.2", "7.6", Food.TREESAP);
        monkey5 = sanctuary1.createMonkey("Edison", Species.TAMARIN, Sex.F, "5.6", "4.3", "6.7", Food.NUTS);
        //Randomly added to isolation
        sanctuary1.getIsolation().addMonkey(monkey2);
        sanctuary1.getIsolation().addMonkey(monkey3);
        sanctuary1.getIsolation().addMonkey(monkey1);
        sanctuary1.getIsolation().addMonkey(monkey5);
        sanctuary1.getIsolation().addMonkey(monkey4);
        //Then moved to enclosure
        sanctuary1.setMonkeyHealthiness(monkey2);
        sanctuary1.setMonkeyHealthiness(monkey3);
        sanctuary1.setMonkeyHealthiness(monkey1);
        sanctuary1.setMonkeyHealthiness(monkey5);
        sanctuary1.setMonkeyHealthiness(monkey4);
        //Check if five monkeys are added to enclosure for species TAMARIN and check if the list includes name, sex and favourite food of the monkey
        assertEquals
                ("Name:Apple,Sex:M,Favourite Food:SEEDS; "
                                + "Name:Banana,Sex:F,Favourite Food:FRUITS; "
                                + "Name:Chicken,Sex:M,Favourite Food:NUTS; "
                                + "Name:Dick,Sex:F,Favourite Food:TREESAP; "
                                + "Name:Edison,Sex:F,Favourite Food:NUTS"
                        , sanctuary1.getEnclosure().listAllMonkey(Species.TAMARIN));
    }


    @Test
    /**
     * Test to verify the report of species that are currently being housed in the sanctuary is correct
     * Test to verify the list of all monkeys housed in the Sanctuary is ordered by name
     * The list of all monkeys is in alphabetical order
     */
    public void testCorrectListSanctuary() {
        monkey1 = sanctuary1.createMonkey("Abu", Species.DRILL, Sex.F, "8.3", "2.4", "12.3", Food.SEEDS);
        monkey2 = sanctuary1.createMonkey("Bear", Species.GUEREZA, Sex.M, "28.2", "5.4", "13.4", Food.FRUITS);
        monkey3 = sanctuary1.createMonkey("Clyde", Species.HOWLER, Sex.F, "8.5", "9.2", "12.1", Food.INSECTS);
        monkey4 = sanctuary1.createMonkey("Marcel", Species.MANGABEY, Sex.F, "7.5", "1.2", "5.6", Food.LEAVES);
        monkey5 = sanctuary1.createMonkey("Mizaru", Species.SAKI, Sex.M, "9.2", "4.3", "7.5", Food.NUTS);
        monkey6 = sanctuary1.createMonkey("Ella", Species.SPIDER, Sex.F, "9.1", "8.4", "4.2", Food.NUTS);
        monkey7 = sanctuary1.createMonkey("Nim", Species.SQUIRREL, Sex.M, "3.4", "5.3", "4.5", Food.TREESAP);
        monkey8 = sanctuary1.createMonkey("Pipsqueak", Species.TAMARIN, Sex.F, "5.6", "10.2", "3.2", Food.INSECTS);
        monkey9 = sanctuary1.createMonkey("Bingo", Species.DRILL, Sex.F, "2.7", "10.5", "9.5", Food.SEEDS);
        monkey10 = sanctuary1.createMonkey("Fiona", Species.GUEREZA, Sex.M, "5.1", "18.3", "4.3", Food.TREESAP);
        monkey11 = sanctuary1.createMonkey("Aldo", Species.HOWLER, Sex.F, "4.7", "8.2", "1.2", Food.SEEDS);
        monkey12 = sanctuary1.createMonkey("Space", Species.MANGABEY, Sex.M, "13.2", "4.3", "5.6", Food.TREESAP);
        monkey13 = sanctuary1.createMonkey("Tala", Species.SAKI, Sex.M, "11.2", "9.4", "6.7", Food.EGGS);
        monkey14 = sanctuary1.createMonkey("Papina", Species.SPIDER, Sex.M, "8.6", "7.2", "5.3", Food.EGGS);
        monkey15 = sanctuary1.createMonkey("Totit", Species.SQUIRREL, Sex.F, "7.3", "1.2", "7.6", Food.EGGS);
        //Add all 15 monkeys to isolation
        sanctuary1.getIsolation().addMonkey(monkey1);
        sanctuary1.getIsolation().addMonkey(monkey2);
        sanctuary1.getIsolation().addMonkey(monkey3);
        sanctuary1.getIsolation().addMonkey(monkey4);
        sanctuary1.getIsolation().addMonkey(monkey5);
        sanctuary1.getIsolation().addMonkey(monkey6);
        sanctuary1.getIsolation().addMonkey(monkey7);
        sanctuary1.getIsolation().addMonkey(monkey8);
        sanctuary1.getIsolation().addMonkey(monkey9);
        sanctuary1.getIsolation().addMonkey(monkey10);
        sanctuary1.getIsolation().addMonkey(monkey11);
        sanctuary1.getIsolation().addMonkey(monkey12);
        sanctuary1.getIsolation().addMonkey(monkey13);
        sanctuary1.getIsolation().addMonkey(monkey14);
        sanctuary1.getIsolation().addMonkey(monkey15);
        //Put some monkey to Enclosure
        monkey5.setHealthiness(sanctuary1);
        monkey4.setHealthiness(sanctuary1);
        monkey9.setHealthiness(sanctuary1);
        //Add the element to a Sanctuary list
        //Verify the name is inorder, should include both monkeys in enclosure and isolation
        assertEquals
                ("Abu,Aldo,Bear,Bingo,Clyde,Ella,Fiona,Marcel,Mizaru,Nim,Papina,Pipsqueak,Space,Tala,Totit"
                        , sanctuary1.listAllMonkey());
    }

    @Test
    /**
     * Test the getMonkeyName
     */
    public void testGetMonkeyName() {
        assertEquals("Cute",sanctuary1.getMonkeyName(monkey1));
        assertEquals("Stupid",sanctuary1.getMonkeyName(monkey2));
        assertEquals("Apple",sanctuary1.getMonkeyName(monkey3));
    }

    @Test
    /**
     * Test the getMonkeySpeciesValue
     */
    public void testGetMonkeySpeciesValue() {
        assertEquals(1,sanctuary1.getMonkeySpeciesValue(monkey1),0.0);
        assertEquals(6,sanctuary1.getMonkeySpeciesValue(monkey2),0.0);
        assertEquals(7,sanctuary1.getMonkeySpeciesValue(monkey3),0.0);
    }

}