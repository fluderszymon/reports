package com.szymonfluder.reports.dao;

import com.szymonfluder.reports.Entity.CompressiveStrengthTest;

import java.util.ArrayList;
import java.util.List;

public interface CompressiveStrengthTestDAO {

    void addCompressiveStrengthTest(int employee_id, int product_format_id, CompressiveStrengthTest compressiveStrengthTest);
    CompressiveStrengthTest getCompressiveStrengthTestById(int id);
    List<CompressiveStrengthTest> getCompressiveStrengthTests();
    void deleteCompressiveStrengthTestById(int id);
    void updateCompressiveStrengthTest(int employee_id, int product_format_id, CompressiveStrengthTest compressiveStrengthTest);

    void addCompressiveStrengthTestResults(int compressiveStrengthTestId, ArrayList<Integer> results);
    List<CompressiveStrengthTest> getCompressiveStrengthTestsByEmployeeId(int employee_id);
}