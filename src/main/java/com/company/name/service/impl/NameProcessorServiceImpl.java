package com.company.name.service.impl;

import com.company.name.model.Name;
import com.company.name.service.NameProcessorService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NameProcessorServiceImpl implements NameProcessorService {
    @Override
    public List<Name> processData(List<String> nameList) {

        Collections.sort(nameList);

        //create a name object list and capture individual name score and index after the sort
        return nameList.stream().map(nameStr -> new Name(nameStr, nameList.indexOf(nameStr)+1)).collect(Collectors.toList());

    }
}
