package myspring.di.annot;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hello {
	@Value("Spring")
	private String name;
	
	@Autowired
	@Qualifier("stringPrinter")
//	@Resource(name="${printer1}")
	private Printer printer;
	private List<String> names;
	
	public Hello() { }
	
	public Hello(String name, Printer printer) {
		super();
		this.name = name;
		this.printer = printer;
	}
	
	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public void setPrinter(Printer printer) {
//		this.printer = printer;
//	}
	
	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		printer.print(sayHello());
	}
}
