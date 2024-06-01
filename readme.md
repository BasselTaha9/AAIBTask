
# nopCommerce Selenium Test Suite

This project contains automated test cases for the registration and login functionalities of the nopCommerce demo website using Selenium WebDriver and TestNG.

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK) 8 or above
- Apache Maven
- Google Chrome Browser
- ChromeDriver (managed automatically by WebDriverManager)

### Project Setup

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-repo/nopcommerce-tests.git
   cd nopcommerce-tests
   ```

2. **Install dependencies**:

   ```bash
   mvn clean install
   ```

3. **Run the tests**:

   ```bash
   mvn test
   ```

## Test Classes and Test Cases

### Test Class: `testRegistrationTestCases`

This class contains test cases for various registration scenarios on the nopCommerce demo website.

#### Test Cases

1. **Register with new email**:
    - Description: Register a new user with a unique email address.
    - Method: `testRegisterWithNewEmail()`

2. **Register with existing email**:
    - Description: Attempt to register a user with an email address that is already registered.
    - Method: `registrationWithExistingEmail()`

3. **Register with invalid email**:
    - Description: Register a user with an invalid email format.
    - Method: `registrationWithAnInvalidEmail()`

4. **Register with mismatched passwords**:
    - Description: Register a user with mismatched passwords.
    - Method: `registrationWithMismatchedPasswords()`

5. **Register with empty fields**:
    - Description: Register a user with all fields left empty.
    - Method: `registrationWithEmptyFields()`

6. **Register with weak password**:
    - Description: Register a user with a weak password.
    - Method: `registrationWithWeakPassword()`

7. **Register with long name**:
    - Description: Register a user with excessively long names.
    - Method: `registrationWithLongName()`

8. **Register with special characters in names**:
    - Description: Register a user with special characters in names.
    - Method: `registrationWithSpecialCharactersInNames()`

9. **Register with new email (Female)**:
    - Description: Register a new user with a unique email address.
    - Method: `testRegisterWithNewEmailFemale()`

10. **Register with existing email (Female)**:
    - Description: Attempt to register a user with an email address that is already registered.
    - Method: `registrationWithExistingEmailFemale()`

11. **Register with invalid email (Female)**:
    - Description: Register a user with an invalid email format.
    - Method: `registrationWithAnInvalidEmailFemale()`

12. **Register with mismatched passwords (Female)**:
    - Description: Register a user with mismatched passwords.
    - Method: `registrationWithMismatchedPasswordsFemale()`

13. **Register with empty fields (Female)**:
    - Description: Register a user with all fields left empty.
    - Method: `registrationWithEmptyFieldsFemale()`

14. **Register with weak password (Female)**:
    - Description: Register a user with a weak password.
    - Method: `registrationWithWeakPasswordFemale()`

15. **Register with long name (Female)**:
    - Description: Register a user with excessively long names.
    - Method: `registrationWithLongNameFemale()`

16. **Register with special characters in names (Female)**:
    - Description: Register a user with special characters in names.
    - Method: `registrationWithSpecialCharactersInNamesFemale()`

### Test Class: `loginTestCases`

This class contains test cases for various login scenarios on the nopCommerce demo website.

#### Test Cases

1. **Valid login**:
    - Description: Log in with valid credentials.
    - Method: `validLogin()`

2. **Invalid email format**:
    - Description: Attempt to log in with an invalid email format.
    - Method: `inValidEmailFormat()`

3. **Unregistered email**:
    - Description: Attempt to log in with an unregistered email.
    - Method: `unregisteredEmail()`

4. **Incorrect password**:
    - Description: Attempt to log in with an incorrect password.
    - Method: `incorrectPassword()`

5. **Empty fields**:
    - Description: Attempt to log in with both email and password fields empty.
    - Method: `emptyFields()`

6. **Empty email field**:
    - Description: Attempt to log in with an empty email field.
    - Method: `emptyEmailField()`

7. **Empty password field**:
    - Description: Attempt to log in with an empty password field.
    - Method: `emptyPasswordField()`

8. **Login with upper case in email field**:
    - Description: Log in with the email field in uppercase.
    - Method: `loginWithUpperCaseInEmailField()`

9. **Login with upper case in password field**:
    - Description: Attempt to log in with the password field in uppercase.
    - Method: `loginWithUpperCaseInPasswordField()`

10. **Forgot password**:
    - Description: Navigate to the forgot password page.
    - Method: `forgotPassword()`

## Annotations Used

- `@BeforeClass`: Setup method to initialize the WebDriver before any test cases run.
- `@AfterClass`: Tear down method to quit the WebDriver after all test cases have run.
- `@Test`: Marks a method as a test case.
- `@Description`: Provides a description for the test case, useful for generating reports.

## Project Structure

- **src/test/java**: Contains the test classes and methods.
- **pom.xml**: Maven configuration file with dependencies.

## Dependencies

- **Selenium WebDriver**
- **TestNG**
- **WebDriverManager**
- **Allure TestNG**

## Reporting

To generate and view test reports, use Allure:

1. **Install Allure**:

   ```bash
   brew install allure
   ```

2. **Generate the report**:

   ```bash
   allure serve target/allure-results
   ```

3. **You can find the report compressed in `allure-maven-plugin.rar`**
