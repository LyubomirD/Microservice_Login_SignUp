# Microservice_Login_SignUp
This REST API microservice is designed to handle user registration and login
for our website. Currently, it supports two essential operations: GET and POST 
requests to interact with a PostgreSQL database.

- The GET method serves as a login validation process. It verifies whether users have 
registered and if their entered email and password are accurate for logging in.

- The POST method facilitates user registration. It performs thorough checks on the provided 
username, email, and password to ensure they meet valid and secure criteria, shielding 
against any potential malicious code.

In essence, this microservice's primary task revolves around managing user registration 
and login functionalities, effectively maintaining the security and integrity of our system.