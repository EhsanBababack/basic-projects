package ir.sadad.fileuploader;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UploaderController {
    private final UploaderService uploaderService;

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public List<PersonDto> upload(@RequestParam("file") MultipartFile file) throws IOException {

        try {
            if (!file.isEmpty()) {
                return uploaderService.uploader(file);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}

