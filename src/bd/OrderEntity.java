package bd;

import JSP.List;
import JSP.NewBean;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tttt on 22.11.2016.
 */
@Entity
@Table(name = "prodorder", schema = "shop")
public class OrderEntity {
    public OrderEntity(String userName,String purchases,Byte curier,Integer shopId ) {
        this.userName = userName;
        this.curier = curier;
        this.shopId = shopId;
        this.purchases = purchases;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        String date = format.format(new Date());
        this.orderDate = date;
//        this.list=new MyArr();
    }

    public OrderEntity(String userName,String purchases,Byte curier,String addresses) {
        this.userName = userName;
        this.curier = curier;
        this.addresses = addresses;
        this.purchases = purchases;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        String date = format.format(new Date());
        this.orderDate = date;
//        this.list=new MyArr();
    }

    private int id;
    private String orderDate;
    private String userName;
    private String addresses;
    private Byte curier;
    private Integer shopId;
    private Integer newColumn;
    private String purchases;

    public OrderEntity() {
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "OrderDate", nullable = true, length = 50)
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "UserName", nullable = false, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "addresses", nullable = true, length = 50)
    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    @Basic
    @Column(name = "curier", nullable = true)
    public Byte getCurier() {
        return curier;
    }

    public void setCurier(Byte curier) {
        this.curier = curier;
    }

    @Basic
    @Column(name = "ShopId", nullable = true)
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }



    @Basic
    @Column(name = "purchases", nullable = true, length = 50)
    public String getPurchases() {
        return purchases;
    }

    public void setPurchases(String purchases) {
        this.purchases = purchases;
    }

//    private MyArr arr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != that.id) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (addresses != null ? !addresses.equals(that.addresses) : that.addresses != null) return false;
        if (curier != null ? !curier.equals(that.curier) : that.curier != null) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
        if (newColumn != null ? !newColumn.equals(that.newColumn) : that.newColumn != null) return false;
        if (purchases != null ? !purchases.equals(that.purchases) : that.purchases != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (addresses != null ? addresses.hashCode() : 0);
        result = 31 * result + (curier != null ? curier.hashCode() : 0);
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (newColumn != null ? newColumn.hashCode() : 0);
        result = 31 * result + (purchases != null ? purchases.hashCode() : 0);
        return result;
    }


//    public MyArr getArr() {
//        return arr;
//    }
//
//    public void setArr(MyArr arr) {
//        this.arr = arr;
//    }
}
