import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMixed {
	/*
	Напишіть метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
	який "перемішує" елементи зі стрімів first та second, зупиняючись тоді,
	коли у одного зі стрімів закінчаться елементи.
	 */
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
		List<T> streamA = first.toList();
		List<T> streamB = second.toList();

		int size = Math.min(streamA.size(), streamB.size());

		List<T> result = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			result.add(streamA.get(i));
			result.add(streamB.get(i));
		}
		return result.stream();
	}

	public static void main(String[] args) {
		Stream<String> stringStreamA = Stream.of("Ivan", "Igor", "Egor", "Oleg", "Kolya", "Sasha", "Gora", "Misha");
		Stream<String> stringStreamB = Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9");

		Stream<String> result = StreamMixed.zip(stringStreamA, stringStreamB);
		System.out.println(result.toList());
	}
}
