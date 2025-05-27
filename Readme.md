# Docker

## Images


- Currency Exchange Service 
	- currency-exchange-service
- Currency Conversion Service
	- currency-conversion-service
- Eureka
	- naming-server
- API GATEWAY
	- api-gateway

## URLS

#### Currency Exchange Service
- http://localhost:8000/currency-exchange/from/USD/to/INR

#### Currency Conversion Service
- http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
- http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10

#### Eureka
- http://localhost:8761/

#### Zipkin
- http://localhost:9411/

#### API GATEWAY
- http://localhost:8765/currency-exchange/from/USD/to/INR
- http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10
- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
- http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10

#### Commands
```
docker run -p 9411:9411 openzipkin/zipkin:2.23
docker push docker.io/currency-exchange-service
docker-compose --version
docker-compose up
docker push naming-server
docker push currency-conversion-service
docker push api-gateway
watch -n 0.1 curl http://localhost:8000/sample-api
```