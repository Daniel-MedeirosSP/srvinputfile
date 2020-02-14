package com.medeirosdaniel.srvinputfile.Controller;

import com.medeirosdaniel.srvinputfile.Exception.StorageFileNotFoundException;
import com.medeirosdaniel.srvinputfile.Service.DividePdfService;
import com.medeirosdaniel.srvinputfile.Service.StorageService;
import com.medeirosdaniel.srvinputfile.Storage.StorageProperties;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    private DividePdfService dividePdfService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("cod") String cod, @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException {
        File arquivo = new File(file.getOriginalFilename());
        storageService.store(file);
//        System.out.println(storageService.load(file.getOriginalFilename()));
//        dividePdfService.dividePdf(file);


           StorageProperties sp = new StorageProperties();

        String nome = sp.getLocation()+"/"+file.getOriginalFilename();
        System.out.println(nome);
        File arquivo2 = new File(nome);
        PDDocument documento = PDDocument.load(arquivo2);

            Splitter splitter = new Splitter();
            List<PDDocument> paginas = splitter.split(documento);
            Iterator<PDDocument> iterator = paginas.listIterator();
            int i = 1;
            while(iterator.hasNext()) {
                System.out.println(arquivo2.getName());
                PDDocument novoDocumento = iterator.next();
                novoDocumento.save(nome.replace(".pdf", "") + i++ + ".pdf");
            }

        redirectAttributes.addFlashAttribute("message",
                cod + "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
