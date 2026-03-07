Use Case 2: Room Search & Availability Check
Key Data Structures

HashMap<String, Integer>
HashMap<String, Double>
Key Concepts

Read-only access
Defensive checks
Availability validation
Key Requirements

Display available room types
Show pricing and amenities
Prevent booking unavailable rooms
Goal

Allow guests to search rooms without altering inventory.

Actors

Guest, Search Service

Flow

Search request → HashMap lookup → Filter available rooms → Display
