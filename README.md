This is an Intellij project to create and run a simple Java Spring
boot gRPC server. It includes three clients: one written in
Java, one written in Rust, and one written in Golang. This provides a conformation of interoperability of gRPC across the most popular development languages.

A simple shell script in the project root starts the Java Spring Boot server, runs the Rust and Go clients.
> ./runall.sh