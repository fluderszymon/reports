package com.szymonfluder.reports.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="product_format")
public class ProductFormat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="format_name")
    private String formatName;

    @Column(name="format_number")
    private int formatNumber;

    @Column(name="min_length")
    private int minLength;

    @Column(name="max_length")
    private int maxLength;

    @Column(name="min_width")
    private int minWidth;

    @Column(name="max_width")
    private int maxWidth;

    @Column(name="min_height")
    private int minHeight;

    @Column(name="max_height")
    private int maxHeight;

    @Column(name="min_weight")
    private int minWeight;

    @Column(name="max_weight")
    private int maxWeight;

    @Column(name="min_compressive_strength_in_mpa")
    private int minCompressiveStrengthInMPa;

    @JsonBackReference(value="productFormat-compressiveStrengthTest")
    @OneToMany(mappedBy="productFormat",
            cascade={CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<CompressiveStrengthTest> tests;

    public ProductFormat() {}

    public ProductFormat(String formatName, int formatNumber, int minLength, int maxLength,
                         int minWidth, int maxWidth, int minHeight, int maxHeight,
                         int minWeight, int maxWeight, int minCompressiveStrengthInMPa) {
        this.formatName = formatName;
        this.formatNumber = formatNumber;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.minCompressiveStrengthInMPa = minCompressiveStrengthInMPa;
    }

    public int getId() {
        return id;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public int getFormatNumber() {
        return formatNumber;
    }

    public void setFormatNumber(int formatNumber) {
        this.formatNumber = formatNumber;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMinCompressiveStrengthInMPa() {
        return minCompressiveStrengthInMPa;
    }

    public void setMinCompressiveStrengthInMPa(int minCompressiveStrengthInMPa) {
        this.minCompressiveStrengthInMPa = minCompressiveStrengthInMPa;
    }

    public List<CompressiveStrengthTest> getTests() {
        return tests;
    }

    public void setTests(List<CompressiveStrengthTest> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "ProductFormat{" +
                "id=" + id +
                ", formatName='" + formatName + '\'' +
                ", formatNumber=" + formatNumber +
                ", minLength=" + minLength +
                ", maxLength=" + maxLength +
                ", minWidth=" + minWidth +
                ", maxWidth=" + maxWidth +
                ", minHeight=" + minHeight +
                ", maxHeight=" + maxHeight +
                ", minWeight=" + minWeight +
                ", maxWeight=" + maxWeight +
                ", minCompressiveStrengthInMPa=" + minCompressiveStrengthInMPa +
                '}';
    }
}
