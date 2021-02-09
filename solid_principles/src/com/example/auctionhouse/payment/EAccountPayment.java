package com.example.auctionhouse.payment;

import java.io.Serializable;
import java.util.Date;

abstract class EAccountPayment implements PaymentInterfaceImp, Serializable {
    private String username;
    private String secretKey;
    private Date associatedOn;

    public EAccountPayment(String username, String secretKey) {
        this.username = username;
        this.secretKey = secretKey;
        setAssociatedOn(new Date());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Date getAssociatedOn() {
        return associatedOn;
    }

    public void setAssociatedOn(Date associatedOn) {
        this.associatedOn = associatedOn;
    }
}
