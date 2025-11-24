# Statement

## Project Title

Campus Course & Records Manager (CCRM)

## Problem Statement

Educational departments often struggle with scattered academic data management—student records are kept in spreadsheets, enrollment tracking is manual, GPA calculations are error-prone, and generating transcripts takes unnecessary time. This leads to duplicate entries, calculation error, and delayed processes. Small departments need a centralized, automated solution that handles core academic operations efficiently without requiring expensive enterprise systems.

## Scope

CCRM provides essential academic administration functionality through a console-based interface:
- Complete student profile management (registration, updates etc)
- Course catalog administration with credit hour tracking
- Semester-specific offering creation with instructor assignment and capacity limits
- Automated enrollment processing with real-time validation
- Grade recording with automatic GPA computation using 10-point scale
- Professional transcript generation with formatted output
- Data integrity validation to prevent orphaned records and capacity overflow

The system uses in-memory storage for simplicity, demonstrating clean architecture principles and making it suitable for departmental use or educational projects.

## Target Users

- **Department Coordinators** - Managing course offerings, tracking enrollments, monitoring capacities
- **Academic Staff & Faculty** - Recording grades, viewing enrollment lists, accessing student records
- **Administrative Personnel** - Registering students, maintaining records, generating transcripts for verification
- **College Administration** - Overseeing academic data, generating reports, ensuring data accuracy

## High-level Features

- **Student Management** - Add, update, search, and display student profiles with validation
- **Course Administration** - Register courses, create offerings, assign faculty, set capacity limits
- **Smart Enrollment** - Process enrollments with automatic student/offering validation and capacity checking
- **Grade & GPA System** - Record letter grades, automatic grade-to-point conversion, weighted GPA calculation
- **Transcript Generation** - Professional formatted academic transcripts with course history and cumulative GPA
- **Data Validation** - Prevent duplicate IDs, enforce capacity limits, validate data integrity across operations
- **Console Interface** - Intuitive menu-driven system with formatted output and clear error messages
