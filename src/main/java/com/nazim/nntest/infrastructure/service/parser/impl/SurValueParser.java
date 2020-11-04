package com.nazim.nntest.infrastructure.service.parser.impl;

import com.nazim.nntest.domain.entity.SurValues;
import com.nazim.nntest.domain.persistence.SurValuesRepository;
import com.nazim.nntest.infrastructure.service.parser.FileInputParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurValueParser implements FileInputParser {

    private final SurValuesRepository surValuesRepository;

    @Override
    public String getType() {
        return "SURVALUES";
    }

    @Override
    @Transactional
    public Integer parseStringToInteger(String textFileContent) {
        List<String> surValueFileLines = getCellsAsList(textFileContent);

        saveSurValues(getSurValueList(surValueFileLines));
        return surValueFileLines.size();
    }

    private void saveSurValues(List<SurValues> surValues){
        surValues.stream().forEach(surValuesRepository::save);
    }

    private List<SurValues> getSurValueList(List<String> cellsArrayList){
        List<SurValues> surValueList = new ArrayList<>();

        cellsArrayList.forEach(line -> surValueList.add(createSurValue(line)));

        return surValueList;
    }

    private SurValues createSurValue(String rawList){
        SurValues surValues = new SurValues();

        try {
            surValues.setCompany(rawList.substring(0, 1).trim());
            surValues.setChdrnum(rawList.substring(1, 9).trim());
            surValues.setSurvalue(asBigDecimal(rawList.substring(9, 24).trim()));
            surValues.setCurrency(null);
            surValues.setValidDate(null);

        } catch (StringIndexOutOfBoundsException e){
            log.warn("Missing data!");
        }

        return surValues;
    }

    private List<String> getCellsAsList(String text){
        return Arrays.asList(getLines(text));
    }

    private BigDecimal asBigDecimal(String bigDecimalString){
        try {
            return (bigDecimalString == null || bigDecimalString.equals("")) ? null : new BigDecimal(bigDecimalString);
        } catch (NumberFormatException e){
            return null;
        }
    }

}
