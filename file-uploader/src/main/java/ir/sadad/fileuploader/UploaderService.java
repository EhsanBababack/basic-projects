package ir.sadad.fileuploader;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UploaderService {
    List<PersonDto> uploader(MultipartFile file) throws IOException;
}
