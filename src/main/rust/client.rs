use std::io::stdin;

//
use helloworld::{greeting_service_client::GreetingServiceClient};
use helloworld::RequestMessage;

pub mod helloworld {
    tonic::include_proto!("helloworld");
}

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    let mut client = GreetingServiceClient::connect("http://[::1]:6565").await?;
    loop {
        println!("\nPlease enter your name");
        let mut u = String::new();
        stdin().read_line(&mut u).unwrap();
        let u = u.trim();
        match u {
            "quit" => break,
            _ => {
                let request = tonic::Request::new(RequestMessage {
                    name: (*u).to_string()
                });
                let response = client.say_hello(request).await?;
                println!("Got: '{}' from service", response.into_inner().message);
            }
        };
    }
    Ok(())
}
