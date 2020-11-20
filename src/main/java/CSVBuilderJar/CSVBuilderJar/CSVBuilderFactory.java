package CSVBuilderJar.CSVBuilderJar;

public class CSVBuilderFactory {

	public static ICSVBuilder createCSVBuilder() {
		return new OpenCSVBuilder();
	}

	public static CommonCSVBuilder createCommonCSVBuilder() {
		return new CommonCSVBuilder();
	}
}
