package cn.cooode.jingxishop.repository;

import cn.cooode.jingxishop.entity.LogisticsRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsRecordRepository extends JpaRepository<LogisticsRecord, Long> {

    LogisticsRecord getById(Long id);

}
