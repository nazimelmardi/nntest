package com.nazim.nntest.infrastructure.service;

import com.nazim.nntest.infrastructure.service.parser.FileInputParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParserFactory {

    @Autowired
    private List<FileInputParser> fileInputParsers;

    private static final Map<String, FileInputParser> parserCache = new HashMap<>();

    @PostConstruct
    public void initMyServiceCache() {
        for(FileInputParser fileInputParser : fileInputParsers) {
            parserCache.put(fileInputParser.getType(), fileInputParser);
        }
    }

    public FileInputParser getParser(String inputFileType) {
        FileInputParser parser = parserCache.get(inputFileType);
        if(parser == null) {
            throw new RuntimeException("Unknown parser type");
        }
        return parser;
    }

}
