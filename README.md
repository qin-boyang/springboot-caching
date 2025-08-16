# Simple Spring Boot Caching Demo with ConcurrentHashMap

![Java](https://img.shields.io/badge/Java-24%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![License](https://img.shields.io/badge/License-MIT-yellow)

A minimal demonstration of Spring Boot's in-memory caching using ConcurrentHashMap.

## Overview

This project showcases how to implement basic caching in a Spring Boot application using:
- Spring's built-in cache abstraction
- ConcurrentHashMap as the cache store
- Simple caching annotations (`@Cacheable`)

## Features

- Zero external dependencies (uses Spring's default cache implementation)
- Demonstrates cache hit/miss behavior
- Simulates expensive computations to highlight caching benefits
- Ready-to-run with minimal setup

## Prerequisites

- Java 24 or higher
- Maven 3.9+ or Gradle 7.x
- Spring Boot 3.x

## Getting Started

### 1. Build and run

```bash
mvn spring-boot:run
```

### 2. Test the endpoints

#### Calculate square of a number (cached)
```bash
curl http://localhost:8080/square/5
```

Example responses:
- First call (cache miss):
  ```
  Square of 5.00 is 25.00 (took 2003 ms)
  ```
- Subsequent calls (cache hit):
  ```
  Square of 5.00 is 25.00 (took 0 ms)
  ```

#### Clear Cache
```bash
curl http://localhost:8080/square/clearcache
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── cachedemo/
│   │               ├── SimpleCacheDemoApplication.java  # Main app class
│   │               ├── controller/
│   │               │   └── MathController.java         # REST endpoints
│   │               └── service/
│   │                   └── MathService.java            # Cached service
├── resources/
│   └── application.properties                          # Empty in basic demo
```

## How It Works

1. **Caching Setup**:
    - `@EnableCaching` activates Spring's caching infrastructure
    - By default, Spring uses ConcurrentHashMap as the cache store

2. **Cache Behavior**:
    - `@Cacheable("squareCache")` marks the method as cacheable
    - First call computes and stores the result
    - Subsequent calls with same parameter return cached result

3. **Performance Simulation**:
    - Artificial 2-second delay simulates expensive computation
    - Clear demonstration of cache benefits

4. **Clear Cache**:
    - `@CacheEvict` clear all keys in `squareCache`

## Customization

To modify the behavior:

1. Change cache name in `@Cacheable` annotation
2. Adjust the simulated delay in `MathService.java`
3. Add more methods with different caching strategies

## Switching to Redis

To upgrade to Redis caching:
1. Add Redis dependencies
2. Configure Redis connection in `application.properties`
3. (Optional) Add custom cache configuration

See the [Redis branch](https://github.com/yourusername/spring-boot-cache-demo/tree/redis) for implementation.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Spring Boot documentation
- [Caching with Spring](https://spring.io/guides/gs/caching/) guide