This project executes a Java-Maven-Selenium-TestNG project, that executes some selenium commands in three different browsers parallelly
This is usually known as "Cross-browser Testing" or "Parallel Testing" in Selenium
1. The projec contains a single class under <test> that opens https://www.saucedemo.com/v1/ and logins to it
2. The browser initialization uses paramater from TestNG.xml file to read the URL
3. But there are three tests that use the same class, each using a different browser
4. So, under <suite> tag, the execution is made parallel for "tests" and three threads are added for three browsers to run concurrently
5. Just run the TestNG.xml file to see all three browsers getting executed at the same time, logging into the test site
