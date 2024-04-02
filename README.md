# Documentation

## 1. Objective  
Design and implement a polynomial calculator capable of performing addition, subtraction, multiplication, division, integration, and derivation operations on two polynomials provided by the user as input. The resulting polynomial after each operation is communicated to the user. The calculator is presented as a minimalist graphical interface, enabling easy usage.  
Secondary Objectives:
- Creating a user-friendly graphical interface.
- Testing polynomial operations with JUnit.
- Converting user-input text into polynomial objects.

## 2. Problem Analysis, Modeling, Use Cases  
A polynomial is a mathematical expression composed of monomial components, each consisting of two constants (exponent, an integer, and coefficient, a real number). It will be stored as a TreeMap collection of monomials for easier manipulation.  
The polynomial will be entered by the user via the graphical interface using TextFields (one for each polynomial), in the form of text which will later be converted into a polynomial using a regex pattern. The created regex will group the monomials from the text, then convert them into objects of the monomial class, and finally add them to the collection, forming a polynomial. In case the user enters invalid text (empty text, text that does not comply with the suggested format in the interface, etc.), a warning pop-up containing the exception message will be thrown after the desired operation button is pressed.  
After pressing the operation button (addition [+], subtraction [-], multiplication [*], division [/], integration [∫], derivation [d/dx]), a pop-up with the result will appear.

## 3. Design  
### Model Package:
- **Monomial Class:** Contains two arguments representing the two components of a monomial (exponent and coefficient), accessor and mutator methods for these, a constructor (with parameters), and a toString() method used for aesthetic object display.
  
- **Polynomial Class:** Contains an attribute, a TreeMap collection (key representing the exponent and value representing the coefficient of a monomial), an accessor method for this attribute, two constructors (with and without parameters), a method for adding a monomial to the collection, and a toString() method for displaying the polynomial.

### Logic Package:
- **OperationsP Class:** Handles polynomial operations, contains a constructor (without parameters), and methods for each polynomial operation: addition, subtraction, multiplication, division (each taking two parameters, two Polynomial objects), integration, and derivation (each taking one parameter, a Polynomial object).

### GUI Package:
- **View Class:** Deals with the graphical interface of the calculator, contains components for performing operations, entering data, and displaying results. It also contains a constructor (without parameters), methods for event initialization, accessor methods for data input components, and mutator methods for providing the result.
- **Controller Class:** Contains a single constructor with a single parameter, an object of the View class, in which the actions performed when the components are used are implemented. These actions are implemented in the object received as a parameter.

## 4. Bibliography  
References consulted by the student during the implementation of the project.

Example:
1. Bruce Eckel, "Thinking in Java (4th Edition)", Publisher: Prentice Hall PTR, ISBN:978-0-13-187248-6, Published: 01 December 2005.
2. "What are Java classes?" - www.tutorialspoint.com
3. https://www.w3schools.com/java/java_regex.asp
4. https://regex101.com/
5. https://www.javatpoint.com/java-swing
