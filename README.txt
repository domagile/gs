Allure Framework is used to generate test reports. https://docs.qameta.io/allure/#_about

Allure installation
Open PowerShell and execute to install Scoop:
Set-ExecutionPolicy RemoteSigned -scope CurrentUser
iwr -useb get.scoop.sh | iex

Then to install Allure:
scoop install allure

Command to generate and open test report:
allure serve ./build/allure-results/

##########################################################

Spreadsheet API access:
add user in IAM with role "Access Approval Approver"
in "APIs & Services > Credentials" add OAuth Client Id, download JSON-file with credentials and provide it to the user to put to proper folder

In case of "Bad request / Invalid grant" issue try to cleanup "tokens" folder
