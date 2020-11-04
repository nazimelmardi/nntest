package com.nazim.nntest.infrastructure.service;

import com.nazim.nntest.domain.value.OkResponseValue;
import com.nazim.nntest.infrastructure.service.filestorage.FileStorageUtil;
import com.nazim.nntest.infrastructure.service.parser.FileInputParser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@RequiredArgsConstructor
public class FileStorageService {

    private static final String CUSTCOMP = "CUSTCOMP";
    private static final String  OUTPH = "OUTPH";
    private static final String ZTPSPF = "ZTPSPF";

    private final ParserFactory parserFactory;
    private final FileStorageUtil fileStorageUtil;

    public OkResponseValue processFile(MultipartFile file){
        Resource fileResource = fileStorageUtil.loadFileAsResource(file.getName());

        FileInputParser fileInputParser = parserFactory.getParser(getFileType(file.getName()));

        Integer size = fileInputParser.parseStringToInteger(asString(fileResource));

        OkResponseValue okResponseValue = new OkResponseValue();
        okResponseValue.setMessage(file.getName() + " successfully uploaded");
        okResponseValue.setSize(size);

        return okResponseValue;
    }

    //Outside to handle the exceptions separated
    private String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private String getFileType(String fileName) {
        if(fileName .contains(CUSTCOMP)){
            return "POLICY";
        } else if (fileName.contains(OUTPH)){
            return "OUTHEADER";
        } else if (fileName.contains(ZTPSPF)){
            return "SURVALUES";
        } else {
            throw new RuntimeException();
        }
    }
}
