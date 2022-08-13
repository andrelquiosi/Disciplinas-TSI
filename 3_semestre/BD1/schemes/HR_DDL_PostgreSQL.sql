SHOW SEARCH_PATH;

-- DROP TABLES
DROP TABLE IF EXISTS JOB_HISTORY CASCADE;
DROP TABLE IF EXISTS EMPLOYEES CASCADE;
DROP TABLE IF EXISTS DEPARTMENTS CASCADE;
DROP TABLE IF EXISTS LOCATIONS CASCADE;
DROP TABLE IF EXISTS JOBS CASCADE;
DROP TABLE IF EXISTS COUNTRIES CASCADE;
DROP TABLE IF EXISTS REGIONS CASCADE;


CREATE TABLE IF NOT EXISTS REGIONS (
    REGION_ID SMALLINT NOT NULL,
    REGION_NAME VARCHAR(25)
);
COMMENT ON TABLE REGIONS IS 'Regions table that contains specific localization of a specific country. Contains 4 rows; references with the countries table.';
COMMENT ON COLUMN REGIONS.REGION_ID IS 'Primary key of regions table.';
COMMENT ON COLUMN REGIONS.REGION_NAME IS 'Name of an region country.';
ALTER TABLE REGIONS ADD CONSTRAINT REG_ID_PK PRIMARY KEY (REGION_ID);


CREATE TABLE IF NOT EXISTS COUNTRIES (
    COUNTRY_ID CHAR(2)  NOT NULL,
    COUNTRY_NAME VARCHAR(40),
    REGION_ID SMALLINT
);
COMMENT ON TABLE COUNTRIES IS 'Country table. Contains 25 rows. References with locations table.';
COMMENT ON COLUMN COUNTRIES.COUNTRY_ID IS 'Primary key of countries table.';
COMMENT ON COLUMN COUNTRIES.COUNTRY_NAME IS 'Country name';
COMMENT ON COLUMN COUNTRIES.REGION_ID IS 'Region ID for the country. Foreign key to region_id column in the departments table.';
ALTER TABLE COUNTRIES ADD CONSTRAINT COUNTRY_C_ID_PK PRIMARY KEY (COUNTRY_ID);


CREATE TABLE IF NOT EXISTS JOBS (
    JOB_ID CHAR(10) NOT NULL,
    JOB_TITLE VARCHAR(35) NOT NULL,
    MIN_SALARY NUMERIC(8,2),
    MAX_SALARY NUMERIC(8,2)
);
COMMENT ON TABLE JOBS IS 'Jobs table with job titles and salary ranges. Contains 19 rows. References with employees and job_history table.';
COMMENT ON COLUMN JOBS.JOB_ID IS 'Primary key of jobs table.';
COMMENT ON COLUMN JOBS.JOB_TITLE IS 'A not null column that shows job title, e.g. AD_VP, FI_ACCOUNTANT';
COMMENT ON COLUMN JOBS.MIN_SALARY IS 'Minimum salary for a job title.';
COMMENT ON COLUMN JOBS.MAX_SALARY IS 'Maximum salary for a job title';
ALTER TABLE JOBS ADD CONSTRAINT JOB_ID_PK PRIMARY KEY (JOB_ID);


CREATE TABLE IF NOT EXISTS LOCATIONS (
    LOCATION_ID SMALLINT NOT NULL,
    STREET_ADDRESS VARCHAR(40),
    POSTAL_CODE VARCHAR(12),
    CITY VARCHAR(30) NOT NULL,
    STATE_PROVINCE VARCHAR(25),
    COUNTRY_ID CHAR(2)
);
COMMENT ON TABLE LOCATIONS IS 'Locations table that contains specific address of a specific office, warehouse, and/or production site of a company. Does not store addresses / locations of customers. Contains 23 rows; references with the departments and countries tables.';
COMMENT ON COLUMN LOCATIONS.LOCATION_ID IS 'Primary key of locations table';
COMMENT ON COLUMN LOCATIONS.STREET_ADDRESS IS 'Street address of an office, warehouse, or production site of a company. Contains building number and street name';
COMMENT ON COLUMN LOCATIONS.POSTAL_CODE IS 'Postal code of the location of an office, warehouse, or production site of a company.';
COMMENT ON COLUMN LOCATIONS.CITY IS 'A not null column that shows city where an office, warehouse, or production site of a company is located.';
COMMENT ON COLUMN LOCATIONS.STATE_PROVINCE IS 'State or Province where an office, warehouse, or production site of a company is located.';
COMMENT ON COLUMN LOCATIONS.COUNTRY_ID IS 'Country where an office, warehouse, or production site of a company is located. Foreign key to country_id column of the countries table.';
ALTER TABLE LOCATIONS ADD CONSTRAINT LOC_ID_PK PRIMARY KEY (LOCATION_ID);


CREATE TABLE IF NOT EXISTS DEPARTMENTS (
    DEPARTMENT_ID SMALLINT NOT NULL,
    DEPARTMENT_NAME VARCHAR(30) NOT NULL,
    MANAGER_ID INTEGER,
    LOCATION_ID SMALLINT
);
COMMENT ON TABLE DEPARTMENTS IS 'Departments table that shows details of departments where employees work. Contains 27 rows; references with locations, employees, and job_history tables.';
COMMENT ON COLUMN DEPARTMENTS.DEPARTMENT_ID IS 'Primary key column of departments table.';
COMMENT ON COLUMN DEPARTMENTS.DEPARTMENT_NAME IS 'A not null column that shows name of a department. Administration, Marketing, Purchasing, Human Resources, Shipping, IT, Executive, Public Relations, Sales, Finance, and Accounting.';
COMMENT ON COLUMN DEPARTMENTS.MANAGER_ID IS 'Manager_id of a department. Foreign key to employee_id column of employees table. The manager_id column of the employee table references this column.';
COMMENT ON COLUMN DEPARTMENTS.LOCATION_ID IS 'Location id where a department is located. Foreign key to location_id column of locations table.';
ALTER TABLE DEPARTMENTS ADD CONSTRAINT DEPT_ID_PK PRIMARY KEY (DEPARTMENT_ID);


CREATE TABLE IF NOT EXISTS EMPLOYEES (
    EMPLOYEE_ID INTEGER NOT NULL,
    FIRST_NAME VARCHAR(20),
    LAST_NAME VARCHAR(25) NOT NULL,
    EMAIL VARCHAR(25) NOT NULL,
    PHONE_NUMBER VARCHAR(20),
    HIRE_DATE DATE NOT NULL,
    JOB_ID CHAR(10) NOT NULL,
    SALARY NUMERIC(8,2),
    COMMISSION_PCT NUMERIC(2,2),
    MANAGER_ID INTEGER,
    DEPARTMENT_ID SMALLINT
);
COMMENT ON TABLE EMPLOYEES IS 'Employees table. Contains 107 rows. References with departments, jobs, job_history tables. Contains a self reference.';
COMMENT ON COLUMN EMPLOYEES.EMPLOYEE_ID IS 'Primary key of employees table.';
COMMENT ON COLUMN EMPLOYEES.FIRST_NAME IS 'First name of the employee. A not null column.';
COMMENT ON COLUMN EMPLOYEES.LAST_NAME IS 'Last name of the employee. A not null column.';
COMMENT ON COLUMN EMPLOYEES.EMAIL IS 'Email id of the employee';
COMMENT ON COLUMN EMPLOYEES.PHONE_NUMBER IS 'Phone number of the employee; includes country code and area code';
COMMENT ON COLUMN EMPLOYEES.HIRE_DATE IS 'Date when the employee started on this job. A not null column.';
COMMENT ON COLUMN EMPLOYEES.JOB_ID IS 'Current job of the employee; foreign key to job_id column of the jobs table. A not null column.';
COMMENT ON COLUMN EMPLOYEES.SALARY IS 'Monthly salary of the employee. Must be greater than zero (enforced by constraint emp_salary_min)';
COMMENT ON COLUMN EMPLOYEES.COMMISSION_PCT IS 'Commission percentage of the employee; Only employees in sales department elgible for commission percentage';
COMMENT ON COLUMN EMPLOYEES.MANAGER_ID IS 'Manager id of the employee; has same domain as manager_id in departments table. Foreign key to employee_id column of employees table. (useful for reflexive joins and CONNECT BY query)';
COMMENT ON COLUMN EMPLOYEES.DEPARTMENT_ID IS 'Department id where employee works; foreign key to department_id column of the departments table';
ALTER TABLE EMPLOYEES ADD CONSTRAINT EMP_EMP_ID_PK PRIMARY KEY (EMPLOYEE_ID);
ALTER TABLE EMPLOYEES ADD CONSTRAINT EMP_EMAIL_UK UNIQUE (EMAIL);
ALTER TABLE EMPLOYEES ADD CONSTRAINT EMP_SALARY_MIN CHECK (SALARY>0);


CREATE TABLE IF NOT EXISTS JOB_HISTORY (
    EMPLOYEE_ID INTEGER NOT NULL,
    START_DATE DATE NOT NULL,
    END_DATE DATE NOT NULL,
    JOB_ID CHAR(10) NOT NULL,
    DEPARTMENT_ID SMALLINT
);
COMMENT ON TABLE JOB_HISTORY IS 'Table that stores job history of the employees. If an employee changes departments within the job or changes jobs within the department, new rows get inserted into this table with old job information of the employee. Contains a complex primary key: employee_id+start_date. Contains 25 rows. References with jobs, employees, and departments tables.';
COMMENT ON COLUMN JOB_HISTORY.EMPLOYEE_ID IS 'A not null column in the complex primary key employee_id+start_date. Foreign key to employee_id column of the employee table';
COMMENT ON COLUMN JOB_HISTORY.START_DATE IS 'A not null column in the complex primary key employee_id+start_date. Must be less than the end_date of the job_history table. (enforced by constraint jhist_date_interval)';
COMMENT ON COLUMN JOB_HISTORY.END_DATE IS 'Last day of the employee in this job role. A not null column. Must be greater than the start_date of the job_history table.(enforced by constraint jhist_date_interval)';
COMMENT ON COLUMN JOB_HISTORY.JOB_ID IS 'Job role in which the employee worked in the past; foreign key to job_id column in the jobs table. A not null column.';
COMMENT ON COLUMN JOB_HISTORY.DEPARTMENT_ID IS 'Department id in which the employee worked in the past; foreign key to deparment_id column in the departments table';
ALTER TABLE JOB_HISTORY ADD CONSTRAINT JHIST_EMP_ID_ST_DATE_PK PRIMARY KEY (EMPLOYEE_ID,START_DATE);
ALTER TABLE JOB_HISTORY ADD CONSTRAINT JHIST_DATE_INTERVAL CHECK (END_DATE > START_DATE);
