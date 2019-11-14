package top.objccn.jpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */
@Entity
@Table(name = "cst_customer_b")
public class Customer2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 配置属性和字段的映射关系
    @Column(name = "cust_id")
    private long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_industry")
    private String custIndustry;

    @Column(name = "cust_level")
    private String custLevel;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_phone")
    private String custPhone;

    @Column(name = "cust_source")
    private String custSource;

    // 表示是一对多
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    // JoinColumn 配置关联的字段信息
    // name:外键字段的名称
    //referencedColumnName: 参照一对一的主键字段名称
    //@JoinColumn(name = "custid", referenceColumnName = "cust_id")
    private Set<LinkMan> linkMans = new HashSet<>();



    public Set<LinkMan> getLinkMans() {
        return linkMans;
    }

    public void setLinkMans(Set<LinkMan> linkMans) {
        this.linkMans = linkMans;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    @Override
    public String toString() {
        return "Customer{" + "custId=" + custId + ", custName='" + custName + '\'' + ", custIndustry='" + custIndustry + '\'' + ", custLevel='" + custLevel + '\'' + ", custAddress='" + custAddress + '\'' + ", custPhone='" + custPhone + '\'' + ", custSource='" + custSource + '\'' + '}';
    }
}
