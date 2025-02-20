# Employees Salary Project

This Java program models a payroll system for different types of employees. It demonstrates object-oriented programming (OOP) principles such as inheritance, polymorphism, and abstraction by defining various employee types with unique payment structures.

How It Works

* Employee.java → Abstract base class defining common attributes (name, SSN, birthdate) and enforcing an earnings() method.

* BirthDate.java → Handles birthdate validation and formatting.

* Concrete Employee Classes:
  * SalariedEmployee.java → Employees with a fixed weekly salary.
  * HourlyEmployee.java → Employees paid per hour with overtime handling.
  * CommissionEmployee.java → Employees paid based on sales commission.
  * BasePlusCommissionEmployee.java → A commission-based employee with a fixed base salary.
  * PieceWorker.java → Employees paid per item produced.

* Main.java → Creates different employee objects, stores them in a list, and prints their details and salaries.

Features
- Multiple employee types with different payment structures
- Uses abstract classes and inheritance to define payroll logic
- Birthdate handling and special birthday bonus
- Dynamic employee creation and printing via polymorphism
