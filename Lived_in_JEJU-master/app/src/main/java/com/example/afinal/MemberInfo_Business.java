package com.example.afinal;

public class MemberInfo_Business {
    private String ceoname;
    private String houseneme;
    private String registernum;
    private String phone;
    private String address;

    public MemberInfo_Business(String ceoname, String houseneme, String registernum, String phone, String address ) {
        this.ceoname = ceoname;
        this.houseneme = houseneme;
        this.registernum = registernum;
        this.phone = phone;
        this.address = address;
    }

    public String getCeoname() {
        return ceoname;
    }

    public void setCeoname(String ceoname) {
        this.ceoname = ceoname;
    }

    public String getHouseneme() {
        return houseneme;
    }

    public void setHouseneme(String houseneme) {
        this.houseneme = houseneme;
    }

    public String getRegisternum() {
        return registernum;
    }

    public void setRegisternum(String registernum) {
        this.registernum = registernum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
