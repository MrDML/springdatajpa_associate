package top.objccn.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.objccn.jpa.entity.Customer;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */
public interface CustomerDao extends JpaRepository<Customer,Long> {
}
