package tabelaHash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class EX01 {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		IntStream fiveRandomNumbers = random.ints(0, 11).distinct();
		System.out.println(fiveRandomNumbers);
	}
	
}
