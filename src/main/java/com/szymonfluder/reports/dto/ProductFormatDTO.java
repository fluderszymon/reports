package com.szymonfluder.reports.dto;

import jakarta.persistence.Column;

public class ProductFormatDTO {

    private int id;
    private String formatName;
    private int formatNumber;
    private int minLength;
    private int maxLength;
    private int minWidth;
    private int maxWidth;
    private int minHeight;
    private int maxHeight;
    private int minWeight;
    private int maxWeight;
    private int minCompressiveStrengthInMPa;

    public ProductFormatDTO() {
    }

    public ProductFormatDTO(String formatName, int formatNumber, int minLength, int maxLength,
                            int minWidth, int maxWidth, int minHeight, int maxHeight, int minWeight,
                            int maxWeight, int minCompressiveStrengthInMPa) {
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

    public void setId(int id) {
        this.id = id;
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
}
