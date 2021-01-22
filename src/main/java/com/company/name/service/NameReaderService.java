package com.company.name.service;

import java.io.IOException;
import java.util.List;

public interface NameReaderService {
    List<String> getNames(String file) throws IOException;
}
