package arrays_methods.class_problems;

public class DuplicateTeamNameFinder {

    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            // Only compare against names that come after, so no pair is checked twice.
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicateTeam(new String[]{"ByteForce", "CodeCrafters", "ByteForce"}));
        System.out.println(findDuplicateTeam(new String[]{"ByteForce", "CodeCrafters", "NullPointers"}));
    }
}
