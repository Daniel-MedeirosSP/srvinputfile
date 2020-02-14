package com.medeirosdaniel.srvinputfile.Controller;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DividePdfController {


    @GetMapping("/teste")
    public String teste (){
        return "123 testando";
    }

    @GetMapping
    public String dividePDF() throws IOException {


        return "Verifique!";
    }

}
