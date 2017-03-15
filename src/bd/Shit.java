package bd;

import java.io.Serializable;

/**
 * Created by tttt on 23.11.2016.
 */
public class Shit implements Serializable
{
    private String name;
//    private String date;
    private int val;
//    private Byte curier;

    public  Shit(String n,int v )
    {
        name=n;
//        date=d;
        val=v;
//        curier=c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }

//    public int getVal() {
//        return val;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
}
