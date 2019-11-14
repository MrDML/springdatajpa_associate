package top.objccn.jpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */
@Entity
@Table(name = "sys_user")
public class SysUser {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private long userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    // 相当于中间表的定义
    // name:中间表的表名
    @JoinTable(name = "sys_user_role",joinColumns = @JoinColumn(
            // 重甲表和当前表映射的字段名称
            name = "userid",
            // 参照的当前表的主键字段
            referencedColumnName = "user_id"
    ),inverseJoinColumns = @JoinColumn(
               name = "roleid",
            referencedColumnName = "role_id"
    ))
    private Set<SysRole> roles = new HashSet<>();


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser{" + "userId=" + userId + ", username='" + username + '\'' + ", password='" + password + '\'' + ", roles=" + roles + '}';
    }
}
