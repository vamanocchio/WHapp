package vam.whapp;

/**
 * Created by victoria on 3/29/18.
 */

public class User {

    private String email;
    private String pword;
    private String phone;
//    private long id;

    public User(String email,  String phone){
        this.email = email;
//        this.pword = pword;
        this.phone = phone;
//        this.id = genId(); //for later -> user identification in server
    }

 /*   private long genId(){
        long id = 69;//formula to generate id
        return id;
    }*/

    void setPword(String pword){
        this.pword = pword;
    }

    private void setPhone(String newphone){
        this.pword = newphone;
    }

    String getEmail(){
        return this.email;
    }

    String getPword(){
        return this.pword;
    }

    String getPhone(){
        return this.phone;
    }

 /*   long getId(){
        return this.id;
    }
*/


    //for later -> User Settings



}
