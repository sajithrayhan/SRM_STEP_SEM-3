package encapsulation.class_problems;

public final class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");   // split once, store the parts
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
        NameTag other = new NameTag("Maria Gomez");
        System.out.println(other.getNickname() + " (same name, separate object: " + (tag != other) + ")");
    }
}
