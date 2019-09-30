#       CS 4330/5390: Mobile Application Development, Fall 2019

		HOMEWORK 1: Basic Android Programming
		 (File $Date: 2019/09/17 17:05:38 $)

Due: September 25

This homework shall be done individually. In this homework, you will
learn how to develop your first Android app with Android Studio. You
will also learn how to design a simple UI consisting of TextView and
Button using the Layout Editor.

In this course, you will be developing a price tracking app in a
series of homework assignments. The app will help a user to figure out
the best time to buy something by watching over fluctuating online
prices. It behaves like Amazon's wish list. You will start with a very
simple app and refine it to an ultimate version in several iterations.

In this assignment, you are to write the first version of My Price
Watcher app that tracks "simulated" prices of a single, fixed item.
Your app has to meet the following functional and non-functional
requirements.

R1. The app shall show the name of an item, its initial price, current
    price, and the percentage change of the prices (see R4 below to
    simulate the prices of an item). You may assume that the app knows
    a single item to watch over the price; you don't have to provide a
    UI for the user to enter the item information such as name and
    URL.

R2. The app shall provide a way to find the current price of the item
    and calculate a new price change. You may use a button for this.

R3. The app shall provide a way to view the webpage of the item, e.g.,
    starting a built-in web browser with the item's URL. 

R4. You should define a class, say PriceFinder, to simulate the price
    of an item. Given the URL of an item, the class returns a
    "simulated" price of the item, e.g., by generating a random or
    normally-distributed price. The idea is to apply the Strategy
    design pattern [1] in later assignments by introducing a subclass
    that actually downloads and parses the Web document of the given
    URL to find the price.

R5. You should use the Model-View-Control (MVC) metaphor [2], and your
    model classes should be completely separated from the view and
    control classes. There should be no dependency from model classes
    to view/control classes to make your design extensible for future
    improvements.

R6. The app shall provide a custom launch icon. Use the Image Asset
    Studio of Android Studio to create custom icons (File > New >
    Image Asset). Read an online document entitled "Create App Icons
    with Image Asset Studio" (https://developer.android.com/studio/
    write/image-asset-studio.html) or an online tool like Android
    Asset Studio (https://romannurik.github.io/AndroidAssetStudio/).

R7. Use the following configuration for your project.

    Application name: My Price Watcher
    Package name: edu.utep.cs.cs4330.mypricewatcher
    Minimum SDK version: API 21 - Android 5.0 (Lollipop)
    Main activity: MainActivity

    Name your distribution apk file hw1.apk (see the submission
    instruction below).

1. (10 points) Design your app and express your design by drawing a
   UML class diagram [3]. Your class diagram should include both model
   classes and UI classes (see R4 above) by using a layered
   architecture, where the business logic layer is completely
   separated from the presentation layer.

   - Your class diagram should show the main components (classes) 
     of your app along with their roles and relationships. 
   - Your model (business logic) classes should be cleanly separated 
     from the view/control (UI) classes with no dependencies.
   - For each class in your diagram, define key (public) operations
     to show its roles or responsibilities.
   - For each association including aggregation and composition, include
     at least a label, multiplicities and directions.
   - For each class appearing in your class diagram, provide a brief 
     description.

2. (90 points) Code your design by making your code conform to your
   design.

3. (10 bonus points) Improve the user experience of your app by
   letting it to receive an item URL from other apps like web
   browsers. That is, other apps can share a URL with your app (see
   the lecture notes for an example).

TESTING

   Your app should run correctly on Android 5.0 (API Level 21) and
   later.

WHAT AND HOW TO TURN IN

   You should submit hard copies of your UML diagrams along with
   accompanying documents before the class starts on the due date.
   Your hard copy submission should include:

   - UML class diagram along with a description

   You should submit your program through the Assignment Submission
   page found in the Homework page of the course website. You should
   submit a single zip file that contains:

   - A signed Android package (APK) file. Read Section entitled
     "Publish Your Application" (pages 44-45 of the textbook) for
     creating an Android distribution file. On Android Studio, use
     Build > Generate Singed APK ... menu item.
   - Source code -- the Java src directory in your project folder 
     (app/src/main/java). Include only Java source code files; do 
     not include other files such as resource/build files.

   Your zip file should contain a single root directory named
   YourFirstNameLastName in which all the above-mentioned files and
   directories reside, e.g.,

   - hw1.apk (signed APK file)
   - src/... (Java source code files and directories)

   You should turn in your program by 10:30 am on the due date.

DEMO

   You will need to make one or two minutes demo of your app to the
   course staff.

GRADING

   You will be graded on the quality of your design and how clear your
   code is. Excessively long code will be penalized: don't repeat code
   in multiple places. Your code should be well documented by using
   Javadoc comments and sensibly indented so it is easy to read.

   Be sure your name is in the comments in your source code.

REFERENCES 

   [1] Wikipedia, Strategy pattern, https://en.wikipedia.org/wiki/
       Strategy_pattern.

   [2] Holger Gast, How to Use Objects, Addison-Wesley, 2016.
       Sections 9.1 and 9.2. Ebook available from UTEP library.

   [3] Martina Seidl, et al., UML@Classroom: An Introduction to
       Object-Oriented Modeling, Springer, 2015. Free ebook through
       UTEP library.
