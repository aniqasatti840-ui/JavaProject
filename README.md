# Murder Mystery Detective Game

## Overview

Murder Mystery Detective Game is a Java-based desktop application developed using Java Swing. In this game, the player takes the role of a detective and investigates a murder case by collecting clues, questioning suspects, and identifying the real killer.

The game randomly selects one suspect as the murderer, making each playthrough different and engaging.

---

## Features

- Detective-based investigation gameplay
- Randomly selected killer for each game session
- Multiple suspects with unique identities
- Clue collection system
- Interactive graphical user interface (GUI)
- Login screen and main menu
- Result screen displaying investigation outcome

---

## Project Structure

```text
Murder_Mystery_Detective_Game
│
└── src/game
    ├── Main.java
    ├── Loginframe.java
    ├── MainMenu.java
    ├── InvestigationFrame.java
    ├── ResultFrame.java
    ├── GameManager.java
    ├── Detective.java
    ├── Suspect.java
    ├── Clue.java
    ├── Butler.java
    ├── Wife.java
    ├── Friend.java
    └── BusinessPartner.java
```

---

## Main Components

### Main.java
Application entry point. Launches the login window using Java Swing.

### Loginframe.java
Handles player login and game startup.

### MainMenu.java
Displays the main menu and navigation options.

### InvestigationFrame.java
Provides the investigation interface where the detective interacts with suspects and gathers clues.

### ResultFrame.java
Displays the final result of the investigation.

### GameManager.java
Controls game logic including:

- Creating suspects
- Selecting the killer randomly
- Managing detective data
- Verifying accusations

### Detective.java
Represents the player character (detective).

### Suspect.java
Base class for all suspects in the game.

### Suspect Types

- Butler
- Wife
- Friend
- BusinessPartner

One of these suspects is randomly selected as the murderer at the beginning of the game.

### Clue.java
Stores and manages clues collected during the investigation.

---

## Game Flow

1. Start the application.
2. Login using the login screen.
3. Enter the main menu.
4. Begin the investigation.
5. Gather clues and question suspects.
6. Analyze the evidence.
7. Accuse a suspect.
8. View the final result.

---

## Technologies Used

- Java
- Java Swing
- Object-Oriented Programming (OOP)
- Event-Driven Programming

---

## OOP Concepts Implemented

- Classes and Objects
- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Constructor Usage
- Collections Framework (ArrayList)

---

## Requirements

- Java JDK 8 or above
- Any Java IDE (NetBeans, IntelliJ IDEA, Eclipse)

---

## How to Run

1. Open the project in your preferred Java IDE.
2. Compile all source files.
3. Run `Main.java`.
4. Login and start the investigation.

---
