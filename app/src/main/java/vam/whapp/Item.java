package vam.whapp;

/**
 * Created by victoria on 3/29/18.
 */

public class Item {

    private String name;
    private String exp;
    private String loc;
    private String notes;
    //item id if nec.

    public Item(String name, String exp, String loc, String notes){
        this.name = name;
        this.exp = exp;
        this.loc = loc;
        this.notes = notes;
    }

    String getName(){
        return this.name;
    }

    String getExp(){
        return this.exp;
    }

    String getLoc(){
        return this.loc;
    }

    String getNotes(){
        return this.notes;
    }
}
