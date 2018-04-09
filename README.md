# room-reservation
CS 3716 Group #16 Final Project
Group Members: John Healey, Josh Clarke, Tyler Snow
GitHub Repository: https://github.com/JohnPHealey/room-reservation.git

A system that aids school principals in room scheduling matters.

Instructions:
	<br/>Upon starting application, press a button on the bottom of the screen to proceed
	<br/>as a principal or as an applicant, as desired.
	<br/>Principal:
		<br/>Enter login credentials (Username: admin Password: admin)
		<br/>Press button that describes what you want to do
		<br/>View Requests:
			<br/>Select the semester and room you want to view requests for
			<br/>Press Confirm
			<br/>List of pending requests is displayed
			<br/>Select request that you would like to view
			<br/>Press View in bottom-right corner
			<br/>Request information is displayed
			<br/>Select a booking from the displayed list that you would like to approve/deny
			<br/>Press Approve or Deny beneath the list as desired
			<br/>Repeat for all requests as desired
			<br/>Press Submit to confirm the selected actions
		<br/>Enter Availability Information:
			<br/>Select the semester and room you want to enter availability information for
			<br/>Select the time period and days during which you want to make the room availabile
			<br/>Select Confirm to enter the information into the system
	<br/>Applicant:
		<br/>Enter Name, Group, and Reason for Request
		<br/>Press Confirm to proceed
		<br/>Select desired Room and Semester from the lists presented
		<br/>Press Confirm to proceed
		<br/>Each application/request must include 5 bookings, in case the applicant does not get the slot they really want
		<br/>Therefore, the following steps are repeated 5 times:
			<br/>Select start and end time for desired slot from time lists
			<br/>Select desired weekday from day list
			<br/>Press Add Booking to add the booking to the list of 5
		<br/>The Add Booking button is now replaced by Submit. Press Submit to enter request (with 5 bookings) into system
