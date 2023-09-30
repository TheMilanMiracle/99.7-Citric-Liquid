# 99.7% Citric Liquid

## About

`99.7% Citric Liquid` is a simplified clone of the renowned game, `100% Orange Juice`. Its main
purpose is to serve as an educational tool, teaching foundational programming concepts.

📢 **Note**: This project is purely educational and will not be used for any commercial purposes.

---

## Tarea 1
The objective of this first assignment was to make the basic structure for the project, adding the necessary entities and their basic behaviour to be 
to establish interactions between these entities in future assignments.

Following the good practices from Test Driven Development, first I created tests for the basic capabilities that a Panel should have, after this I implemented the Panel trait and
abstract class to represent this general behavior and initial attributes. After this I created test for each type of panel: Neutral,Home, Bonus, Drop and Encounter; these would use the tests created to check the basic
behaviour of any panel, and an extra test to check that each panel's effect works correctly. Many of these tests required at least a basic structure of what a player character 
is, so I had to do tha as well (without test for the moment).

In order to complete the structure of a player characters I created tests for checking if their attributes were well initially set, if they were able to roll a dice and if they were able to change and return some of those attributes 
(like stars, victories, objective, etc). After doing the same thing with 
the wild units, creating the trait (and an abstract class implements the common behaviour) and three classes each one representing a type of wild unit available, then I realized there was some common behaviour
between these entities so I created a new trait called GameUnits, that would hold the behaviour of the PlayerCharacter and WildUnit classes, also then I
created an abstractGameUnit, that would implement this common behaviour for the game units. After doing this, I went back and updated the tests, making one separately for each game unit (similar to the 
panels), to make sure they're correctly testing this new structure.

Lastly, regarding the Norma, I wanted to represent each level of norma with a different class (normaLevel1, normaLevel2, ..., normaLevel6), this for a better implementation
of Object-Oriented Programing, so each level of norma is responsible for checking the requirements for leveling up, so I created test for all the norma levels, to test if they were
able to check the requirements and also a test to check if every norma level can return and int that will tell the level that the norma level represents, this would
be useful, for example, in the effects of the panels. Then I implemented said functionalities, creating a trait called Norma, an abstract norma to implement the norma behaviour
and the classes of the norma levels themselves. Finally, I created a last test for a normaList, class that I wanted to represent a list with all the norma levels, with the
first one being the starting level and the last one the winning one, and
be able to return any normaLevel next level and check if a level is the last one in the list, so I made a tests for this as well to implement it later.

##Tarea 2
For this assignment, the first thing to do was to create new getters and setter for the attributes of the basic entities, for this, first i updated the tests for the Game Units
to then implement this new getters and setters(for vars)

<div style="text-align:center;">
    <img src="https://i.creativecommons.org/l/by/4.0/88x31.png" alt="Creative Commons License">
</div>

This project is licensed under the [Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).

---