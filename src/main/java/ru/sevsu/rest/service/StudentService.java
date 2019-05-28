package ru.sevsu.rest.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;
import ru.sevsu.db.db.tables.pojos.Student;
import ru.sevsu.db.db.tables.records.StudentRecord;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static ru.sevsu.db.db.Tables.STUDENT;

@Service
@Slf4j
public class StudentService extends JooqAbstractService implements RootService<Student> {

    final String entity = "student";

    public List<Student> find() {
        return context.select()
                .from(STUDENT)
                .fetch()
                .into(Student.class);
    }

    @Override
    public Optional<Student> findByName(String name) {
        return context.select()
                .from(STUDENT)
                .where(STUDENT.FIO.equalIgnoreCase(name))
                .fetchOptional(it -> it.into(Student.class));
    }

    public Integer getIdByName(String name) {

        Integer id = null;

        try {
            id = findByName(name).map(Student::getStudNum)
                    .orElseThrow(() -> new Exception(format("Unable to load %s by name: %s", entity, name)));

        } catch (Exception ex) {
            ex.getMessage();
        }
        return id;
    }

    @Override
    public Student create(Student inputPojo) {

        inputPojo.setStudNum(nextLongId().intValue());
        final StudentRecord rec = context.newRecord(STUDENT, inputPojo);
        final StudentRecord inserted = context.insertInto(STUDENT)
                .set(rec)
                .returning(STUDENT.STUD_NUM)
                .fetchOne();

        return inputPojo;
    }

    @Override
    public Student update(Student inputPojo) {

        inputPojo.setStudNum(getIdByName(inputPojo.getFio()));
        StudentRecord rec = context.update(STUDENT)
                .set(context.newRecord(STUDENT, inputPojo))
                .where(STUDENT.FIO.equalIgnoreCase(inputPojo.getFio()))
                .returning().fetchOne();

        return rec.map(it -> it.into(Student.class));
    }

    @Override
    public void delete(String name) {

        try {
            int count = context.delete(STUDENT)
                    .where(STUDENT.FIO.equalIgnoreCase(name))
                    .execute();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public Integer count() {
        return context.selectCount()
                .from(STUDENT)
                .fetchOne(0, int.class);
    }

    public BigDecimal maxVal() {
        return context.select(DSL.max(STUDENT.GRANTS))
                .from(STUDENT)
                .fetchOne(0, BigDecimal.class);
    }

    public BigDecimal avgVal() {
        return context.select(DSL.avg(STUDENT.GRANTS))
                .from(STUDENT)
                .fetchOne(0, BigDecimal.class);
    }
}
