package esperer.kafka.controller

import esperer.kafka.service.KafkaProducer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka")
class KafkaController(
    private val kafkaProducer: KafkaProducer
) {

    @PostMapping
    fun sendMessage(@RequestParam("message") message: String): String {
        kafkaProducer.sendMessage(message)

        return "success"
    }

}