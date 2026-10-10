# Week 10: Data Structures Foundations (Category C)

## Part B: Quiz Answers

| Question | Answer | Reason |
|----------|--------|--------|
| 1 | D | `new String(...)` creates two distinct objects, so `==` is false, while `equals` compares content and is true. |
| 2 | B | The builder holds "Java Lab"; reversing it gives "baL avaJ". |
| 3 | B | `new Student("Ravi")` matches the one-argument constructor, which then chains with `this(name, ...)`. |
| 4 | D | `w1` and `w2` refer to the same object, so both see 700. |
| 5 | C | The static counter is shared; three objects were created, so it is 3. |
| 6 | A | The loop visits indexes 0 to length - 1, printing every element in order. |
| 7 | B | `continue` skips 3, so the output is 1 2 4 5. |
| 8 | A | Java is pass-by-value; changing the parameter does not change `x`. |
| 9 | C | `total / count` is a double division: 83.33333333333333. |
| 10 | B | A `Card` object runs its overridden `pay`: 500 + 2% fee = 510.0. |
| 11 | B | Strings are immutable; `toUpperCase()` returns a new object and leaves `name` unchanged. |
| 12 | B | One pooled "hello" (shared by s1 and s2) plus one new object from `new String`. |
| 13 | A | "Campus" has length 6 and the character at index 2 is 'm'. |
| 14 | A | In "user@domain.com" the '@' is at index 4. |
| 15 | B | The default constructor sets title to "Unknown" and price to 0.0. |
| 16 | A | The parameterized constructor stores the given title and price. |
| 17 | B | `w1` and `w2` share one object; `w3` is a second object. |
| 18 | C | `w2.add(200)` changes the shared object, so both show 700. |
| 19 | C | `s1` and `s2` are different objects; only `s1` is renamed. |
| 20 | C | The static counter is incremented once per object, giving 3. |

## Part C: Concept Answers

**1. String immutability and performance.**
A `String` cannot be changed after it is created. Every "modification" such as `s = s + "x"` builds a brand new object and copies the old characters, so repeated changes in a loop cost O(n squared) time and create a lot of garbage. Immutability gives safety (thread safety, safe use as hash keys, string pooling), but for repeated edits the cost is mitigated by using `StringBuilder` (or `StringBuffer` when thread safety is needed), which changes one buffer in place.

**2. The `this` keyword with shadowed names.**
When a constructor parameter has the same name as an instance variable, the parameter hides the field inside the constructor. `this.name = name;` resolves it: `this.name` is the field of the object being built and the right-hand `name` is the parameter. Example: `Student(String name) { this.name = name; }`. Without `this`, the line `name = name;` would only assign the parameter to itself and the field would stay unset.

**3. Object and reference variable.**
An object is the actual data created on the heap by `new`. A reference variable is a named variable that holds the address of an object. Assigning `Wallet w2 = w1;` copies only the reference, not the object, so no new object is made and both variables point to the same one. A change made through `w2` is therefore visible through `w1`. An object with no references left becomes eligible for garbage collection.

**4. Static and instance variables.**
An instance variable belongs to each object and holds that object's own state, for example a `Student`'s name or marks. A static variable belongs to the class and is shared by all objects, so it suits class-wide data such as a visitor counter, a college name or a constant. A static member is preferred for "total visitors created"; an instance member is right for "this visitor's name", because every object needs its own value.

**5. `for`, `while` and `do-while`.**
A `for` loop is best when the number of iterations is known, such as walking through array indexes. A `while` loop checks the condition first and suits repeating until something happens, such as reading input until the end of the data. A `do-while` loop runs the body once before checking, so it suits menus or input validation where the action must happen at least once.

**6. Pass-by-value.**
Java always passes a copy of the argument. For a primitive, the method gets a copy of the value, so changing the parameter never changes the caller's variable. For an object, the method gets a copy of the reference. The copy still points to the same object, so the method can change the object's fields and the caller sees it, but reassigning the parameter to a new object does not affect the caller's reference.

**7. Integer division and casting.**
When both operands are integers, Java divides as integers and discards the fractional part, so `250 / 3` is 83. To get a precise result, at least one operand must be a floating-point type, for example `(double) total / count` or declaring `count` as a double, which gives 83.33333333333333. The cast must be applied before the division, because casting after the division would only convert the already truncated 83.

**8. Encapsulation.**
Encapsulation bundles data with the methods that work on it and hides the internal state. Declaring fields `private` blocks direct outside access, and public getters and setters provide controlled access. A setter can validate input (for example reject a negative balance), and omitting the setter makes a field read-only. This keeps the data consistent and lets the internal implementation change without breaking other code.

**9. `==` versus `equals()`.**
For objects, `==` compares references (are they the very same object), while `equals()` compares content when it is overridden. Two `new String("hello")` objects are not `==` but are `equals`. By default `Object.equals` behaves like `==`, so a class that wants value comparison, such as two `Point` objects with the same coordinates, must override `equals()` (and `hashCode()`) so that equal content counts as equal.

**10. Overloading and overriding.**
Overloading means several methods with the same name but different parameter lists in the same class; the compiler picks one at compile time, for example `add(int, int)` and `add(double, double)`. Overriding means a subclass supplies its own implementation of an inherited method with the same signature; the version is chosen at run time from the object's actual class, for example `Dog.makeSound()` replacing `Animal.makeSound()`. Overloading is compile-time polymorphism and overriding is run-time polymorphism.
