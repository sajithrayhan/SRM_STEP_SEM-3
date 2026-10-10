# Week 8 – Inheritance & Polymorphism (Category C)

## Quiz answers

| Q | Answer | Reason |
|---|--------|--------|
| 1 | C – Polymorphism | Overriding `render()` lets each document render itself, so the if-else type checks disappear. |
| 2 | A, B, C | Car is a Vehicle, Rectangle is a Shape, DatabaseConnection is a NetworkResource. D is "has-a" (composition), not "is-a". |
| 3 | C – Runtime method dispatch | The JVM picks the method from the object's actual class at runtime. |
| 4 | C – Inheritance-based polymorphism | One `calculateArea()` call, different behaviour per concrete shape. |
| 5 | A, C, D | `Book` extends inherited behaviour, `LibraryItem` defines the common behaviour, and a `DVD` can be used through a `LibraryItem` reference. (B is wrong: the DVD's fixed period is overridden, not shared.) |
| 6 | A, C | The `Animal` reference runs `Dog`'s method, and `Dog.makeSound()` is overridden behaviour. (B and D are false.) |
| 7 | C | A new `WalletPayment` can be added without touching the processor's loop. |
| 8 | A | Inheritance for plain code reuse gives tight coupling and a false "is-a", so the design becomes rigid. |
| 9 | A, C | Generic sender works with any notification, and new channels can be added without changing it. |
| 10 | A, B, C | Polymorphic collections simplify iteration, allow uniform processing and avoid casts. (D is the opposite of the truth.) |

## Concept answers

**1. Reuse and extend through inheritance.**
A subclass automatically gets the fields and methods of its base class (reuse), and can add new members or override methods to change behaviour (specialisation). Example: a bank `Account` has `deposit()` and `balance`. `SavingsAccount` reuses both and adds `addInterest()`, while `CurrentAccount` reuses them and overrides `withdraw()` to allow an overdraft.

**2. The "is-a" relationship.**
"Is-a" means that an object of the subclass can be used wherever the base class is expected and still be correct (a `Manager` is an `Employee`). It is crucial because inheritance exposes every public member of the parent. If the relationship is not genuine (a `Stack` is not an `ArrayList`), the child inherits operations that make no sense and breaks the substitution principle. A "has-a" relationship should be modelled by composition instead.

**3. Method overriding.**
Overriding is a subclass providing its own implementation of a method with the same signature as one in its base class. For `Employee.calculateSalary()`, `FullTimeEmployee` returns monthly salary, `ContractEmployee` returns hours x rate, and `Intern` returns a fixed stipend. A call through an `Employee` reference runs the version that belongs to the real object.

**4. Runtime polymorphism (dynamic dispatch).**
When a method is called on a base-type reference, the compiler only checks that the method exists in the base type. At runtime the JVM looks at the actual class of the object (its virtual method table) and runs the most specific overriding method. So `Vehicle v = new Car(); v.startEngine();` runs `Car.startEngine()`.

**5. Polymorphic collections.**
A collection such as `List<Shape> shapes = List.of(new Circle(..), new Rectangle(..), new Triangle(..))` holds base-type references whose objects are of different derived types. One loop (`for (Shape s : shapes) total += s.area();`) processes all of them uniformly, with no casts or type checks, and new shapes work without changing the loop.

**6. Polymorphism vs type-based conditionals.**
With if-else/switch, every place that needs different behaviour repeats the type check, and adding a type means finding and editing all of them (easy to miss one, violating open/closed). With polymorphism, the behaviour lives in each class, the calling code is one line, and adding a type means adding one class. It is shorter, safer and easier to maintain, so it is preferred for related objects with varying behaviour.

**7. Adding new types with no change to processing logic.**
Processing code depends only on the base type (`PaymentMethod.fee()`). If a `CryptoPayment extends PaymentMethod` is introduced and overrides `fee()`, the existing `PaymentProcessor` loop works with it unchanged, because dynamic dispatch calls the new override. Only the new class (and the place that creates it) needs to be written.

**8. Inherited vs overridden behaviour.**
Inherited behaviour is used as-is from the parent; overridden behaviour replaces it in the child. A subclass inherits when the parent's logic is already correct (`Employee.getName()` for all employees) and overrides when its rule differs (`Intern.calculateBonus()` returns a fixed amount instead of a percentage).

**9. Inheritance only for code reuse.**
If there is no true "is-a", the subclass inherits members that don't make sense, couples itself tightly to the parent's internals so any parent change can break it, exposes a wrong public API, breaks substitutability, and makes the hierarchy rigid and confusing. Composition or utility classes give reuse without those problems.

**10. VehicleRental example.**
Common behaviour for all rentals: customer, rental days, base calculation and printing a bill, which live in a `VehicleRental` base class. Specialised behaviour: `CarRental` may add insurance and a per-km charge, while `TruckRental` adds a load-based charge and a driver fee, each by overriding `calculateCost()`. Inheritance models this by putting the shared part once in the parent and each variation in a subclass.
