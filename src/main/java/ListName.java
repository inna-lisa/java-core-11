import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ListName {
		/*
		Метод приймає на вхід список імен. Необхідно вернути рядок вигляду
		1. Ivan, 3. Peter... лише з тими іменами, що стоять під непарним індексом (1, 3 і т.д.)
		*/

	public static void main(String[] args) {

		ListName listName = new ListName();

		List<String> names = new LinkedList<>();
		names.add("Ivan");
		names.add("Igor");
		names.add("Egor");
		names.add("Oleg");
		names.add("Kolya");
		names.add("Sasha");
		names.add("Gora");
		names.add("Misha");

		System.out.println(listName.getNewListName(names));
	}

	public String getNewListName(List<String> names){
		AtomicInteger index = new AtomicInteger(1);

		return names.stream()
				.map(name -> index.getAndIncrement() + ". " + name)
				.filter(it -> Character.getNumericValue(it.charAt(0)) % 2 != 0)
				.collect(Collectors.joining(", "));
	}
}
