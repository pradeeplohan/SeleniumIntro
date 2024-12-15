import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Java_Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		regulor();
		filterStream(); //filter stream by a condition and count the result stream
		printStream(); //filter stream by a condition and print the stream 
		printInUpperCase(); // print stream in upper case (use map method)
		printInSort(); // print the stream in sort order
		mergeTwoList();// merge two lists using Stream.contact(stream1, stream2)
		findAnyMatch(); //find any string match list using stream
		streamCollect(); //covert list into stream and perform operations then back to convert into list
		assignment(); //1. print unique number 2. sort the unique number and print only 3rd index value
		

	}
	

	private static void assignment() {
		// TODO Auto-generated method stub
		
		List<Integer> numbers = Arrays.asList(4,2,4,2,5,6,7,4,8,5,9,2,4,1,8);
		System.out.println("**********ASSIGNMENT RESULT**********");
		//1. print unique number
		numbers.stream().distinct().forEach(s->System.out.println(s));
		System.out.println("**********ASSIGNMENT RESULT**********");
		//2. sort the unique number and print only 3rd index value
		List<Integer> ls = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(ls.get(2));
		System.out.println("**********ASSIGNMENT RESULT**********");
		
	}


	public static void regulor()
	{
		int count = 0;
		ArrayList<String> names = new ArrayList<String>();
		names.add("Pardeep");
		names.add("Sam");
		names.add("Deep");
		names.add("Sahil");
		names.add("Silver");
		//count name start with "S"
		for(String name : names)
		{
			if(name.startsWith("S"))
				count++;
			
		}
		System.out.println(count);
	}
	
	public static void filterStream()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Pardeep");
		names.add("Sam");
		names.add("Deep");
		names.add("Sahil");
		names.add("Silver");
		//count name start with "S"
		//1. covert into stream
		//2. Perform intermediate operation (using lamda expression "->" 
		//3. Perform terminal operation
		
		Long count = names.stream().filter(s -> s.startsWith("S")).count();
		System.out.println(count);
		names.stream().filter(s -> s.length()>4).forEach(s->System.out.println(s));
	}
	
	public static void printStream()
	{
		Stream<String> st = Stream.of("Manoj", "Saroj", "Prem", "Rahul", "Deepak");
		//st.forEach(s -> System.out.println(s));
		st.filter(s1 -> ((String) s1).length()>4).limit(1).forEach(s1 -> System.out.println(s1));
		
	}
	
	private static void printInUpperCase() {
		// TODO Auto-generated method stub
		
		Stream.of("Pardeep", "Lohan", "Deep", "Kuldeep").map(s->s.toUpperCase())
		.forEach(s-> System.out.println(s));
		System.out.println("************************");
		Stream.of("Pardeep", "Lohan", "Deep", "Kuldeep").filter(s-> s.endsWith("p")).map(s->s.toUpperCase())
				.forEach(s-> System.out.println(s));
		
	}
	
	private static void printInSort() {
		// TODO Auto-generated method stub
		String[] names = {"Rahul", "Deepak","Sam", "Karan", "Abhi"};
		List<String> nameList = Arrays.asList(names);
		nameList.stream().sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
	}
	
	private static void mergeTwoList() {
		// TODO Auto-generated method stub
		
		String[] names = {"Rahul", "Deepak","Sam", "Karan", "Abhi"};
		List<String> nameList1 = Arrays.asList(names);
		
		ArrayList<String> nameList2 = new ArrayList<String>();
		nameList2.add("Hello");
		nameList2.add("World");
		
		Stream<String> newStream = Stream.concat(nameList1.stream(), nameList2.stream());
		Long c = newStream.count();
		System.out.println(c);
		
		Stream<String> newStream1 = Stream.concat(nameList1.stream(), nameList2.stream());
		newStream1.sorted().forEach(s->System.out.println(s));
		
	}
	
	private static void findAnyMatch() {
		// TODO Auto-generated method stub
		
		String[] names = {"Rahul", "Deepak","Sam", "Karan", "Abhi"};
		List<String> nameList1 = Arrays.asList(names);
		
		boolean flag = nameList1.stream().anyMatch(s-> s.equalsIgnoreCase("sam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	

	private static void streamCollect() {
		// TODO Auto-generated method stub
		
		String[] names = {"Rahul", "Deepak","Sam", "Karan", "Abhi"};
		List<String> nameList1 = Arrays.asList(names);
		
		List<String> newList = nameList1.stream().sorted().map(s-> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(newList.get(0));
		
	}

}
