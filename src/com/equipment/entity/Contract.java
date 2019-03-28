package com.equipment.entity;/*
 * @author :张
 * Date  : 2019/3/26
 *        合同表
 */

import java.sql.Date;

public class Contract {


    private int contractId;
    private String contractName;
    private String firstParty;
    private String secondParty;
    private Date sigingDate;
    private String projectLocation;
    private double cost;
    private String content;
    private String supplyChain;
    private String paymentCycle;
    private String acceptanceResult;

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(String firstParty) {
        this.firstParty = firstParty;
    }

    public String getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(String secondParty) {
        this.secondParty = secondParty;
    }

    public Date getSigingDate() {
        return sigingDate;
    }

    public void setSigingDate(Date sigingDate) {
        this.sigingDate = sigingDate;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSupplyChain() {
        return supplyChain;
    }

    public void setSupplyChain(String supplyChain) {
        this.supplyChain = supplyChain;
    }

    public String getPaymentCycle() {
        return paymentCycle;
    }

    public void setPaymentCycle(String paymentCycle) {
        this.paymentCycle = paymentCycle;
    }

    public String getAcceptanceResult() {
        return acceptanceResult;
    }

    public void setAcceptanceResult(String acceptanceResult) {
        this.acceptanceResult = acceptanceResult;
    }

    public Contract(int contractId, String contractName, String firstParty, String secondParty, Date sigingDate,
                    String projectLocation, double cost, String content, String supplyChain, String paymentCycle, String acceptanceResult) {
        this.contractId = contractId;
        this.contractName = contractName;
        this.firstParty = firstParty;
        this.secondParty = secondParty;
        this.sigingDate = sigingDate;
        this.projectLocation = projectLocation;
        this.cost = cost;
        this.content = content;
        this.supplyChain = supplyChain;
        this.paymentCycle = paymentCycle;
        this.acceptanceResult = acceptanceResult;
    }

    public Contract() {
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", contractName='" + contractName + '\'' +
                ", firstParty='" + firstParty + '\'' +
                ", secondParty='" + secondParty + '\'' +
                ", sigingDate=" + sigingDate +
                ", projectLocation='" + projectLocation + '\'' +
                ", cost=" + cost +
                ", content='" + content + '\'' +
                ", supplyChain='" + supplyChain + '\'' +
                ", paymentCycle='" + paymentCycle + '\'' +
                ", acceptanceResult='" + acceptanceResult + '\'' +
                '}';
    }
}
