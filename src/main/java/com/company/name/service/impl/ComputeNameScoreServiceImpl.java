package com.company.name.service.impl;

import com.company.name.enums.Department;
import com.company.name.service.ComputeNameScoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Delegator service which will to route the request to the correct service based on department code.
 */
@Service("computeNameScoreServiceDelegator")
public class ComputeNameScoreServiceImpl implements ComputeNameScoreService {

    private Map<String, ComputeNameScoreService> computeNameScoreServiceMap;

    public ComputeNameScoreServiceImpl(List<ComputeNameScoreService> computeNameScoreServiceList) {
        computeNameScoreServiceMap = computeNameScoreServiceList.stream()
                .collect(Collectors.toMap(computeNameScoreService -> computeNameScoreService.getDepartmentId(),
                        computeNameScoreService -> computeNameScoreService));
    }

    @Override
    public long computeNameScore(String... args) throws Exception {
        String deptId = args.length > 1 ? args[1] : Department.DEP1.name();
        return computeNameScoreServiceMap.get(deptId).computeNameScore(args);
    }

    @Override
    public String getDepartmentId() {
        return null;
    }
}
