package co.davidguimaraes.basicsecuritydemo.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Hello {

    private Long id;
    private String message;

    public Hello() { }

    public Hello(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hello)) return false;
        Hello hello = (Hello) o;
        return id.equals(hello.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
