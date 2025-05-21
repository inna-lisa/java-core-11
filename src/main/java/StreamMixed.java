import java.util.Iterator;
import java.util.stream.Stream;

public class StreamMixed {
	/*
	Напишіть метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
	який "перемішує" елементи зі стрімів first та second, зупиняючись тоді,
	коли у одного зі стрімів закінчаться елементи.
	 */
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){

		Stream.Builder <T> result = Stream.builder();
		Iterator<T> iteratorA = first.iterator();
		Iterator<T> iteratorB = second.iterator();

		Stream.iterate(0, i -> iteratorA.hasNext() && iteratorB.hasNext(),
						i -> {
							result.add(iteratorA.next());
							result.add(iteratorB.next());
							return i += 1;
						})
				.count();
		return result.build();


//		List<T> streamA = first.toList();
//		List<T> streamB = second.toList();
// 		List<T> result = new ArrayList<>();

//		int size = Math.min(streamA.size(), streamB.size());
//
//		for (int i = 0; i < size; i++) {
//			result.add(streamA.get(i));
//			result.add(streamB.get(i));
//		}
//		return result.stream();
	}

	public static void main(String[] args) {
		Stream<String> stringStreamA = Stream.of("Ivan", "Igor", "Egor", "Oleg", "Kolya", "Sasha", "Gora", "Misha");
		Stream<String> stringStreamB = Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9");

		Stream<String> result = StreamMixed.zip(stringStreamA, stringStreamB);
		System.out.println(result.toList());
	}
}
