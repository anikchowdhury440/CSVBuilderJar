package CSVBuilderJar.CSVBuilderJar;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implements ICSVBuilder {
	
	public Iterator<E> getCsvFileIterator(Reader reader, Class csvClass) throws CSVBuilderException {
		try {
			OpenCSVBuilder openCSVBuilder = new OpenCSVBuilder();
			Iterator<E> myIterator = openCSVBuilder.getCSVBean(reader, csvClass).iterator();
			return myIterator;
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			throw new CSVBuilderException(CSVBuilderException.ExceptionType.UNABLE_TO_PARSE, "Unable to Parse");
		}
	}

	public List getCSVFileList(Reader reader, Class csvClass) throws CSVBuilderException {
		return this.getCSVBean(reader, csvClass).parse();
	}
	
	private CsvToBean<E> getCSVBean(Reader reader, Class csvClass) throws CSVBuilderException {
		try {
			CsvToBean<E> csvToBean = new CsvToBeanBuilder<E>(reader)
	                    .withType(csvClass)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .build();
			return csvToBean;
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			throw new CSVBuilderException(CSVBuilderException.ExceptionType.UNABLE_TO_PARSE, "Unable to Parse");
		}
	}
}
