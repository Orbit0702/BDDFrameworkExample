Feature: Basic Contact Form 

Scenario: Sign Up with Valid Credentials
	Given User is on Basic Contact Form sign up page
	Then Your Name, Email Address and Message is visible
	Then user fills in the details in the above respective fields
	| Prithvi Adhikary | prithviadhikary11@gmail.com |