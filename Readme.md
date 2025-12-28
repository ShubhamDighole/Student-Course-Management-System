Project Description

This project is a Java console-based application divided into three main sections:

1 tudent
This section manages student details. New students are added to the studentsList.
All operations such as viewing the complete list or searching for a specific student are performed using this list.
A StudentNotFoundException is thrown if the requested student is not found.

2. ourse
This section handles course management. Similar to the student functionality, all course-related operations are performed using the courseList.

3. Enrollment
This section manages student enrollments. Enrollments are stored in the enrollmentList.
A student can be enrolled in a course only if both the student and the course already exist.
The Status enum is used to represent the enrollment status.

Additionally, the project contains a UITexts final class that stores all constant texts and banners displayed in the application.