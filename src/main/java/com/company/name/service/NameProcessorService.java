package com.company.name.service;

import com.company.name.model.Name;

import java.util.List;

public interface NameProcessorService {
    public List<Name> processData(List<String> nameList);
}
