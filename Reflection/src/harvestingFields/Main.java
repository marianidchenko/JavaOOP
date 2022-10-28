package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Field[] fields = RichSoilLand.class.getDeclaredFields();

		String command = scanner.nextLine();
		while(!command.equals("HARVEST")) {
			if (command.equals("all")) {
				printFields(fields);
			} else {
				String finalCommand = command;
				Field[] fieldsToPrint = Arrays.stream(fields)
						.filter(f -> Modifier.toString(f.getModifiers())
								.equalsIgnoreCase(finalCommand)).toArray(Field[]::new);
				printFields(fieldsToPrint);
			}
			command = scanner.nextLine();
		}
	}

	private static void printFields(Field[] fieldsToPrint) {
		Arrays.stream(fieldsToPrint).forEach(field -> System.out.printf("%s %s %s%n",
				Modifier.toString(field.getModifiers()),
				field.getType().getSimpleName(),
				field.getName()
				));
	}
}
