package com.example.auctionhouse.payment;

import com.example.auctionhouse.ioservice.FileObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface CardPaymentRepositoryImp{
    public void createCardPaymentDB(CardPayment cp);
    public List<CardPayment> readCardPaymentListDB();
    public void deleteCardPaymentDB(CardPayment cp);

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
    public void createCardPaymentDB(CardPayment cp) {
        this.cpList.add(cp);
        boolean result = fileWriteObject(this.cpList, this.fileName);
        if (!result){
            System.out.println("Adding of card payment profile failed.");
        }
    }

    @Override
    public List<CardPayment> readCardPaymentListDB() {
        return this.cpList;
    }

    @Override
    public void deleteCardPaymentDB(CardPayment cp) {
        this.cpList.remove(cp);
        boolean result = fileWriteObject(this.cpList, this.fileName);
        if (!result){
            System.out.println("deleting of card payment profile failed.");
        }
    }
}
