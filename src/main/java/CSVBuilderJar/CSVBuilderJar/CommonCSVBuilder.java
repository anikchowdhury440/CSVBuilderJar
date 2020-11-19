package CSVBuilderJar.CSVBuilderJar;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CommonCSVBuilder<E> implements ICSVBuilder<E>{

	public Iterator<E> getCsvFileIterator(Reader reader, Class<E> csvClass) throws CSVBuilderException {
		try {
			Iterable<CSVRecord> csvRecords = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
			return (Iterator<E>) csvRecords.iterator();
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new CSVBuilderException(CSVBuilderException.ExceptionType.UNABLE_TO_PARSE, "Unable to Parse");
		}
	}

	public List<E> getCSVFileList(Reader reader, Class csvClass) throws CSVBuilderException {
		try {
			CSVParser csvParser = CSVParser.parse(reader, CSVFormat.DEFAULT);
			return (List<E>) csvParser.getRecords();
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new CSVBuilderException(CSVBuilderException.ExceptionType.UNABLE_TO_PARSE, "Unable to Parse");
		}
	}
}
