CS 3716 Group #16 Final Project
Group Members: John Healey, Josh Clarke, Tyler Snow
GitHub Repository: https://github.com/JohnPHealey/room-reservation.git

Instructions:
	Upon starting application, press a button on the bottom of the screen to proceed
	as a principal or as an applicant, as desired.
	Principal:
		Enter login credentials (Username: admin Password: admin)
		Press button that describes what you want to do
		View Requests:
			Select the semester and room you want to view requests for
			Press Confirm
			List of pending requests is displayed
			Select request that you would like to view
			Press View in bottom-right corner
			Request information is displayed
			Select a booking from the displayed list that you would like to approve/deny
			Press Approve or Deny beneath the list as desired
			Repeat for all requests as desired
			Press Submit to confirm the selected actions
		Enter Availability Information:
			Select the semester and room you want to enter availability information for
			Select the time period and days during which you want to make the room availabile
			Select Confirm to enter the information into the system
	Applicant:
		Enter Name, Group, and Reason for Request
		Press Confirm to proceed
		Select desired Room and Semester from the lists presented
		Press Confirm to proceed
		Each application/request must include 5 bookings, in case the applicant does not get the slot they really want
		Therefore, the following steps are repeated 5 times:
			Select start and end time for desired slot from time lists
			Select desired weekday from day list
			Press Add Booking to add the booking to the list of 5
		The Add Booking button is now replaced by Submit. Press Submit to enter request (with 5 bookings) into system
		
Persistence:
	In order to have the school's pending requests be persistent, the objects/requests folder must be on the local machine, in the same hierarchy as in this repository.
		
Point Distribution:
	John Healey - 10 points
	Josh Clarke - 10 points
	Tyler Snow - 10 points
