/**
 * 
 */
package com.nector.alpha.uno.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shash
 *
 */
public class Utils {
	private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

	// Get ExecutorService from Executors utility class, thread pool size is 10
	private static ExecutorService executor = Executors.newFixedThreadPool(10);

	// create a list to hold the Future object associated with Callable
	private static List<Future<String>> list = new ArrayList<Future<String>>();

	/**
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List<String> readFile(String file) throws FileNotFoundException, IOException {
		LOG.info("Going to read file:{}", file);
		List<String> retval = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (String line; (line = br.readLine()) != null;) {
				retval.add(line.replace("\"", ""));
				// retval.add(line);
			}
		}

		LOG.info("Total record count(with header) in file:{}, is:{}", file, retval.size());

		return retval;
	}

	/**
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String readCompleteFile(String file) throws FileNotFoundException, IOException {
		LOG.info("Going to read file:{}", file);
		StringBuilder retval = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (String line; (line = br.readLine()) != null;) {
				retval.append(line);
			}
		}

		LOG.info("Data of file:{}, is:{}", file, retval.toString());

		return retval.toString();
	}

	/**
	 * @param seekPattern
	 * @param testString
	 * @return
	 */
	public static String getMatch(String seekPattern, String testString) {
		LOG.info("Search pattern:{} in string:{}", seekPattern, testString);

		String retval = AppConstant.CSV;

		Pattern pattern = Pattern.compile(seekPattern);
		// in case you would like to ignore case sensitivity,
		// you could use this statement:
		// Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(testString);
		// check all occurance
		while (matcher.find()) {
//			System.out.println("Start index: " + matcher.start());
//			System.out.println(" End index: " + matcher.end() + " ");
//			System.out.println(matcher.group(1));
			retval = matcher.group(1);
			break;
		}

		return retval;
	}

}
