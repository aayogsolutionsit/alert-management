alert-management API

# Contact Management System

A Spring Boot application for managing contacts with CRUD operations.

## Features
- Create, Read, Update, Delete contacts
- Search by email domain
- Search by birth year range

## Tech Stack
- Java 17
- Spring Boot 3.4.2
- PostgreSQL
- Maven

## Setup
1. Clone repository
2. Create PostgreSQL database named "contacts"
3. Update application.properties with database credentials
4. Run application

## API Endpoints
- POST /api/contacts/save - Create contact
- GET /api/contacts - Get all contacts
- GET /api/contacts/{id} - Get contact by ID
- PUT /api/contacts/{id} - Update contact
- DELETE /api/contacts/{id} - Delete contact
