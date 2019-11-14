package top.objccn.jpa.entity;

import javax.persistence.*;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */
@Entity
@Table(name = "cst_customer_ext")
public class CustomerExt {

    @Id
    @Column(name = "ext_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long extId;

    private String memo;

    private String info;

    @OneToOne /*(mappedBt = "ext")*/
    @PrimaryKeyJoinColumn
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getExtId() {
        return extId;
    }

    public void setExtId(long extId) {
        this.extId = extId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CustomerExit{" + "extId=" + extId + ", memo='" + memo + '\'' + ", info='" + info + '\'' + '}';
    }
}
