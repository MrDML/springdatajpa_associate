package top.objccn.jpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */
@Entity
@Table(name = "sys_role")
public class SysRole {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "memo")
    private String memo;

    @ManyToMany(mappedBy = "roles")
    private Set<SysUser> users = new HashSet<>();


    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "SysRole{" + "roleId=" + roleId + ", roleName='" + roleName + '\'' + ", memo='" + memo + '\'' + ", " +
                "users=" + users + '}';
    }
}
