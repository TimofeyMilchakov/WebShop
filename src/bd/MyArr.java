package bd;

import JSP.NewBean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by tttt on 22.11.2016.
 */
public class MyArr implements Serializable
{
    private ArrayList<Shit> arr=null;

    public MyArr()
    {}


    public ArrayList<Shit> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Shit> arr) {
        this.arr = arr;
    }

    public void addShit(Shit shit)
    {
        if(arr==null)
        {
            arr=new ArrayList<>();

        }
        arr.add(shit);
    }

}
