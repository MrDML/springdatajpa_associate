package top.objccn.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import top.objccn.jpa.dao.Customer2Dao;
import top.objccn.jpa.dao.LinkManDao;
import top.objccn.jpa.entity.Customer2;
import top.objccn.jpa.entity.LinkMan;

import java.util.Set;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OneToManyTest {

    @Autowired
    private Customer2Dao customer2Dao;

    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional
    @Commit
    public void addCustomer2(){
        // 1. 每个实体类对应创建dao
        // 2. 在测试方法中,创建一个Customer2对象
        Customer2 customer2 = new Customer2();
        customer2.setCustName("元朝");
        customer2.setCustAddress("上海");
        customer2.setCustLevel("VIP");
        // 3. 创建LinkMan对象, 可以创建多个
        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLkmName("李白");
        linkMan1.setLkmPhone("13467851347");

        LinkMan linkMan2 = new LinkMan();
        linkMan2.setLkmName("杜甫");
        linkMan2.setLkmPhone("13767851347");

        // 4. 配置客户和联系人之间的关系
        customer2.getLinkMans().add(linkMan1);
        customer2.getLinkMans().add(linkMan2);


        linkMan1.setCustomer(customer2);
        linkMan2.setCustomer(customer2);

        // 5. 使用dao把数据写入数据库
        customer2Dao.save(customer2);
//        linkManDao.save(linkMan1);
//        linkManDao.save(linkMan2);

    }

    @Test
    @Transactional
    @Commit
    public void deleteCustomer2(){
        customer2Dao.delete(1l);
    }

    @Test
    @Transactional
    @Commit
    public void updateCustomer(){
        // 根据id 查询一个客户信息
        Customer2 customer2 = customer2Dao.findOne(2l);
        customer2.setCustIndustry("网络");
        customer2.setCustSource("Web");
        // 根据客户信息获取联系人信息
        Set<LinkMan> linkMans = customer2.getLinkMans();

        // 更新数据
        for (LinkMan linkMan : linkMans) {
            linkMan.setLkmGender("男");
        }

        // 保存到数据库
        customer2Dao.save(customer2);

    }



}
