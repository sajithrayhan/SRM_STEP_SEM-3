# Week 9 – Abstraction, Interfaces, Class vs Interface (Category C)

## Part B – Quiz answers

| Q | Answer | Why |
|---|--------|-----|
| 1 | C | Abstraction hides *how* an operation is done and exposes only *what* it does. |
| 2 | C | An abstract class cannot be instantiated directly. |
| 3 | B | The subclass must itself be declared abstract, otherwise compilation fails. |
| 4 | C | `private` methods can't be overridden, so they can never be abstract. |
| 5 | C | Interface fields are implicitly `public static final`. |
| 6 | C | A class can implement any number of interfaces. |
| 7 | D | Interface methods are implicitly `public`, so implementations must be `public`. |
| 8 | C | Interfaces carry no instance state, so there is no diamond problem over conflicting data. |
| 9 | D | Compile-time error until the class overrides the conflicting default method. |
| 10 | B | Abstract classes can have constructors, which run when a subclass object is created. |

## Part C – Concept questions

**1. Abstraction in my own words.**
Abstraction means exposing *what* something does and hiding *how* it does it. A washing machine is a good example: the user sees a few buttons (select program, start, pause) and the result (clean clothes). The motor control, water-level sensors, drum speed and timing logic are hidden. The user can use any washing machine the same way without knowing how it works inside.

**2. Abstraction vs encapsulation.**
Abstraction is a *design* idea: show only the essential operations and hide the complexity. Encapsulation is a *protection* idea: bundle data with the methods that act on it and restrict direct access (private fields, public getters/setters). In one class they work together: the public methods form the abstract view of the object (abstraction), and the private fields behind them are protected so they can only change through those methods (encapsulation). Together they reduce complexity and keep the data valid.

**3. Why an abstract class can have a constructor.**
Abstract classes can hold fields (for example `owner` or `count`) that every subclass shares, and the constructor initialises that shared state in one place. It is never called with `new AbstractClass()`, but it runs when a subclass object is created, because the subclass constructor calls `super(...)` first. It runs before the subclass constructor body.

**4. Why an abstract method cannot be `private`, `static` or `final`.**
- `private`: an abstract method must be overridden by a subclass, but private methods are not visible to subclasses, so they could never be implemented.
- `static`: static methods belong to the class, not to an object, and are not overridden (they are only hidden), so a static method can't be left to a subclass to implement polymorphically.
- `final`: `final` forbids overriding, but an abstract method exists precisely to be overridden. The two modifiers contradict each other.

**5. The diamond problem.**
The diamond problem appears when a class inherits from two classes that both inherit from the same parent. If both middle classes override a method or keep their own copy of a field, the bottom class doesn't know which version to inherit. Java avoids it by allowing only single inheritance of classes (so only one source of state) while allowing many interfaces. Interfaces have no instance state, and if two interfaces provide the same default method, the compiler forces the class to override it and choose explicitly, so there is never an ambiguity left at runtime.
