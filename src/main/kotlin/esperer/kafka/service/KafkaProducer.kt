package esperer.kafka.service

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    private val log by lazy { LoggerFactory.getLogger(this.javaClass.simpleName) }

    companion object {
        const val TOPIC = "esperer"
    }

    fun sendMessage(message: String){
        log.info("Produce Message: $message")
        this.kafkaTemplate.send(TOPIC, message)
    }
}