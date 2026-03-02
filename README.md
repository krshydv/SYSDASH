# SYSDASH

SYSDASH is a system monitoring dashboard developed using Spring Boot. The purpose of this project is to monitor important system and application metrics in a simple and organized way through a web interface.

This project was built to understand how backend services can collect system-level data and present it visually for monitoring and analysis.

---

## Overview

Applications need continuous monitoring to ensure performance and stability. SYSDASH collects information such as CPU usage, memory usage, and database connection statistics and displays them on a dashboard.

The backend is developed using Java and Spring Boot, while the frontend is built using basic HTML, CSS, and JavaScript.

---

## Features

- CPU usage monitoring  
- Memory usage tracking  
- Database connection pool metrics  
- Application metrics overview  
- Log tracking support  
- Web-based dashboard interface  

---

## Technology Stack

Backend:
- Java  
- Spring Boot  
- Maven  

Frontend:
- HTML  
- CSS  
- JavaScript  

---

## Installation and Setup

1. Clone the repository:

```bash
git clone https://github.com/krshydv/SYSDASH.git
cd SYSDASH
```

2. Build the project:

```bash
mvn clean install
```

3. Run the application:

```bash
mvn spring-boot:run
```

Alternatively, you can run the generated JAR file:

```bash
java -jar target/sysdash-0.0.1-SNAPSHOT.jar
```

---

## Accessing the Application

Once the application is running, open your browser and go to:

```
http://localhost:8080
```

---

## Future Improvements

- Adding real-time updates  
- Implementing authentication  
- Supporting cloud-based monitoring  
- Exporting metrics in different formats  

---

## Author

Krish Yadav  
B.Tech Computer Science Engineering  

---

## License

This project is created for academic and learning purposes. new
