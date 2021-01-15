package ru.sevsu.rest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sevsu.db.tables.pojos.StudCourseLink;
import ru.sevsu.db.tables.records.StudCourseLinkRecord;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static ru.sevsu.db.Tables.STUDENT;
import static ru.sevsu.db.tables.StudCourseLink.STUD_COURSE_LINK;

@Service
@Slf4j
public class StudCourseService extends JooqAbstractService implements StudCourseImplService<StudCourseLink> {

    final String entity = "stud-course";

    public List<StudCourseLink> find() {
        return context.select()
                .from(STUD_COURSE_LINK)
                .fetch()
                .into(StudCourseLink.class);
    }

    @Override
    public Optional<StudCourseLink> findByName(String name) {
        return context.select()
                .from(STUDENT, STUD_COURSE_LINK)
                .where((STUDENT.FIO.equalIgnoreCase(name)).and(STUDENT.STUD_NUM.eq(STUD_COURSE_LINK.SCL_ID)))
                .fetchOptional(it -> it.into(StudCourseLink.class));
    }

    public Optional<StudCourseLink> findById (Integer id) {
        return context.select()
                .from(STUD_COURSE_LINK)
                .where(STUD_COURSE_LINK.SCL_ID.eq(id))
                .fetchOptional(it -> it.into(StudCourseLink.class));
    }

    public Integer getIdByStudId (Integer value) {

        Integer id = null;
        try {
            id = findById(value).map(StudCourseLink::getSclId)
                    .orElseThrow(() -> new Exception(format("Unable to load %s by name: %s", entity, value)));
        }catch (Exception ex) {
            ex.getMessage();
        }
        return id;
    }

    @Override
    public StudCourseLink create(StudCourseLink inputPojo) {

        inputPojo.setSclId(nextLongId().intValue());
        final StudCourseLinkRecord rec = context.newRecord(STUD_COURSE_LINK, inputPojo);
        final StudCourseLinkRecord inserted = context.insertInto(STUD_COURSE_LINK)
                .set(rec)
                .returning(STUD_COURSE_LINK.SCL_ID)
                .fetchOne();

        return inputPojo;
    }

    @Override
    public StudCourseLink update(StudCourseLink inputPojo) {
        return null;
    }

    @Override
    public void delete(Integer studName, Integer courseName) {
        try {
            context.delete(STUD_COURSE_LINK)
                    .where((STUD_COURSE_LINK.STUD_NUM.eq(studName)
                            .and(STUD_COURSE_LINK.COURSE_NUM.eq(courseName))))
                            .execute();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Integer count() {
        return context.selectCount()
                .from(STUD_COURSE_LINK)
                .fetchOne(0, int.class);
    }
}
