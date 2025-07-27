# BankManagementSystem

💳 Bank Management System (Java + Swing + MySQL)

This is a Bank Management System built using Java Swing for GUI and MySQL as the backend database. It allows management of customers, staff and account balance.

📌 Features

- 🔐 Staff Login System
- 👤 Add, View, Update, Delete Customers
- 🧑‍💼 Add, View, Delete Staff
- 💰 Deposit Money
- 📈 Check Customer Balance
- 📋 GUI Table to View Records

🛠️ Technologies & Concepts Used

| Technology         | Purpose                          |
|--------------------|----------------------------------|
| Java Swing         | For creating graphical interface |
| JDBC               | Database connectivity            |
| MySQL              | Backend database                 |
| OOP Concepts       | Encapsulation, classes & objects |
| Exception Handling | To manage runtime errors safely  |
| Java Packages      | Code structure and modularity    |

🔧 How to Run

1. Clone this repository
   git clone https://github.com/your-username/bank-management-system.git
   cd bank-management-system

2. Import project into your IDE (e.g., Eclipse or IntelliJ)

3. Set up MySQL Database
   - Create a database (e.g., bank_db)
   - Import tables using provided SQL script (optional if you have one)

4. Edit DB Connection
   - Open DbConnection.java file and update:
     String url = "jdbc:mysql://localhost:3306/bank_db";
     String user = "your_mysql_user";
     String pass = "your_mysql_password";

5. Run the Project
   - Launch the main class (e.g., Main.java or Login.java)

📁 Folder Structure

src/
├── com.bms.db               # Database connection
├── com.bms.entity           # Entity classes (Customer, Staff)
├── com.bms.repository       # Logic for insert/update/delete/view
├── com.bms.ui               # GUI classes
├── Main.java                # Entry point

🙋‍♂️ Author

Rahul  
📍 Mandi, Himachal Pradesh  
📧 RC2292062@gmail.com  
🔗 https://www.linkedin.com/in/rahul7650/  
💻 https://github.com/rahul7640

📃 License

This project is open-source and free to use for educational purposes.
