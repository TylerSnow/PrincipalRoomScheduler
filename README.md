# Principal Room Scheduler Group Project
CS 3716 Group #16 Final Project
Group Members: John Healey, Josh Clarke, Tyler Snow
GitHub Repository: https://github.com/JohnPHealey/room-reservation.git

A system that aids school principals in room scheduling matters.

Instructions:
	<br/>Upon starting application, press a button on the bottom of the screen to proceed as a principal or as an applicant, as desired.
	<br/>Principal:
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;Enter login credentials (Username: admin Password: admin)
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;Press button that describes what you want to do
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;View Requests:
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select the semester and room you want to view requests for
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Press Confirm
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;List of pending requests is displayed
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select request that you would like to view
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Press View in bottom-right corner
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Request information is displayed
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select a booking from the displayed list that you would like to approve/deny
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Press Approve or Deny beneath the list as desired
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Repeat for all requests as desired
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Press Submit to confirm the selected actions
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;Enter Availability Information:
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select the semester and room you want to enter availability information for
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select the time period and days during which you want to make the room availabile
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select Confirm to enter the information into the system
	<br/>Applicant:
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;Enter Name, Group, and Reason for Request
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;Press Confirm to proceed
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;Select desired Room and Semester from the lists presented
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;Press Confirm to proceed
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;Each application/request must include 5 bookings, in case the applicant does not get the slot they really want
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;Therefore, the following steps are repeated 5 times:
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select start and end time for desired slot from time lists
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select desired weekday from day list
			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Press Add Booking to add the booking to the list of 5
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;The Add Booking button is now replaced by Submit. Press Submit to enter request (with 5 bookings) into system
