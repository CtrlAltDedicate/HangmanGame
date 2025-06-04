# Hangman Game – Java Swing Application

## Description
A Java Swing-based Hangman game created as part of a second-year Object-Oriented Programming (OOP) assignment. The game features user registration, login, scoring, and a leaderboard — all implemented without a database using in-memory data storage (`ArrayList<User>`).

This version of the game:
- Uses **Java Swing** for GUI
- Implements **user login and registration**
- Tracks scores and maintains a **leaderboard**
- Retrieves a **random word** from a simulated API
- Is implemented **without MySQL** (no database dependency)

## Features
- Graphical UI using Java Swing
- Register and login functionality
- Score tracking and top players leaderboard
- Random word guessing (first and last letter shown)
- Game over conditions: guessed or hanged (6 wrong attempts)

## Technologies
- Java 17+
- IntelliJ IDEA (recommended IDE)
- Swing (Java GUI library)

## Project Structure
```plaintext
.
├── Main.java
├── User.java
├── UserStorage.java
├── LoginFrame.java
├── RegisterFrame.java
├── GameFrame.java
├── WordFetcher.java
└── Hangman.java
