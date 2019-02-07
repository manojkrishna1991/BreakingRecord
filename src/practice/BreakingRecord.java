package practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BreakingRecord

{

	// Complete the breakingRecords function below.
	static int[] breakingRecords(int[] scores) {

		int highestScoreCount = 0;
		int lowestScoreCount = 0;
		int lowestValue = 0;
		int highestValue = 0;
		for (int i = 0; i < scores.length; i++) {
			if (i == 0) {
				lowestValue = scores[i];
				highestValue = scores[i];
			} else {
				if (scores[i] < lowestValue) {
					lowestValue = scores[i];
					lowestScoreCount++;
				}
				if (scores[i] > highestValue) {
					highestValue = scores[i];
					highestScoreCount++;
				}

			}
		}
		int[] result = new int[2];
		result[0] = highestScoreCount;
		result[1] = lowestScoreCount;
		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[n];

		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
		}

		int[] result = breakingRecords(scores);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {
				bufferedWriter.write(" ");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
