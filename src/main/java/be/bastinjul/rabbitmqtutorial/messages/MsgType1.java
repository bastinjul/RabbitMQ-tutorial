package be.bastinjul.rabbitmqtutorial.messages;

import java.util.UUID;

public class MsgType1 {
    private UUID id;
    private String name;
    private Double value;

    public MsgType1(String name, Double value) {
        this.name = name;
        this.value = value;
        this.id = UUID.randomUUID();
    }

    public MsgType1() {
        //needed for serialization
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MsgType1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
