# Rest-MultiPart-API
Here We have created REST Multipart API for single/multiple file uploading and downloading using spring boot. 

rest-mutipart is a maven project in which we have created rest APIs using spring boot for uploading and downloading files with exception handling.
Go through the source code, you'll understand the flow.

In this project I have exposed three services:
- Upload single file:
  - Http Method: POST
  - URI: "/uploadFile"
  
- Upload Multiple files:
  - Http Method: POST
  - URI: "/uploadMultipleFiles"
  
- Download file:
  - Http Method: GET
  - URI: "/downloadFile/{fileName}"
