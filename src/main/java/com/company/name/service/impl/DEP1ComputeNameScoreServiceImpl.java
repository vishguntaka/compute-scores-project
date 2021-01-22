package com.company.name.service.impl;


import com.company.name.enums.Department;
import com.company.name.model.Name;
import com.company.name.service.ComputeNameScoreService;
import com.company.name.service.NameProcessorService;
import com.company.name.service.NameReaderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DEP1ComputeNameScoreServiceImpl implements ComputeNameScoreService {
    private NameProcessorService nameProcessorService;
    private NameReaderService nameReaderService;

    public DEP1ComputeNameScoreServiceImpl(NameProcessorService nameProcessorService, NameReaderService nameReaderService) {
        this.nameProcessorService = nameProcessorService;
        this.nameReaderService = nameReaderService;
    }

    public long computeNameScore(String... args) throws Exception {
        List nameList = nameReaderService.getNames(args[0]);

        List<Name> list = nameProcessorService.processData(nameList);

        return list.stream().map(o -> o.getSum()).reduce(Long::sum).get();

    }

    @Override
    public String getDepartmentId() {
        return Department.DEP1.name();
    }


}
