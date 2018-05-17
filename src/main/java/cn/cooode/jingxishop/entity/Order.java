package cn.cooode.jingxishop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    public static final String STATUS_FINISHED = "finished";
    public static final String STATUS_PAID = "paid";
    public static final String STATUS_WITHDRAWN = "withdrawn";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Integer totalPrice;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private List<PurchaseItem> purchaseItemList;
    private Date createTime;
    private Date finishTime;
    private Date withdrawnTime;
    private Date paidTime;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<PurchaseItem> getPurchaseItemList() {
        return purchaseItemList;
    }

    public void setPurchaseItemList(List<PurchaseItem> purchaseItemList) {
        this.purchaseItemList = purchaseItemList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getWithdrawnTime() {
        return withdrawnTime;
    }

    public void setWithdrawnTime(Date withdrawnTime) {
        this.withdrawnTime = withdrawnTime;
    }
}
