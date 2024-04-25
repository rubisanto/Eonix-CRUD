# User Service

This is a Spring Boot application that provides a RESTful API for managing users.

## Features

- Create a new user
- Get all users
- Get a user by ID
- Update a user
- Delete a user
- Custom search users by name

## Technologies Used

- Java
- Spring Boot
- Maven
- SQL

## Setup and Installation

1. Clone the repository: `git clone https://github.com/yourusername/userservice.git`
2. Navigate to the project directory: `cd userservice`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

## API Endpoints

- `GET /api/users`: Get all users
- `GET /api/users/{id}`: Get a user by ID
- `POST /api/users/create`: Create a new user
- `PUT /api/users/{id}/update`: Update a user
- `DELETE /api/users/{id}/delete`: Delete a user
- `GET /api/users/search={name}`: Custom search users by name

## Testing

Unit tests are written using JUnit and can be run with `mvn test`.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)