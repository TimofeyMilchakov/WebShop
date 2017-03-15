/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSP;

import java.beans.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tttt
 */
public class BasketList implements Serializable {
     private static Map<String,Integer> basketList=new HashMap();
    public void addItem(String name)
    {
        int val = (int) basketList.get(name);
        val++;
        basketList.put(name,val);
    }
    public void addItem2(String name)
    {
        basketList.put(name,1);
    }
    public static Map<String,Integer> getBasketList() {
        return new HashMap<String, Integer>(basketList);
    }
    public void deleteItem(String name) 
    {
        int val = (int) basketList.get(name);
        if(val>1)
        {
            val--; 
            basketList.put(name,val); 
        }
        else
        {
            basketList.remove(name);
        }
        
        
    }
    
    public static BasketList get(HttpSession session) {
        BasketList cart = (BasketList) session.getAttribute("cart");
        if (cart == null) {
            cart = new BasketList();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
    public static int getVal()
    {
        return basketList.size();
    }
    public static boolean check()
    {
        if(basketList.size()>0)
        {
            return true;
        }
        return false;
    }
    public static void clearBasket() {
        basketList.clear();
    }
    public static int getSum() {
        int sum = 0;
        for (Map.Entry<String, Integer> entry: basketList.entrySet()) {
            String id = entry.getKey();
            if(entry.getValue()>1) {
                sum+= List.getProd(id).getBuy()*entry.getValue();
            } else {
                sum+= List.getProd(id).getBuy();
            }
        }
        return sum;
    }
}
