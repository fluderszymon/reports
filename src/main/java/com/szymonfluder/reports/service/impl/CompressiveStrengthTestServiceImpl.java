package com.szymonfluder.reports.service.impl;

import com.szymonfluder.reports.dao.CompressiveStrengthTestDAO;
import com.szymonfluder.reports.dto.CompressiveStrengthTestDTO;
import com.szymonfluder.reports.entity.CompressiveStrengthTest;
import com.szymonfluder.reports.mapper.CompressiveStrengthTestMapper;
import com.szymonfluder.reports.service.CompressiveStrengthTestService;

import java.util.List;

public class CompressiveStrengthTestServiceImpl implements CompressiveStrengthTestService {

    private final CompressiveStrengthTestDAO compressiveStrengthTestDAO;
    private final CompressiveStrengthTestMapper compressiveStrengthTestMapper;

    public CompressiveStrengthTestServiceImpl(CompressiveStrengthTestDAO compressiveStrengthTestDAO,
                                              CompressiveStrengthTestMapper compressiveStrengthTestMapper) {
        this.compressiveStrengthTestDAO = compressiveStrengthTestDAO;
        this.compressiveStrengthTestMapper = compressiveStrengthTestMapper;
    }

    @Override
    public List<CompressiveStrengthTestDTO> getCompressiveStrengthTests() {
        List<CompressiveStrengthTest> compressiveStrengthTests = compressiveStrengthTestDAO.getCompressiveStrengthTests();
        return compressiveStrengthTests
                .stream()
                .map(compressiveStrengthTestMapper::compressiveStrengthTestToCompressiveStrengthTestDto)
                .toList();
    }

    @Override
    public CompressiveStrengthTestDTO getCompressiveStrengthTestById(int id) {
        CompressiveStrengthTest compressiveStrengthTest = compressiveStrengthTestDAO.getCompressiveStrengthTestById(id);
        return compressiveStrengthTestMapper.compressiveStrengthTestToCompressiveStrengthTestDto(compressiveStrengthTest);
    }

    @Override
    public void addCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO) {
        CompressiveStrengthTest compressiveStrengthTest = compressiveStrengthTestMapper.compressiveStrengthTestDtoToCompressiveStrengthTest(compressiveStrengthTestDTO);
        compressiveStrengthTestDAO.addCompressiveStrengthTest(compressiveStrengthTest);
    }

    @Override
    public void deleteCompressiveStrengthTestById(int id) {
        compressiveStrengthTestDAO.deleteCompressiveStrengthTestById(id);
    }

    @Override
    public void updateCompressiveStrengthTest(CompressiveStrengthTestDTO compressiveStrengthTestDTO) {
        CompressiveStrengthTest compressiveStrengthTest = compressiveStrengthTestMapper.compressiveStrengthTestDtoToCompressiveStrengthTest(compressiveStrengthTestDTO);
        compressiveStrengthTestDAO.updateCompressiveStrengthTest(compressiveStrengthTest);
    }

    @Override
    public List<CompressiveStrengthTestDTO> getCompressiveStrengthTestsByEmployeeId(int employeeId) {
        List<CompressiveStrengthTest> compressiveStrengthTests = compressiveStrengthTestDAO.getCompressiveStrengthTestsByEmployeeId(employeeId);
        return compressiveStrengthTests
                .stream()
                .map(compressiveStrengthTestMapper::compressiveStrengthTestToCompressiveStrengthTestDto)
                .toList();
    }
}
