/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wns.ta.vo;

/**
 *
 * @author u162914
 */
public class WorkItemVO {

    public WorkItemVO() {
    }

    

    private String workItemName;
    private String requestorEmailAddress;
    private String requestorName;
    private String apc;
    private String sourceCode;
    private String cpa;
    private String drCr;
    private String reasonCode;
    private String type;
    private String effectiveGLDate;
    private String approverEmailAddress;
    private String approverName;

    public String getRequestorEmailAddress() {
        return requestorEmailAddress;
    }

    public void setRequestorEmailAddress(String requestorEmailAddress) {
        this.requestorEmailAddress = requestorEmailAddress;
    }

    public String getRequestorName() {
        return requestorName;
    }

    public void setRequestorName(String requestorName) {
        this.requestorName = requestorName;
    }

    public String getApc() {
        return apc;
    }

    public void setApc(String apc) {
        this.apc = apc;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getCpa() {
        return cpa;
    }

    public void setDrCr(String drCr) {
        this.drCr = drCr;
    }
    
    
     public String getDrCr() {
        return drCr;
    }

    public void setCpa(String cpa) {
        this.cpa = cpa;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffectiveGLDate() {
        return effectiveGLDate;
    }

    public void setEffectiveGLDate(String effectiveGLDate) {
        this.effectiveGLDate = effectiveGLDate;
    }

    public String getApproverEmailAddress() {
        return approverEmailAddress;
    }

    public void setApproverEmailAddress(String approverEmailAddress) {
        this.approverEmailAddress = approverEmailAddress;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }
    
    
    
    public String getWorkItemName() {
        return workItemName;
    }

    public void setWorkItemName(String workItemName) {
        this.workItemName = workItemName;
    }

}
