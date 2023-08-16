# AKIA Backend Application

<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://github.com/mas-diq/akia-backend-ktor-v1/blob/master/AKIA%20V4.png?raw=true">
    <img alt="Ktor logo" src="https://github.com/mas-diq/akia-backend-ktor-v1/blob/master/AKIA%20V4.png?raw=true">
  </picture>
</div>

## Background
AKIA Backend is a backend application developed to be submitted in partial fulfilment of requirements for the Master’s Degree of Management Information Systems, in the Postgraduate Program at Gunadarma University. This backend application is developing an Android application that has previously been developed. With the presence of this backend application, it is hoped that the frontend application that will implement its services can use several inspection programs even better.

## Abstract
Preventing maternal death, especially during childbirth, has become a global and national concern. One of the targets in the SDGs is to reduce the Maternal Mortality Rate (MMR) to 70 deaths per 100,000 live births by 2030 globally. About 96 out of 100 mothers who gave birth to live births in the last two years and their births were assisted by health personnel. These health workers are scattered in various health facilities throughout Indonesia, one of which is centred at the puskesmas. The government has facilitated several activities related to pregnant women by distributing guidebooks for pregnant women, namely maternal and child health (MCH) books. National Health Survey data from the 2016 National Health Survey showed that as many as 81.5% of pregnant women stated they had an MCH handbook, but only 60.5% of them could show an MCH handbook. The unfilled MCH handbook was caused by the indiscipline of pregnant women who forgot to bring their MCH handbook when they came to the Puskesmas. Coupled with recording using a manual model that still uses books to monitor pregnant women's development, it is considered less relevant in today's all-digital era. Several applications for pregnant women have been widely spread on various platforms. However, from some of these applications, no applications can connect with health workers at the Puskesmas. In fact, the government has made many efforts to reduce the MMR rate centred there. This connection is expected to make the efforts that have been made by the government increasingly supported and can be more sustainable. The developed application will use the Kotlin language for its programming language and Ktor as a framework for developing backend applications. Application testing will also be carried out on functionality, performance and security. Functionality and performance testing will use the Postman application, while security testing will use OWASP ZAP. Application development will use the prototype as a software development life cycle (SDLC) method. Furthermore, the application will be named "Maternal and Child Health Application" or AKIA.

## Postman Collection
Access this link to open the <a href="https://documenter.getpostman.com/view/15179422/2s93sgXWQF"><strong>Postman Collection  »</strong></a>


## Architectural Framework
<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://github.com/mas-diq/akia-backend-ktor-v1/blob/master/Architecture%20Akia%204.0.png?raw=true">
    <img alt="Ktor logo" src="https://github.com/mas-diq/akia-backend-ktor-v1/blob/master/Architecture%20Akia%204.0.png?raw=true">
  </picture>
</div>

This research will not focus on developing front-end applications but will still implement a small part of the processes on the front end. This process is to get an access ID token sent from Google Oauth 2.0 to be used in backend applications as a cookie. The complete flow of the architectural framework above will be explained at several points below.
1.	The user logs into a simple Android application configured via the open ID connect protocol and signs on the Google Oauth consent screen. Users will get an ID Token, which can be used to access multiple endpoints from backend applications.
2.	In this case, users are health workers who will use the akia-app.site domain and mothers will use the akia-dev.site domain. The request process that occurs to the two users will first pass through a reversed proxy that the nginx proxy manager has provided.
3.	The reversed proxy will point to a virtual machine that runs on the Google Compute Engine service on the Google Cloud Platform. The virtual machine runs using the Ubuntu operating system, in which a docker runs several docker images, one of which is the AKIA backend application.
4.	Docker images that have run the AKIA backend application will send an ID Token previously obtained to a Google verification service to confirm whether the ID Token sent is valid.
5.	If the Token ID is valid, the backend application will enter the session the Google Verification Service sent as a cookie in the backend application that sent the request. These cookies can later be used to access databases in MongoDB.
6.	As long as the cookie is still embedded in a user's application, the user does not need to create a new ID Token. The ID Token will be forfeited within 1 hour, and if it is forfeited, it is necessary to create a new ID Token according to the previous procedure.
7.	Access rights on the MongoDB database have different access. Virtual machines with the akia-app.site domain used by health workers can view and change data in the database. Whereas the virtual machine with the akia-dev.site domain used by mothers can only view without being able to change data in the database, except for the mother monitoring program collection.
8.	The data transaction process between the user and the database will run via the HTTPS protocol because it has included an SSL Certificate in its proxy. So it is expected to increase the security of the AKIA backend application.

## Diagram Class
Twenty-six database collections have various variables ranging from strings, doubles, integers, booleans, and objects. Some of these variables are stored in a document in the form of JSON. The JSON file type allows backend applications to easily map or place a value from an object in the JSON files into a variable in the backend application. Below is an overview of the AKIA class diagram.

## Diagram Activity
There are 4 inspection menus that health workers and pregnant women can select in the AKIA backend application prototype. The four menus include blood supplement tablet inspection, mother monitoring inspection, doctor service inspection, and maternal delivery inspection. These menus have their respective endpoints pointing to different database collections. Some of the grooves in the AKIA backend application prototype system will be illustrated in the image below.
