package com.example.auctionhouse.payment;

import com.example.auctionhouse.ioservice.FileObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface EAccountPaymentRepositoryImp{
    void createEAccountPayment(EAccountPayment eap);
    List<EAccountPayment> readEAccountPaymentList();
    void updateEAccountPayment(EAccountPayment eap);
    void deleteEAccountPayment(EAccountPayment eap);
}

public class EAccountPaymentRepository extends FileObject<EAccountPayment> implements EAccountPaymentRepositoryImp{

    private String fileName;
    private List<EAccountPayment> eapList;

    EAccountPaymentRepository(String fileName){
        this.fileName = fileName;
        this.eapList = fileReadObject(this.fileName);
        if (this.eapList == null){
            this.eapList = new ArrayList<EAccountPayment>();
            System.out.println("Unable to find existing file, e-account payment profile start fresh.");
        }
        else {
            System.out.println("System file managed to read e-account payment profile.");
        }
    }

    @Override
    public void createEAccountPayment(EAccountPayment eap) {
        this.eapList.add(eap);
        boolean result = fileWriteObject(this.eapList, this.fileName);
        if (!result){
            System.out.println("Adding of e-account profile failed.");
        }
    }

    @Override
    public List<EAccountPayment> readEAccountPaymentList() {
        return this.eapList;
    }

    @Override
    public void updateEAccountPayment(EAccountPayment eap) {
        Iterator i = this.eapList.iterator();
        while (i.hasNext()){
            EAccountPayment dbPayment = (EAccountPayment) i.next();
            if (eap.getUsername().equals(dbPayment.getUsername())){
                this.eapList.remove(dbPayment);
                this.eapList.add(eap);
                break;
            }
        }
        boolean result = fileWriteObject(this.eapList, this.fileName);
        if (!result){
            System.out.println("Updating of e-account payment profile failed.");
        }
    }

    @Override
    public void deleteEAccountPayment(EAccountPayment eap) {
        this.eapList.remove(eap);
        boolean result = fileWriteObject(this.eapList, this.fileName);
        if (!result){
            System.out.println("Deleting of e-account payment profile failed.");
        }
    }
}
