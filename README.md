# Andorid-API-Handler
Android API Handler

**Instructions:**

- Download project as a zip and extract.
- Import "datahandler" package/folder as module.
- Make sure to have include this line in settings.gradle file:

`	include ':datahandler' `

- Add this line in your app level build.gradle:

`	implementation project(path: ':datahandler')`

Clean Build and then again build your project.


-------
This package includes the necessary files for calling API at multiple endpoints with interface and callbacks to include in your main project. 

Used libraries:
- Retrofit 2
- GSON
- OKHttp
- PaperDB