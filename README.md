# CountriesInfo App

## Overview

This project is an Android application that follows the principles of Clean Code Architecture. This Project is solely developed to demonstrate Android skills.

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Setup](#setup)

## Features

- Clean Code Architecture
- Jetpack Compose for UI design
- SharedViewModel for data sharing between CountryList and CountryDetail screens
- MVVM (Model-View-ViewModel) pattern
- Dependency Injection with Hilt
- StateFlow for reactive UI updates
- Kotlin Coroutines for asynchronous operations
- SharedTransitionLayout for transition animation between two screens

## Architecture

This project is structured following the Clean Code Architecture principles, which separate concerns into different layers:

1. **Presentation Layer**: Contains UI-related components such as Composables, Themes and ViewModels.
2. **Domain Layer**: Contains business logic, use cases, and domain models.
3. **Data Layer**: Handles data management, including repositories and data sources (e.g., network).

### Presentation Layer

- **Compodable Screens**: Handle UI rendering and user interactions.
- **SharedViewModel**: A special ViewModel shared across multiple screens to share data.
- **Connectivity Observers**: Observe the device's internet connection.

### Domain Layer

- **Use Cases**: Encapsulate business logic and interact with repositories.
- **Domain Models**: Represent the core entities of the application.

### Data Layer

- **Repositories**: Provide a clean API for data access to the rest of the application.
- **Data Sources**: Handle data operations (e.g., network requests, database queries).

## Setup

### Prerequisites

- Android Studio (latest version)


