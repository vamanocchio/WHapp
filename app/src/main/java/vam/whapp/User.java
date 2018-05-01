package vam.whapp;

/**
 * Created by victoria on 3/29/18.
 */

public class User {

    private String name;
    private String email;
    private String pword;
    private String phone;
//    private long id;

    public User(String name, String pword, String email,  String phone){
        this.email = email;
        this.pword = pword;
        this.phone = phone;
//        this.id = genId(); //for later -> user identification in server
    }

 /*   private long genId(){
        long id = 69;//formula to generate id
        return id;
    }*/

    void setName(String name) { this.name = name; }

    void setPword(String pword){
        this.pword = pword;
    }

    void setEmail(String email) { this.email = email; }

    void setPhone(String phone){
        this.pword = phone;
    }


    String getName() { return this.name; }

    String getPword(){
        return this.pword;
    }

    String getEmail(){
        return this.email;
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
