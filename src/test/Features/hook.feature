#Feature: User Management1
#
#  Background:
#    Given User is logged into the application
#
#  Scenario: Add employee
#    Given User is on employee page
#    When User enters details and add a new employee
#      | firstname | lastname | employeeID | email | password | department | designation | mobileNumber | location | dob | joiningDate | qualification | role | gender | bloodGroup | salary | ReportingTo |
#      | Srikanthh | Srikanthh | IIIT11 | test@gmail.com | Test@123 | MCA | INTERN | 9876543210 | VIZAG | 10-10-2001 | 17-11-2025 | PG | Admin | Male | 4 | 15000 | srikanthreddy.udumula@optimworks.com |
#    Then Employee should be created successfully