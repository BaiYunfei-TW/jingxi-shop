package cn.cooode.jingxishop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "logistics_record")
@ApiModel
public class LogisticsRecord {

    public static final String STATUS_SHIPPING = "shipping";
    public static final String STATUS_SIGNED = "signed";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("自增主键")
    private Long id;
    @ApiModelProperty("配送员")
    private String deliveryMan;
    @ApiModelProperty("出库时间")
    private Date outboundTime;
    @ApiModelProperty("签收时间")
    private Date signedTime;
    @ApiModelProperty(value = "配送状态", allowableValues = "shipping,signed", allowEmptyValue = true)
    private String logisticsStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(String deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public Date getOutboundTime() {
        return outboundTime;
    }

    public void setOutboundTime(Date outboundTime) {
        this.outboundTime = outboundTime;
    }

    public Date getSignedTime() {
        return signedTime;
    }

    public void setSignedTime(Date signedTime) {
        this.signedTime = signedTime;
    }

    public String getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(String logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }
}
