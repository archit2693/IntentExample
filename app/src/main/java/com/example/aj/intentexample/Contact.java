package com.example.aj.intentexample;

public class Contact {

    private int image_id;
    private String name,email,mobile;

    public Contact(int image_id,String name,String email,String mobile)
    {
        this.setImage_id(image_id);
        this.setName(name);
        this.setEmail(email);
        this.setMobile(mobile);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
