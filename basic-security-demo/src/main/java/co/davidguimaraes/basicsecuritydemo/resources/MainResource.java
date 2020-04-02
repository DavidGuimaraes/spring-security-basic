package co.davidguimaraes.basicsecuritydemo.resources;

import co.davidguimaraes.basicsecuritydemo.models.Hello;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class MainResource {

    @GetMapping(value = "/hello/json", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello hello(){
        return new Hello(1L, "Hello!");
    }

    @GetMapping(value = "/hello/xml", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Hello hello2(){
        return new Hello(1L, "Hello!");
    }

    @GetMapping(value = "/hello/pdf", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<ByteArrayResource> hello3() throws IOException {

        Path pdfPath = Paths.get("/absolute/path/to/file/file.pdf");
        byte[] pdf = Files.readAllBytes(pdfPath);

        return ResponseEntity
                .ok()
                .contentLength(pdf.length)
                .body(new ByteArrayResource(pdf));
    }
}
