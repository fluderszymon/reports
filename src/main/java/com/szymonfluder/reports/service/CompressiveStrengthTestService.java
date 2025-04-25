package com.szymonfluder.reports.service;

import com.szymonfluder.reports.dto.CompressiveStrengthTestDTO;
import java.util.List;

public interface CompressiveStrengthTestService {

    CompressiveStrengthTestDTO getCompressiveStrengthTestById(int id);
    List<CompressiveStrengthTestDTO> getCompressiveStrengthTests();
    void addCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO);
    void deleteCompressiveStrengthTestById(int id);
    void updateCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO);

    List<CompressiveStrengthTestDTO> getCompressiveStrengthTestsByEmployeeId(int employeeId);

}
