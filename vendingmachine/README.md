## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

## Use Case

The vending machine displays a welcome message with all products and prices.
The vending machine repeatedly asks the user to select a product till user type N.
The Vending machine asks the user to choose payment option cash or card.
The Vending machine takes the total payment and return the change amount if any.
The Vending machine also informs if transaction failed due to insufficient amount paid or wrong product selection.

## High Level Design

1. Implement the Product enum class with 5 products - selection number and price.
2. VendingMachineInterface is the interface for class that defines how to communicate with the user- the class will display products, take user input which product to buy? payment options, take payment, display change.
3. The App class will start the program and coordinate the communication between the user and the VendingMachineInterface.