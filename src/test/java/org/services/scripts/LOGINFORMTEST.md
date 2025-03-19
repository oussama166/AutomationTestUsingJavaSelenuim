# **Login Page Test Cases - README**

This document outlines the different test cases for testing the login functionality of the application. The test cases cover various aspects such as valid and invalid login scenarios, UI and functional tests, boundary and input validation, session management, security, negative tests, performance, browser compatibility, accessibility, and recovery procedures.

#### ℹ️<i> Each groups of test cases will be groups as separated test  </i>

---

## **1. Valid Login Test Cases**
1. **Test Case 1:** Verify that the login page loads successfully with all required fields (username, password, login button).
2. **Test Case 2:** Verify the user can log in with valid credentials (correct username and password).
3. **Test Case 3:** Verify that after successful login, the user is redirected to the home/dashboard page.
4. **Test Case 4:** Verify that the user can log in with valid credentials using a valid email (if the login allows email-based login).

---

## **2. Invalid Login Test Cases**
1. **Test Case 5:** Verify that the login fails when an invalid username is provided.
2. **Test Case 6:** Verify that the login fails when an invalid password is provided.
3. **Test Case 7:** Verify that the login fails when both invalid username and password are entered.
4. **Test Case 8:** Verify that the login fails when the username is left blank and a valid password is entered.
5. **Test Case 9:** Verify that the login fails when the password is left blank and a valid username is entered.
6. **Test Case 10:** Verify that the login fails when both username and password fields are left blank.
7. **Test Case 11:** Verify that the login fails when an invalid email format is used for the username.
8. **Test Case 12:** Verify the error message displayed when incorrect login credentials are entered (e.g., "Invalid username or password").

---

## **3. UI and Functional Test Cases**
1. **Test Case 13:** Verify that the username and password fields are visible and accessible.
2. **Test Case 14:** Verify that the "Login" button is clickable after entering valid credentials.
3. **Test Case 15:** Verify that the "Forgot Password?" link is present and works as expected.
4. **Test Case 16:** Verify that the "Remember Me" checkbox is present and can be checked/unchecked.
5. **Test Case 17:** Verify that the "Login" button is disabled when either username or password is empty.
6. **Test Case 18:** Verify the alignment and formatting of the login form fields.
7. **Test Case 19:** Verify that the user is able to logout after logging in successfully.

---

## **4. Boundary and Input Validation Test Cases**
1. **Test Case 20:** Verify that the username field accepts only valid characters (alphanumeric or special characters, based on the application’s requirement).
2. **Test Case 21:** Verify that the password field accepts valid characters (e.g., alphanumeric and special characters).
3. **Test Case 22:** Verify that the username and password fields do not accept more than the maximum allowed characters.
4. **Test Case 23:** Verify the username field allows valid lengths (e.g., 6-50 characters).
5. **Test Case 24:** Verify that the password field accepts a minimum number of characters (e.g., 6-8 characters for security).
6. **Test Case 25:** Verify that the login form does not accept SQL injection characters (e.g., --, ', ", ;, etc.) in the username and password fields.
7. **Test Case 26:** Verify that the login form does not accept script tags or cross-site scripting (XSS) characters in input fields.

---

## **5. Session Management and Security Test Cases**
1. **Test Case 27:** Verify that after logging in, the session is maintained until the user logs out or the session expires.
2. **Test Case 28:** Verify that the user is redirected to the login page after logging out.
3. **Test Case 29:** Verify that the "Remember Me" functionality works as expected (user remains logged in after closing and reopening the browser).
4. **Test Case 30:** Verify that the session expires after a set period of inactivity (if applicable).
5. **Test Case 31:** Verify that the login is not bypassed by directly accessing the home/dashboard page without logging in.
6. **Test Case 32:** Verify that if the user tries to access a restricted page after logging out, they are redirected to the login page.

---

## **6. Negative Test Cases**
1. **Test Case 33:** Verify that the application handles special characters in username and password fields gracefully.
2. **Test Case 34:** Verify that the application handles spaces in username and password fields gracefully.
3. **Test Case 35:** Verify that the login attempt with a locked or disabled user account returns the appropriate error message (e.g., "Account locked").

---

## **7. Performance Test Cases**
1. **Test Case 36:** Verify that the login form is responsive and loads quickly.
2. **Test Case 37:** Verify that the login page functions correctly across various devices and screen resolutions (mobile, tablet, desktop).
3. **Test Case 38:** Verify the system’s behavior with a high volume of login requests (load testing).

---

## **8. Browser Compatibility Test Cases**
1. **Test Case 39:** Verify that the login functionality works across all major browsers (Chrome, Firefox, Safari, Edge).
2. **Test Case 40:** Verify that the login page is responsive and adapts to different screen sizes and orientations (mobile, tablet, desktop).

---

## **9. Accessibility Test Cases**
1. **Test Case 41:** Verify that the login page is accessible using keyboard navigation.
2. **Test Case 42:** Verify that the login page is compatible with screen readers for visually impaired users.
3. **Test Case 43:** Verify that all form fields have appropriate labels and tooltips.

---

## **10. Recovery Test Cases**
1. **Test Case 44:** Verify that the "Forgot Password?" link sends a password reset email.
2. **Test Case 45:** Verify that the user can successfully reset their password through the "Forgot Password?" process.

---

