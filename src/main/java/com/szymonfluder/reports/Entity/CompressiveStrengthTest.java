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

    @JsonBackReference(value="productFormat-compressiveStrengthTest")
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name="product_format_id")
    private ProductFormat productFormat;

    @ElementCollection
    @CollectionTable(name="results_in_mpa", joinColumns= @JoinColumn(name="compressivestrengthtest_id"))
    @Column(name="result_in_mpa", nullable=false)
    private List<Integer> resultsInMPa;

    @JsonBackReference(value="employee-compressiveStrengthTest")
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                         CascadeType.DETACH, CascadeType.REFRESH},
                            fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee employee;

    public CompressiveStrengthTest() {
    }

    public CompressiveStrengthTest(Date testDate, String batch, ProductFormat productFormat, List<Integer> resultsInMPa, Employee employee) {
        this.testDate = testDate;
        this.batch = batch;
        this.productFormat = productFormat;
        this.resultsInMPa = resultsInMPa;
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

    public ProductFormat getProductFormat() {
        return productFormat;
    }

    public void setProductFormat(ProductFormat productFormat) {
        this.productFormat = productFormat;
    }

    public List<Integer> getResultsInMPa() {
        return resultsInMPa;
    }

    public void setResultsInMPa(List<Integer> resultsInMPa) {
        this.resultsInMPa = resultsInMPa;
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
                ", productFormat=" + productFormat +
                ", resultsInMPa=" + resultsInMPa +
                ", employee=" + employee +
                '}';
    }
}
