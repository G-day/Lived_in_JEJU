package com.example.boardtest;

public class MemberInfo {

    private String name;
    private String phone;
    private String birth;
    private String address;
    private String classify;
    private String photoUrl;

    public MemberInfo(String name, String phone, String birth, String address, String classify, String photoUrl) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.address = address;
        this.classify = classify;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
