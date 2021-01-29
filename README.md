## Design Pattern

### Content

- Overview
- Patterns
  - 

### I. Overview

#### 1. What's Design Pattern

- solutions to general problems developers facing during software development
- obtained by trial and error by numerous developers over quite a substantial period of time

#### 2. What is Gang of Four (GoF)?

- in 1994, four authors (Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides) published a book titled **Design Patterns - Elements of Reusable Object-Oriented Software** which initiated the concept of Design Pattern
- These authors are collectively known as **Gang of Four**. According to these authors, design patterns are primarily based on following principles of object oriented design
  - Program to an interface not an implementation
  - Favor object composition over inheritance

#### 3. What is the usage of Design Pattern

There are two main usages : 

- **Common platform for developers**
  - provide a standard terminology and are specific to particular scenario. For example : a **singleton design pattern** signifies use of single object, developer can tell each other it's following a singleton pattern.
- **Best Practice**
  - design patterns have been evolved over a long time, they provide best solutions to certain problems faced during software development.

#### 4. What are the types of Design Patterns

According to GoF, there are 23 design patterns which can be classified in three categories : **Creational, Structural and Behavioral Patterns**. 

And some other category of design pattern : **J2EE Design Pattern**

| Pattern                  | Description                                                  |
| ------------------------ | ------------------------------------------------------------ |
| **Creational Patterns**  | 1. provide a way to create objects while hiding the creation logic, rather than instantiating objects directly using new operator<br/>2. This gives program flexibility in deciding which object need to be created for a given usage.<br/>3. Examples :   Factory, Builder |
| **Structural Patterns**  | 1. concern class and object composition.<br/>2. Concept of inheritance is used to compose interfaces and define ways to compose objects to obtain new functionalities<br/>3. Example : Adapter, Bridge |
| **Behavioral  Patterns** | 1. specifically concerned with communication between objects<br/>2. Example : |
| **J2EE Patterns**        | 1. specifically concerned with the presentation tier.        |



#### 5. [Patterns by type](https://en.wikipedia.org/wiki/Design_Patterns)

- **Creational Patterns** - creational patterns are that create objects, rather than having to instantiate objects directly. This gives the program more flexibility in deciding which objects need to created.
  - **Abstract Factory** groups object factories that have a common theme
  - **Factory  method** creates objects without specifying the exact class to create
  - **Builder** constructs complex objects by ***separating construction and representation***
  - **Prototype** crates objects by ***cloning an existing object***
  - **Singleton** restricts object creation for ***one class to only one instance in one scope***
- **Structural Patterns** concern class and object composition. They use inheritance to compose interfaces and define ways to compose objects to obtain new functionality.
  - **Adapter** allows classes with ***incompatible*** interfaces to work together by wrapping its own interface around that of an already existing class.
  - **Bridge** decouples an abstraction from its implementation so that he two can vary independently
  - **Composite** composes zero-or-more similar objects so that they can be manipulated as one object
  - **Decorator** dynamically adds/overrides behavior in an existing method of an object
  - **Facade** provides a simplified interface to a large body of code
  - **Flyweight** reduces the cost of creating and manipulating a large number of similar objects
  - **Proxy** provides a placeholder for another object to control access, reduce cost and complexity
- **Behavioral Patterns** are specifically concerned with communication between objects
  - **Chain of responsibility** delegates commands to a chain of processing objects
  - **Command** creates objects which encapsulate actions and parameters
  - **Interpreter** implements a specialized language
  - **Iterator** accesses the elements of an object sequentially without exposing its underlying representation
  - **Mediator** allows loose coupling between classes by being the only class that has detailed knowledge
  - **Momento** provides the ability to restore an object to its previous state(undo)
  - **Observer** is a publish/subscribe pattern which allows a number of observer objects to see an object
  - **State** allows an object to alter its behavior when its internal state changes
  - **Strategy** allows one of a family algorithms to be selected on-the-fly at runtime
  - **Template method** defines the skeleton of an algorithm as an abstract class, allowing its subclasses to provide concrete behavior
  - **Visitor** separates an algorithm from an object structure by moving the hierarchy of methods into one objects

## II. Patterns

#### 1. Factory Pattern

- one of the most used design pattern in java
- comes under creational pattern,  which provide ways to create an object
- **Advantage** : create object without exposing creation logic to the client and refer to newly created object using common interface

**Example**

We have **TeslaFactory** class, which will return specific object implements interface **ElectricVehicle**.

Different classes (**CyberTruck, ModelS, ModelX**) implement ElectricVehicle interface.



![](https://github.com/yushi12138/Design-Pattern/blob/main/Patterns/src/factory/Factory_UML.png?raw=true)





```java
package factory;

public class FactoryPatternDemo {

    public static interface ElectricVehicle {
        void charge();
        void drive();
    }
    
    public static class CyberTruck implements ElectricVehicle {
        public void charge() {
            System.out.println("CyberTruck is charging!");
        }

        public void drive() {
            System.out.println("Driving the CyberTruck!");
        }
    }

    public static class ModelS implements ElectricVehicle {
        public void charge() {
            System.out.println("Model-S is charging!");
        }

        public void drive() {
            System.out.println("Driving the Model-X!");
        }
    }

    public static class ModelX implements ElectricVehicle {
        public void charge() {
            System.out.println("Model-X is charging!");
        }

        public void drive() {
            System.out.println("Driving the Model-X!");
        }
    }

    public static class TeslaFactory {
        public static ElectricVehicle getVehicle(String type) {
            if (type == null || type.length() == 0) {
                System.out.println("Input shouldn't be empty!");
                return null;
            }
            switch (type) {
                case "cybertruck":
                    return new CyberTruck();
                case "models":
                    return new ModelS();
                case "modelx":
                    return new ModelX();
                default:
                    System.out.println("Type is not available : " + type);
                    return null;
            }
        }
    }

    public static void main(String[] args) {
        ElectricVehicle cybertruck = TeslaFactory.getVehicle("cybertruck");
        cybertruck.charge();
        cybertruck.drive();
        ElectricVehicle models = TeslaFactory.getVehicle("models");
        models.charge();
        models.drive();
        ElectricVehicle modelx = TeslaFactory.getVehicle("modelx");
        modelx.charge();
        modelx.drive();
        /*
            output :
            CyberTruck is charging!
            Driving the CyberTruck!
            Model-S is charging!
            Driving the Model-X!
            Model-X is charging!
            Driving the Model-X!
         */
    }
}




```

