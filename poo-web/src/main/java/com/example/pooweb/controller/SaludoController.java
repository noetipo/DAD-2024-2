package com.example.pooweb.controller;

import com.example.pooweb.dto.Persona;
import com.example.pooweb.utils.PdfUtils;
import com.itextpdf.text.DocumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/saludo")
public class SaludoController {
    @GetMapping("/dni/{dni}")
    public String saludo(
            @PathVariable String dni,
            @RequestParam String nombre) {
        return "Hola mundo: " + nombre + "  COn DNI: " + dni;
    }

    @PostMapping
    public List<Persona> saludoBody(@RequestBody Persona persona) {
        List<Persona> personas = new ArrayList<>();
        int contador = 0;

        while (contador <= 100) {
            Persona persona1 = new Persona(persona.getNombre(), persona.getApellido(), contador + 1);
            personas.add(persona1);
            contador++;
        }


        return personas;
    }

    @PostMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf(@RequestBody Persona persona) throws IOException, DocumentException {
        List<Persona> personas = new ArrayList<>();
        int contador = 0;

        while (contador <= 100) {
            Persona persona1 = new Persona(persona.getNombre(), persona.getApellido(), contador + 1);
            personas.add(persona1);
            contador++;
        }



        ByteArrayOutputStream pdfStream = PdfUtils.generatePdfStream(personas);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=query_results.pdf");
        headers.setContentLength(pdfStream.size());
        return new ResponseEntity<>(pdfStream.toByteArray(), headers, HttpStatus.OK);
    }
}
