package com.medeirosdaniel.srvinputfile.Service;

import com.medeirosdaniel.srvinputfile.Storage.StorageProperties;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Service
public class DividePdfService {


    public void dividePdf(MultipartFile file) {
        try {
            StorageProperties sp = new StorageProperties();
            File arquivo = new File(file.getOriginalFilename());
            PDDocument documento = PDDocument.load(arquivo);
            Splitter splitter = new Splitter();
            List<PDDocument> paginas = splitter.split(documento);
            Iterator<PDDocument> iterator = paginas.listIterator();
            int i = 1;
            while(iterator.hasNext()) {
            PDDocument novoDocumento = iterator.next();
            novoDocumento.save(sp.getLocation()+file.getName().replace(".pdf","")+ i++ +".pdf");

            }

        }catch(IOException ex) {
            System.out.println(ex);
        }

    }




}
