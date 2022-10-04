package filesfolderhomework.filesfolderlab;

import filesfolderhomework.filesfolderlab.models.File;
import filesfolderhomework.filesfolderlab.models.Folder;
import filesfolderhomework.filesfolderlab.models.Person;
import filesfolderhomework.filesfolderlab.repository.FileRepository;
import filesfolderhomework.filesfolderlab.repository.FolderRepository;
import filesfolderhomework.filesfolderlab.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
class FilesfolderlabApplicationTests {



	@Autowired
	FileRepository fileRepository;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	FolderRepository folderRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPersonAndFolderThenSave(){
		Person person1 = new Person("Alex");
		personRepository.save(person1);
		Folder folder1 = new Folder("folder1", person1);
		folderRepository.save(folder1);
	}

	@Test
	public void createPersonAndFileThenSave(){
		Person person1 = new Person("James");
		personRepository.save(person1);
		Folder folder2 = new Folder("folder2", person1);
		folderRepository.save(folder2);
		File file1 = new File("file1", "exe", 34, folder2);
		fileRepository.save(file1);

		person1.addFolder(folder2);
		folder2.addFile(file1);

	}



}
