package top.objccn.jpa.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */
@Entity
@Table(name = "cst_customer_a")
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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

    // 表示是一对一的关联关系
    @OneToOne(cascade = CascadeType.ALL)
    // 连接字段
    // name:当前表存储外键字段的名称
    //@JoinColumn(name = "exid",referencedColumnName = "ext_id")
    //使用主键关联
    @PrimaryKeyJoinColumn
    private CustomerExt ext;

    public CustomerExt getExt() {
        return ext;
    }

    public void setExt(CustomerExt ext) {
        this.ext = ext;
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
