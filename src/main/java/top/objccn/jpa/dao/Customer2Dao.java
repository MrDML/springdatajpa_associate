package top.objccn.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.objccn.jpa.entity.Customer;
import top.objccn.jpa.entity.Customer2;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */
public interface Customer2Dao extends JpaRepository<Customer2,Long>, JpaSpecificationExecutor<Customer2> {
}
