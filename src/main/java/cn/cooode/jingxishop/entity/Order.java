package cn.cooode.jingxishop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@ApiModel
public class Order {

    public static final String STATUS_FINISHED = "finished";
    public static final String STATUS_PAID = "paid";
    public static final String STATUS_WITHDRAWN = "withdrawn";
    public static final String STATUS_UNPAID = "unPaid";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("自增主键")
    private Long id;
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("订单总额")
    private Integer totalPrice;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    @ApiModelProperty("购买的商品列表")
    private List<PurchaseItem> purchaseItemList;
    @ApiModelProperty("订单创建时间")
    private Date createTime;
    @ApiModelProperty("订单完成时间（签收时间）")
    private Date finishTime;
    @ApiModelProperty("订单取消时间")
    private Date withdrawnTime;
    @ApiModelProperty("付款时间")
    private Date paidTime;
    @ApiModelProperty(value = "订单状态", allowableValues = "unPaid, paid, finished, withdrawn")
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
