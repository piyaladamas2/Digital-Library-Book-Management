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
•	Java 17
•	Spring Boot 3.4.4
•	Spring Data JPA
•	MySql
•	Gradle
•	Lombok
•	Spring Boot Validation
•	Spring Boot Actuator provides a built-in /shutdown endpoint to terminate the application.
Setup Instructions
Prerequisites
Ensure you have the following installed:
•	JDK 21
•	Gradle
•	Postman or cURL (for testing APIs)
Clone the Repository
git clone <repository-url>
cd Digital-Library-Book-Managemen
Build and Run the Application

Using Gradle:
gradle bootRun
API Endpoints
Method	Endpoint	Description
POST	/books/add	Add a new book
GET	/books/all	Get all books
GET	/books/{id}	Get a book by ID
GET	/books/search	search a book by title
PUT	/books/update/{id}	Update book details
DELETE /books/delete/{id}	Delete a book
EXIT /books/exit  Exit application
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
•	Store data in a MySQL database.
License
This project is licensed under the MIT License.

