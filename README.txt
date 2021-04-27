Allure Framework is used to generate test reports. https://docs.qameta.io/allure/#_about

Allure installation
Open PowerShell and execute to install Scoop:
Set-ExecutionPolicy RemoteSigned -scope CurrentUser
iwr -useb get.scoop.sh | iex

Then to install Allure:
scoop install allure

Command to generate and open test report:
allure serve ./build/allure-results/