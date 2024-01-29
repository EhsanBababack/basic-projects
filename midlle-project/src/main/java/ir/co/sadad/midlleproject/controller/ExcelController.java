package ir.co.sadad.midlleproject.controller;

import ir.co.sadad.midlleproject.services.ExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/persons")
public class ExcelController {
    private final ExcelService excelService;

    @PostMapping(value = "excel", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void excelReader(@RequestParam("file") MultipartFile excel) throws IOException {
        excelService.excelReader(excel.getInputStream());
    }
}