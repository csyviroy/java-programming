package com.example.auctionhouse.payment;
interface PaymentServiceFactoryImp{
    public PaymentServiceImp getAPIService();
}
public class PaymentServiceFactory implements PaymentServiceFactoryImp{

    PaymentObject po;

    public PaymentServiceFactory(PaymentObject po) {
        this.po = po;
    }

    @Override
    public PaymentServiceImp getAPIService() {
        if (this.po instanceof CreditCard)
            return new CreditCardAPIService((CreditCard) this.po);
        else if (this.po instanceof DebitCard)
            return new DebitCardAPIService((DebitCard) this.po);
        else if (this.po instanceof GooglePay)
            return new GoogleAPIService((GooglePay) this.po);
        else if (this.po instanceof GrabPay)
            return new GrabAPIService((GrabPay) this.po);
        else
            return new SamsungAPIService((SamsungPay) this.po);
    }
}
