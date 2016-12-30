# Spring Boot Server-Side Example for the Widen Fine Uploader Javascript Library #

This repository contains a [**Spring Boot**](https://projects.spring.io/spring-boot/) server-side example for users of [**Widen's Fine Uploader javascript library**](http://fineuploader.com/).  

### This server supports

* [File chunking](http://docs.fineuploader.com/branch/master/features/chunking.html)
* [Concurrent uploading](http://docs.fineuploader.com/branch/master/features/concurrent-chunking.html)
* [Delete uploaded files](http://docs.fineuploader.com/branch/master/features/delete.html)
* [Resume uploads](http://docs.fineuploader.com/branch/master/features/resume.html)

### Requirements

Java Platform (JDK) 8 (it might work as is with JDK 7, some changes would be needed to make it run with JDK 6)

## Getting Started

First step is to clone this repository. You can compile and run this as any other Spring Boot application, if you are
not familiar with Spring Boot, a simple way is to run the below commands from the root directory (where the pom.xml is located),

Compile and package
```bash
./mvnw clean package
```
Run the server
```bash
java -jar target/spring-boot-server-1.0.0.jar
```

### Server configuration

To configure the server, you can add the below properties in the application.properties file or set them 
when running the server from the command line,

Property | Default | Description
---------|---------|-------------
fineuploader.base-dir|./uploads|Root upload directory
server.port|8080|Listening port


application.properties
```properties
fineuploader.base-dir=/tmp/uploads
server.port=9090
```

Command line configuration
```bash
java -Dserver.port=9090 -Dfineuploader.base-dir=/tmp/uploads -jar target/spring-boot-server-1.0.0.jar
```

### Server endpoints
Method | Endpoint | Usage
-------|----------|-------
POST|/uploads|Upload file end point. Will create `<root_upload_directory>/qquuid` directory and store the received file inside. Refer to [request.endpoint](http://docs.fineuploader.com/branch/master/api/options.html#request.endpoint)
DELETE|/uploads|Deletes the uploaded file based on the `qquuid` parameter. Refer to [deleteFile.endpoint](http://docs.fineuploader.com/branch/master/api/options.html#deleteFile.endpoint)
POST|/chunksdone|Builds original file based on received chunks for the received `qquuid` parameter. Refer to [chunking.success.endpoint](http://docs.fineuploader.com/branch/master/api/options.html#chunking.success.endpoint)


### Fine Uploader library

Go to the [Download](http://fineuploader.com/customize.html) section of the Fine Uploader website for instructions on how to get the library.

Go to the [Demos](http://fineuploader.com/demos.html) section for Fine Uploader configuration examples.

### License ###
This project is licensed under the terms of the MIT license.