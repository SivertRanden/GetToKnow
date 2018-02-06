# Get-to-Know testing

## Tests

The following tests are required to ensure the quality of the application, and to ensure that it runs and performs as expected. 

#### Add Person activity tests
These tests have no special prerequisites.

* that person is added upon input and confirmation

  * length of person list should be incremented by 1

* that person details are validated before being added

  * person should only be added if name is valid

#### Quiz activity tests
These tests require one or more persons to have been added.

* that correct guesses increment score

  * score should be incremented by 1

* that incorrect guesses don’t increment score

  * score should remain the same

* that score is correct after a finished quiz

  * score should be equal to amount of correct guesses

#### Profile activity test
These tests have no special prerequisites.

* that user is prompted to enter user details on first startup

  * user preference activity should launch

* that user is *not* prompted to enter user details on subsequent startups

  * user preference activity should not launch

#### MainActivity activity test
The main test have no special prerequisites.
Testing preferences requires a clean install of the app.

* that correct activities are launched when buttons are pressed

  * correct activity is launched

* that preferences starts on first time app launch

  * Correct activity is launched

## Instrumented unit testing

Instrumented unit tests are tests that don’t just run your code, they run on an actual device, emulated or otherwise, simulating actual user interaction with the application.

## Bugs

In the current iteration of the application, there are no known bugs. We did have quite a few prior to delivery, however. One of them was in regards to using the camera to add images to a person. This was eventually sorted out by using the full namespace of the intent.

