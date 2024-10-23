package com.prodia_service.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodia_service.Model.http.request.RequestGenerate;
import com.prodia_service.Model.http.response.GeneratingImage;
import com.prodia_service.Model.http.response.ResponseImage;
import com.prodia_service.Service.ProdiaService;

@RestController
@RequestMapping("/api/prodia")
@CrossOrigin(origins = "*")
public class ProdiaController {
    private final ProdiaService prodiaService;

    
    public ProdiaController(ProdiaService prodiaService) {
        this.prodiaService = prodiaService;
    }

    @PostMapping("/generate")
    public ResponseEntity<GeneratingImage> generateImageSDXL(@RequestBody RequestGenerate request){
        try {
            System.out.println(request.getHeight());
            System.out.println(request.getImageUrl());
            System.out.println(request.getWidth());
            System.out.println(request.getEffect());
            return new ResponseEntity<>(prodiaService.generateImageSDXL(request),HttpStatus.OK);
        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/get-job")
    public ResponseEntity<ResponseImage> getJobResult(@RequestBody GeneratingImage request){
        try {
            return new ResponseEntity<>(prodiaService.getJobResult(request),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
