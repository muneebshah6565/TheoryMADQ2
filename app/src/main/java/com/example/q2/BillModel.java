package com.example.q2;

public class BillModel {
    public String customerName;
    public String billNo;
    public String cMeterNo;
    public String mAmount;
    public String cLastUnits;
    public String cUnits;

    public BillModel(String customerName, String billNo, String cMeterNo, String mAmount, String cLastUnits, String cUnits) {
        this.customerName = customerName;
        this.billNo = billNo;
        this.cMeterNo = cMeterNo;
        this.mAmount = mAmount;
        this.cLastUnits = cLastUnits;
        this.cUnits = cUnits;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getcMeterNo() {
        return cMeterNo;
    }

    public void setcMeterNo(String cMeterNo) {
        this.cMeterNo = cMeterNo;
    }

    public String getmAmount() {
        return mAmount;
    }

    public void setmAmount(String mAmount) {
        this.mAmount = mAmount;
    }

    public String getcLastUnits() {
        return cLastUnits;
    }

    public void setcLastUnits(String cLastUnits) {
        this.cLastUnits = cLastUnits;
    }

    public String getcUnits() {
        return cUnits;
    }

    public void setcUnits(String cUnits) {
        this.cUnits = cUnits;
    }
}
