# Pattern Recognition

Computer vision involves analyzing patterns in visual images and reconstructing the real world objects that produced them. 
The process in often broken up into two phases: feature detection and pattern recognition. 
Feature detection involves selecting important features of the image; pattern recognition involves discovering patterns in the features. 
We will investigate a particularly clean pattern recognition problem involving points and line segments. 
This kind of pattern recognition arises in many other applications, for example statistical data analysis.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Building](#building)
  - [Running](#running)
- [Usage](#usage)
  - [Request examples](#request-examples)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 17 or later
- Apache Maven (for building)

## Getting Started

### Building

To build the application, follow these steps:

1. Clone the repository:

   ```sh
   git clone https://github.com/sinol-italy/PatternRecognition.git
   ```

2. Navigate to the project directory:

   ```sh
   cd PatternRecognition
   ```

3. Build the project using Maven:

   ```sh
   mvn clean install
   ```

This will compile the source code and generate a JAR file in the `target` directory.

### Running

To run the application, use the following command:

```sh
java -jar target/PatternRecognition-0.0.1-SNAPSHOT.jar
```

## Usage

Once the application is running, open your web browser and visit [http://localhost:8080/space](http://localhost:8080/space). You should see the application's homepage with an array of all points in the space.

### Request examples

Add a point to the space:  
curl -X POST -H "Content-Type: application/json" -d '{"x": 1.0, "y": 2.0}' http://localhost:8080/point 

Get all points in the space:  
curl http://localhost:8080/space

Get all line segments passing through at least N points. Note that a line segment should be a set of points:  
curl http://localhost:8080/lines/3

Remove all points from the space:  
curl -X DELETE http://localhost:8080/space



## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your fork.
5. Submit a pull request.

## License

This project is licensed (see [LICENSE](license.txt) file for details).
```
