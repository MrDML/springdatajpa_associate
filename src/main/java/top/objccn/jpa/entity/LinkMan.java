package top.objccn.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Auter MrDML
 * @Date 2019-11-14
 */

@Entity
@Table(name = "cst_linkman")
public class LinkMan implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Long lkmId;

    @Column(name = "lkm_name")
    private String lkmName;

    @Column(name = "lkm_gender")
    private String lkmGender;

    @Column(name = "lkm_phone")
    private String lkmPhone;

    @Column(name = "lkm_mobile")
    private String lkmMobile;

    @Column(name = "lkm_email")
    private String lkmEmail;

    @Column(name = "lkm_position")
    private String lkmPosition;

    @Column(name = "lkm_memo")
    private String lkmMemo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custid", referencedColumnName = "cust_id")
    private Customer2 customer;


    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail;
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    public Customer2 getCustomer() {
        return customer;
    }

    public void setCustomer(Customer2 customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LinkMan{" + "lkmId=" + lkmId + ", lkmName='" + lkmName + '\'' + ", lkmGender='" + lkmGender + '\'' +
                ", lkmPhone='" + lkmPhone + '\'' + ", lkmMobile='" + lkmMobile + '\'' + ", lkmEmail='" + lkmEmail + '\'' + ", lkmPosition='" + lkmPosition + '\'' + ", lkmMemo='" + lkmMemo + '\'' + ", customer=" + customer + '}';
    }
}
