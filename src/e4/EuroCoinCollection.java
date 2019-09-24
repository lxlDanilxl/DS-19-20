package e4;

// Represents a Euro coin collection

import java.util.HashSet;
import java.util.Iterator;

public class EuroCoinCollection {
    
    HashSet collection = new HashSet();
// Inserts a coin in the collection . If the coin is already in the
// collection ( there is an equal coin inserted ) then the coin is not inserted .
// Returns true only if a new coin has been inserted in the collection .

    public boolean insertCoin(EuroCoin coin) {
        return collection.add(coin);
    }
// Checks if a coin has been already inserted in the collection

    public boolean hasCoin(EuroCoin coin) {
        return collection.contains(coin);
    }
// Returns the nominal value of the entire collection in euro cents .

    public int value() {
        int total=0;
        Iterator<EuroCoin> lista = collection.iterator();
        while(lista.hasNext()) {
            total+=lista.next().getValNom();
        }
        return total;
    }
// Counts the number of coins in the collection .

    public int numCoins() {
        return collection.size();
    }
// Removes the specified coin from the collection

    public void removeCoin(EuroCoin coin) {
        collection.remove(coin);
    }
}
