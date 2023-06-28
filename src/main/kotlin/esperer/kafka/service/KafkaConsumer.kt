package esperer.kafka.service

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {

    private val log by lazy { LoggerFactory.getLogger(this.javaClass.simpleName) }

    @KafkaListener(topics = arrayOf("esperer"), groupId = "esperer")
    fun consume(message: String){
        log.info("Consumed Message: %message")
    }
}