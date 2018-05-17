package cn.cooode.jingxishop.repository;

import cn.cooode.jingxishop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order getById(Long id);

    List<Order> findAllByUserId(Long userId);
}
