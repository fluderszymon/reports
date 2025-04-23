package com.szymonfluder.reports.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="compressive_strength_test")
public class CompressiveStrengthTest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="test_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss.SSSSSS")
    private Date testDate;

    @Column(name="batch")
    private String batch;

    @Column(name="measured_strength")
    private int measuredStrength;

    @JsonBackReference(value="productFormat-compressiveStrengthTest")
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name="product_format_id")
    private ProductFormat productFormat;

    @JsonBackReference(value="employee-compressiveStrengthTest")
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                         CascadeType.DETACH, CascadeType.REFRESH},
                            fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee employee;

    public CompressiveStrengthTest() {
    }

    public CompressiveStrengthTest(Date testDate, String batch, int measuredStrength,
                                   ProductFormat productFormat, Employee employee) {
        this.testDate = testDate;
        this.batch = batch;
        this.measuredStrength = measuredStrength;
        this.productFormat = productFormat;
        this.employee = employee;
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

    public int getMeasuredStrength() {
        return measuredStrength;
    }

    public void setMeasuredStrength(int measuredStrength) {
        this.measuredStrength = measuredStrength;
    }

    public ProductFormat getProductFormat() {
        return productFormat;
    }

    public void setProductFormat(ProductFormat productFormat) {
        this.productFormat = productFormat;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "CompressiveStrengthTest{" +
                "id=" + id +
                ", testDate=" + testDate +
                ", batch='" + batch + '\'' +
                ", measuredStrength=" + measuredStrength +
                ", productFormat=" + productFormat +
                ", employee=" + employee +
                '}';
    }
}
