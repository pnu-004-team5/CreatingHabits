package com.team5.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "account_info")
public class Account_info {
    private static final String ACCOUNT_INFO_NUM_ID_SEQ = "account_info_num_id_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ACCOUNT_INFO_NUM_ID_SEQ)
    @SequenceGenerator(name = ACCOUNT_INFO_NUM_ID_SEQ, sequenceName = ACCOUNT_INFO_NUM_ID_SEQ, allocationSize = 1)
    private long num_id;
    private String id;
    private String password;
    private String name;
    private String email1;
    private String email2;
    private int ph1;
    private int ph2;
    private int ph3;
    private String gender;
    private int birth1;
    private int birth2;
    private int birth3;
    private String address;
    //private Date regDate;

    public Account_info() {
    }

    public Account_info(long num_id, String id, String password, String name, String email1, String email2, int ph1, int ph2, int ph3, String gender, int birth1, int birth2, int birth3, String address) {
        this.num_id = num_id;
        this.id = id;
        this.password = password;
        this.name = name;
        this.email1 = email1;
        this.email2 = email2;
        this.ph1 = ph1;
        this.ph2 = ph2;
        this.ph3 = ph3;
        this.gender = gender;
        this.birth1 = birth1;
        this.birth2 = birth2;
        this.birth3 = birth3;
        this.address = address;
        //this.regDate = regDate;
    }

    public long getNumID() {
        return num_id;
    }

    public void setNumID(long num_id) {
        this.num_id = num_id;
    }

    public String getId() {
        return id;
    }
    public void setId(String Id) {
        this.id = Id;
    }
    public String getPassword() {
        return password;
    }
    public void setPass(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail1() {
        return email1;
    }
    public void setEmail1(String email1) {
        this.email1 = email1;
    }
    public String getEmail2() {
        return email2;
    }
    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    public int getPh1() {
        return ph1;
    }
    public void setPh1(int ph1) {
        this.ph1 = ph1;
    }
    public int getPh2() {
        return ph2;
    }
    public void setPh2(int ph2) {
        this.ph2 = ph2;
    }
    public int getPh3() {
        return ph3;
    }
    public void setPh3(int ph3) {
        this.ph3 = ph3;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getBirth1() {
        return birth1;
    }
    public void setBirth1(int birth1) {
        this.birth1 = birth1;
    }
    public int getBirth2() {
        return birth2;
    }
    public void setbirth2(int birth2) {
        this.birth2 = birth2;
    }
    public int getBirth3() {
        return birth3;
    }
    public void setBirth3(int birth3) {
        this.birth3 = birth3;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    // public Date getRegDate() {
    //     return regDate;
    // }
    // public void setRegdate(Date regDate) {
    //     this.regDate = regDate;
    // }
    @Override
    public String toString() {
        return "Account_info[id=" + id + ", password=" + password + ", name=" + name + ", email1="
                + email1 + ", email2=" + email2 + ", ph1=" + ph1 + ", ph2=" + ph2 + ", ph3=" 
              + ph3 + ", gender=" + gender + ", birth1=" + birth1 + " birth2=" 
                + birth2 + ",  birth3=" + birth3 + ", address=" + address
                // +", regDate=" + regDate 
                + "]";
    }


}