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
(like stars, victories, objective, etc.). After doing the same thing with 
the wild units, creating the trait (and an abstract class implements the common behaviour) and three classes each one representing a type of wild unit available, then I realized there was some common behaviour
between these entities ,so I created a new trait called GameUnits, that would hold the behaviour of the PlayerCharacter and WildUnit classes, also then I
created an abstractGameUnit, that would implement this common behaviour for the game units. After doing this, I went back and updated the tests, making one separately for each game unit (similar to the 
panels), to make sure they're correctly testing this new structure.

Lastly, regarding the Norma, I wanted to represent each level of norma with a different class (normaLevel1, normaLevel2, ..., normaLevel6), this for a better implementation
of Object-Oriented Programing, so each level of norma is responsible for checking the requirements for leveling up, so I created test for all the norma levels, to test if they were
able to check the requirements and also a test to check if every norma level can return and int that will tell the level that the norma level represents, this would
be useful, for example, in the effects of the panels. Then I implemented said functionalities, creating a trait called Norma, an abstract norma to implement the norma behaviour
and the classes of the norma levels themselves. Finally, I created a last test for a normaList, class that I wanted to represent a list with all the norma levels, with the
first one being the starting level and the last one the winning one, and
be able to return any normaLevel next level and check if a level is the last one in the list, so I made a tests for this as well to implement it later.

## Tarea 2
For this assignment, the first thing to do was to create new getters and setter for the attributes of the basic entities, for this, first I updated the tests for the Game Units
to then implement this new getters and setters(for vars) to then go and update the last assignment with this new features. Thanks to this new feature it was now possible to 
update the privacy of the attributes of all entities, making them private to not permit direct access to them. Finally, for this, it was necessary a big 
refactor in the hierarchy of the basic entities, now some of the abstract classes receive parameters in their constructors, these are the attributes that will now be
private in the respective classes.

Next up, it was time to implement some combat methods, so the game units can attack, defend and evade. For this, I saw necessary to add a new kind of "entity", the
Combat Stance (this way the code is made more extensible, adding a new response to an attack should be easy), this would be a new attribute for the game units and the one in charge of deciding what a unit should do when receiving an attack, making use of multiple  
dispatch. Units are now able to defend an attack or try to avoid it.

Then, I worked in the drops of the units, for the victories I created new methods for the units that gives a different number of victories depending on what type of 
game unit is giving victories (PlayerCharacter or WildUnit) to then use these methods with double dispatch in a new one for the players that allows them to win victories. 
I went for a similar approach for the stars, just that this time every class (player, chicken, robo ball and seagull) has a unique form of dropping stars, and then used these 
methods for a new method for the units, that using double dispatch, allows units to get stars.

The last big part of this assigment was to implement the most complex effect between the panels, HomePanel's normaCheck, for this I decided to create a new entity 
the objectives, this would be similar to a CombatStance, they are a new attribute of a player and the responsible for calling the right method of a norma level to 
check if a player meets the requirements to level up their normaLevel depending on what kind of objective they were (this also add extensibility to the implementation). 
The effect of a Home Panel now works with every entity being responsible for itself.

Finally, I added a new little interface, clonableEntity, meant to be used in those game entities whose attributes would be directly accessible via the getter. And then I 
worked in testing and adding some exceptions for names of units and board position.

## Tarea 3

The general objective for this assignment was the implementation of a Controller for the game, so the first thing I did was to recognize and model which were the states necessary for the game
to work and the possible transitions between them. The next diagram is the result of this first approach to the game controller:

### State Diagram:
![Diagrama de estados](/docs/state_diagram.PNG)

After this, the first thing I did was to implement the basic behaviour of the transitions of the states, so I created a class Game Controller which stores the current state of the game, 
states that are also new classes, there is a State for every state possible in the game. Then I made the controller, by delegating responsibilities to the state, able to transition between any pair of state,
raising an exception for invalid transition for the ones that were not described in the diagram, this way the game flow can be simulated with the
**State** design Pattern.

For Further development of the Game Controller it was now necessary to create a basic board, it was here when I
decided to use the **Singleton** design patter for the Game Controller and the Game Board, because for every game it is necessary to have a one an only instance of each of these classes and this way I can make sure of
it. Having now the basic transitions and a board for the game, it was now possible to do the real implementation for every transition of the game controller, 
for this many new variables were created in the GameController class to store useful information of the game, like the order of the players, the current chapter, the winner of the game, etc. All of this was possible using all the implementation 
made for past assignments. In this phase of development
many transitions that came from the same game state were 'refactored' into one, so this way the controller was able to choose a transition based on the information previously mentioned.

Finally, I wanted to revisit and improve the implementation of some of the entities of the game, I changed the way a PlayerCharacter change its norma, the way this was done before the change was that the player received the new 
norma level and directly change it, I replaced this using the **Factory** design patter, adding a new hierarchy of NormaFactories and changing the way a player sets its norma to now use this new way of creating normas. Also, I modified the way the game
interprets a Norma Level 6, due to the fact that this is the last of the norma levels, a player having it makes them automatically the winner of the game, so logically this norma level will never be 'norma checked' or used for any calculation, 
so I ended up making the norma level 6 the NullNorma (applying the **Null Object** design pattern), and with the **Observer** pattern, with the players as the subjects and the game controller their observer, it was now possible to recognize this 'null' 
behaviour so any player could notify the game controller if it has won the game, giving the controller a way of deciding when to end a game.

<div style="text-align:center;">
    <img src="https://i.creativecommons.org/l/by/4.0/88x31.png" alt="Creative Commons License">
</div>

This project is licensed under the [Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).

---
