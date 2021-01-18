package xxx;

import java.util.Arrays;

public class PersonDatabase {
    private int maxPeople = 1;
    Person[] people = new Person[maxPeople];
    private int emptyPlace;

    public void add(Person person) {
        if (person == null)
            throw new NullPointerException( "brak miejsca" );
        if (emptyPlace == people.length) {
            people = Arrays.copyOf( people, people.length * 2 );
        }
        people[emptyPlace] = person;
        emptyPlace++;
    }

    public void remove(Person person) {
        if (person == null)
            throw new NullPointerException( "person cannot be null" );
        final int notFound = -1;
        int foundIndex = notFound;
        for (int i = 0; i < emptyPlace; i++) {
            if (person.equals( people[i] )) {
                foundIndex = i;
            }
        }
        if (foundIndex != notFound) {
            System.arraycopy( people, foundIndex + 1, people, foundIndex, people.length - foundIndex - 1 );
            emptyPlace--;
            people[emptyPlace] = null;
        }
    }

    Person getIndex(int index) {
        if (index >= emptyPlace || index < 0)
            throw new NullPointerException( "Index has to be positive and lower than " + emptyPlace );
        return people[index];
    }

    int size() {
        return emptyPlace;
    }

    @Override
    public String toString() {
        return "PersonDatabase{" +
                "maxPeople=" + maxPeople +
                ", people=" + Arrays.toString( people ) +
                ", emptyPlace=" + emptyPlace +
                '}';
    }
}




