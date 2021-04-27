# Tic Tac Toe
## Rules

The rules are described below :

- X always goes first.
- Players cannot play on a played position.
- Players alternate placing X’s and O’s on the board until either:
    - One player has three in a row, horizontally, vertically or diagonally
    - All nine squares are filled.
- If a player is able to draw three X’s or three O’s in a row, that player wins.
- If all nine squares are filled and neither player has three in a row, the game is a draw.

## Before you start

This project uses java 11.0.10 and maven 3.6.3

Make sure these are properly set up on your system.

Java:

    java -version
    java version "11.0.10" 2021-01-19 LTS
    
Maven:

    mvn -v
    Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)

## Compile and run

This is a command line application.

Compile and run this project using maven:

    mvn spring-boot:run -q

It will take a few seconds to start up

## Playing the game

You will be prompted to play your move by providing coordinates
    
       |   |   a
    ---+---+---
       |   |   b
    ---+---+---
       |   |   c
     0   1   2
    New game
    Please enter the coordinates :

You can enter any coordinate from a0 to c2.

Invalid inputs or already occupied squares will not be accepted.

## Unit tests
You can run the unit tests with maven:

    mvn test
