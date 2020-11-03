package com.nazim.nntest.infrastructure.adapter.mapper;

import com.nazim.nntest.domain.value.OkResponseValue;
import com.nazim.nntest.infrastructure.api.model.OkResponse;
import org.mapstruct.Mapper;

@Mapper
public interface OkResponseMapper {

    OkResponse toModel(OkResponseValue value);
}
