package filesfolderhomework.filesfolderlab.components;


import filesfolderhomework.filesfolderlab.models.File;
import filesfolderhomework.filesfolderlab.models.Folder;
import filesfolderhomework.filesfolderlab.models.Person;
import filesfolderhomework.filesfolderlab.repository.FileRepository;
import filesfolderhomework.filesfolderlab.repository.FolderRepository;
import filesfolderhomework.filesfolderlab.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FolderRepository folderRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args)  {
        Person person1 = new Person("Alex");
        personRepository.save(person1);

        Folder folder1 = new Folder("folder1", person1);
        folderRepository.save(folder1);

        File file1 = new File("file1", "java", 45, folder1);
        fileRepository.save(file1);


    }


}
