package ru.sevsu.rest.mapping;

import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class PlainMapping<Pojo, Dto> {

    protected ModelMapper mapper = new ModelMapper();

    private Class<Pojo> pojo;
    private Class<Dto> dto;


    public PlainMapping() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType pTyp = (ParameterizedType) type;
        pojo = (Class<Pojo>) pTyp.getActualTypeArguments()[0];
        dto = (Class<Dto>) pTyp.getActualTypeArguments()[1];

    }

    public Pojo fromDto(Dto dto) {
        return mapper.map(dto, pojo);
    }

    public Dto toDto(Pojo pojo) {
        return mapper.map(pojo, dto);
    }

}
