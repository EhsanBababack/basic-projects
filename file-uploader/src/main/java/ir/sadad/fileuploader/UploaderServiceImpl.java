package ir.sadad.fileuploader;

import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploaderServiceImpl implements UploaderService {
    @Transactional(dontRollbackOn = RuntimeException.class)
    public List<PersonDto> uploader(MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get("./tmp/");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Path filePath = null;

        try (InputStream inputStream = multipartFile.getInputStream()) {
            filePath = uploadPath.resolve(UUID.randomUUID() + ".txt");
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save file: ", ioe);
        }
        String originalFilename = multipartFile.getOriginalFilename();

        List<String> fileRows = Files.readAllLines(filePath);
        List<PersonDto> personDtos = new ArrayList<>(100);

        for (int i = 0; i < fileRows.size(); i++) {
            String[] rowLine = fileRows.get(i).split(",");
            PersonDto personDto = PersonDto.builder()
                    .firstName(rowLine[0])
                    .lastName(rowLine[1])
                    .nationalId(rowLine[2])
                    .customerNo(rowLine[3])
                    .mobileNumber(rowLine[4])
                    .fatherName(rowLine[5])
                    .build();
            personDtos.add(personDto);
        }
        return personDtos;
    }
}
