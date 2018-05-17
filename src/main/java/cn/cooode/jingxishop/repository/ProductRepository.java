package cn.cooode.jingxishop.repository;

import cn.cooode.jingxishop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getById(Long id);

    List<Product> findAllByNameContainingAndDescriptionContaining(String name, String description);
}
