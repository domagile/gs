mkdir build\allure-results\history
copy allure-report\history\* build\allure-results\history

call gradlew allureReport
call gradlew allureServe
