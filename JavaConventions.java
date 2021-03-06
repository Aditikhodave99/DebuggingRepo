package OpenCSV;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadingCSV {
    public static void main(String[] args) throws IOException, CsvException {
        Reader reader= Files.newBufferedReader(Paths.get("Student.txt"));

        //parser!
        CSVParser parser=new CSVParserBuilder()
                .withSeparator('\t')
                .build();


        CSVReader object=new CSVReaderBuilder(reader)
                .withCSVParser(parser)
                .build();

        //read the contents of the file!

        List<String[]> data=object.readAll(); //returns a list of Strings from the file

        for(int count=0;count<4;count++) {
            System.out.println(data.get(count)[0]);// 0th line object
        }

        for(String[] arr : data){
            System.out.println(arr[0]);
        }

        data.stream()
                .forEach(x-> System.out.println(x[0]));
    }

}

