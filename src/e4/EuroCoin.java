/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e4;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author rd_fr
 */
public class EuroCoin {
    private final int ValNom;
    private final IsoCountries iso;
    private final int date;
    private final String design;
    private final Color color;

    public EuroCoin(int ValNom, IsoCountries iso, int date, String design, Color color) {
        this.ValNom = ValNom;
        this.iso = iso;
        this.date = date;
        this.design = design;
        this.color = color;
    }
    
    public float getValNom() {
        return this.ValNom;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Float.floatToIntBits(this.ValNom);
        hash = 17 * hash + Objects.hashCode(this.iso);
        hash = 17 * hash + Objects.hashCode(this.design);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = true;
        if (obj==null || obj.getClass()!=this.getClass()) {
            return false;
        }
        EuroCoin moneda = (EuroCoin) obj;
        equal = equal && this.ValNom==moneda.ValNom;
        equal = equal && this.iso==moneda.iso;
        equal = equal && this.design.equals(moneda.design);
        return equal;
    }
    
    
    
}
