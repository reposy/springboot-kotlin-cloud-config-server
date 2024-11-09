package springbootmsa.cloudconfig

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class SpringbootKotlinCloudConfigServerApplication

fun main(args: Array<String>) {
    runApplication<SpringbootKotlinCloudConfigServerApplication>(*args)
}
