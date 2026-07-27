Decorator Pattern
https://youtu.be/GCraGHx6gso?si=26I6F5WrKoDA0PsQ 
Example: Starbuzz Coffee (from Head First Design Patterns)

1. DEFINITION

"The Decorator Pattern attaches additional responsibilities to an object
dynamically. Decorators provide a flexible alternative to subclassing for
extending functionality."

Key Design Principle Used:

The Open-Closed Principle (OCP): "Classes should be open for extension,
but closed for modification."

2. THE PROBLEM (Starbuzz Coffee)

Starbuzz Coffee has a base class called Beverage and various sub-classes like
HouseBlend, DarkRoast, Espresso, and Decaf.

Customers want to add condiments (milk, soy, mocha, whip).

Bad Approach 1 (Class Explosion): Creating a subclass for every combination
(e.g., EspressoWithMochaAndWhip, DecafWithDoubleMocha). This leads to an
infinite number of classes and a maintenance nightmare.

Bad Approach 2 (Fat Base Class): Putting boolean flags in the Beverage
base class (e.g., hasMilk(), hasMocha()) and calculating the cost there.
Why it fails:

Violates the Open-Closed Principle: Every time a new condiment is invented
(e.g., Caramel), you have to open the Beverage class and modify its code.

Doesn't handle multiples well (e.g., how do you represent "Double Mocha"?).

3. THE SOLUTION: DECORATOR PATTERN

Instead of inheritance to get behavior, we use composition to WRAP objects
inside other objects (decorators).

The trick: A Decorator both "IS-A" Component (via inheritance/interface) AND
"HAS-A" Component (via composition).

Steps for Starbuzz:

We start with a dark roast object.

The customer wants Mocha, so we create a Mocha object and wrap it around the
DarkRoast.

The customer wants Whip, so we create a Whip object and wrap it around the
Mocha.

To calculate the cost, we call cost() on the outermost wrapper (Whip).
Whip delegates to Mocha, Mocha delegates to DarkRoast, DarkRoast returns
its cost, Mocha adds its cost, and Whip adds its cost.

HOW IT WORKS IN PRACTICE (Conceptual Code)

// 1. Create the base beverage
Beverage myDrink = new Espresso();   // cost: $1.99

// 2. Wrap it in a Mocha
myDrink = new Mocha(myDrink);        // cost: 1.99 + 0.20 = $2.19

// 3. Wrap it in a Whip
myDrink = new Whip(myDrink);         // cost: 2.19 + 0.10 = $2.29

How Mocha's cost() method looks:
public double cost() {
return this.beverage.cost() + 0.20; // Delegates inward, then adds its own!
}

PROS AND CONS

PROS:

High flexibility; you can mix and match behaviors at runtime.

Avoids class explosion.

Follows the Open-Closed Principle perfectly.

CONS:

Can result in a design with lots of small objects that look alike, which
can be confusing for developers trying to debug.

Instantiating the component involves wrapping it in multiple decorators,
which can be tedious (often mitigated by using the Factory or Builder pattern
to handle the creation step).