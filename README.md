👨‍💻 Developer
Nand Kishor Yadav


## Getting Started
Welcome to sparkCharge ||


## ⚡ SparkCharge - Java Desktop Application

**SparkCharge** is a Java-based Electricity Billing System desktop application. It provides an interface for managing customer records, meter information, billing details, and administrative functions.

## 📦 Project Structure

This project is packaged into a `.jar` file for easy execution on any Java-supported system.

## 🚀 How to Run

### Requirements
- Java JDK 8 or later
- MySQL Workbench Database (configured with your credentials and schema)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/Nand9847/SparkCharge.git
   cd SparkCharge



🎯 Features
👨‍💼 Admin Module
Login with username/password

Add new customer with auto-generated meter number

Insert meter info (location, type, phase, billing type)

View/update/delete customer data

Add tax/rent values

Calculate and generate electricity bills

View and print deposit details

Utility tools (Notepad, Calculator)

👤 Customer Module
Login with meter number

View personal information and update details

Generate, view, and pay electricity bills

Utility tools (Notepad, Calculator)




🗂️ Database Design
Tables Used:
login, customer, meter_info, tax, rent, bill

Normalization: Up to 3NF

Keys:

Primary: meter_no, cost_per_unit

Foreign: Relationships between customer, bill, and meter_info




⚠️ Limitations
Desktop-only, no remote access

Requires technical knowledge to operate

No multi-language or journal/logging features




🙌 Conclusion
This project demonstrates a practical implementation of a desktop-based electricity billing system that significantly reduces manual work and improves operational efficiency for electricity boards and their consumers.




📜 License
This project is for educational purposes. Feel free to fork, modify, and share!






## GitHub repo link => https://github.com/Nand0027/SparkCharge.git
## Database code 

create Database Bill_Systems;
use Bill_Systems;

create table Signup(meter_no varchar(25), username varchar(25), name varchar(30), password varchar(30), usertype varchar(25));
select * from Signup;

create table new_customer(name varchar(30), meter_no varchar(30), address varchar(50), city varchar(30), state varchar(25),email varchar(40), phone_no varchar(15));
select * from new_customer;

create table meter_info(meter_number varchar(30), meter_location varchar(30), meter_type varchar(30), phase_code varchar(30), bill_type varchar(30), days varchar(10));
select * from meter_info;


create table tax(cost_per_unit varchar(20), meter_rent varchar(20), service_charge varchar(20), service_tax varchar(20), fixed_tax varchar(20));
select * from tax;
insert into tax values('10', '45', '20', '58', '18');


create table bill(meter_no varchar(20), month varchar(20), unit varchar(20), total_bill varchar(20), status varchar(20));
select * from bill;



## Screenshots or demo GIF?






