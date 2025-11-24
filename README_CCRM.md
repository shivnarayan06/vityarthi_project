## **Campus Course & Records Manager (CCRM)**

A console-based academic records system that manages students, courses, offerings, enrollments, grades, and GPA computation. Designed as a clean, administration-level implementation demonstrating modular design, layered architecture, and basic data-handling workflows.

────

## Overview

CCRM is a tool for managing the academic administration intended for small departments or institutional units that require a simple way to manage: 

    • Student information 
    • Course catalog 
    • Semester offerings 
    • Enrollments 
    • Grade recording 
    • GPA calculation 
    • Transcript-style reports

Everything runs purely in the console, with a structured service-layer architecture and in-memory repositories. The project demonstrates core principles of software design without relying on heavyweight databases or frameworks.

────

## Features

Student Management :

    • Addition of new students      
    • Updating academic details      
    • Viewing complete student list

Course Management : 

    • Add and register for courses with credits 
    • Create semester-wise offerings 
    • List and edit course catalog and offerings

Enrollment System:

    • Enroll students into offerings 
    • Validate offering capacity 
    • Assign and update grades 
    • Compute cumulative GPA
    • Transcript-style student record 
    • Enrollment listings per offering

────

## Architecture

The system uses a clear yet layered structure:

Presentation Layer • Console interface (CLIController) • Command-driven operations for all modules

Service Layer • Independent services for: • Students • Courses & offerings • Enrollments & grades • GPA computation

Repository Layer • In-memory storage for: • Students • Courses • Offerings • Enrollments

Each repository abstracts persistence, allowing easy future migration to a real database.

────

## Project Structure

│
├── src/
│   └── ccrm/
│       ├── model/
│       ├── dao/
│       ├── service/
│       ├── cli/
│       └── util/
│
├── statement.md
│
│
└── README.md

────

## Running the Project

Prerequisites:

Java 11 or higher installed

Terminal/Command Prompt access

Any text editor or IDE (VS Code, IntelliJ IDEA recommended)

────

Usage Guide

The console displays a numbered menu for all major operations:

\=== CCRM Menu ===

 \[1\] Register New Student

 \[2\] Display All Students

 \[3\] Register New Course

 \[4\] Display All Courses

 \[5\] Create Course Offering

 \[6\] Display All Offerings

 \[7\] Enroll Student in Course

 \[8\] Record Student Grade

 \[9\] Display Student Transcript

 \[0\] Exit Application

────

## Example Actions

Add a student

1 Student id: S101 Name: Shiv Narayan Prasad Email: shiv@example.com Program: BTech CSE Year: 2

Enroll a student

7 Enrollment id: E201 Student id: S101 Offering id: OFR-CSE2001-1

Generate transcript

9 Student id: S101

Key Concepts Demonstrated • Modular design • Encapsulation through services • Simple layered architecture • Data modeling (Student, Course, Offering, Enrollment) • Business rule validation (capacity, grading)

────

## Future Enhancements:

 • Replace in-memory HashMap with MySQL or PostgreSQL • Web interface (Express/React/JavaFX) • Build frontend with React for better UX • Authentication and role-based access • CSV import/export • Automated transcript PDF generation • Attendance or timetable modules • Backup and recovery system

────

## Author:

Developed as part of an academic project requirement to practice design thinking, framework collection and real-world system modeling.
