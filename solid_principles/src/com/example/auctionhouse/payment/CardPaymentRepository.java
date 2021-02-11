package com.example.auctionhouse.payment;

import com.example.auctionhouse.ioservice.FileObject;
import java.util.ArrayList;
import java.util.List;

interface CardPaymentRepositoryImp{
    void createCardPayment(CardPayment cp);
    List<CardPayment> readCardPaymentList();
    void deleteCardPayment(CardPayment cp);

}

public class CardPaymentRepository extends FileObject<CardPayment> implements CardPaymentRepositoryImp{

    private String fileName;
    private List<CardPayment> cpList;

    CardPaymentRepository(String fileName){
        this.fileName = fileName;
        this.cpList = fileReadObject(this.fileName);
        if (this.cpList == null){
            this.cpList = new ArrayList<CardPayment>();
            System.out.println("Unable to find existing file, card payment profile start fresh.");
        }
        else {
            System.out.println("System file managed to read card payment profile.");
        }
    }

    @Override
    public void createCardPayment(CardPayment cp) {
        this.cpList.add(cp);
        boolean result = fileWriteObject(this.cpList, this.fileName);
        if (!result){
            System.out.println("Adding of card payment profile failed.");
        }
    }

    @Override
    public List<CardPayment> readCardPaymentList() {
        return this.cpList;
    }

    @Override
    public void deleteCardPayment(CardPayment cp) {
        this.cpList.remove(cp);
        boolean result = fileWriteObject(this.cpList, this.fileName);
        if (!result){
            System.out.println("deleting of card payment profile failed.");
        }
    }
}
