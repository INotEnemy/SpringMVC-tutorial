package ru.sevsu.rest.service;

import java.util.List;
import java.util.Optional;

public interface StudCourseImplService <T> {

    public List<T> find();

    public Optional<T> findByName(String name);

    public T create(T inputPojo);

    public T update(T inputPojo);

    public void delete(Integer studName, Integer courseName);
}
