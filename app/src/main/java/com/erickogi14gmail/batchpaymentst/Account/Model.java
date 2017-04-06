package com.erickogi14gmail.batchpaymentst.Account;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by kimani kogi on 3/24/2017.
 */

public class Model {
private String modificationDate="23/4/2017";
    private String amount ="500";
    private  String transactionStatus="Completed";
    private String  creditor="+254720001101";

    public Model() {
    }

    public Model(String modificationDate, String amount, String transactionStatus, String creditor) {
        this.modificationDate = modificationDate;
        this.amount = amount;
        this.transactionStatus = transactionStatus;
        this.creditor = creditor;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }
}
