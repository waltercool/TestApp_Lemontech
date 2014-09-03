package cl.slash.letstalkclone.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.slash.letstalkclone.obj.Conversation;
import cl.slash.letstalkclone.obj.Person;

/**
 * Created by waltercool on 02-09-14.
 */
public class Demo {

    public List<Conversation> getDemoConversation() {
        List<Conversation> conversations = new ArrayList<Conversation>();
        for(int i = 0; i < 50; i++) {
            conversations.add(new Conversation(1, "Falla", 2, "Solucionado",
                    getDemoPerson(), getDemoPerson().get(0)));
        }

        return conversations;
    }

    public List<Person> getDemoPerson() {
        List<Person> listPerson = new ArrayList<Person>();
        listPerson.add(new Person(1, "John", "john@doe.com", new Date(),
                new File("/data/data/cl.slash.letstalkclone/cache/IMG_3896.JPG"), "fo9ewjdesolc"));
        listPerson.add(new Person(2, "Rocky", "rocky@rick.com", new Date(),
                new File("/data/data/cl.slash.letstalkclone/cache/IMG_3896.JPG"), "fdqwdewgdfjidew"));
        return listPerson;
    }
}
