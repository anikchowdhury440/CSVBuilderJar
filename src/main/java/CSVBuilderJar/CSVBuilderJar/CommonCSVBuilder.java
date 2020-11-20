package CSVBuilderJar.CSVBuilderJar;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CommonCSVBuilder {

	public Iterator getCsvFileIterator(Reader reader){
		try {
			CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
			Iterator<CSVRecord> records = parser.iterator();
			records.next();
			return records;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List getCSVFileList(Reader reader){
		try {
			CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
			List<CSVRecord> csvList = parser.getRecords();
			csvList = (List<CSVRecord>) csvList.stream().skip(1);
			return csvList;
		}
		catch (IOException e) {
			e.printStackTrace();
			
		}
		return null;
	}
}
