package com.example.main;

import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import com.example.model.Persona;

public class VelocityMainExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VelocityEngine engine = new VelocityEngine();
		engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		engine.init();

		List<Persona> people = new ArrayList<Persona>();
		for (int i = 0; i < 10; i++) {
			Persona person = new Persona();
			person.setName("Persona " + 1);
			person.setAge(18);
			people.add(person);
		}

		VelocityContext context = new VelocityContext();
		context.put("title", "Title test");
		context.put("people", people);
		context.put("percent", 50);

		Template template = engine.getTemplate("\\templates\\prueba.vm");
//		StringWriter stringWriter = new StringWriter();
//		template.merge(context, stringWriter);

//		System.out.println(stringWriter.toString());
		try {
			FileWriter fileWriter=new FileWriter(new File("src/main/resources/outputs/prueba.html"));
			template.merge(context, fileWriter);
			fileWriter.flush();
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
