package com.szymonfluder.reports.dao;

import com.szymonfluder.reports.dto.CompressiveStrengthTestDTO;

import java.util.ArrayList;
import java.util.List;

public interface CompressiveStrengthTestDAO {

    void addCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO);
    CompressiveStrengthTestDTO getCompressiveStrengthTestById(int id);
    List<CompressiveStrengthTestDTO> getCompressiveStrengthTests();
    void deleteCompressiveStrengthTestById(int id);
    void updateCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO);

    List<CompressiveStrengthTestDTO> getCompressiveStrengthTestsByEmployeeId(int employee_id);
}