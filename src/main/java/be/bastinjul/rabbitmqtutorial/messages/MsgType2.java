package be.bastinjul.rabbitmqtutorial.messages;

import java.util.Random;
import java.util.UUID;

public class MsgType2 {
    private Long id;
    private UUID msgType1Id;
    private String description;

    public MsgType2(UUID msgType1Id, String name, Double value) {
        this.id = new Random().nextLong();
        this.msgType1Id = msgType1Id;
        this.description = String.format("Name = %s, value = %f", name, value);
    }

    public MsgType2() {
        //needed for serialization
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getMsgType1Id() {
        return msgType1Id;
    }

    public void setMsgType1Id(UUID msgType1Id) {
        this.msgType1Id = msgType1Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
