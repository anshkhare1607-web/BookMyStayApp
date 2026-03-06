Use Case 1: Room Inventory Setup & Management
Key Data Structures

HashMap<String, Integer> – Room type → available count
HashMap<String, Double> – Room type → price per night
Key Concepts

Fast lookup
Centralized inventory
Data consistency
Key Requirements

Initialize room types (Single, Double, Suite)
Store room counts and prices
Support dynamic inventory updates
Provide real-time availability status
Goal

Maintain a single source of truth for hotel room inventory.

Actors

Hotel Admin, Inventory Service

Flow

Add room type → Store in HashMap → Update count/price → Confirm

Key Benefits

O(1) inventory access
Clean separation of room data
Easy scalability for new room types
Limitations of the Previous Approach

Manual registers → inconsistent counts → overbooking
