package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.client.Address;
import seedu.address.model.client.Client;
import seedu.address.model.client.Email;
import seedu.address.model.client.Name;
import seedu.address.model.client.Phone;
import seedu.address.model.client.Plan;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Client[] getSampleClients() {
        return new Client[] {
            new Client(new Name("MINISO"), new Phone("65705231"), new Email("miniso@example.com"),
                new Address("3155 Commonwealth Ave W, #03-56-58"), new Plan("EXPRESS 200MBps"),
                getTagSet("friends")),

            new Client(new Name("Master Fix Services"), new Phone("96724552"), new Email("masterfix@example.com"),
                new Address("3155 Commonwealth Ave W, #B1-10"), new Plan("NORMAL 100MBps"),
                getTagSet("colleagues", "friends")),

            new Client(new Name("Mr Bean"), new Phone("66594724"), new Email("mrbean@example.com"),
                new Address("3155 Commonwealth Ave W, #B1-K13"), new Plan("VALUE 50MBps"),
                getTagSet("neighbours")),

            new Client(new Name("Optical 88"), new Phone("66595327"), new Email("optical88@example.com"),
                new Address("3155 Commonwealth Ave W, #05-27"), new Plan("EXPRESS 200MBps"),
                getTagSet("family")),
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Client sampleClient : getSampleClients()) {
            sampleAb.addClient(sampleClient);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
