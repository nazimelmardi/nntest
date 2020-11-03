package com.nazim.nntest.infrastructure.service.parser.impl;

import com.nazim.nntest.infrastructure.service.parser.FileInputParser;

public class PolicyParser implements FileInputParser {

    @Override
    public String getType() {
        return "policyparser";
    }
}
