package ru.sevsu.rest.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;
import ru.sevsu.db.tables.pojos.Teacher;
import ru.sevsu.db.tables.records.TeacherRecord;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static ru.sevsu.db.Tables.TEACHER;

@Service
@Slf4j
public class TeacherService extends JooqAbstractService implements RootService<Teacher> {

        final String entity = "teacher";

        public List<Teacher> find() {
            return context.select()
                    .from(TEACHER)
                    .fetch()
                    .into(Teacher.class);
        }

        @Override
        public Optional<Teacher> findByName(String name) {
            return context.select()
                    .from(TEACHER)
                    .where(TEACHER.TEACHER_FIO.equalIgnoreCase(name))
                    .fetchOptional(it -> it.into(Teacher.class));
        }

        public Integer getIdByName(String name) {

            Integer id = null;

            try {
                id = findByName(name).map(Teacher::getTeacherNum)
                        .orElseThrow(() -> new Exception(format("Unable to load %s by name: %s", entity, name)));

            } catch (Exception ex) {
                ex.getMessage();
            }
            return id;
        }

        @Override
        public Teacher create(Teacher inputPojo) {

            inputPojo.setTeacherNum(nextLongId().intValue());
            final TeacherRecord rec = context.newRecord(TEACHER, inputPojo);
            final TeacherRecord inserted = context.insertInto(TEACHER)
                    .set(rec)
                    .returning(TEACHER.TEACHER_NUM)
                    .fetchOne();

            return inputPojo;
        }

        @Override
        public Teacher update(Teacher inputPojo) {

            inputPojo.setTeacherNum(getIdByName(inputPojo.getTeacherFio()));
            TeacherRecord rec = context.update(TEACHER)
                    .set(context.newRecord(TEACHER, inputPojo))
                    .where(TEACHER.TEACHER_FIO.equalIgnoreCase(inputPojo.getTeacherFio()))
                    .returning().fetchOne();

            return rec.map(it -> it.into(Teacher.class));
        }

        @Override
        public void delete(String name) {

            try {
                int count = context.delete(TEACHER)
                        .where(TEACHER.TEACHER_FIO.equalIgnoreCase(name))
                        .execute();
            } catch (Exception ex) {
                ex.getMessage();
            }
        }

        public Integer count() {
            return context.selectCount()
                    .from(TEACHER)
                    .fetchOne(0, int.class);
        }

}
