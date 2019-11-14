package top.objccn.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import top.objccn.jpa.dao.SysRoleDao;
import top.objccn.jpa.dao.SysUserDao;
import top.objccn.jpa.entity.SysRole;
import top.objccn.jpa.entity.SysUser;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManyToManyTest {

    @Autowired
    private SysUserDao userDao;

    @Autowired
    private SysRoleDao roleDao;


    @Test
    @Transactional
    @Commit
    public void addUserAndRole(){

        // 1. 创建用户
        SysUser user = new SysUser();
        user.setUsername("admin");
        user.setPassword("123456");

        // 2. 创建角色
        SysRole role = new SysRole();
        role.setRoleName("管理员");


        user.getRoles().add(role);
        role.getUsers().add(user);

        userDao.save(user);
        roleDao.save(role);

    }

    @Test
    @Transactional
    @Commit
    public void addUserAndRole2(){

        SysUser user1 = new SysUser();
        user1.setUsername("江疏影_01");
        user1.setPassword("123456");

        SysUser user2 = new SysUser();
        user2.setUsername("江疏影_02");
        user2.setPassword("123456");

        SysRole role1 = new SysRole();
        role1.setRoleName("演员");

        SysRole role2 = new SysRole();
        role2.setRoleName("导演");

        user1.getRoles().add(role1);
        user1.getRoles().add(role2);

        user2.getRoles().add(role1);
        user2.getRoles().add(role2);

        role1.getUsers().add(user1);
        role1.getUsers().add(user2);

        role2.getUsers().add(user1);
        role2.getUsers().add(user2);

        userDao.save(user1);
        userDao.save(user2);


    }

    @Test
    @Transactional
    @Commit
    public void deleteUser(){
        userDao.delete(2l);
    }




}
