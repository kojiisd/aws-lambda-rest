# aws-lambda-rest
To execute AWS Lambda jar as standalone Spring Boot application without any modifications.

# Preparation
1. Modify application.yml to create an object for target class.
2. Put target jar file and modify pom.xml according to target jar file.

# Command
For build, execute following command.

```
$ mvn clean package
```

For execution, type following command.
```
$ java -cp target/aws-lambda-local-rest-0.0.1-SNAPSHOT.jar jp.gr.java_conf.kojiisd.AwsLambdaLocalRestApplication
```

