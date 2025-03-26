Library Management System
Overview
This is a Spring Boot-based Library Management System that enables librarians to efficiently add, update, search, and remove books while maintaining their availability status.
Features
•	Add a Book: Accepts Book ID, Title, Author, Genre, and Availability Status as input and stores the book details.
•	View All Books: Displays a list of all books with their details.
•	Search Book by ID or Title: Allows searching for a book using its ID or title.
•	Update Book Details: Modify book details such as availability status, title, or author.
•	Delete a Book Record: Removes a book from the catalog.
Technologies Used
•	Java 21
•	Spring Boot 3.5.3
•	Spring Data JPA
•	H2 Database (In-memory database for testing)
•	Maven/Gradle
•	Lombok
•	Spring Boot Validation
Setup Instructions
Prerequisites
Ensure you have the following installed:
•	JDK 21
•	Maven or Gradle
•	Postman or cURL (for testing APIs)
Clone the Repository
git clone <repository-url>
cd library-management-system
Build and Run the Application
Using Maven:
mvn spring-boot:run
Using Gradle:
gradle bootRun
API Endpoints
Method	Endpoint	Description
POST	/api/books	Add a new book
GET	/api/books	Get all books
GET	/api/books/{id}	Get a book by ID
PUT	/api/books/{id}	Update book details
DELETE	/api/books/{id}	Delete a book
Example API Usage
Add a Book
curl -X POST http://localhost:8080/api/books \
     -H "Content-Type: application/json" \
     -d '{"title":"Book Title","author":"Author Name","genre":"Fiction","availabilityStatus":"AVAILABLE"}'
Get All Books
curl -X GET http://localhost:8080/api/books
Search by ID
curl -X GET http://localhost:8080/api/books/1
Update a Book
curl -X PUT http://localhost:8080/api/books/1 \
     -H "Content-Type: application/json" \
     -d '{"title":"Updated Title","author":"Updated Author","genre":"Non-Fiction","availabilityStatus":"CHECKED_OUT"}'
Delete a Book
curl -X DELETE http://localhost:8080/api/books/1
Assumptions
•	Book IDs are auto-generated.
•	Availability status can be either AVAILABLE or CHECKED_OUT.
•	Title and Author fields are required.
Challenges and Improvements
Challenges Faced
•	Ensuring data integrity with unique Book IDs.
•	Handling request validation effectively.
Future Improvements
•	Implement a front-end UI using React.
•	Add user authentication and authorization.
•	Store data in a MySQL/PostgreSQL database.
License
This project is licensed under the MIT License.

