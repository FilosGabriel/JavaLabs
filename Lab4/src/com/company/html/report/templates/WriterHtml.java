package com.company.html.report.templates;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.company.com.catalog.Catalog;
import com.company.graph.Graph;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class WriterHtml {
	public  void writeHtml(Map<String, Graph> catalog){
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(WriterHtml.class, "templates");
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("title", "Graph catalog");
		List<ValueExampleObject> systems = new ArrayList<ValueExampleObject>();
		for (Map.Entry<String , Graph> entry:catalog.entrySet()) {

			if(entry.getValue().getDescription()==null)
			{
					systems.add(new ValueExampleObject(entry.getValue().getName(),"", entry.getValue().getPathImage(),entry.getValue().getPathDefinition()));
			}
			else {
				systems.add(new ValueExampleObject(entry.getValue().getName(),entry.getValue().getDescription(), entry.getValue().getPathImage(),entry.getValue().getPathDefinition()));
			}
		}
		input.put("systems", systems);

		Template template=null;
		Writer consoleWrite=null;
		try {
			template = cfg.getTemplate("html.ftl");

			// 2.3. Generate the output

			// Write output to the console
			Writer consoleWriter = new OutputStreamWriter(System.out);
			template.process(input, consoleWriter);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// For the sake of example, also write output into a file:
		Writer fileWriter=null;
		try {
			fileWriter = new FileWriter(new File("output.html"));
			template.process(input, fileWriter);
		}catch (Exception e) {
				e.printStackTrace();

		} finally {
			try{
				fileWriter.close();
			}
			catch (Exception e){

			}
		}
	}

}
