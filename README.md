# TechEasyTest

## Getting Started

1. **Clone the repository:**

```sh
git clone https://github.com/Dheeraj1326/TechEasyTest.git
```

2. **Build the Project:**

```
   mvn clean install
```

3. **Run the application:**

   ```sh
   mvn spring-boot:run
   ```

4. **Access the H2 console:**

   - URL: `http://localhost:9000/h2-console`
   - JDBC URL: `jdbc:h2:file:C:/Users/DELL/techeasy`
   - Username: `sa`
   - Password: (leave blank)

## API Endpoints

### Student API

- **Create Student**

  ```http
  POST localhost:9000/api/student/add-student
  ```

  ```json
  {
    "name": "Dhiraj v. Mukharjee",
    "address": "mahal Nagpur",
    "subject_ids": [1, 2, 3]
  }
  ```

- **Get All Students**

  ```http
  GET localhost:9000/api/student/list
  ```

### Subject API

- **Create Subject**

  ```http
  POST localhost:9000/api/subject/add-subject
  ```

  ```json
  {
    "name":"Science"
  }
  ```


- **Get All Subjects**

  ```http
  GET localhost:9000/api/subject/list
  ```

## Security

- This part is not created.

