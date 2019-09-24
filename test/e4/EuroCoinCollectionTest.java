package e4;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EuroCoinCollectionTest {
    EuroCoin e1_sp1, // Juan Carlos I coin
             e1_sp2, // Felipe VI coin
             e2_sp_2002,  // Juan Carlos I coin of 2002
             e2_sp_2005,  // Juan Carlos I coin of 2005
             c50_it, 
             c20_fr, 
             c1_pt;
    EuroCoinCollection collection;
    
    
    @Before
    public void setUp() {
        collection = new EuroCoinCollection();
        
        // THIS COINS MUST BE PROPERLY CREATED IN ORDER TO THE TEST TO WORK CORRECTLY
        e1_sp1 = new EuroCoin(100, IsoCountries.Spain, 0, "Juan Carlos I", Color.oroplata);
        e1_sp2 = new EuroCoin(100, IsoCountries.Spain, 0, "Felipe VI", Color.oroplata);
        e2_sp_2002  = new EuroCoin(200, IsoCountries.Spain, 2002, "Juan Carlos I", Color.oroplata);
        e2_sp_2005  = new EuroCoin(200, IsoCountries.Spain, 2005, "Juan Carlos I", Color.oroplata);
        c50_it = new EuroCoin(50, IsoCountries.Italy, 0, "", Color.oro);
        c20_fr = new EuroCoin(20, IsoCountries.France, 0, "", Color.oro);
        c1_pt = new EuroCoin(50, IsoCountries.Portugal, 0, "", Color.bronce);
       
        assertTrue(collection.insertCoin(e1_sp1));
        assertTrue(collection.insertCoin(e1_sp2));
        assertTrue(collection.insertCoin(e2_sp_2002));
        assertFalse(collection.insertCoin(e2_sp_2005)); // Not inserted
        assertTrue(collection.insertCoin(c50_it));
        assertTrue(collection.insertCoin(c20_fr));
        assertFalse(collection.insertCoin(c50_it)); // Not inserted        
    }
    
    @Test
    public void testNumCoins() {       
        assertEquals(5, collection.numCoins());
    }

    @Test
    public void testHasCoin() {
        assertTrue(collection.hasCoin(e1_sp1));
        assertTrue(collection.hasCoin(e2_sp_2005));
        assertFalse(collection.hasCoin(c1_pt));
    }

    @Test
    public void testCollectionValue() {
        assertEquals(470, collection.value());
    }    
    
    @Test
    public void testRemoveCoin() {
        collection.removeCoin(c50_it);
        assertEquals(4, collection.numCoins());
        assertEquals(420, collection.value());
        
        collection.removeCoin(e2_sp_2005); // removes the 2002 coin
        assertEquals(3, collection.numCoins());
        assertEquals(220, collection.value());
        
        collection.removeCoin(c1_pt); // No coin removed
        assertEquals(3, collection.numCoins());
        assertEquals(220, collection.value());
    }    
}
