package vam.whapp;

import android.app.Application;

/**
 * Created by Victoria on 4/28/2018.
 */

public class GlobalVar extends Application {

    private long curr_user;
    private String curr_wh;
    private long curr_inv;

    public void setUser(long user){ this.curr_user = user; }

    public void setWH(String wh){
        this.curr_wh = wh;
        //this.curr_inv = wh.getFKInvID;
    }

    public void setInv(long inv){ this.curr_inv = inv; }


    public long getUser(){ return this.curr_user; }

    public String getWH(){ return this.curr_wh; }

    public long getInv(){ return this.curr_inv; }

}
