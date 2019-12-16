$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Project.feature");
formatter.feature({
  "line": 2,
  "name": "Adding below data  to your excel file in Sheets;",
  "description": "",
  "id": "adding-below-data--to-your-excel-file-in-sheets;",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@ProjectDay"
    }
  ]
});
formatter.before({
  "duration": 5137684140,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "",
  "description": "",
  "id": "adding-below-data--to-your-excel-file-in-sheets;;",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Go to Databaseand get First name and Last name of employees who works in Europe and validate withtheirUI information",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Go to Excel and update column ‘Actual # of Employees’ with number of Europe employees that you get from UI",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Compare ‘Actual # of Employees’’ with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSEDif not match then update with FAILED.",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "duration": 250931954,
  "status": "passed"
});
});