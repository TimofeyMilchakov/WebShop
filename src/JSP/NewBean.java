/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSP;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author tttt
 */
public class NewBean implements Serializable {

    private int count;
    private String name;
    private String img;
    private String type;
    private String servlet;
    private String dis;
    private static int countingElems = 0; 
    private int buy;
    public int id;

    public NewBean(String n, int i)
    {
        this.name = n;
        this.img=null;
        this.type = null;
        this.servlet=null;
        this.dis=null;
        buy=0;
        this.id = countingElems;
        this.count=i;
    }

    public NewBean()
    {
        this.name = null;
        this.img=null;
        this.type = null;     
        this.servlet=null;
        this.dis=null;
        buy=0;
        this.id = countingElems;
        countingElems++;
    }
   
    public NewBean(String n, String i, String t,String s, int b)
    {
        this.name = n;
        this.img=i;
        this.type = t;    
        this.servlet=s;
        this.dis=n;
        this.buy=b;
        this.id = countingElems;
        countingElems++;
    }
    
    public int getId()
    {
        return id;
    }
    public void setId(int b)
    {
        this.id=b;
    }
    
    public int getBuy()
    {
        return buy;
    }
    public void setBuy(int b)
    {
        this.buy=b;
    }
    public String getName()
    {
        return this.name;
    }
    
    public String getImg()
    {
        return this.img;
    }
    public String getType()
    {
        return this.type;
    }
    public void setName(String n)
    {
        this.name=n;
    }
     public String getServlet()
    {
        return this.servlet;
    }
    public void setServlet(String s)
    {
        this.servlet=s;
    }
    public void setImg(String i)
    {
        this.img=i;
    }
    public void setType(String t)
    {
        this.type=t;
    }
    
    public void setDis(String t)
    {
        this.dis=t;
    }
    
    public String getDis()
    {
        return this.dis;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
