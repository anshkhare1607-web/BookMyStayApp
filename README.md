Use Case 5: Add-On Service Selection
Key Data Structures

Map<String, List<Service>> – reservation ID → services
Key Concepts

One-to-many mapping
Composition
Extensible service model
Key Requirements

Attach services (breakfast, spa, pickup)
Allow multiple services per booking
Calculate the additional cost
Goal

Enhance bookings with optional services.

Actors

Guest, Service Management Module

Flow

Select service → Add to List → Map to reservation ID

Key Benefits

Flexible service attachment
Clean reservation-service mapping
Easy future expansion
Limitations of the Previous Approach

Manual add-ons → billing errors
