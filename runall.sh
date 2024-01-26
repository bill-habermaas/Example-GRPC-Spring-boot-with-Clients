echo -e "\nRunning the GO client..."
cd src/main/golang
go run client.go
echo -e "\nRunning the Rust client..."
cd ../rust
cargo run --bin client

