public static String[] parse(String fullCommand) {
  fullCommand = fullCommand.trim();

  if (fullCommand.equalsIgnoreCase("bye")) {
    return new String[]{"bye"};
  }

  // Split the command into words
  String[] parts = fullCommand.split(" ");

  // Handle the special case for "deadline" commands
  if (parts[0].equals("deadline") && parts.length > 2) {
    // Finding the position of "/by"
    int byIndex = -1;
    for (int i = 0; i < parts.length; i++) {
      if (parts[i].equals("/by")) {
        byIndex = i;
        break;
      }
    }

    // If "/by" is found, combine the description and date parts
    if (byIndex != -1 && byIndex < parts.length - 1) {
      String description = String.join(" ", java.util.Arrays.copyOfRange(parts, 1, byIndex));
      String dateTime = parts[byIndex + 1] + " " + parts[byIndex + 2];
      return new String[]{"deadline", description, "/by", dateTime};
    }
  }

  return parts;
}
