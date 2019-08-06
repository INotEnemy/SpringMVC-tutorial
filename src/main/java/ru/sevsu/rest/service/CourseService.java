package ru.sevsu.rest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sevsu.db.tables.pojos.Course;
import ru.sevsu.db.tables.records.CourseRecord;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static ru.sevsu.db.Tables.COURSE;

@Service
@Slf4j
public class CourseService extends JooqAbstractService implements RootService<Course>{

    final String entity = "course";

    public List<Course> find() {
        return context.select()
                .from(COURSE)
                .fetch()
                .into(Course.class);
    }

    @Autowired
    private TeacherService teacherService;

    @Override
    public Optional<Course> findByName(String name) {
        return context.select()
                .from(COURSE)
                .where(COURSE.COURSE_NAME.equalIgnoreCase(name))
                .fetchOptional(it -> it.into(Course.class));
    }

    public Integer getIdByName(String name) {

        Integer id = null;

        try {
            id = findByName(name).map(Course::getCourseNum)
                    .orElseThrow(() -> new Exception(format("Unable to load %s by name: %s", entity, name)));

        } catch (Exception ex) {
            ex.getMessage();
        }
        return id;
    }

    @Override
    public Course create(Course inputPojo) {
        inputPojo.setCourseNum(nextLongId().intValue());
        final CourseRecord rec = context.newRecord(COURSE, inputPojo);
        final CourseRecord inserted = context.insertInto(COURSE)
                .set(rec)
                .returning(COURSE.COURSE_NUM)
                .fetchOne();

        return inputPojo;
    }

    @Override
    public Course update(Course inputPojo) {

        inputPojo.setCourseNum(getIdByName(inputPojo.getCourseName()));
        CourseRecord rec = context.update(COURSE)
                .set(context.newRecord(COURSE, inputPojo))
                .where(COURSE.COURSE_NAME.equalIgnoreCase(inputPojo.getCourseName()))
                .returning().fetchOne();

        return rec.map(it -> it.into(Course.class));
    }

    @Override
    public void delete(String name) {

        try {
            int count = context.delete(COURSE)
                    .where(COURSE.COURSE_NAME.equalIgnoreCase(name))
                    .execute();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public Integer count() {
        return context.selectCount()
                .from(COURSE)
                .fetchOne(0, int.class);
    }

}
