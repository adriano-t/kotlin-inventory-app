# The Shoe Store

This project will consist of five screens. You don't have to create a shoe store, 
you can use any other item as long as you create the following screens. You will be creating:

1. [x] Login screen: Email and password fields and labels plus create and login buttons
2. [x] Welcome onboarding screen
3. [x] Instructions onboarding screen
4. [x] Shoe Listing screen
5. [x] Shoe Detail screen for adding a new shoe

## Steps

1. [x] Open the starter project in the latest stable version of Android Studio.

2. [x] Add the navigation libraries to the app build.gradle file

3. [x] Add the safe-arg plugin to the main and app build.gradle file

4. [x] Create a new navigation xml file

5. Create a new Login destination.

   - [x] Include email and password labels
   - [x] Include email and password fields
   - [x]  Create buttons for creating a new login and logging in with an existing account
   - [x] Clicking either button should navigate to the Welcome Screen.

6. Create a new Welcome screen destination that includes:

   * [x] A new layout
   * [x] At least 2 textviews
   * [x] A navigation button with actions to navigate to the instructions screen

7. Create a new Instruction destination that includes:

   * [x] A new layout
   * [x] At least 2 textviews
   * [x] A navigation button with actions to navigate to the shoe list screen

8. Create a class that extends ViewModel

   *  [x] Use a LiveData field that returns the list of shoes

9. Create a new Shoe List destination that includes:

   * [x] A new layout
   * [x] A ScrollView
   * [x] A LinearLayout for Shoe Items
   * [x] A FloatingActionButton with an action to navigate to the shoe detail screen

10. [x] In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

11. Create a new Shoe Detail destination that includes:

    * [x] A new layout
    * [x] A TextView label and EditView for the
      * [x] Shoe Name
      * [x] Company
      * [x] Shoe Size
      * [x] Description
    * [x] A Cancel button with an action to navigate back to the shoe list screen
    * [x] A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model

12. [x] Make sure you can’t go back to onboarding screens

13. In the Shoe List screen:

    * [x] Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
    * [x] Observe the shoes variable from the ViewModel
    * [x] Use DataBindingUtil to inflate the shoe_list layout
    * [x] Add a new layout item into the scrollview for each shoe.