package Exercicio3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Cores> cores = new ArrayList<>(Arrays.asList(Cores.values()));

		Collections.sort(cores, Collections.reverseOrder());

		cores.stream().forEach(System.out::println);
	}

}
