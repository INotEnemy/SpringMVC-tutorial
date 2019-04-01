package ru.sevsu.rest.service;


import org.springframework.stereotype.Service;
import ru.sevsu.db.db.tables.pojos.Student;

import java.util.List;
import java.util.Optional;

import static ru.sevsu.db.db.Tables.STUDENT;

@Service
public class StudentService extends JooqAbstractService implements RootService<Student> {

    public List<Student> find() {
        return context.select()
                .from(STUDENT)
                .fetch()
                .into(Student.class);
    }

    @Override
    public Optional<Student> findByName() {
        return context.select()
                .from(STUDENT)
                .fetchOptional(it -> it.into(Student.class));
    }

    @Override
    public Student create(Student inputPojo) {
        return null;
    }

    @Override
    public Student update(Student inputPojo) {
        return null;
    }

    @Override
    public void delete(String name) {

    }
}
