# BookMyStayApp

## Overview

BookMyStayApp is a Java console application for hotel room inventory management, customer booking requests, add-on service management, and booking history reporting. The application uses in-memory repositories and supports admin and customer workflows.

## Project Structure

- `bookmystay/src/com/main/Main.java` - application entry point
- `bookmystay/src/com/controller` - controllers for main menu, admin, and customer flows
- `bookmystay/src/com/service` - service interfaces and implementations for authentication, inventory, search, booking queue, add-ons, and reporting
- `bookmystay/src/com/repository` - in-memory data repositories for users, inventory, bookings, add-ons, and reporting
- `bookmystay/src/com/model` - domain models for users, reservations, roles, and add-on services
- `bookmystay/src/com/exception` - custom exceptions for authentication, room lookup, and duplicate users

## Features

Admin functions:
- add room types
- update room inventory counts
- update room prices
- view real-time availability
- view pending booking requests
- process booking requests
- generate booking history reports

Customer functions:
- search available rooms
- submit booking requests
- manage add-on services (breakfast, bar, cab)

## Requirements

- Java JDK 8 or later




