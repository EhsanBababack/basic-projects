package ir.co.sadad.midlleproject.services;

import ir.co.sadad.midlleproject.entity.PersonEntity;
import ir.co.sadad.midlleproject.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExcelServiceImpl implements ExcelService {
    private PersonRepository personRepository;

    public void excelReader(InputStream excel) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(excel);
            HSSFSheet sheet = workbook.getSheetAt(0);
            List<PersonEntity> personEntityList = new ArrayList<>();
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                HSSFRow row = sheet.getRow(i);
                PersonEntity personEntity = new PersonEntity();
                personEntity.setFirstName(String.valueOf(row.getCell(0)));
                personEntity.setLastName(String.valueOf(row.getCell(1)));
                personEntity.setGender(String.valueOf(row.getCell(2)));
                personEntity.setCountry(String.valueOf(row.getCell(3)));
                personEntity.setAge(String.valueOf(row.getCell(4)));
//                HSSFCell cell6 = row.getCell(6);
//                String cell6String = cell6.toString();
//                LocalDate dateCell6 = LocalDate.parse(cell6String);
//                personEntity.setDate(dateCell6);
//                String toString = row.getCell(5).toString();
                personEntity.setId(String.valueOf(row.getCell(5)));
//                HSSFCell cell7 = row.getCell(7);
//                String cell7String = cell7.toString();
//                int cell7Int = Integer.parseInt(cell7String);
//                personEntity.setId(cell7Int);
                personEntityList.add(personEntity);
            }
            excelToDataBaseWithBatch(personEntityList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void excelToDataBaseWithBatch(List<PersonEntity> personEntities) {
        final int batchSize = 100;
        List<PersonEntity> personEntityBatchList = new ArrayList<>();
        for (PersonEntity person : personEntities) {
            personEntityBatchList.add(person);
            if (personEntityBatchList.size() == batchSize) {
                personRepository.saveAll(personEntityBatchList);
                personEntityBatchList.clear();
            }
        }
        personRepository.saveAll(personEntityBatchList);
    }
}
