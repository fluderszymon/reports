package com.szymonfluder.reports.service;

import com.szymonfluder.reports.dto.CompressiveStrengthTestDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CompressiveStrengthTestService {

    CompressiveStrengthTestDTO getCompressiveStrengthTestById(int id);
    List<CompressiveStrengthTestDTO> getCompressiveStrengthTests();
    void addCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO);
    void deleteCompressiveStrengthTestById(int id);
    void updateCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO);

    List<CompressiveStrengthTestDTO> getCompressiveStrengthTestsByEmployeeId(int employeeId);

}
