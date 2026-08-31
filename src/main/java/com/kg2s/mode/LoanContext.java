package com.kg2s.mode;

import java.io.Serializable;
import java.math.BigDecimal;

public class LoanContext  implements Serializable {
    private String instnaceId;
    private String applicationId;
    private BigDecimal applyAmount;

    //Agen 处理的状态和结果
    private Integer creditScore;
    private Boolean isBlackList;
    private Boolean incomeVerified;

    //确定性的节点处理结果

    private BigDecimal approvalAmount;
    private BigDecimal interestRate;
    private String currentStatus;

    public LoanContext(String instnaceId,String applicationId,BigDecimal applyAmount){
        this.instnaceId = instnaceId;
        this.applicationId = applicationId;
        this.applyAmount = applyAmount;
        this.currentStatus = "INIT";


    }

    public String getInstnaceId() {
        return instnaceId;
    }

    public void setInstnaceId(String instnaceId) {
        this.instnaceId = instnaceId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public Boolean getBlackList() {
        return isBlackList;
    }

    public void setBlackList(Boolean blackList) {
        isBlackList = blackList;
    }

    public Boolean getIncomeVerified() {
        return incomeVerified;
    }

    public void setIncomeVerified(Boolean incomeVerified) {
        this.incomeVerified = incomeVerified;
    }

    public BigDecimal getApprovalAmount() {
        return approvalAmount;
    }

    public void setApprovalAmount(BigDecimal approvalAmount) {
        this.approvalAmount = approvalAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
}
