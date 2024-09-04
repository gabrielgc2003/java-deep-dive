# 1.Bank Simulator

## Overview
- A Java project to demonstrate concurrent programming concepts.
- Simulates a banking system with multiple clients performing operations on shared bank accounts.
- Focuses on synchronization to maintain data consistency in a multi-threaded environment.

## Project Structure
- **BankAccount:**
  - Represents a bank account with deposit, withdrawal, and balance inquiry methods.
  - Uses `synchronized` and `ReentrantLock` to ensure thread-safe access.

- **Client:**
  - Represents a bank client performing operations in separate threads.
  - Executes deposits and withdrawals on the `BankAccount`.

- **BankSimulator:**
  - Main class that initiates the simulation.
  - Sets up multiple clients and starts concurrent operations.

## Key Concepts
- **Threads and Concurrency:**
  - Multiple threads simulate clients accessing shared resources (bank accounts).

- **Synchronization:**
  - Utilizes `synchronized` methods and `ReentrantLock` for thread-safe operations.
  - Prevents race conditions and ensures data integrity.

- **Atomicity:**
  - Ensures operations like deposits and withdrawals are executed atomically.


# 2.Producer-Consumer System

## Overview
- A Java project designed to demonstrate the Producer-Consumer problem using concurrent queues.
- Models real-time data production and consumption.
- Showcases efficient inter-thread communication and synchronization using Java's concurrency utilities.

## Project Structure
- **Producer:**
  - Represents a producer thread that generates data and adds it to a concurrent queue.
  - Simulates data production at variable rates to demonstrate dynamic load handling.

- **Consumer:**
  - Represents a consumer thread that retrieves and processes data from the concurrent queue.
  - Handles varying consumption rates to showcase synchronization challenges.

- **Main Class:**
  - Sets up producers and consumers to operate concurrently.
  - Uses a `BlockingQueue` to coordinate data exchange between producers and consumers.

## Key Concepts
- **Inter-Thread Communication:**
  - Uses `BlockingQueue` (e.g., `ArrayBlockingQueue`, `LinkedBlockingQueue`) to manage data flow between producer and consumer threads.

- **Concurrency Control:**
  - Ensures thread-safe operations on the queue, preventing data corruption and ensuring that producers wait when the queue is full, and consumers wait when the queue is empty.

- **Blocking and Notification:**
  - Utilizes blocking mechanisms (`put` and `take` methods of `BlockingQueue`) to handle synchronization without explicit use of `wait` and `notify`.


# 3.Web Crawler Multithreaded

## Overview
- A Java project designed to implement a web crawler that extracts data from multiple websites in parallel.
- Demonstrates the use of multithreading to optimize I/O-bound tasks like HTTP requests and HTML parsing.
- Utilizes concurrent data structures and thread management to efficiently explore and gather web data.

## Project Structure
- **WebCrawler:**
  - Manages the overall crawling process.
  - Initializes and controls the pool of threads using `ExecutorService`.
  - Keeps track of visited URLs and coordinates the exploration of new links.

- **CrawlerTask:**
  - Represents the task executed by each thread.
  - Performs HTTP requests to fetch web pages and parses the HTML content to extract useful information.
  - Extracts links from pages and adds them to the queue of URLs to be visited.

- **Main Class:**
  - Sets up the web crawler, defining the starting URLs and the number of threads in the pool.
  - Initiates the crawling process and manages the lifecycle of the threads.

## Key Concepts
- **Multithreading:**
  - Uses `ExecutorService` to manage a pool of threads, allowing for concurrent execution of multiple crawling tasks.
  - Enhances the performance of the crawler by utilizing multiple threads to fetch and process web pages in parallel.

- **Concurrency in I/O:**
  - Optimizes HTTP requests and HTML parsing through concurrent execution, reducing overall runtime.
  - Ensures efficient handling of network latency and slow server responses.

- **Synchronization:**
  - Uses concurrent collections (e.g., `ConcurrentHashMap`, `BlockingQueue`) to manage shared data like URLs and crawled results.
  - Prevents race conditions and ensures threads do not access the same resources simultaneously, avoiding data corruption.
