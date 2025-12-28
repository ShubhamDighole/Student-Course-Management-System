###Why you used ArrayList instead of array

ArrayList was preferred over arrays due to its dynamic resizing and built-in utility methods for adding or removing elements.


###Where you used static members and why

variables declare with the static keyword are associated with the class. 

1. Lists like courseList and studentsList are declared as static so their values are shared across all instances of the class. 
2. enums (which are implicitly public static final) are final and static. So, i have declared "Status" class as enum.
3. The main method in Main.java is declared as static because it is the entry point of the application.
4. In "UITexts.java" all variable has constant values so declare all as static final.


###Where you used inheritance and what you gained from it


1. In Service class i declare the class as interface, and methods of this interface are used in serviceImpl classes.
2. Class "Trainee" is extended from "Person".

We can extend the child class from parent class and have our own implementation in child class as required.