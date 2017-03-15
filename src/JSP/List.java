/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSP;

import java.util.ArrayList;

/**
 *
 * @author tttt
 */
public class List {
    private static ArrayList<NewBean> list = new ArrayList();

    public static void addElem(NewBean bean) {
        list.add(bean);
    }
    public static void deleteList() {
        list.clear();
        
    }
    public static ArrayList<NewBean> getList() {
        return list;
    }
    public static NewBean getProd(String name)
    {
        for(NewBean li: list )
        {
            if(li.getType().equals(name))
            {
                return li;
                
            }
        }
        return null;
    }
   
}
