package com.szymonfluder.reports.dto;

import java.util.Date;

public class CompressiveStrengthTestDTO {

    private int id;
    private Date testDate;
    private String batch;
    private int productFormatId;
    private int employeeId;

    public CompressiveStrengthTestDTO() {
    }

    public CompressiveStrengthTestDTO(int id, Date testDate, String batch, int productFormatId, int employeeId) {
        this.id = id;
        this.testDate = testDate;
        this.batch = batch;
        this.productFormatId = productFormatId;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getProductFormatId() {
        return productFormatId;
    }

    public void setProductFormatId(int productFormatId) {
        this.productFormatId = productFormatId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
