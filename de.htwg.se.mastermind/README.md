# Mastermind

#For users

**1. What is it?**
This project is an implementation of the Mastermind game for the lecture **Software Engineering** at the University of Applied Science Constance, Germany.

**2. Rules of the game**
- There are 7 colors in the game
- The computer chooses 4 of them by chance (one color can be chosen multiple)
- These 4 colors are non visible for the user
- Goal of the game is to guess the colors, the computer had chosen, in the right order
- The user has a determine amount of steps to guess the colors
- After every round the user gets information about weather he has chosen a right color or not
- There a three types of information:
	a) The color he has chosen was also chosen by the computer and is on the right place
	   INFORMATION: black stone
	b) The color he has chosen was also chosen by the computer but is on the wrong place
	   INFORMATION: white stone
	c) The color he has chosen was not chosen by the computer
	   INFORMATION: no stone
- If the user guesses the right colors in the right order within the determine amount of steps he wins, if not, he loses!

**3. TUI/GUI**
The game can be played in a TUI and a GUI as well. Both UI's are scalable.
The TUI looks like that:

              +-------------+
              | xx xx xx xx |
+-------------+-------------+
|             |             |[6]
|             |             |[5]
|             |             |[4]
|             |             |[3]
|             |             |[2]
|             |             |[1]
|             |             |[0]
+-------------+-------------+
                [3][2][1][0]

- The "xx xx xx xx" are the 4 colors which the computer has chosen by chance. They are hided.
- The white box below is the game field where the user makes it's inputs.
                
**4. Play with the TUI**
- Available colors: yellow(yl), red(rd), blue(bl), green(gr), orange(or), pink(pk), purple(pu)
- To set a color on a position please enter the row and column followed by a color e.g. 00yl
- The color yellow (yl) will be set to the row [0] and column [0]:

              +-------------+
              | xx xx xx xx |
+-------------+-------------+
|             |             |[6]
|             |             |[5]
|             |             |[4]
|             |             |[3]
|             |             |[2]
|             |             |[1]
|             |          yl |[0]
+-------------+-------------+
                [3][2][1][0]
 
- After that the next color can be set               
- If you have one row filled, please enter **"c"** to confirm the row
- Now the next row can be filled with values
- If you type **"s"** the solution of the game will be appear
- To scale the game enter **"z"** followed by a 4,8 or 12 e.g. z4

              +-------------+
              | xx xx xx xx |
+-------------+-------------+
|             |             |[2]
|             |             |[1]
|             |             |[0]
+-------------+-------------+
                [3][2][1][0]

- To start a new game enter **"n"**
- To quit the game enter **"q"**              

#For developers

**1. Architecture & Co.**

Main goal of the application is to demonstrate the development of a software project in an agile development methodology.
The project is build with the **MVC-architecture**.

It shows 
* version control with git 
* test driven development (with junit)
* layered architecture
* metrics with sonar
* continuous integration with maven and jenkins
* patterns
* components and interfaces

The initial user interface is a console-based text UI. Its purpose is to be able to interact with the application as early as possible. 
The Tui is built in a way so that it continues to run in parallel with a GUI or WUI.

**2. Download project and import to IDE

- Please click the *Download ZIP*- button on the right side of this github repository and unpack the files
- Please make sure that you have installed java version 1.7 on your computer
- Run an IDE like eclipse or netbeans and import the project