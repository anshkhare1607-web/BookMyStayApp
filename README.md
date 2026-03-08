Use Case 4: Reservation Confirmation & Room Allocation
Key Data Structures

Set<String> (HashSet) – booked room IDs
HashMap<String, Set<String>> – room type → assigned rooms
Key Concepts

Uniqueness enforcement
Duplicate prevention
Atomic allocation (logical)
Key Requirements

Assign a unique room ID
Prevent reuse of room IDs
Update availability immediately
Goal

Guarantee zero double-booking.

Actors

Booking Service, Inventory Service

Flow

Dequeue request → Assign room ID → Add to Set → Decrement count

Key Benefits

Strong booking integrity
Instant inventory sync
Conflict-free allocations
Limitations of the Previous Approach
Room overlap → guest dissatisfaction
