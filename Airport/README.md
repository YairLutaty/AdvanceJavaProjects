# Airport Project

Overview

This Java program simulates an airport flight control system, where flights depart from one airport and land at another while managing runway availability. It utilizes multithreading to handle multiple flights concurrently.

How It Works:

* Airport.java: Manages airport operations, including takeoff and landing, while ensuring runway availability.

* Flight.java: Represents a flight as a thread, handling departure, transition, and landing.

* Main.java: Creates two airports (Barcelona and Berlin) and generates 10 random flights between them.

Features
- Multithreading: Each flight runs as an independent thread.
- Synchronized Runway Management: Ensures safe flight operations using wait() and notifyAll().
- Random Flight Generation: Assigns random flight numbers and routes dynamically.
