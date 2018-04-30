package vam.whapp;

/**
 * Created by victoria on 3/29/18.
 */
import org.javatuples.*;

public class Item {

    private long id;
    private String name;
    private int exp; //days until exp
    private int qty;
    private float price;
    private String loc;
    private String notes;

    public Item(String name, int exp, int qty, float price, String loc, String notes){
        this.name = name;
        this.exp = exp;
        this.price = price;
        this.loc = loc;
        this.notes = notes;
    }

    void setID(long id){ this.id = id; }

    void setName(String name){ this.name = name; }

    void setExp(int exp){ this.exp = exp; }

    void setQty(int qty){ this.qty = qty; }

    void setPrice(float price){ this.price = price; }

    void setLoc(String loc){ this.loc = loc; }

    void setNotes(String notes){ this.notes = notes; }



    long getID(){ return this.id; }

    String getName(){
        return this.name;
    }

    int getExp(){
        return this.exp;
    }

    int getQty(){ return this.qty; }

    float getPrice(){ return this.price; }

    String getLoc(){
        return this.loc;
    }

    String getNotes(){
        return this.notes;
    }
}
