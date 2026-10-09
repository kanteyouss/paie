package com.paie.paie.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(AbsenceRequestDto.class),
        @JsonSubTypes.Type(BulletinRequestDto.class),
        @JsonSubTypes.Type(ContratRequestDto.class),
        @JsonSubTypes.Type(EmployeRequestDto.class),
        @JsonSubTypes.Type(RubriqueRequestDto.class)

})
public interface RequestDto { }
