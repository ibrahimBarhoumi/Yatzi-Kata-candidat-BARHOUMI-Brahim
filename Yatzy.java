

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5)
    {
        List<Integer> list = Arrays.asList(d1,d2,d3,d4,d5);
        return list.stream()
        		.mapToInt(Integer::intValue)
        		.sum();
    }

    public static int yatzy(int... dice)
    {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
       
        return Arrays.asList(d1,d2,d3,d4,d5)
        		.stream()
        		.filter(value -> value == 1)
        		.mapToInt(Integer::intValue)
        		.sum();
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        
        return Arrays.asList(d1,d2,d3,d4,d5)
        		.stream().
        		filter(value -> value == 2)
        		.mapToInt(Integer::intValue)
        		.sum();
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return Arrays.asList(d1,d2,d3,d4,d5)
        		.stream()
        		.filter(value -> value == 3)
        		.mapToInt(Integer::intValue)
        		.sum();
    }

    protected int[] dice;
    public Yatzy(int d1, int d2, int d3, int d4, int _5)
    {
        dice = new int[5];
        List<Integer> list = Arrays.asList(d1,d2,d3,d4,_5);
        IntStream.range(0, dice.length)
        .forEach(i -> dice[i] = list.get(i));
    }

    public int fours()
    {
    	 return Arrays.stream(dice)
    			 .filter(value -> value == 4)
    			 .sum();
    }

    public int fives()
    {
    	return Arrays.stream(dice)
    			.filter(value -> value == 5)
    			.sum();
    }

    public int sixes()
    {
    	return Arrays.stream(dice)
    			.filter(value -> value == 6)
    			.sum();
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
    	
    	 int[] counts = new int[6];
         List<Integer> list = Arrays.asList(d1,d2,d3,d4,d5);
         IntStream.range(1, counts.length )
         .forEach(i -> counts[list.get(i-1) -1]++);
         
         int range = IntStream.range(0, counts.length)
         		  .boxed()
                  .filter(i -> counts[6-i-1] >= 2)
                  .findFirst().orElse(0);
         return (6-range)*2;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
    	 int[] counts = new int[6];
         List<Integer> list = Arrays.asList(d1,d2,d3,d4,d5);
         IntStream.range(1, counts.length )
         .forEach(i -> counts[list.get(i-1) -1]++);
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        List<Integer> list = Arrays.asList(_1,_2,d3,d4,d5);
        IntStream.range(1, tallies.length )
        .forEach(i -> tallies[list.get(i-1) -1]++);
        int range = IntStream.range(0, list.size())
         		  .boxed()
                  .filter(i -> tallies[i] >= 4)
                  .findFirst().orElse(0);
         return (range + 1) * 4;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[6];
        List<Integer> list = Arrays.asList(d1,d2,d3,d4,d5);
        IntStream.range(1, t.length )
        .forEach(i -> t[list.get(i-1) -1]++);
        int range = IntStream.range(0, list.size())
         		  .boxed()
                  .filter(i -> t[i] >= 3)
                  .findFirst().orElse(0);
         return (range +1) * 3;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        List<Integer> list = Arrays.asList(d1,d2,d3,d4,d5);
        IntStream.range(1, tallies.length )
        .forEach(i -> tallies[list.get(i-1) -1]++);
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        List<Integer> list = Arrays.asList(d1,d2,d3,d4,d5);
        IntStream.range(1, tallies.length )
        .forEach(i -> tallies[list.get(i-1) -1]++);
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        List<Integer> list = Arrays.asList(d1,d2,d3,d4,d5);
        IntStream.range(1, tallies.length )
        .forEach(index -> tallies[list.get(index-1) -1]++);

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
    
}