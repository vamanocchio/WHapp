package vam.whapp;

import java.util.ArrayList;

/**
 * Created by resnet on 4/25/18.
 */

public class Warehouse{

    private long id;
    private String title;
    private long inv_id;
    private User owner;
    private ArrayList<User> members;

    public Warehouse(String title, User owner){

        //id
        //inv_id
        this.title = title;
        this.owner = owner;

    }
}
