/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e4;

/**
 *
 * @author rd_fr
 */
public enum IsoCountries {
    Austria ("AT"),
    Belgium ("BE"),
    Cyprus ("CY"),
    Netherlands ("NL"),
    Estonia ("EE"),
    Finland ("FI"),
    France ("FR"),
    Germany ("DE"),
    Greece ("GR"),
    Ireland ("IE"),
    Italy ("IT"),
    Latvia ("LV"),
    Lithuania ("LT"),
    Luxembourg ("LU"),
    Malta ("MT"),
    Monaco ("MC"),
    Portugal ("PT"),
    SanMarino ("SM"),
    Slovakia ("SK"),
    lovenia ("SI"),
    Spain ("ES"),
    VaticanCity ("VA");
    
    private final String IsoCode;
    IsoCountries(String str){
        this.IsoCode=str;
    }
}
