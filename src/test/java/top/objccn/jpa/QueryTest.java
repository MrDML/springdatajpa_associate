package top.objccn.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import top.objccn.jpa.dao.Customer2Dao;
import top.objccn.jpa.dao.LinkManDao;
import top.objccn.jpa.entity.Customer2;
import top.objccn.jpa.entity.LinkMan;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Set;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class QueryTest {
    @Autowired
    private Customer2Dao customer2Dao;
    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional
    public void queryCustomer(){
        Customer2 customer2 = customer2Dao.findOne(2l);
        System.out.println(customer2);
        // 根据客户查询联系人信息
        Set<LinkMan> linkMans = customer2.getLinkMans();

        for (LinkMan linkMan : linkMans) {
            System.out.println(linkMan);
        }

    }

    @Test
    @Transactional
    public void getLinkMan(){
        LinkMan linkMan = linkManDao.findOne(3l);
        System.out.println(linkMan);
        // 通过联系人查询客户
        Customer2 customer = linkMan.getCustomer();
        System.out.println(customer);
    }


    @Test
    @Transactional
    @Commit
    public void findCustomerByPhone(){
        List<Customer2> customer2List = customer2Dao.findAll(new Specification<Customer2>() {
            @Override
            public Predicate toPredicate(Root<Customer2> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                //使用root关联联系人表
                //参数1：Customer2实体类中关联的属性名称
                //参数2：连接方式
                Join<Object, Object> join = root.join("linkMans", JoinType.LEFT);
                //创建查询条件
                Predicate predicate = criteriaBuilder.equal(join.get("lkmPhone"), "13767851347");
                //返回查询条件
                return predicate;
            }
        });


        for (Customer2 customer2 : customer2List) {

            System.out.println(customer2);
            System.out.println("=============================");
            Set<LinkMan> linkMans = customer2.getLinkMans();

            for (LinkMan linkMan : linkMans) {
                System.out.println(linkMan);
            }


        }


    }





}
