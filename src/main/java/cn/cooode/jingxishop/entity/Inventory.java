package cn.cooode.jingxishop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 库存 实体类
 */
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer count;
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
