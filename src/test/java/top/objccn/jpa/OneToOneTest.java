package top.objccn.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import top.objccn.jpa.dao.CustomerDao;
import top.objccn.jpa.dao.CustomerExtDao;
import top.objccn.jpa.entity.Customer;
import top.objccn.jpa.entity.CustomerExt;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OneToOneTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerExtDao customerExtDao;

    @Test
    @Transactional
    @Commit
    public void addCustomer(){

        // 1. 创建一个Customer 对象
        Customer customer = new Customer();
        customer.setCustName("杜甫");
        customer.setCustAddress("北京");
        customer.setCustLevel("VIP");

        // 2. 创建一个CustomerExt对象
        CustomerExt ext = new CustomerExt();
        ext.setMemo("扩展字段信息");
        ext.setInfo("Web hello World");

        // 3. 配置对象的关联关系
        customer.setExt(ext);
        ext.setCustomer(customer);

        // 4. 把对象写入数据库
        customerDao.save(customer);

        // 设置了级联,这里就不需要进行保存了
        //customerExtDao.save(ext);
    }

    @Test
    @Transactional
    @Commit
    public void updateCustomer(){
        // 查询客户信息
        Customer customer = customerDao.findOne(1l);
        // 根据客户信息取扩展信息
        CustomerExt ext = customer.getExt();
        // 修改扩展信息
        ext.setInfo("Java Hello World");
        // 更新到数据库
        customerDao.save(customer);

    }


    @Test
    @Transactional
    @Commit
    public void deleteCustomer(){

        customerDao.delete(1l);
    }






}
