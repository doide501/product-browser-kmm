# Product Browser App (Kotlin Multiplatform)

This project is a **Kotlin Multiplatform Mobile (KMM)** application built using **Compose Multiplatform**, targeting **Android and iOS**.

The app displays products from a public API and allows users to browse product listings and view product details.

---

# Business Requirements


The application allows users to:

• View a list of products with **title, price, rating, and thumbnail image**

• Tap a product to see **detailed product information**

• Search products using **API-based search**

• View product information including:
  - Title
  - Description
  - Brand
  - Price
  - Rating

---

# Technology Stack

- Kotlin Multiplatform Mobile (KMM)
- Compose Multiplatform
- Ktor Client (API calls)
- kotlinx.serialization (JSON parsing)
- StateFlow (state management)
- Clean Architecture

---

# Project Architecture

The project follows **Clean Architecture** with three main layers:

### Layer Responsibilities

**Data Layer**
- Handles API communication using Ktor
- Maps DTO models to domain models

**Domain Layer**
- Contains business logic
- Includes use cases such as:
    - `GetProducts`
    - `SearchProducts`

**Presentation Layer**
- Built using Compose Multiplatform
- Displays UI screens
- Uses `StateFlow` for state management

---

# Application Features

✔ Product List Screen  
✔ Product Detail Screen  
✔ Product Search  
✔ API Integration using Ktor  
✔ Image loading using Coil  
✔ Navigation between screens  
✔ Loading & error states

---

# API Used

Public API:

https://dummyjson.com/products

Search API:

https://dummyjson.com/products/search?q=

---

# How to Run the Project

## Android

1. Open the project in **Android Studio**
2. Sync Gradle
3. Run the app using an **Android Emulator or Device**

---

## iOS

1. Open the project in **Xcode**
2. Select the **iosApp** module
3. Run on an iOS simulator

Note: iOS builds require **macOS with Xcode installed**.

---

# Trade-offs & Assumptions

• Dependency Injection was implemented manually for simplicity.

• Image loading uses **Coil**, which currently runs on Android.

• The project focuses on **demonstrating architecture and API integration** rather than full production UI.

• Error handling is implemented at a basic level.

---

# Future Improvements

• Add dependency injection using **Koin or Hilt**

• Implement **offline caching**

• Improve UI with advanced Compose components

• Add **unit tests for more use cases**

---

# Screens

Product List Screen  
Product Detail Screen

---

# Author

Ashish Sharma 
ashish48608@gmail.com

