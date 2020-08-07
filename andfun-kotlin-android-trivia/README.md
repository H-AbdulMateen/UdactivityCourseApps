# Navigation

# Principles of Navigation
1)- There's always a starting place

2)- You can always go back

3)- Up goes back mostly

# Q:What are advantages we get from using safe arguments?

1)- We get type safety, as navigation generates the action and the argument class from the navigation graph.

2)- We get argument enforcement, as non-default arguments are required parameters in the action.

# Intents
   THere are two types of intent
## Explicit Intent
   Launch specific activity
## Implicit Intent
   Specify what you want done and system choose activity
   Each implicit intent must have an action(the type of thing that the app wants to have done on its behalf).
   Intent Category(Adds a subtype to the action)    

This is the toy app for lesson 3 of the [Android App Development in Kotlin course on Udacity](https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012).

## Android Trivia 

The Android Trivia application is an application that asks the user trivia questions about Android development.  It makes use of the Navigation component within Jetpack to move the user between different screens.  Each screen is implemented as a Fragment.
The app navigates using buttons, the Action Bar, and the Navigation Drawer.
Since students haven't yet learned about saving data or the Android lifecycle, it tries to eliminate bugs caused by configuration changes. 

## Screenshots

![Screenshot1](screenshots/screen_1.png) ![Screenshot2](screenshots/screen_2.png)
