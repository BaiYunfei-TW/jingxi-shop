package cn.cooode.jingxishop.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 库存 实体类
 */
@ApiModel("库存信息")
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @ApiModelProperty("自增主键")
    private Long id;
    @ApiModelProperty("库存数量（包括已锁定和未锁定）")
    private Integer count;
    @ApiModelProperty("已锁定的数量")
    private Integer lockedCount;

    public Inventory() {
        this(0, 0);
    }

    public Inventory(Integer count, Integer lockedCount) {
        this.count = count;
        this.lockedCount = lockedCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLockedCount() {
        return lockedCount;
    }

    public void setLockedCount(Integer lockedCount) {
        this.lockedCount = lockedCount;
    }

}
