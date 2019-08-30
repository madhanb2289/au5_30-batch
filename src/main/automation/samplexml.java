package automation;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class samplexml {

	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Employee.class);

		// create unmarsheller
		Unmarshaller un = context.createUnmarshaller();
		// xml file path
		File max = new File(
				"C:\\Users\\39543\\Documents\\Projectworkspace\\automation\\src\\test\\resources\\test\\NewFile.xml");

		/// create java object
		Object obj = un.unmarshal(max);

		Employee e = (Employee) obj;
		System.out.println(e.getId());

	}

}
