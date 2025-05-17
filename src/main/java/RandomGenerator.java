import java.util.stream.Stream;

public class RandomGenerator {
	/*
	Використовуючи Stream.iterate, створіть безкінечний стрім випадкових чисел,
	але не використовуючи Math.random().
	 */
	Long a, c, m, seed;

	public RandomGenerator(Long a, Long c, Long m) {
		this.a = a;
		this.c = c;
		this.m = m;
	}

	public RandomGenerator setSeed (Long seed){
		this.seed = seed;
		return this;
	}

	public Long next(){
		return (a * seed + c) % m;
	}

	public static void main(String[] args) {

		RandomGenerator randomGenerator = new RandomGenerator(25214903917L, 11L,2 ^ 48L);

		Stream<Long> stream =
				Stream.iterate(0L, (seed) -> randomGenerator.setSeed(seed).next());

		stream.limit(10)
				.forEach(System.out::println);
	}
}
