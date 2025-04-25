package com.szymonfluder.reports.dao;

import com.szymonfluder.reports.entity.CompressiveStrengthTest;
import java.util.List;

public interface CompressiveStrengthTestDAO {

    void addCompressiveStrengthTest(CompressiveStrengthTest compressiveStrengthTest);
    CompressiveStrengthTest getCompressiveStrengthTestById(int id);
    List<CompressiveStrengthTest> getCompressiveStrengthTests();
    void deleteCompressiveStrengthTestById(int id);
    void updateCompressiveStrengthTest(CompressiveStrengthTest compressiveStrengthTest);

    List<CompressiveStrengthTest> getCompressiveStrengthTestsByEmployeeId(int employeeId);
}