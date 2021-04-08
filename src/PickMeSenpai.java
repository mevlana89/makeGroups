import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class PickMeSenpai {

    private static String[] studentsList = new String[]{"Jérôme", "Nicolas", "Sandrine", "Stéphane", "Maxime", "Hajar", "Christophe", "Mustafa", "Huber"};

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Vous devez spécifier le nombre d'élèves par groupe.");
        }

        int nbMinPerGroup = Integer.parseInt(args[0]);
        if (nbMinPerGroup < 0) {
            throw new IllegalArgumentException("Le paramètre doit être un nombre entier positif. ");
        }
        displayGroups(makeGroups(nbMinPerGroup));
    }

    private static void displayGroups(String[][] groupsList) {
        for (int i = 0; i < groupsList.length; i++) {
            System.out.println("Groupe " + (i + 1) + " : " + String.join(", ", Arrays.stream(groupsList[i]).filter(Objects::nonNull).toArray(String[]::new)));
        }
    }

    private static String[][] makeGroups(int nbMinPerGroup) {
        int nbGroup = studentsList.length / nbMinPerGroup;
        int groupMinSize = studentsList.length / nbGroup;
        int groupMaxSize = (studentsList.length % nbGroup > 0) ? studentsList.length / nbGroup + 1 : studentsList.length / nbGroup;
        int groupIndex = 0;
        int inGroupIndex = 0;

        String[][] groupsList = new String[nbGroup][groupMaxSize];
        for (String ignored : studentsList) {
            int random = (int) Math.floor(Math.random() * studentsList.length);
            groupsList[groupIndex][inGroupIndex] = studentsList[random];
            studentsList = Stream.concat(
                    Arrays.stream(Arrays.copyOfRange(studentsList, 0, random)),
                    Arrays.stream(Arrays.copyOfRange(studentsList, random + 1, studentsList.length))
            ).toArray(String[]::new);
            if (inGroupIndex == groupMinSize - 1 && groupIndex != nbGroup - 1) {
                groupIndex++;
                inGroupIndex = 0;
            } else {
                inGroupIndex++;
            }
        }
        return groupsList;
    }
}
