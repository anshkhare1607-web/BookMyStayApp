Use Case 3: Booking Request (First-Come-First-Served)
Key Data Structures

Queue<Reservation> (LinkedList)
Key Concepts

FIFO principle
Fair allocation
Request ordering
Key Requirements

Accept booking requests
Enforce arrival order
Handle high-traffic scenarios
Goal

Ensure booking fairness during peak demand.

Actors

Guest, Booking Queue Service

Flow

Booking request → Enqueue → Await processing

Key Benefits

Predictable booking order
No race conditions at the request level
Real-world fairness model
Limitations of the Previous Approach

Parallel requests → inconsistent allocations
