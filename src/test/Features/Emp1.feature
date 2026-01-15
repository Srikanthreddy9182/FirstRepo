
Feature: User Management

  @hjhfbjhns
  Scenario: Login to the application
    Given User is on login page
    When User enters valid username and password
      | username | password |
      | srikanthreddy.udumula@optimworks.com | Srikrishna@123 |
    Then User should be redirected to Home Page


#  Scenario: Add employee
#    Given User is on employee page
#    When User enters details and add a new employee
#    | firstname | lastname | employeeID | email | password | department | designation | mobileNumber | location | dob | joiningDate | qualification | role | gender | bloodGroup | salary | ReportingTo |
#    | Srikanthh   | Srikanthh | IIIT11  | Srikrishna11@gmail.com  | Srikrishna@123 | MCA | INTERN | 9876543210 | VIZAG | 10-10-2001 | 17-11-2025 | PG | Admin | Male | 4 | 15000 |srikanthreddy.udumula@optimworks.com |
#    Then Employee should be created successfully

  @hjhfbjhns
  Scenario: Apply Leave
    Given User is On Leave Management Page
    When User enters Leave details
    | fromDate | toDate | subject | leaveForReason|
    | 1-1-2026 | 10-1-2026 | Leave | jhubfvgtgknjh |
    Then Leave should be applied

#  Scenario: Upload File
#    Given User is on employee page to upload doc
#    When User selct a file and upload
#    Then Document should be uploaded successfully
#
#
#  Scenario: Add Holiday
#    Given User is on dashboard
#    When User enter holiday details
#    | Occassion | date |
#    | pongal | 14-01-2025 |
#    Then Holiday should be added successfully