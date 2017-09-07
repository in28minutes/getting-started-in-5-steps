## URLs
- http://localhost:8000/currency-exchange/from/USD/to/INR
- http://localhost:8100/currency-converter-direct/from/USD/to/INR/amount/10
- http://localhost:8100/currency-converter-feign/from/USD/to/INR/amount/10
- http://localhost:8761/
- http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR
- http://localhost:9411/
- http://localhost:8080/limits

## VM Argument

-Dserver.port=8001

## Commands
- mkdir git-configuration-repo
- cd git-configuration-repo/
- git init
- git add -A
- git commit -m "first commit"

## Ports
| Application       |  Port          |
| Currency Exchange | 8000, 8001, 8002, ..  |
| Currency Conversion Service | 8100, 8101, 8102, ... |
| Limits Service | 8080, 8081, ... |
| Config Server | 8888 |
| Name Server | 8761 |
| Zuul Server | 8765 |
| Zipkin | 9411 |

## Installing Rabbit MQ

### Windows
- https://www.rabbitmq.com/install-windows.html
- https://www.rabbitmq.com/which-erlang.html
- http://www.erlang.org/downloads

### Mac


## Complete Code Example
 

 <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <compilerArgs>
                        <arg>-parameters</arg>
                    </compilerArgs>
                </configuration>
            </plugin>
