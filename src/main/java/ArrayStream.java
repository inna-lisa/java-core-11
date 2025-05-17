import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayStream {
	/*
	Є масив:   ["1, 2, 0", "4, 5"]
	Необхідно отримати з масиву всі числа, і вивести їх у відсортованому вигляді через кому ,,
	наприклад:    "0, 1, 2, 4, 5"
	 */
	public static void main(String[] args) {

		String[] numbers = {"1, 2, 0", "4, 5", "10, 8, 7", "jj"};

		System.out.println(
				Arrays.stream(numbers)
						.flatMap(s -> Stream.of(s.split(", ")))
						.map(s -> s.replaceAll("[^\\d.]", ""))
						.filter(s -> !s.isEmpty())
						.map(Integer::parseInt)
						.sorted()
						.map(String::valueOf)
						.collect(Collectors.joining(", ")));
	}
}
