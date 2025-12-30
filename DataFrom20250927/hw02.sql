-- a.
SELECT T.teacher_id,
       T.teacher_name,
       COUNT(S.course_segment_id) AS course_count
FROM Teacher T
LEFT JOIN Teaches S ON T.teacher_id = S.teacher_id
GROUP BY T.teacher_id, T.teacher_name;

-- b.
SELECT T.teacher_id,
       T.teacher_name,
       (
         SELECT COUNT(*)
         FROM Teaches S
         WHERE S.teacher_id = T.teacher_id
       ) AS course_count
FROM Teacher T;

-- c.
SELECT C.course_name,
       COALESCE(T.teacher_name, '—') AS teacher_name
FROM CourseSegment C
LEFT JOIN Teaches S ON C.course_segment_id = S.course_segment_id
LEFT JOIN Teacher T ON S.teacher_id = T.teacher_id
WHERE C.year = 2010 AND C.term = 'Spring';

-- d.
SELECT D.dept_id,
       D.dept_name,
       COUNT(T.teacher_id) AS teacher_count
FROM Department D
LEFT JOIN Teacher T ON D.dept_id = T.dept_id
GROUP BY D.dept_id, D.dept_name;
