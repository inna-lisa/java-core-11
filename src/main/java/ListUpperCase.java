import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListUpperCase {
	/*
	Метод приймає на вхід список рядків (можна взяти список із Завдання 1).
	Повертає список цих рядків у верхньому регістрі, і відсортованих по спадання (від Z до A).
	 */
	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("Ivan");
		names.add("Igor");
		names.add("Egor");
		names.add("Oleg");
		names.add("Kolya");
		names.add("Sasha");
		names.add("Gora");
		names.add("Misha");

		ListUpperCase listUpperCase = new ListUpperCase();
		System.out.println(listUpperCase.newList(names));
	}

	public List<String> newList(List<String> names) {
		return names.stream()
				.map(String::toUpperCase)
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
	}
}
