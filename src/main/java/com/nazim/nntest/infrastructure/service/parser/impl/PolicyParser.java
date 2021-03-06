package com.nazim.nntest.infrastructure.service.parser.impl;

import com.nazim.nntest.domain.persistence.PolicyRepository;
import com.nazim.nntest.infrastructure.service.parser.FileInputParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PolicyParser implements FileInputParser {

    private final PolicyRepository policyRepository;

    @Override
    public String getType() {
        return "POLICY";
    }

    @Override
    public Integer parseStringToInteger(String textFileContent) {
        return null;
    }

}
